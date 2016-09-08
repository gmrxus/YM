package cn.mrxus.ym.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseFragment;

/**
 * Created by mrxus on 16/8/26.
 */
public class PeiduiFragment extends BaseFragment {
    @BindView(R.id.bt_peidui_select_nan)
    Button btPeiduiSelectNan;
    @BindView(R.id.bt_peidui_select_nv)
    Button btPeiduiSelectNv;
    @BindView(R.id.bt_peidui_ok)
    Button btPeiduiOk;

    @Override
    protected void init(View rootView) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_peidui;
    }



    @OnClick({R.id.bt_peidui_select_nan, R.id.bt_peidui_select_nv, R.id.bt_peidui_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_peidui_select_nan:

                break;
            case R.id.bt_peidui_select_nv:
                break;
            case R.id.bt_peidui_ok:
                break;
        }
    }
}
