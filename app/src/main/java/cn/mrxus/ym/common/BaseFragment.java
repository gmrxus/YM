package cn.mrxus.ym.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by mrxus on 16/8/23.
 */
public abstract class BaseFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
            ButterKnife.bind(this, rootView);
            init(rootView);
        }
        return rootView;

    }

    /**
     * 页面初始化
     *
     * @param rootView
     */
    protected abstract void init(View rootView);

    /**
     * 导入页面的布局文件
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 跳转页面
     *
     * @param activityClass
     */
    public void go2Activity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(getActivity(), activityClass));
    }

    /**
     * 携带值跳转
     *
     * @param activityClass
     */
    public void go2ActivitySend(Class<? extends Activity> activityClass, String key, String value) {
        Intent intent = new Intent(getActivity(), activityClass);
        intent.putExtra(key, value);
        startActivity(intent);

    }
}
