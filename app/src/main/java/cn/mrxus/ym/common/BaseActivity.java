package cn.mrxus.ym.common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by mrxus on 16/8/23.
 */
public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init();
    }


    /**
     * 页面的初始化函数
     */
    protected abstract void init();

    /**
     * 给activity设置布局文件
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 跳转到指定activity
     *
     * @param activityClass
     */
    public void go2View(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
