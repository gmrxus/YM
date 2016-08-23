package cn.mrxus.ym.view;

import android.os.Handler;

import cn.mrxus.ym.MainActivity;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseActivity;

/**
 * Created by mrxus on 16/8/23.
 */
public class SplashActivity extends BaseActivity {
    private Handler mHandler=new Handler();
    @Override
    protected void init() {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                go2View(MainActivity.class);
            }
        }, 4000);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
