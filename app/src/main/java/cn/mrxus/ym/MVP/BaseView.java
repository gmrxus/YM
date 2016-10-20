package cn.mrxus.ym.MVP;

import android.view.View;

import com.bigkoo.pickerview.view.BasePickerView;

/**
 * Created by mrxus on 16/8/26.
 */
public interface BaseView {
    /**
     * 注册presenter
     *
     * @param view
     * @param <V>
     */
    <V extends BaseView> void registerPresenter(V view);

    /**
     * 注销presenter
     */
    void unregisterPresenter();
}