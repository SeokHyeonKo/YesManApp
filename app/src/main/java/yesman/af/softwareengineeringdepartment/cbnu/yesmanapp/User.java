package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp;

import java.util.ArrayList;

/**
 * Created by seokhyeon on 2016-06-22.
 */
public class User {
    private static User user = null;
    private String userID;
    private double x;
    private double y;
    private int domain1;
    private int domain2;
    private int domain3;
    private int domain4;
    private int point;
    private int reliability;
    private ArrayList<Board> BoardList = new ArrayList<Board>();
    private Board currentBoard = null;

    public User(){

    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getDomain1() {
        return domain1;
    }

    public void setDomain1(int domain1) {
        this.domain1 = domain1;
    }

    public int getDomain2() {
        return domain2;
    }

    public void setDomain2(int domain2) {
        this.domain2 = domain2;
    }

    public int getDomain3() {
        return domain3;
    }

    public void setDomain3(int domain3) {
        this.domain3 = domain3;
    }

    public int getDomain4() {
        return domain4;
    }

    public void setDomain4(int domain4) {
        this.domain4 = domain4;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getReliability() {
        return reliability;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    public ArrayList<Board> getBoardList() {
        return BoardList;
    }

    public void setBoardList(ArrayList<Board> dashBoardList) {
        this.BoardList = dashBoardList;
    }



    public User(String userID){
        this.userID = userID;
    }

    public void setCurrentDashBoard(Board dashBoard){
        this.currentBoard = dashBoard;
    }

    public Board getCurrentBoard(){
        return currentBoard;
    }

    public String getUserID(){
        return userID;
    }

    public static synchronized User getInstance(){
        if(user==null){
            user = new User();
        }
        return user;
    }

}
