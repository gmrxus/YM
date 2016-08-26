package cn.mrxus.ym.MVP.view;

import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.common.BaseActivity;

/**
 * Created by mrxus on 16/8/26.
 */
public interface IInitSetView extends BaseView {
    /**
     * 显示上次姨妈选择时间框
     */
    void showLaseTimePicker();

    /**
     * 显示时长选择框
     */
    void showDurationPicker();

    /**
     * 显示周期选择框
     */
    void showCyclePicker();

    /**
     * 退出本页
     */
    void finishThis();

    /**
     * 如果已经设置,给控件赋上已经设置好了的值
     */
    void restoreSet(String lastTiem,String duration,String cycle);


}
