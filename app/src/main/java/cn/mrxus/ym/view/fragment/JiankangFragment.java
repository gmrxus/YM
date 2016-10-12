package cn.mrxus.ym.view.fragment;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseFragment;
import cn.mrxus.ym.common.YmApplication;
import cn.mrxus.ym.view.activity.JiankangWenzhangActivity;


/**
 * Created by mrxus on 16/8/23.
 */
public class JiankangFragment extends BaseFragment implements View.OnClickListener {
    private TextView tvBaohuluanchao;
    private TextView tvBuchongcijisu;
    private TextView tvBuqixue;
    private TextView tvKangshuailaoxiaomiaozhao;
    private TextView tvPaidu;
    private TextView tvRufangyingyang;

    @Override
    protected void init(View rootView) {
        tvBaohuluanchao = (TextView) rootView.findViewById(R.id.tv_jiankang_baohuluanchao);
        tvBaohuluanchao.setOnClickListener(this);
        tvBuchongcijisu = (TextView) rootView.findViewById(R.id.tv_jiankang_buchongcijisu);
        tvBuchongcijisu.setOnClickListener(this);
        tvBuqixue = (TextView) rootView.findViewById(R.id.tv_jiankang_buqixue);
        tvBuqixue.setOnClickListener(this);
        tvKangshuailaoxiaomiaozhao = (TextView) rootView.findViewById(R.id.tv_jiankang_kangshuailaoxiaomiaozhao);
        tvKangshuailaoxiaomiaozhao.setOnClickListener(this);
        tvPaidu = (TextView) rootView.findViewById(R.id.tv_jiankang_paidu);
        tvPaidu.setOnClickListener(this);
        tvRufangyingyang = (TextView) rootView.findViewById(R.id.tv_jiankang_rufangyingyang);
        tvRufangyingyang.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_jiankang;

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_jiankang_baohuluanchao:
                break;
            case R.id.tv_jiankang_buqixue:
                break;
            case R.id.tv_jiankang_paidu:
                break;
            case R.id.tv_jiankang_buchongcijisu:
                break;
            case R.id.tv_jiankang_kangshuailaoxiaomiaozhao:
                break;
            case R.id.tv_jiankang_rufangyingyang:
                break;
        }
        go2ActivitySend(JiankangWenzhangActivity.class, YmApplication.jiangkangKey,
                view instanceof TextView ? ((TextView) view).getText().toString() : "");


    }
}
