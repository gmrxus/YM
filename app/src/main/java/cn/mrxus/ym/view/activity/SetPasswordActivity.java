package cn.mrxus.ym.view.activity;

import android.view.View;
import android.widget.EditText;

import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseActivity;

/**
 * Created by mrxus on 2016/10/13.
 */
public class SetPasswordActivity extends BaseActivity implements View.OnClickListener {
    private EditText etYuanshimima;
    private EditText etXinmima;
    private EditText etQuerenmima;

    @Override
    protected void init() {
        findViewById(R.id.iv_setpassword_back).setOnClickListener(this);
        findViewById(R.id.bt_setpassword_ok).setOnClickListener(this);
        findViewById(R.id.tv_setpassword_forgotpassowrd).setOnClickListener(this);
        etYuanshimima = (EditText) findViewById(R.id.et_setpassword_yuanshimima);
        etXinmima = (EditText) findViewById(R.id.et_setpassword_xinmima);
        etQuerenmima = (EditText) findViewById(R.id.et_setpassword_querenmima);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_password;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_setpassword_back:
                this.finish();
                break;
            case R.id.bt_setpassword_ok:
                break;
            case R.id.tv_setpassword_forgotpassowrd:
                break;
        }
    }
}
