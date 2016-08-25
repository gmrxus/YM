package cn.mrxus.ym.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.view.BasePickerView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.ym.MainActivity;
import cn.mrxus.ym.R;
import cn.mrxus.ym.bean.InitSetDataBean;
import cn.mrxus.ym.bean.ProvinceBean;
import cn.mrxus.ym.common.BaseActivity;
import cn.mrxus.ym.util.DateUtil;
import cn.mrxus.ym.util.SPUtil;


/**
 * Created by mrxus on 16/8/24.
 */
public class InitSetActivity extends BaseActivity implements TimePickerView.OnTimeSelectListener {

    @BindView(R.id.bt_back)
    Button btBack;
    @BindView(R.id.tv_last_time)
    TextView tvLastTime;
    @BindView(R.id.tv_duration)
    TextView tvDuration;
    @BindView(R.id.tv_cycle)
    TextView tvCycle;
    @BindView(R.id.bt_ok)
    Button btOk;


    private ArrayList<ProvinceBean> durationOptionList = new ArrayList<>();
    private ArrayList<ProvinceBean> cycleOptionList = new ArrayList<>();
    private Gson gson;

    @Override
    protected void init() {
        setPickerData();
    }

    /**
     * 设置选项的值
     */
    private void setPickerData() {
        for (int i = 2; i < 16; i++) {
            durationOptionList.add(new ProvinceBean(i, i + ""));
        }
        for (int i = 20; i < 61; i++) {
            cycleOptionList.add(new ProvinceBean(i, i + ""));
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_init_set;
    }


    @OnClick({R.id.bt_back, R.id.tv_last_time, R.id.tv_duration, R.id.tv_cycle, R.id.bt_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_back://返回
                finish();
                break;
            case R.id.tv_last_time://上次时间
                buildDialog(tvLastTime).show();
                break;
            case R.id.tv_duration://时长
                buildDialog(tvDuration).show();
                break;
            case R.id.tv_cycle://周期
                buildDialog(tvCycle).show();
                break;
            case R.id.bt_ok://确定
                if (gson == null) {
                    gson = new Gson();
                }
                String json = gson.toJson(new InitSetDataBean(tvLastTime.getText().toString(), tvDuration.getText().toString(), tvCycle.getText().toString()));
                SPUtil.put(this, SPUtil.SPkeys.IS_INIT_SET, true);
                SPUtil.put(this, SPUtil.SPkeys.VALUE_INIT_SET, json);
                go2View(MainActivity.class);
                break;
        }
    }


    /**
     * 根据不同控件创建不同时间选择框
     *
     * @param view
     * @return
     */
    private BasePickerView buildDialog(View view) {
        switch (view.getId()) {
            case R.id.tv_last_time:
                TimePickerView timeDialog = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY);
                timeDialog.setTitle(getString(R.string.set_last_time));
                timeDialog.setTime(new Date());
                timeDialog.setCyclic(false);
                timeDialog.setCancelable(true);
                timeDialog.setOnTimeSelectListener(this);
                return timeDialog;
            case R.id.tv_duration:
                OptionsPickerView durationOptionDialog = new OptionsPickerView(this);
                durationOptionDialog.setTitle(getString(R.string.set_duration));
                durationOptionDialog.setPicker(durationOptionList);
                durationOptionDialog.setCyclic(false);
                durationOptionDialog.setLabels("天");
                durationOptionDialog.setSelectOptions(2);
                durationOptionDialog.setCancelable(true);
                durationOptionDialog.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        tvDuration.setText(durationOptionList.get(options1).getPickerViewText() + "天");
                    }
                });
                return durationOptionDialog;
            case R.id.tv_cycle:
                OptionsPickerView cyckeOptionDialog = new OptionsPickerView(this);
                cyckeOptionDialog.setTitle(getString(R.string.set_cycle));
                cyckeOptionDialog.setPicker(cycleOptionList);
                cyckeOptionDialog.setCyclic(false);
                cyckeOptionDialog.setLabels("天");
                cyckeOptionDialog.setSelectOptions(8);
                cyckeOptionDialog.setCancelable(true);
                cyckeOptionDialog.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3) {
                        tvCycle.setText(cycleOptionList.get(options1).getPickerViewText() + "天");
                    }
                });
                return cyckeOptionDialog;

            default:
                throw new RuntimeException("参数错了,只能给限定的三个参数");
        }

    }

    @Override
    public void onTimeSelect(Date date) {
        tvLastTime.setText(DateUtil.getTime(date.getTime()));
    }


}
