package cn.mrxus.ym.view.fragment;

import android.view.View;

import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseFragment;
import cn.mrxus.ym.view.activity.InitSetActivity;
import cn.mrxus.ym.view.activity.SetPasswordActivity;


/**
 * Created by mrxus on 16/8/23.
 */
public class WodeFragment extends BaseFragment implements View.OnClickListener {
    @Override
    protected void init(View rootView) {
        rootView.findViewById(R.id.rl_set_password).setOnClickListener(this);
        rootView.findViewById(R.id.rl_set_preiod).setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wode;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_set_preiod:
                go2Activity(InitSetActivity.class);
                break;
            case R.id.rl_set_password:
                go2Activity(SetPasswordActivity.class);
                break;
        }
    }
}
