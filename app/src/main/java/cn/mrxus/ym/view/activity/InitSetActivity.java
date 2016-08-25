package cn.mrxus.ym.view.activity;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseActivity;
import cn.mrxus.ym.util.DateUtil;

/**
 * Created by mrxus on 16/8/24.
 */
public class InitSetActivity extends BaseActivity {

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

    @Override
    protected void init() {

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
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
                showDatePopup(view);

                break;
            case R.id.tv_duration://时长
                break;
            case R.id.tv_cycle://周期
                break;
            case R.id.bt_ok://确定
                break;
        }
    }

    private void showDatePopup(View view) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateListener, DateUtil.get(10), DateUtil.get(DateUtil.MONTH), DateUtil.get(DateUtil.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        }
    };
}
