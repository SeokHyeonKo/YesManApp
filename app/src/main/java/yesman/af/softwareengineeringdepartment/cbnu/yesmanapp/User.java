package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp;

import java.util.ArrayList;

/**
 * Created by seokhyeon on 2016-06-22.
 */
public class User {
    String userID;
    ArrayList<DashBoard> dashBoardList = new ArrayList<DashBoard>();
    DashBoard currentDashBoard;
    public User(String userID){
        this.userID = userID;
    }

    public void setCurrentDashBoard(DashBoard dashBoard){
        this.currentDashBoard = dashBoard;
    }

    public DashBoard getCurrentDashBoard(){
        return currentDashBoard;
    }

    public String getUserID(){
        return userID;
    }



}
