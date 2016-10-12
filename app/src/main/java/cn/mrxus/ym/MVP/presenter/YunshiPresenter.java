package cn.mrxus.ym.MVP.presenter;

import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import cn.mrxus.ym.MVP.BaseView;
import cn.mrxus.ym.MVP.view.IYunshiView;
import cn.mrxus.ym.bean.YunshiBean;
import cn.mrxus.ym.common.YmApplication;
import cn.mrxus.ym.util.DateUtil;
import cn.mrxus.ym.util.HttpUtil;
import cn.mrxus.ym.util.LogUtil;
import cn.mrxus.ym.util.SPUtil;

/**
 * Created by mrxus on 16/8/29.
 */
public class YunshiPresenter {
    private String url = "http://web.juhe.cn:8080/constellation/getAll";
    private String key = "deb1f16de2019e4079288ac36f05121f";
    private IYunshiView view;

    public YunshiPresenter(IYunshiView view) {
        this.view = view;
    }

    /**
     * 获取运势信息的网络请求,数据来源[聚合数据]
     *
     * @param xingzuo
     * @param type
     */
    public void NetWorkForYunshi(String xingzuo, final String type) {

        HttpUtil.RequestBody requestBody = new HttpUtil.RequestBody.Builder()
                .add("key", key)
                .add("consName", xingzuo)
                .add("type", type)
                .build();
        HttpUtil.post(url, requestBody, new HttpUtil.OnNetRequestListener() {
            @Override
            public void onSuccess(String returnValue) {
                LogUtil.e(returnValue);
                if (TextUtils.isEmpty(returnValue)) {
                    return;
                }
                YunshiBean yunshiBean = new Gson().fromJson(returnValue, YunshiBean.class);
                if (0 != yunshiBean.getError_code()) {
                    LogUtil.e("错误码:"+yunshiBean.getError_code());
                } else {
                    if("today".equals(type)){
                        SPUtil.put(YmApplication.getContext(),SPUtil.SPkeys.YUNSHI_TOADY,returnValue);
                    }
                    view.showYunshiInfo(yunshiBean);
                }
            }

            @Override
            public void onFail() {
                view.showError("访问网络出错");
            }
        });
    }
}
