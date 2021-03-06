package cn.mrxus.ym.view.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.MVP.presenter.YunshiPresenter;
import cn.mrxus.ym.MVP.view.IYunshiView;
import cn.mrxus.ym.R;
import cn.mrxus.ym.bean.XingzuoJiyu;
import cn.mrxus.ym.bean.YunshiBean;
import cn.mrxus.ym.common.BaseActivity;
import cn.mrxus.ym.common.YmApplication;
import cn.mrxus.ym.util.SPUtil;
import cn.mrxus.ym.util.StringUtil;

/**
 * Created by mrxus on 16/8/27.
 */
public class YunshiActivity extends BaseActivity implements IYunshiView {

    @BindView(R.id.iv_yunshi_back)
    ImageView ivYunshiBack;
    @BindView(R.id.tv_yunshi_jintian)
    TextView tvYunshiJintian;
    @BindView(R.id.tv_yunshi_mingtian)
    TextView tvYunshiMingtian;
    @BindView(R.id.tv_yunshi_benzhou)
    TextView tvYunshiBenzhou;
    @BindView(R.id.tv_yunshi_benyue)
    TextView tvYunshiBenyue;
    @BindView(R.id.iv_yunshi_icon)
    ImageView ivYunshiIcon;
    @BindView(R.id.tv_yunshi_name)
    TextView tvYunshiName;
    @BindView(R.id.tv_yunshi_time)
    TextView tvYunshiTime;
    @BindView(R.id.tv_yunshi_wenben)
    TextView tvYunshiWenben;
    @BindView(R.id.iv_yunshi_zonghezhishu)
    ImageView ivYunshiZonghezhishu;
    @BindView(R.id.iv_yunshi_aiqingzhishu)
    ImageView ivYunshiAiqingzhishu;
    @BindView(R.id.iv_yunshi_caiyunzhishu)
    ImageView ivYunshiCaiyunzhishu;
    @BindView(R.id.iv_yunshi_gongzuozhishu)
    ImageView ivYunshiGongzuozhishu;
    @BindView(R.id.tv_yunshi_jiankangzhishu)
    TextView tvYunshiJiankangzhishu;
    @BindView(R.id.tv_yunshi_xingyunshuzi)
    TextView tvYunshiXingyunshuzi;
    @BindView(R.id.tv_yunshi_xingyunyanse)
    TextView tvYunshiXingyunyanse;
    @BindView(R.id.tv_yunshi_guirenxingzuo)
    TextView tvYunshiGuirenxingzuo;
    @BindView(R.id.tv_yunshi_content1)
    TextView tvYunshiContent1;
//    @BindView(R.id.tv_yunshi_context2)
//    TextView tvYunshiContext2;

    private String xingzuo;
    private YunshiPresenter presenter;
    private String netKey_xingzuo;
    private String netKey_type;
    private View lastView;
    private Handler mHandler = new Handler();

    @Override
    protected void init() {
        registerPresenter(this);
        Intent intent = getIntent();
        xingzuo = intent.getStringExtra(YmApplication.xingzuoKey);
        if (xingzuo != null) {
            initViewSet(xingzuo);
            onClick(tvYunshiJintian);
        }

    }

    /**
     * 初始化星座图标和标题
     *
     * @param tag
     */
    private void initViewSet(String tag) {
        selectIconAndTitle(tag);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yunshi;
    }


    @OnClick({R.id.iv_yunshi_back, R.id.tv_yunshi_jintian, R.id.tv_yunshi_mingtian, R.id.tv_yunshi_benzhou, R.id.tv_yunshi_benyue})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_yunshi_back:
                finish();
                return;
            case R.id.tv_yunshi_jintian:
                netKey_type = "today";
                break;
            case R.id.tv_yunshi_mingtian:
                netKey_type = "tomorrow";

                break;
            case R.id.tv_yunshi_benzhou:
                netKey_type = "week";

