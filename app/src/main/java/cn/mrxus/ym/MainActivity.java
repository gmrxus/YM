package cn.mrxus.ym;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.ym.adapter.MyFragmentPagaeAdapter;
import cn.mrxus.ym.common.BaseActivity;
import cn.mrxus.ym.view.fragment.JiankangFragment;
import cn.mrxus.ym.view.fragment.MainFragment;
import cn.mrxus.ym.view.fragment.WodeFragment;
import cn.mrxus.ym.view.fragment.XingzuoFragment;

public class MainActivity extends BaseActivity {


    @BindView(R.id.content)
    ViewPager content;
    @BindView(R.id.tv_shouye)
    TextView tvShouye;
    @BindView(R.id.ll_main_shouye)
    LinearLayout llMainShouye;
    @BindView(R.id.tv_xingzuo)
    TextView tvXingzuo;
    @BindView(R.id.ll_main_xingzuo)
    LinearLayout llMainXingzuo;
    @BindView(R.id.tv_jiankang)
    TextView tvJiankang;
    @BindView(R.id.ll_main_jiankang)
    LinearLayout llMainJiankang;
    @BindView(R.id.tv_wode)
    TextView tvWode;
    @BindView(R.id.ll_main_wode)
    LinearLayout llMainWode;
    private MyFragmentPagaeAdapter mFragmentViewPagerAdapter;
    private FragmentManager fm;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private View originalView;


    @Override
    public void init() {
        if (fragments.size() == 0) {
            addFragment();
        }
        fm = getSupportFragmentManager();
        mFragmentViewPagerAdapter = new MyFragmentPagaeAdapter(fm, fragments);
        initViewPager();
        setAnimator(0);
    }

    public List addFragment() {
        fragments.add(new MainFragment());
        fragments.add(new XingzuoFragment());
        fragments.add(new JiankangFragment());
        fragments.add(new WodeFragment());
        return fragments;
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {

        content.setAdapter(mFragmentViewPagerAdapter);
        content.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setAnimator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main1;
    }


    @OnClick({R.id.ll_main_shouye, R.id.ll_main_xingzuo, R.id.ll_main_jiankang, R.id.ll_main_wode})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_main_shouye:
                content.setCurrentItem(0);
                break;
            case R.id.ll_main_xingzuo:
                content.setCurrentItem(1);
                break;
            case R.id.ll_main_jiankang:
                content.setCurrentItem(2);
                break;
            case R.id.ll_main_wode:
                content.setCurrentItem(3);
                break;
        }
    }

    /**
     * 导航栏的文字动画
     *
     * @param v1
     * @param original
     * @param target
     */
    private void clickAnimation(View v1, float original, float target) {
        AnimatorSet as = new AnimatorSet();
        ObjectAnimator v1X = ObjectAnimator.ofFloat(v1, "scaleX", original, target);
        ObjectAnimator v1Y = ObjectAnimator.ofFloat(v1, "scaleY", original, target);
        if (originalView != null) {
            ObjectAnimator v2X = ObjectAnimator.ofFloat(originalView, "scaleX", target, original);
            ObjectAnimator v2Y = ObjectAnimator.ofFloat(originalView, "scaleY", target, original);
            as.play(v1X).with(v1Y).with(v2X).with(v2Y);
        } else {
            as.play(v1X).with(v1Y);
        }
        as.setDuration(200);
        as.start();

    }

    /**
     * 根据不同的page显示不同的动画效果
     *
     * @param position
     */
    private void setAnimator(int position) {
        switch (position) {
            case 0:
                clickAnimation(tvShouye, 1f, 1.3f);
                originalView = tvShouye;
                break;
            case 1:
                clickAnimation(tvXingzuo, 1f, 1.3f);
                originalView = tvXingzuo;
                break;
            case 2:
                clickAnimation(tvJiankang, 1f, 1.3f);
                originalView = tvJiankang;
                break;
            case 3:
                clickAnimation(tvWode, 1f, 1.3f);
                originalView = tvWode;
                break;
        }
    }


}
