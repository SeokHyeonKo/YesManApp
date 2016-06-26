package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.ServerIDO;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.JSON.DataMakerbyJson;
import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.JSON.JsonMaker;
import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.Model.Board;
import yesman.af.softwareengineeringdepartment.cbnu.yesmanapp.Model.User;

/**
 * Created by seokhyeon on 2016-06-22.
 */
public class ServerConnection extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String...url) {
        // URL 연결이 구현될 부분
        URL url1;
        String response = null;
        Log.w("Dd","dd");

            try {
                System.out.println("보냄?");
                URL object = new URL(url[0]);
                HttpURLConnection con = (HttpURLConnection) object.openConnection();
                con.setDoOutput(true);
                con.setDoInput(true);
                con.setRequestProperty("Accept", "*/*");
                con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
                con.setRequestMethod("POST");

                JSONObject obj = JsonMaker.getInstance().makeJson();

                OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
                //System.out.println(obj.toString());
                 wr.write("data=" + obj.toString());

                wr.flush();
                wr.close();


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
                    //System.out.println("" + sb.toString());
                    response = sb.toString();
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

        if(result!=null && (JsonMaker.getInstance().getSeleted()==JsonMaker.GET_REQUSET_LIST
                || JsonMaker.getInstance().getSeleted()==JsonMaker.GET_DONATION_LIST
                || JsonMaker.getInstance().getSeleted()==JsonMaker.CHECK_MYBOARDLIST)){
            User.getInstance().setBoardList(DataMakerbyJson.getDataMaker().getBoardList(result));
            ArrayList<Board> arr = User.getInstance().getBoardList();
            for(int i=0;i<arr.size();i++){
                System.out.println(arr.get(i).getContent());
                System.out.println(arr.get(i).getAcceptID());
                System.out.println(arr.get(i).getDomain());
                System.out.println(arr.get(i).getX());

            }
        }


    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.v("d", "WaitAndDrawAsyncTask on Cancelled");

    }


}
