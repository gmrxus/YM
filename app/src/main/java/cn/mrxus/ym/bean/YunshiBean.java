package cn.mrxus.ym.bean;

import java.util.List;

/**
 * Created by mrxus on 16/8/29.
 */
public class YunshiBean {


    /**
     * date : 20160829
     * name : 金牛座
     * datetime : 2016年08月29日
     * all : 60%
     * color : 橙色
     * health : 81%
     * love : 80%
     * job : 求职：乱打乱撞，反而得到心仪的职位。
     * money : 60%
     * happyMagic :
     * year : 2016
     * number : 8
     * weekth : 36
     * month : 8
     * QFriend : 双鱼座
     * summary : 也许你从来没发现彼此如此能聊，甜言蜜语说不完，对方也似乎很能懂得你的心思，接着甜言蜜语最让你感到很受用。今天是你增进感情关系的极佳日子。
     * work : 60%
     * luckyStone : 天河石
     * resultcode : 200
     * error_code : 0
     * reason : Does not exist in the consName!
     * result : []
     */
    private String date;
    private String name;
    private String datetime;
    private String all;
    private String color;
    private String health;
    private String love;
    private String job;
    private String money;
    private String happyMagic;
    private int year;
    private int number;
    private int weekth;
    private int month;
    private String QFriend;
    private String summary;
    private String work;
    private String resultcode;
    private int error_code;

    private String reason;
    private List<?> result;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getHappyMagic() {
        return happyMagic;
    }

    public void setHappyMagic(String happyMagic) {
        this.happyMagic = happyMagic;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWeekth() {
        return weekth;
    }

    public void setWeekth(int weekth) {
        this.weekth = weekth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getQFriend() {
        return QFriend;
    }

    public void setQFriend(String QFriend) {
        this.QFriend = QFriend;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<?> getResult() {
        return result;
    }

    public void setResult(List<?> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "YunshiBean{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", datetime='" + datetime + '\'' +
                ", all='" + all + '\'' +
                ", color='" + color + '\'' +
                ", health='" + health + '\'' +
                ", love='" + love + '\'' +
                ", job='" + job + '\'' +
                ", money='" + money + '\'' +
                ", happyMagic='" + happyMagic + '\'' +
                ", year=" + year +
                ", number=" + number +
                ", weekth=" + weekth +
                ", month=" + month +
                ", QFriend='" + QFriend + '\'' +
                ", summary='" + summary + '\'' +
                ", work='" + work + '\'' +
                ", resultcode='" + resultcode + '\'' +
                ", error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
