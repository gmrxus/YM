package cn.mrxus.ym.view.activity;

import android.widget.TextView;

import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseActivity;
import cn.mrxus.ym.common.YmApplication;

/**
 * Created by mrxus on 2016/10/12.
 */
public class JiankangWenzhangActivity extends BaseActivity {
    private TextView tv;

    @Override
    protected void init() {
        tv = (TextView)findViewById(R.id.tv);
        String type = getIntent().getStringExtra(YmApplication.jiangkangKey);
        tv.setText(type);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_jiankang_wenzhang;
    }
}
