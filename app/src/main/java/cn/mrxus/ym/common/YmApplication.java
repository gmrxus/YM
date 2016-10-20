package cn.mrxus.ym.common;

import android.app.Application;
import android.content.Context;

/**
 * 自定义application类
 * <p/>
 * Created by mrxus on 16/8/23.
 */
public class YmApplication extends Application {
    public static String xingzuoKey="xingzuo";
    public static final String jiangkangKey ="jiankang";

    private static YmApplication ymApp;
    /**
     * 全局context
     */
    public Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        ymApp = this;


    }


    public static Context getContext() {
        return ymApp;
    }
}
