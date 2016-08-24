package cn.mrxus.ym.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseActivity;

/**
 * Created by mrxus on 16/8/24.
 */
public class InitSetActivity extends BaseActivity {
    @BindView(R.id.bt_back)
    Button btBack;
    @BindView(R.id.et_last_time)
    EditText etLastTime;
    @BindView(R.id.et_duration)
    EditText etDuration;
    @BindView(R.id.et_cycle)
    EditText etCycle;
    @BindView(R.id.bt_ok)
    Button btOk;

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_init_set;
    }



    @OnClick({R.id.bt_back, R.id.bt_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back:
                finish();
                break;
            case R.id.bt_ok:
                break;
        }
    }
}
