package cn.mrxus.ym.view.fragment;

import android.view.View;
import android.widget.Button;

import cn.aigestudio.datepicker.views.DatePicker;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseFragment;
import cn.mrxus.ym.util.DateUtil;

/**
 * Created by mrxus on 16/8/23.
 */
public class MainFragment extends BaseFragment {


    private Button btn;
    private DatePicker dp;

    @Override
    protected void init(View rootView) {
        initView(rootView);
        initData();
    }

    private void initData() {
        int year = DateUtil.get(DateUtil.YEAR);
        int month=DateUtil.get(DateUtil.MONTH);
        dp.setDate(year,month);
    }

    private void initView(View rootView) {
        btn = (Button) rootView.findViewById(R.id.btn_main);
        dp = (DatePicker) rootView.findViewById(R.id.dp_main);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

}
