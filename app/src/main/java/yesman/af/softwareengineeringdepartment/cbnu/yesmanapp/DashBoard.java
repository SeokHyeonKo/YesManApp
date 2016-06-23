package yesman.af.softwareengineeringdepartment.cbnu.yesmanapp;

import java.util.Date;

/**
 * Created by seokhyeon on 2016-06-22.
 */
public class DashBoard {
    private double x;
    private double y;
    private String title;
    private String content;
    private int domain;
    private String requestID;
    private String acceptID;
    private int category;
    private int ischeckrequest;
    private int ischeckaccept;
    private int ismatching;
    private Date date;

    public int getDomain() {
        return domain;
    }

    public void setDomain(int domain) {
        this.domain = domain;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getAcceptID() {
        return acceptID;
    }

    public void setAcceptID(String acceptID) {
        this.acceptID = acceptID;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getIscheckrequest() {
        return ischeckrequest;
    }

    public void setIscheckrequest(int ischeckrequest) {
        this.ischeckrequest = ischeckrequest;
    }

    public int getIscheckaccept() {
        return ischeckaccept;
    }

    public void setIscheckaccept(int ischeckaccept) {
        this.ischeckaccept = ischeckaccept;
    }

    public int getIsmatching() {
        return ismatching;
    }

    public void setIsmatching(int ismatching) {
        this.ismatching = ismatching;
    }

    public DashBoard(String title, String content, Date date, double x, double y){
        this.x = x;
        this.y = y;
        this.title = title;
        this.content = content;
        this.date = date;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
