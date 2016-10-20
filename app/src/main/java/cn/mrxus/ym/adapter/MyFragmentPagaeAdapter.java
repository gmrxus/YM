package cn.mrxus.ym.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by mrxus on 2016/10/20.
 */
public class MyFragmentPagaeAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public MyFragmentPagaeAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyFragmentPagaeAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (fragments.get(0) != null) {
                    return fragments.get(0);
                } else {
                    return null;
                }
            case 1:
                if (fragments.get(1) != null) {
                    return fragments.get(1);
                } else {
                    return null;
                }
            case 2:
                if (fragments.get(2) != null) {
                    return fragments.get(2);
                } else {
                    return null;
                }
            case 3:
                if (fragments.get(3) != null) {
                    return fragments.get(3);
                } else {
                    return null;
                }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

}
