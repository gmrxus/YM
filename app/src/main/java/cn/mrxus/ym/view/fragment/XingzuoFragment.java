package cn.mrxus.ym.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.MVP.presenter.XingzuoPresenter;
import cn.mrxus.ym.MVP.view.IXingzuoView;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseFragment;
import cn.mrxus.ym.util.LogUtil;

/**
 * Created by mrxus on 16/8/23.
 */
public class XingzuoFragment extends BaseFragment implements IXingzuoView {
    @BindView(R.id.bt_yunshi)
    Button btYunshi;
    @BindView(R.id.bt_peidui)
    Button btPeidui;
    @BindView(R.id.xingzuo_content)
    FrameLayout xingzuoContent;

    private YunshiFragment yunshiFragment;
    private PeiduiFragment peiduiFragment;

    private XingzuoPresenter presenter;


    @Override
    protected void init(View rootView) {
        presenter.selectedYunshi(btYunshi, btPeidui);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xingzuo;
    }

    @Override
    public void showYunshiFragment() {
        if (yunshiFragment == null) {
            yunshiFragment = new YunshiFragment();
        }
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.xingzuo_content, yunshiFragment).commit();
    }

    @Override
    public void showPeiduiFragment() {
        if (peiduiFragment == null) {
            peiduiFragment = new PeiduiFragment();
        }
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.xingzuo_content, peiduiFragment).commit();
    }

    @Override
    public void registerPresenter(BaseView View) {
        presenter = new XingzuoPresenter((IXingzuoView) View);
    }

    @Override
    public void unregisterPresenter() {
        presenter = null;
    }


    @OnClick({R.id.bt_yunshi, R.id.bt_peidui})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_yunshi:
                presenter.selectedYunshi(btYunshi, btPeidui);
                break;
            case R.id.bt_peidui:
                presenter.selectedPeidui(btPeidui, btYunshi);
                break;
        }
    }

    @Override
    public void setView(View view, @Nullable @ColorRes int colorId, @DrawableRes int drawableId) {
        if (view instanceof Button) {
            ((Button) view).setTextColor(getResources().getColor(colorId));
            view.setBackground(getResources().getDrawable(drawableId));
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterPresenter();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerPresenter(this);
    }


}
