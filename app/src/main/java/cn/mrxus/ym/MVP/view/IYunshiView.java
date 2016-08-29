package cn.mrxus.ym.MVP.view;

import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.bean.YunshiBean;

/**
 * Created by mrxus on 16/8/29.
 */
public interface IYunshiView extends BaseView {
    /**
     * 显示运势信息
     *
     * @param info 星座(汉字)
     */
    void showYunshiInfo(YunshiBean info);

    /**
     * 显示错误信息
     *
     * @param error
     */
    void showError(String error);
}
