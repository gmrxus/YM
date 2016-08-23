package cn.mrxus.ym.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by mrxus on 16/8/23.
 */
public class YmApplication extends Application {
    public Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        initContext();
    }

    private void initContext() {
        this.context=getApplicationContext();
    }
}
