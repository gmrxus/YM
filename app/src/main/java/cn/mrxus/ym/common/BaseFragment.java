package cn.mrxus.ym.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
     * @return
     */
    protected abstract int getLayoutId();
}
