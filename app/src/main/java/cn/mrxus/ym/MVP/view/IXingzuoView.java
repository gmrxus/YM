package cn.mrxus.ym.MVP.view;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.View;

import cn.mrxus.ym.MVP.BaseView;

/**
 * Created by mrxus on 16/8/26.
 */
public interface IXingzuoView extends BaseView {
    /**
     * 显示运势页面
     */
    void showYunshiFragment();

    /**
     * 显示配对页面
     */
    void showPeiduiFragment();

    /**
     * 设置按钮的文字颜色和背景图
     *
     * @param view
     * @param colorId
     * @param drawableId
     */
    void setView(View view, @ColorRes int colorId, @DrawableRes int drawableId);

}
