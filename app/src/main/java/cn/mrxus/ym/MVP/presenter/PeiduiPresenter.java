package cn.mrxus.ym.MVP.presenter;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import cn.mrxus.ym.BuildConfig;
import cn.mrxus.ym.MVP.view.IPeiduiView;
import cn.mrxus.ym.common.YmApplication;
import cn.mrxus.ym.util.HttpUtil;
import cn.mrxus.ym.util.LogUtil;

/**
 * Created by mrxus on 16/9/9.
 */
public class PeiduiPresenter {
    public static final String peiduiKey = "ad869e499af44d3c96706a72a0af95fb";//星座配对接口key[阿凡达云数据平台]
    public static final String peiduiUrl = "http://api.avatardata.cn/XingZuoPeiDui/Lookup";//星座配对url[阿凡达云数据平台]
    private IPeiduiView peiduiView;

    public PeiduiPresenter(IPeiduiView peiduiView) {
        this.peiduiView = peiduiView;

    }

    public void peidui(String nanXingzuo, String nvXingzuo) {
        if (TextUtils.isEmpty(nanXingzuo) || TextUtils.isEmpty(nvXingzuo)) {
            peiduiView.showToast("请选择星座后再进行配对哦~");
            return;
        }

        HttpUtil.RequestBody body = new HttpUtil.RequestBody.Builder()
                .add("key", peiduiKey)
                .add("xingzuo1", nanXingzuo)
                .add("xingzuo2", nvXingzuo)
                .build();

        HttpUtil.post(peiduiUrl, body, new HttpUtil.OnNetRequestListener() {
            @Override
            public void onSuccess(String returnValue) {
                JsonElement parse = new JsonParser().parse(returnValue);
                if("\"Succes\"".equals(parse.getAsJsonObject().get("reason").toString())){
                    peiduiView.showPeiduiResult(parse.getAsJsonObject().get("result").getAsJsonObject().get("content2").toString());
                }else {
                    LogUtil.e("没啥好配的,散了吧");
                }
            }

            @Override
            public void onFail() {

            }
        });
    }

    public void showNanDialog() {
        peiduiView.showNanDialog();
    }

    public void showNvDialog() {
        peiduiView.showNvDialog();
    }
}
