package cn.mrxus.ym.view.fragment;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.MVP.presenter.PeiduiPresenter;
import cn.mrxus.ym.MVP.view.IPeiduiView;
import cn.mrxus.ym.R;
import cn.mrxus.ym.common.BaseFragment;


/**
 * Created by mrxus on 16/8/26.
 */
public class PeiduiFragment extends BaseFragment implements View.OnClickListener, IPeiduiView {

    private AlertDialog.Builder builder;

    private String[] xingzuos = {"白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};
    private int postiton = -1;
    private Button btSelectNan;
    private Button btSelectNv;
    private String nanXingzuo;
    private String nvXingzuo;
    private PeiduiPresenter presenter;


    @Override
    protected void init(View rootView) {
        registerPresenter(this);
        findView(rootView);
    }

    private void findView(View rootView) {
        btSelectNan = (Button) rootView.findViewById(R.id.bt_peidui_select_nan);
        btSelectNan.setOnClickListener(this);
        btSelectNv = (Button) rootView.findViewById(R.id.bt_peidui_select_nv);
        btSelectNv.setOnClickListener(this);
        rootView.findViewById(R.id.bt_peidui_ok).setOnClickListener(this);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_peidui;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_peidui_select_nan:
                presenter.showNanDialog();
                break;
            case R.id.bt_peidui_select_nv:
                presenter.showNvDialog();
                break;
            case R.id.bt_peidui_ok:
                presenter.peidui(nanXingzuo,nvXingzuo);
                break;
        }
    }

    private AlertDialog createSelectXingzuoDialog(final int sex) {
        builder = new AlertDialog.Builder(this.getActivity());
        builder.setTitle("请选择星座");
        builder.setSingleChoiceItems(xingzuos, 0, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                postiton = i;
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (1 == sex) {
                    btSelectNan.setBackground(getResources().getDrawable(R.drawable.shap_peidui_select_nan));
                    btSelectNan.setText(xingzuos[postiton]);
                    nanXingzuo=xingzuos[postiton];
                }
                if (0 == sex) {
                    btSelectNv.setBackground(getResources().getDrawable(R.drawable.shap_peidui_select_nv));
                    btSelectNv.setText(xingzuos[postiton]);
                    nvXingzuo=xingzuos[postiton];
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }

    @Override
    public void showNanDialog() {
        createSelectXingzuoDialog(1).show();
    }

    @Override
    public void showNvDialog() {
        createSelectXingzuoDialog(0).show();
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this.getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public <V extends BaseView> void registerPresenter(V view) {
        presenter = new PeiduiPresenter((IPeiduiView) view);
    }

    @Override
    public void unregisterPresenter() {
        presenter=null;
    }

    @Override
    public void onDestroy() {
        unregisterPresenter();
        super.onDestroy();
    }
}
