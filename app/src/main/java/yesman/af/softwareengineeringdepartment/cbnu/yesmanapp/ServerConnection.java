package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by seokhyeon on 2016-06-22.
 */
public class ServerConnection extends AsyncTask<String, Void, String> {

    private User user;

    @Override
    protected String doInBackground(String...url) {
        // URL 연결이 구현될 부분
        URL url1;
        String response = null;
        Log.w("Dd","dd");

            try {
                // 占쌍소뤄옙 占쏙옙占쏙옙占싹울옙 post占쏙옙占쏙옙占쏙옙占?json 占싼깍옙占?
                URL object = new URL(url[0]);
                HttpURLConnection con = (HttpURLConnection) object.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestProperty("Accept", "*/*");
                con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
                con.setRequestMethod("POST");

                JSONObject dashboardObj = new JSONObject();
                dashboardObj.put("userid",user.getUserID());
                dashboardObj.put("title",user.getCurrentDashBoard().getTitle());
                dashboardObj.put("content",user.getCurrentDashBoard().getContent());
                dashboardObj.put("date",user.getCurrentDashBoard().getDate().getTime());
                dashboardObj.put("x",user.getCurrentDashBoard().getX());
                dashboardObj.put("y",user.getCurrentDashBoard().getY());

                OutputStreamWriter wr = new OutputStreamWriter(
                        con.getOutputStream());
                System.out.println(dashboardObj.toString());
                wr.write("data=" + dashboardObj.toString()); // 占쌔댐옙 占쏙옙占쏙옙 占싼뤄옙占쌔댐옙.
                // data=value占쏙옙 post占쏙옙占쏙옙占쏙옙占?
                // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙
                wr.flush();
                wr.close();
                // 肉뚮┛??寃곌낵 媛믪쓣 蹂대뒗 硫붿냼??
                StringBuilder sb = new StringBuilder();
                int HttpResult = con.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            con.getInputStream(), "utf-8"));
                    String line = null;
                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                    System.out.println("" + sb.toString());
                } else {
                    System.out.println(con.getResponseMessage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }



        return response;
    }
    @Override
    protected void onPostExecute(String result) {
        // UI 업데이트가 구현될 부분
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.v("d", "WaitAndDrawAsyncTask on Cancelled");

    }

    public void setUser(User user){
        this.user = user;
    }
}
