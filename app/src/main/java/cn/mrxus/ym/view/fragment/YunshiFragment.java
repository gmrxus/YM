package cn.mrxus.ym.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseFragment;
import cn.mrxus.ym.common.YmApplication;
import cn.mrxus.ym.view.activity.YunshiActivity;

/**
 * Created by mrxus on 16/8/26.
 */
public class YunshiFragment extends BaseFragment {

    @BindView(R.id.iv_yunshi_baiyang)
    ImageView baiyang;
    @BindView(R.id.iv_yunshi_jinniu)
    ImageView jinniu;
    @BindView(R.id.iv_yunshi_shuangzi)
    ImageView shuangzi;
    @BindView(R.id.iv_yunshi_juxie)
    ImageView juxie;
    @BindView(R.id.iv_yunshi_shizi)
    ImageView shizi;
    @BindView(R.id.ll_yunshi_chunv)
    ImageView chunv;
    @BindView(R.id.iv_yunshi_tianping)
    ImageView tianping;
    @BindView(R.id.iv_yunshi_tianxie)
    ImageView tianxie;
    @BindView(R.id.iv_yunshi_sheshou)
    ImageView sheshou;
    @BindView(R.id.iv_yunshi_mojie)
    ImageView mojie;
    @BindView(R.id.iv_yunshi_shuiping)
    ImageView shuiping;
    @BindView(R.id.iv_yunshi_shaungyu)
    ImageView shuangyu;

    private String xingzuo;

    @Override
    protected void init(View rootView) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_yunshi;
    }



    @OnClick({R.id.iv_yunshi_baiyang, R.id.iv_yunshi_jinniu, R.id.iv_yunshi_shuangzi, R.id.iv_yunshi_juxie, R.id.iv_yunshi_shizi, R.id.ll_yunshi_chunv, R.id.iv_yunshi_tianping, R.id.iv_yunshi_tianxie, R.id.iv_yunshi_sheshou, R.id.iv_yunshi_mojie, R.id.iv_yunshi_shuiping, R.id.iv_yunshi_shaungyu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_yunshi_baiyang:
                xingzuo="baiyang";
                break;
            case R.id.iv_yunshi_jinniu:
                xingzuo="jinniu";
                break;
            case R.id.iv_yunshi_shuangzi:
                xingzuo="shuangzi";
                break;
            case R.id.iv_yunshi_juxie:
                xingzuo="juxie";
                break;
            case R.id.iv_yunshi_shizi:
                xingzuo="shizi";
                break;
            case R.id.ll_yunshi_chunv:
                xingzuo="chunv";
                break;
            case R.id.iv_yunshi_tianping:
                xingzuo="tianping";
                break;
            case R.id.iv_yunshi_tianxie:
                xingzuo="tianxie";
                break;
            case R.id.iv_yunshi_sheshou:
                xingzuo="sheshou";
                break;
            case R.id.iv_yunshi_mojie:
                xingzuo="mojie";
                break;
            case R.id.iv_yunshi_shuiping:
                xingzuo="shuiping";
                break;
            case R.id.iv_yunshi_shaungyu:
                xingzuo="shuangyu";
                break;
        }
        go2ActivitySend(YunshiActivity.class, YmApplication.xingzuoKey,xingzuo);

    }
}
