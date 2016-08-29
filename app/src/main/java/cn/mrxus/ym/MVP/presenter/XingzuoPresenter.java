package cn.mrxus.ym.MVP.presenter;

import android.view.View;

import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.MVP.view.IXingzuoView;
import cn.mrxus.ym.R;

/**
 * Created by mrxus on 16/8/26.
 */
public class XingzuoPresenter {
    private IXingzuoView view;

    public XingzuoPresenter(IXingzuoView view) {
        this.view=view;
    }

    public void selectedYunshi(View v1, View v2) {
        view.showYunshiFragment();
        view.setView(v1, R.color.mainColor, R.drawable.bg_xingzuo_head_left_pick);
        view.setView(v2, R.color.black, R.drawable.bg_xingzuo_head_right_unpick);

    }

    public void selectedPeidui(View v1, View v2) {
        view.showPeiduiFragment();
        view.setView(v1, R.color.mainColor, R.drawable.bg_xingzuo_head_right_pick);
        view.setView(v2, R.color.black, R.drawable.bg_xingzuo_head_left_unpick);
    }

}
