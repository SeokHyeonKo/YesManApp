package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.View;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.regex.Pattern;

import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.Model.User;
import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.R;

public class LoginAcitivity extends Activity {

    private CallbackManager mCallbackManger;
    /* facebook profile */
    private Profile profile;
    private com.facebook.login.widget.LoginButton loginButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_facebook__login);
        mCallbackManger = CallbackManager.Factory.create();

        loginButton = (LoginButton)findViewById(R.id.buttonId); //페이스북 로그인 버튼

        loginButton.registerCallback(mCallbackManger, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                User user = User.getInstance();

                AccessToken.setCurrentAccessToken(loginResult.getAccessToken());

                /* 페이스북 프로필을 가져온다*/
                profile = Profile.getCurrentProfile();
                //String userId = profile.getId();
                //String user_name = profile.getName();
                String user_password = "";
                String userId = loginResult.getAccessToken().getUserId();
                user.setUserID(userId);

                /* 사용 디바이스 핸드폰 번호 알아오기
                TelephonyManager systemService = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
                String user_phone = systemService.getLine1Number();
                user_phone = user_phone.substring(user_phone.length() - 10, user_phone.length());
                user_phone = "0" + user_phone;
                */

                /* 안드로이드 기기 구글 동기화 이메일 주소 가져오기 */
                Pattern emailPattern = Patterns.EMAIL_ADDRESS;
                AccountManager am = (AccountManager)getSystemService(Context.ACCOUNT_SERVICE);
                Account[] accounts = am.getAccounts();
                String user_email="";
                for (Account account : accounts) {
                    if (emailPattern.matcher(account.name).matches()) {
                        user_email = account.name;
                    }
                }

                /** SharedPreferences로 Facbook 정보 저장*/
                /* 로그인될 시 세션을 유지하기 위해 환경 변수에 facebook login session 관리를 저장한다. */
                SharedPreferences pref = getSharedPreferences("PrefName", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("FACEBOOK_LOGIN", "LOGIN");

                /* 페이스 북 로그인이 처음이라면 SharedPreferences와 DB에 저장해야 한다.*/
                String facebookFirstLogin = pref.getString("FACEBOOK_FIRST_LOGIN","TRUE");
                if(facebookFirstLogin.equals("TRUE")) {
                    /** SharedPreferences 저장*/
                    editor.putString("FACEBOOK_FIRST_LOGIN","FALSE");
                    editor.putString("USER_ID", userId);
                   // editor.putString("USER_NAME", user_name);
                    editor.putString("USER_PASSWORD", user_password);
                    //editor.putString("USER_PHONE", user_phone);
                    editor.putString("USER_EMAIL", user_email);
                    editor.commit();

                    //Log.d("FaceBook :::", "id : " + userId);
                    //Log.d("FaceBook :::", "name : " + user_name);
                    //Log.d("FaceBook :::", "phone : " + user_phone);
                    //Log.d("FaceBook :::", "email : " + user_email);

                }
                editor.commit();
                Intent mainIntent = new Intent(LoginAcitivity.this, MapAcitivity.class);
                startActivity(mainIntent);
                finish();
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginAcitivity.this, "페이스북 로그인이 취소 되었습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginAcitivity.this, "페이스북 로그인이 취소 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManger.onActivityResult(requestCode, resultCode, data);
    }
}


