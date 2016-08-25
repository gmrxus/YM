package cn.mrxus.ym.bean;

/**
 * Created by mrxus on 16/8/26.
 */
public class InitSetDataBean {
    private String lastDate;
    private String duration;
    private String cycle;


    public InitSetDataBean(String lastDate, String duration, String cycle) {
        this.lastDate = lastDate;
        this.duration = duration;
        this.cycle = cycle;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
