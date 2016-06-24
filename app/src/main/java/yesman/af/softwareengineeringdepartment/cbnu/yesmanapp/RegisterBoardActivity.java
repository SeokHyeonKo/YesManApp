package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class RegisterBoardActivity extends Activity
{
    EditText contentEditText;
    EditText titleEditText;
    Button registerBtn;
                String userID;
                Date date;

                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);

                    contentEditText = (EditText)findViewById(R.id.contentEditText);
                    contentEditText.setBackgroundColor(Color.CYAN);
                    titleEditText = (EditText)findViewById(R.id.titleEditText);
                    registerBtn = (Button)findViewById(R.id.registerbtn);

                    registerBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ServerManager a  = ServerManager.getInstance();

                            String userID = "user";
                            String title = titleEditText.getText().toString();
                            String content = contentEditText.getText().toString();

                            Log.w(title,"title");
                            Log.w(content,"content");

                            long now = System.currentTimeMillis();
                            Date date = new Date(now);

                //임시
                double x = 1111.222;
                double y = 1111.111;

               // Board dashBoard = new Board(title,content,date,x,y);
                     User user = User.getInstance();

                user.setUserID("sdfsdfdf");
                user.setX(125);
                user.setY(125);
                Board board = new Board("ddd","sdfdf",new Date(),123.124,231.23);
                            user.setCurrentDashBoard(board);

                            a.registerBoard();
                //a.registerDahsBoard(dashBoard);
                            //User u = new User("1243223423",123.23,124.2,1,0,0,1);
                            //a.getRequestList(u);
            }
        });
    }


}
