package cn.mrxus.ym.view.activity;

import android.os.Handler;
import android.text.TextUtils;

import cn.mrxus.ym.MainActivity;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseActivity;
import cn.mrxus.ym.common.YmApplication;
import cn.mrxus.ym.util.SPUtil;

/**
 * Created by mrxus on 16/8/23.
 */
public class SplashActivity extends BaseActivity {
    private Handler mHandler = new Handler();

    @Override
    protected void init() {

        delayStartActivity();

    }

    private void delayStartActivity() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isInitSet()) {
                    go2Activity(MainActivity.class);
                } else {
                    go2Activity(InitSetActivity.class);
                }
            }
        }, 2000);
    }

    private boolean isInitSet() {
        if (TextUtils.isEmpty((String) SPUtil.get(YmApplication.getContext(), SPUtil.SPkeys.VALUE_INIT_SET, ""))) {
            return false;
        }
        return true;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

