package cn.mrxus.ym.MVP.view;

import cn.mrxus.ym.MVP.BaseView;

/**
 * Created by mrxus on 16/8/29.
 */
public interface IYunshiView extends BaseView {
    /**
     * 显示运势信息
     *
     * @param xingzuo 星座(汉字)
     * @param type    [today,tomorrow,week,nextweek,month,year]
     */
    void showYunshiInfo(String xingzuo, String type);
    
}
