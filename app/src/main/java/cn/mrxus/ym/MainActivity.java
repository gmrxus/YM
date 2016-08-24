package cn.mrxus.ym;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.ym.common.BaseActivity;
import cn.mrxus.ym.view.fragment.JiankangFragment;
import cn.mrxus.ym.view.fragment.MainFragment;
import cn.mrxus.ym.view.fragment.WodeFragment;
import cn.mrxus.ym.view.fragment.XingzuoFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.ll_main_shouye)
    LinearLayout llMainShouye;
    @BindView(R.id.ll_main_xingzuo)
    LinearLayout llMainXingzuo;
    @BindView(R.id.ll_main_jiankang)
    LinearLayout llMainJiankang;
    @BindView(R.id.ll_main_wode)
    LinearLayout llMainWode;
    @BindView(R.id.tv_shouye)
    TextView tvShouye;
    @BindView(R.id.tv_xingzuo)
    TextView tvXingzuo;
    @BindView(R.id.tv_jiankang)
    TextView tvJiankang;
    @BindView(R.id.tv_wode)
    TextView tvWode;
    private MainFragment mainFragment;
    private XingzuoFragment xingzuoFragment;
    private JiankangFragment jiankangFragment;
    private WodeFragment wodeFragment;
    private int thisShowFragmentNumber = 0;
    private int lastShowFragmentNumber = 1;
    private List<View> viewList = new ArrayList();

    @Override
    protected void init() {
        viewList.add(tvShouye);
        viewList.add(tvXingzuo);
        viewList.add(tvJiankang);
        viewList.add(tvWode);
        showFragment(1);
        initSet();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.ll_main_shouye, R.id.ll_main_xingzuo, R.id.ll_main_jiankang, R.id.ll_main_wode})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_main_shouye:
                showFragment(1);
                break;
            case R.id.ll_main_xingzuo:
                showFragment(2);
                break;
            case R.id.ll_main_jiankang:
                showFragment(3);
                break;
            case R.id.ll_main_wode:
                showFragment(4);
                break;

        }
    }


    /**
     * 显示哪个页面
     *
     * @param fragmentNumber
     */
    private void showFragment(int fragmentNumber) {
        if (thisShowFragmentNumber != 0) {
            lastShowFragmentNumber = thisShowFragmentNumber;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        switch (fragmentNumber) {
            case 1:
                if (1 == thisShowFragmentNumber) {
                    return;
                }
                if (mainFragment == null) {
                    mainFragment = new MainFragment();
                }
                thisShowFragmentNumber = 1;
                ft.replace(R.id.content, mainFragment).commit();
                break;
            case 2:
                if (2 == thisShowFragmentNumber) {
                    return;
                }
                if (xingzuoFragment == null) {
                    xingzuoFragment = new XingzuoFragment();
                }
                thisShowFragmentNumber = 2;
                ft.replace(R.id.content, xingzuoFragment).commit();

                break;
            case 3:
                if (3 == thisShowFragmentNumber) {
                    return;
                }
                if (jiankangFragment == null) {
                    jiankangFragment = new JiankangFragment();
                }
                thisShowFragmentNumber = 3;
                ft.replace(R.id.content, jiankangFragment).commit();
                break;
            case 4:
                if (4 == thisShowFragmentNumber) {
                    return;
                }
                if (wodeFragment == null) {
                    wodeFragment = new WodeFragment();
                }
                thisShowFragmentNumber = 4;
                ft.replace(R.id.content, wodeFragment).commit();
                break;
            default:
                break;

        }
        setAnimation(viewList, lastShowFragmentNumber, 1.2f, 1f, 100);
        setAnimation(viewList, thisShowFragmentNumber, 1f, 1.2f, 200);

    }


    /**
     * 改变view大小的属性动画
     *
     * @param viewList 需要改变大小控件的集合
     * @param location 第几个控件
     * @param bSize    初始大小
     * @param eSize    最终大小
     * @param duration 动画持续时间
     */
    private void setAnimation(List<View> viewList, int location, float bSize, float eSize, long duration) {

        View view = viewList.get(location - 1);
        AnimatorSet as = new AnimatorSet();
        if (view != null) {
            ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", bSize, eSize);
            ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", bSize, eSize);
            as.play(scaleX).with(scaleY);
            as.setDuration(duration);
            as.start();
        }
    }

    /**
     * 首次进入页面的初始设置
     */
    private void initSet() {
        showSetWindow();
    }

    private void showSetWindow() {

    }


}
