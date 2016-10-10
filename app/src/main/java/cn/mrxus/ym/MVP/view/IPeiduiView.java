package cn.mrxus.ym.MVP.view;

import cn.mrxus.ym.MVP.BaseView;

/**
 * Created by mrxus on 16/9/9.
 */
public interface IPeiduiView extends BaseView{
    /**
     * 左边星座选择弹窗
     */
    void showNanDialog();

    /**
     * 右边星座选择弹窗
     */
    void showNvDialog();

    /**
     * 吐司
     * @param msg
     */
    void showToast(String msg);

    /**
     * 显示配对结果
     * @param result
     */
    void showPeiduiResult(String result);
}
