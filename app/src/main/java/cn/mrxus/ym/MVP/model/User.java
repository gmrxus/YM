package cn.mrxus.ym.MVP.model;

/**
 * Created by mrxus on 16/8/26.
 */
public class User {
    private String lastTime;
    private String duration;
    private String cycle;
    private int status;

    public User() {
    }

    public User(String lastTime, String duration, String cycle) {
        this.lastTime = lastTime;
        this.duration = duration;
        this.cycle = cycle;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
