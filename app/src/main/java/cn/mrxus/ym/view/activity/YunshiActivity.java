package cn.mrxus.ym.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseActivity;

/**
 * Created by mrxus on 16/8/27.
 */
public class YunshiActivity extends BaseActivity {

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
    @BindView(R.id.tv_yunshi_bennian)
    TextView tvYunshiBennian;
    @BindView(R.id.iv_yunshi_icon)
    ImageView ivYunshiIcon;
    @BindView(R.id.tv_yunshi_name)
    TextView tvYunshiName;
    @BindView(R.id.tv_yunshi_time)
    TextView tvYunshiTime;
    @BindView(R.id.tv_yunshi_wenben)
    TextView tvYunshiWenben;

    private String xingzuo;

    @Override
    protected void init() {
        Intent intent = getIntent();
        xingzuo = intent.getStringExtra("xingzuo");
        if (xingzuo != null) {
            initViewSet(xingzuo);
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


    @OnClick({R.id.iv_yunshi_back, R.id.tv_yunshi_jintian, R.id.tv_yunshi_mingtian, R.id.tv_yunshi_benzhou, R.id.tv_yunshi_benyue, R.id.tv_yunshi_bennian})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_yunshi_back:
                finish();
                break;
            case R.id.tv_yunshi_jintian:
                break;
            case R.id.tv_yunshi_mingtian:
                break;
            case R.id.tv_yunshi_benzhou:
                break;
            case R.id.tv_yunshi_benyue:
                break;
            case R.id.tv_yunshi_bennian:
                break;
        }
    }

    private void selectIconAndTitle(String xingzuo) {
        switch (xingzuo) {
            case "baiyang":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.baiyang_b));
                tvYunshiName.setText(getResources().getString(R.string.baiyangzuo));
                tvYunshiTime.setText(getResources().getString(R.string.baiyang_t));
                break;
            case "jinniu":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.jinniu_b));
                tvYunshiName.setText(getResources().getString(R.string.jinniuzuo));
                tvYunshiTime.setText(getResources().getString(R.string.jinniu_t));
                break;
            case "shuangzi":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.shuangzi_b));
                tvYunshiName.setText(getResources().getString(R.string.shuangzizuo));
                tvYunshiTime.setText(getResources().getString(R.string.shuangzi_t));
                break;
            case "juxie":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.juxie_b));
                tvYunshiName.setText(getResources().getString(R.string.juxiezuo));
                tvYunshiTime.setText(getResources().getString(R.string.juxie_t));
                break;
            case "shizi":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.shizi_b));
                tvYunshiName.setText(getResources().getString(R.string.shizizuo));
                tvYunshiTime.setText(getResources().getString(R.string.shizi_t));
                break;
            case "chunv":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.chunv_b));
                tvYunshiName.setText(getResources().getString(R.string.chunvzuo));
                tvYunshiTime.setText(getResources().getString(R.string.chunv_t));
                break;
            case "tianping":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.tianping_b));
                tvYunshiName.setText(getResources().getString(R.string.tianpingzuo));
                tvYunshiTime.setText(getResources().getString(R.string.tianping_t));
                break;
            case "tianxie":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.tianxie_b));
                tvYunshiName.setText(getResources().getString(R.string.tianxiezuo));
                tvYunshiTime.setText(getResources().getString(R.string.tianxie_t));
                break;
            case "sheshou":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.sheshou_b));
                tvYunshiName.setText(getResources().getString(R.string.sheshouzuo));
                tvYunshiTime.setText(getResources().getString(R.string.sheshou_t));
                break;

            case "mojie":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.mojie_b));
                tvYunshiName.setText(getResources().getString(R.string.mojiezuo));
                tvYunshiTime.setText(getResources().getString(R.string.mojie_t));
                break;
            case "shuiping":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.shuiping_b));
                tvYunshiName.setText(getResources().getString(R.string.shuipingzuo));
                tvYunshiTime.setText(getResources().getString(R.string.shuiping_t));
                break;
            case "shuangyu":
                ivYunshiIcon.setImageDrawable(getResources().getDrawable(R.drawable.shuangyu_b));
                tvYunshiName.setText(getResources().getString(R.string.shuangyuzuo));
                tvYunshiTime.setText(getResources().getString(R.string.shuangyu_t));
                break;
            default:
                break;


        }

    }
}