                break;
            case R.id.tv_yunshi_benyue:
                netKey_type = "month";
                break;

        }
        setSelectTitleInfo(view, lastView);


    }

    private void selectIconAndTitle(String xingzuo) {
        switch (xingzuo) {
            case "baiyang":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.baiyang_b));
                tvYunshiName.setText(getResources().getString(R.string.baiyangzuo));
                tvYunshiTime.setText(getResources().getString(R.string.baiyang_t));
                netKey_xingzuo = "白羊座";
                break;
            case "jinniu":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.jinniu_b));
                tvYunshiName.setText(getResources().getString(R.string.jinniuzuo));
                tvYunshiTime.setText(getResources().getString(R.string.jinniu_t));
                netKey_xingzuo = "金牛座";

                break;
            case "shuangzi":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.shuangzi_b));
                tvYunshiName.setText(getResources().getString(R.string.shuangzizuo));
                tvYunshiTime.setText(getResources().getString(R.string.shuangzi_t));
                netKey_xingzuo = "双子座";

                break;
            case "juxie":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.juxie_b));
                tvYunshiName.setText(getResources().getString(R.string.juxiezuo));
                tvYunshiTime.setText(getResources().getString(R.string.juxie_t));
                netKey_xingzuo = "巨蟹座";

                break;
            case "shizi":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.shizi_b));
                tvYunshiName.setText(getResources().getString(R.string.shizizuo));
                tvYunshiTime.setText(getResources().getString(R.string.shizi_t));
                netKey_xingzuo = "狮子座";

                break;
            case "chunv":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.chunv_b));
                tvYunshiName.setText(getResources().getString(R.string.chunvzuo));
                tvYunshiTime.setText(getResources().getString(R.string.chunv_t));
                netKey_xingzuo = "处女座";

                break;
            case "tianping":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.tianping_b));
                tvYunshiName.setText(getResources().getString(R.string.tianpingzuo));
                tvYunshiTime.setText(getResources().getString(R.string.tianping_t));
                netKey_xingzuo = "天秤座";

                break;
            case "tianxie":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.tianxie_b));
                tvYunshiName.setText(getResources().getString(R.string.tianxiezuo));
                tvYunshiTime.setText(getResources().getString(R.string.tianxie_t));
                netKey_xingzuo = "天蝎座";

                break;
            case "sheshou":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.sheshou_b));
                tvYunshiName.setText(getResources().getString(R.string.sheshouzuo));
                tvYunshiTime.setText(getResources().getString(R.string.sheshou_t));
                netKey_xingzuo = "射手座";

                break;

            case "mojie":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.mojie_b));
                tvYunshiName.setText(getResources().getString(R.string.mojiezuo));
                tvYunshiTime.setText(getResources().getString(R.string.mojie_t));
                netKey_xingzuo = "摩羯座";

                break;
            case "shuiping":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.shuiping_b));
                tvYunshiName.setText(getResources().getString(R.string.shuipingzuo));
                tvYunshiTime.setText(getResources().getString(R.string.shuiping_t));
                netKey_xingzuo = "水瓶座";

                break;
            case "shuangyu":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.shuangyu_b));
                tvYunshiName.setText(getResources().getString(R.string.shuangyuzuo));
                tvYunshiTime.setText(getResources().getString(R.string.shuangyu_t));
                netKey_xingzuo = "双鱼座";
                break;
            default:
                break;


        }

    }

    @Override
    public void showYunshiInfo(final YunshiBean info) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //今天和明天的运势设置
                if (0 == info.getWeekth() && 0 == info.getMonth()) {
                    tvYunshiWenben.setText("\t\t" + info.getSummary());
                    tvYunshiContent1.setText("\t\t" + XingzuoJiyu.getXingzuoXingge(info.getName()));

                    ivYunshiZonghezhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(info.getAll())));
                    ivYunshiAiqingzhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(info.getLove())));
                    ivYunshiCaiyunzhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(info.getMoney())));
                    ivYunshiGongzuozhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(info.getWork())));

                    tvYunshiJiankangzhishu.setText(info.getHealth());
                    tvYunshiXingyunshuzi.setText(info.getNumber() + "");
                    tvYunshiXingyunyanse.setText(info.getColor());
                    tvYunshiGuirenxingzuo.setText(info.getQFriend());
                }
                //本周运势设置(图片和指数取自今天运势)
                if (0 != info.getWeekth()) {
                    tvYunshiWenben.setText(info.getHealth() + "\n" + info.getJob());
                    tvYunshiContent1.setText(info.getLove() + "\n" + info.getMoney() + "\n" + info.getWork());

                    YunshiBean todayInfo = new Gson().fromJson((String) SPUtil.get(YmApplication.getContext(), SPUtil.SPkeys.YUNSHI_TOADY, ""), YunshiBean.class);
                    ivYunshiZonghezhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(todayInfo.getAll())));
                    ivYunshiAiqingzhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(todayInfo.getLove())));
                    ivYunshiCaiyunzhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(todayInfo.getMoney())));
                    ivYunshiGongzuozhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(todayInfo.getWork())));

                    tvYunshiJiankangzhishu.setText(todayInfo.getHealth());
                    tvYunshiXingyunshuzi.setText(todayInfo.getNumber() + "");
                    tvYunshiXingyunyanse.setText(todayInfo.getColor());
                    tvYunshiGuirenxingzuo.setText(todayInfo.getQFriend());
                }
                //本月运势设置(图片和指数取自今天运势)
                if (0 != info.getMonth()) {
                    if(info.getAll().length()<info.getLove().length()){
                        tvYunshiWenben.setText(info.getAll());
                        tvYunshiContent1.setText(info.getLove());
                    }else {
                        tvYunshiContent1.setText(info.getAll());
                        tvYunshiWenben.setText(info.getLove());
                    }


                    YunshiBean todayInfo = new Gson().fromJson((String) SPUtil.get(YmApplication.getContext(), SPUtil.SPkeys.YUNSHI_TOADY, ""), YunshiBean.class);
                    ivYunshiZonghezhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(todayInfo.getAll())));
                    ivYunshiAiqingzhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(todayInfo.getLove())));
                    ivYunshiCaiyunzhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(todayInfo.getMoney())));
                    ivYunshiGongzuozhishu.setImageDrawable(genjuzhishufanhuitupian(StringUtil.str2int(todayInfo.getWork())));

                    tvYunshiJiankangzhishu.setText(todayInfo.getHealth());
                    tvYunshiXingyunshuzi.setText(todayInfo.getNumber() + "");
                    tvYunshiXingyunyanse.setText(todayInfo.getColor());
                    tvYunshiGuirenxingzuo.setText(todayInfo.getQFriend());
                }


            }
        });
    }

    @Override
    public void showError(final String error) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(YunshiActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 选择title上的按钮后的动作
     *
     * @param v
     * @param lastV
     */
    private void setSelectTitleInfo(View v, View lastV) {
        if (v == lastView) {
            return;
        }
        ((TextView) v).setTextColor(getResources().getColor(R.color.mainColor));
        presenter.NetWorkForYunshi(netKey_xingzuo, netKey_type);
        if (lastView != null) {
            if (lastV instanceof TextView) {
                ((TextView) lastV).setTextColor(getResources().getColor(R.color.black));
            }
        }
        if (v != lastView) {
            lastView = v;
        }
    }

    @Override
    public void registerPresenter(BaseView view) {
        this.presenter = new YunshiPresenter((IYunshiView) view);
    }

    @Override
    public void unregisterPresenter() {
        presenter = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterPresenter();
    }

    /**
     * 根据指数返回图片
     *
     * @param zhishu
     * @return
     */
    private Drawable genjuzhishufanhuitupian(int zhishu) {
        if (zhishu >= 0 && zhishu <= 20) {
            return getResources().getDrawable(R.drawable.pingfen_1xing);
        } else if (zhishu > 20 && zhishu <= 40) {
            return getResources().getDrawable(R.drawable.pingfen_2xing);
        } else if (zhishu > 40 && zhishu <= 60) {
            return getResources().getDrawable(R.drawable.pingfen_3xing);
        } else if (zhishu > 60 && zhishu <= 80) {
            return getResources().getDrawable(R.drawable.pingfen_4xing);
        } else if (zhishu > 80 && zhishu <= 100) {
            return getResources().getDrawable(R.drawable.pingfen_5xing);
        } else {
            return getResources().getDrawable(R.drawable.pingfen_3xing);
        }

    }


}
