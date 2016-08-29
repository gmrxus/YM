package cn.mrxus.ym.MVP.presenter;

import android.view.View;

import cn.mrxus.ym.MVP.BasePresenter;
import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.MVP.model.IInitSetAct;
import cn.mrxus.ym.MVP.model.InitSetAct;
import cn.mrxus.ym.MVP.model.User;
import cn.mrxus.ym.MVP.view.IInitSetView;

/**
 * Created by mrxus on 16/8/26.
 */
public class InitSetPresenter implements BasePresenter {
    private IInitSetView view;
    private IInitSetAct act;

    public InitSetPresenter(IInitSetView view) {
        attach(view);
        act = new InitSetAct();
    }

    public void setlastTime() {
        view.showLaseTimePicker();
    }

    public void setDuration() {
        view.showDurationPicker();
    }

    public void setCycle() {
        view.showCyclePicker();
    }

    public void finishView() {
        view.finishThis();
    }

    public void setData(User user) {
        act.initSet(user.getLastTime(), user.getDuration(), user.getCycle());
    }

    public void onResume() {
        User user = act.restoreSet();
        if (user == null) {
            return;
        }
        view.restoreSet(user.getLastTime(), user.getDuration(), user.getCycle());
    }

    @Override
    public void attach(BaseView view) {
        this.view = (IInitSetView) view;
    }

    @Override
    public void dettach() {
        view = null;
    }
}
