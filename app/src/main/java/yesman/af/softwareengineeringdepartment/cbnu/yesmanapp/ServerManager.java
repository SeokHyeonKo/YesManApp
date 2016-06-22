package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp;

/**
 * Created by seokhyeon on 2016-06-22.
 */
public class ServerManager {

    private static ServerManager serverManager;
    private ServerConnection server;
    private String path;
    private String url = "http://kossi.iptime.org:2000/YesManProject";

    public void registerDahsBoard(DashBoard dashBoard){
        path = "/RegisterDashBoard.jsp";
        checkTask();
        if(server==null) server = new ServerConnection();
        //임시 유저
        User user = new User("123");
        user.setCurrentDashBoard(dashBoard);
        server.setUser(user);
        server.execute(url+path);
    }

    public void checkTask(){
        if(server != null) {
            server.cancel(true);
            server = null;
            server = new ServerConnection();
        }
    }

    public static synchronized ServerManager getInstance(){
        if(serverManager==null){
            serverManager = new ServerManager();
        }
        return serverManager;
    }


}
