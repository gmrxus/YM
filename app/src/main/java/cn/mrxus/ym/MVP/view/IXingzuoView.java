package cn.mrxus.ym.MVP.view;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import cn.mrxus.ym.MVP.BaseView;

/**
 * Created by mrxus on 16/8/26.
 */
public interface IXingzuoView extends BaseView {
    void showYunshiFragment();

    void showPeiduiFragment();

    void setView(View view, @ColorRes int colorId, @DrawableRes int drawableId);
}
