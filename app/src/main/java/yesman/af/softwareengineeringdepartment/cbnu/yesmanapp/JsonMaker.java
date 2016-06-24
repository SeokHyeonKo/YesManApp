package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by seokhyeon on 2016-06-24.
 */
public class JsonMaker {


    private static JsonMaker jsonmaker = null;
    public static int JOIN = 0,GET_REQUSET_LIST = 1,GET_DONATION_LIST = 2, REGISTER_BOARD = 3;
    private JSONObject jsonobj;
    private JSONArray jsonarr;
    private int selected;

    public JSONObject makeJson(){
        JSONObject tempobj = null;
        User user = User.getInstance();
        if(selected==JOIN){
            tempobj = joinUserMakeJson(user);
        }else if(selected==GET_REQUSET_LIST || selected == GET_DONATION_LIST){
            tempobj = getRequsetList(user);
        }else if(selected==REGISTER_BOARD){
            tempobj = registerBoard(user);
        }


        return  tempobj;
    }

    public JSONObject joinUserMakeJson(User user){
        jsonobj = new JSONObject();
        try {
            jsonobj.put("UserId", user.getUserID());
            jsonobj.put("domain1", user.getDomain1());
            jsonobj.put("domain2", user.getDomain2());
            jsonobj.put("domain3", user.getDomain3());
            jsonobj.put("domain4", user.getDomain4());
            jsonobj.put("x", user.getX());
            jsonobj.put("y", user.getY());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonobj;
    }

    public JSONObject getRequsetList(User user){
        jsonobj = new JSONObject();
        try {
            jsonobj.put("x", user.getX());
            jsonobj.put("y", user.getY());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonobj;
    }

    public JSONObject registerBoard(User user){
        Board board = user.getCurrentBoard();
        //현재로 저장된 위치를 사용 할 것인지 새롭게 저장할 위치로 할 것인지 임시로 만들어놓은 변수
        boolean iscurrent = true;
        jsonobj = new JSONObject();
        try {
            jsonobj.put("title", board.getTitle());
            jsonobj.put("content", board.getContent());
            jsonobj.put("userid",user.getUserID());
            if(iscurrent){
                jsonobj.put("x",user.getX());
                jsonobj.put("y",user.getY());
            }else{
                jsonobj.put("x",board.getX());
                jsonobj.put("y",board.getY());
            }
            jsonobj.put("domain",board.getDomain());
            jsonobj.put("category",board.getCategory());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonobj;

    }



    public void setSeleted(int seleted){
        this.selected = seleted;
    }

    public int getSeleted(){
        return selected;
    }

    public static synchronized JsonMaker getInstance(){
        if(jsonmaker==null){
            jsonmaker = new JsonMaker();
        }
        return jsonmaker;
    }

}
