package cn.mrxus.ym.view.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.view.BasePickerView;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.MVP.model.User;
import cn.mrxus.ym.MVP.presenter.InitSetPresenter;
import cn.mrxus.ym.MVP.view.IInitSetView;
import cn.mrxus.ym.MainActivity;
import cn.mrxus.ym.R;
import cn.mrxus.ym.bean.ProvinceBean;
import cn.mrxus.ym.common.BaseActivity;
import cn.mrxus.ym.util.DateUtil;


/**
 * Created by mrxus on 16/8/24.
 */
public class InitSetActivity extends BaseActivity implements IInitSetView {

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
    private User user;
    private InitSetPresenter presenter;
    private TimePickerView timeDialog;
    private OptionsPickerView durationOptionDialog;
    private OptionsPickerView cyckeOptionDialog;

    @Override
    protected void init() {

        registerPresenter(this);
        user = new User();
        setPickerData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
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
                presenter.finishView();
                break;
            case R.id.tv_last_time://上次时间
                presenter.setlastTime();
                break;
            case R.id.tv_duration://时长
                presenter.setDuration();
                break;
            case R.id.tv_cycle://周期
                presenter.setCycle();
                break;
            case R.id.bt_ok://确定
                presenter.setData(user);
                go2View(MainActivity.class);
                presenter.finishView();

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
                if (timeDialog == null) {
                    timeDialog = new TimePickerView(this, TimePickerView.Type.YEAR_MONTH_DAY);
                    timeDialog.setTitle(getString(R.string.set_last_time));
                    timeDialog.setTime(new Date());
                    timeDialog.setCyclic(false);
                    timeDialog.setCancelable(true);
                    timeDialog.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {
                        @Override
                        public void onTimeSelect(Date date) {
                            String time = DateUtil.getTime(date.getTime());
                            tvLastTime.setText(time);
                            user.setLastTime(time);
                        }
                    });
                }

                return timeDialog;
            case R.id.tv_duration:
                if (durationOptionDialog == null) {
                    durationOptionDialog = new OptionsPickerView(this);
                    durationOptionDialog.setTitle(getString(R.string.set_duration));
                    durationOptionDialog.setPicker(durationOptionList);
                    durationOptionDialog.setCyclic(false);
                    durationOptionDialog.setLabels("天");
                    durationOptionDialog.setSelectOptions(2);
                    durationOptionDialog.setCancelable(true);
                    durationOptionDialog.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int option2, int options3) {
                            String durateion = durationOptionList.get(options1).getPickerViewText();
                            tvDuration.setText(durateion + "天");
                            user.setDuration(durateion);
                        }
                    });
                }

                return durationOptionDialog;
            case R.id.tv_cycle:
                if (cyckeOptionDialog == null) {
                    cyckeOptionDialog = new OptionsPickerView(this);
                    cyckeOptionDialog.setTitle(getString(R.string.set_cycle));
                    cyckeOptionDialog.setPicker(cycleOptionList);
                    cyckeOptionDialog.setCyclic(false);
                    cyckeOptionDialog.setLabels("天");
                    cyckeOptionDialog.setSelectOptions(8);
                    cyckeOptionDialog.setCancelable(true);
                    cyckeOptionDialog.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
                        @Override
                        public void onOptionsSelect(int options1, int option2, int options3) {
                            String cycle = cycleOptionList.get(options1).getPickerViewText();
                            tvCycle.setText(cycle + "天");
                            user.setCycle(cycle);
                        }
                    });
                }
                return cyckeOptionDialog;

            default:
                throw new RuntimeException("参数错了,只能给限定的三个参数");
        }

    }


    @Override
    public void showLaseTimePicker() {
        buildDialog(tvLastTime).show();

    }

    @Override
    public void showDurationPicker() {
        buildDialog(tvDuration).show();

    }

    @Override
    public void showCyclePicker() {
        buildDialog(tvCycle).show();

    }

    @Override
    public void finishThis() {
        finish();
    }

    @Override
    public void restoreSet(String lastTiem, String duration, String cycle) {
        tvLastTime.setText(lastTiem);
        tvDuration.setText(duration);
        tvCycle.setText(cycle);
    }


    @Override
    public void registerPresenter(BaseView View) {
        presenter = new InitSetPresenter((IInitSetView) View);
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

}
