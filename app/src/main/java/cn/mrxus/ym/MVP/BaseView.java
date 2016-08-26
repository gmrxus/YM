package cn.mrxus.ym.MVP;

import android.view.View;

import com.bigkoo.pickerview.view.BasePickerView;

/**
 * Created by mrxus on 16/8/26.
 */
public  interface BaseView<P extends BasePresenter> {
     <V extends BaseView> void registerPresenter(V View);
    void unregisterPresenter();
}
