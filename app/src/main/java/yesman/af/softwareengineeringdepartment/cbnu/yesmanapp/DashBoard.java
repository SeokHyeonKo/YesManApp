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
    private Date date;

    public DashBoard(String title,String content,Date date,double x,double y){
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
