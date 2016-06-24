package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp;

/**
 * Created by seokhyeon on 2016-06-22.
 */
public class ServerManager {

    private static ServerManager serverManager;
    private ServerConnection server;
    private String path;
    private String url = "http://kossi.iptime.org:2000/YesManProject";

    public void registerBoard(){
        path = "/registerBoard";
        JsonMaker.getInstance().setSeleted(JsonMaker.REGISTER_BOARD);
        checkTask();
        server.execute(url+path);
    }

    public void joinUser(){
        path = "/joinuser";
        JsonMaker.getInstance().setSeleted(JsonMaker.JOIN);
        checkTask();
        server.execute(url+path);
    }

    public void getRequest_BoardList(){
        path = "/getRequestList";
        JsonMaker.getInstance().setSeleted(JsonMaker.GET_REQUSET_LIST);
        checkTask();
        server.execute(url+path);
    }

    public void getDonation_BoardList(){
        path = "/getDonationList";
        JsonMaker.getInstance().setSeleted(JsonMaker.GET_DONATION_LIST);
        checkTask();
        server.execute(url+path);
    }

    public void checkTask(){
        if(server != null) {
            server.cancel(true);
            server = null;
        }
        server = new ServerConnection();
    }

    public static synchronized ServerManager getInstance(){
        if(serverManager==null){
            serverManager = new ServerManager();
        }
        return serverManager;
    }


}
