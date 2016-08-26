package cn.mrxus.ym.MVP.model;

/**
 * Created by mrxus on 16/8/26.
 */
public interface IInitSetAct {
    void initSet(String lastTiem,String duration,String cycle);
    User restoreSet();
    void cleanSet();
}
