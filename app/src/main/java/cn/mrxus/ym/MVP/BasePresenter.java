package cn.mrxus.ym.MVP;

/**
 * Created by mrxus on 16/8/26.
 */
public abstract class BasePresenter<V extends BaseView> {
    /**
     * 绑定view
     */
    public abstract void attach(V view);

    /**
     * 解绑view
     */
    public abstract void dettach(V view);
}
