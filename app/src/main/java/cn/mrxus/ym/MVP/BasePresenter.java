package cn.mrxus.ym.MVP;

/**
 * Created by mrxus on 16/8/26.
 */
public  interface BasePresenter<V extends BaseView> {
    /**
     * 绑定view
     */
    void attach(V view);

    /**
     * 解绑view
     */
    void dettach();
}
