package cn.mrxus.ym.MVP.model;

import android.text.TextUtils;

import com.google.gson.Gson;

import cn.mrxus.ym.common.YmApplication;
import cn.mrxus.ym.util.SPUtil;

/**
 * Created by mrxus on 16/8/26.
 */
public class InitSetAct implements IInitSetAct {
    @Override
    public void initSet(String lastTime, String duration, String cycle) {
        String json = new Gson().toJson(new User(lastTime, duration, cycle));
        SPUtil.put(YmApplication.getContext(), SPUtil.SPkeys.VALUE_INIT_SET, json);
    }

    @Override
    public User restoreSet() {
        String json = (String) SPUtil.get(YmApplication.getContext(), SPUtil.SPkeys.VALUE_INIT_SET, "");
        if (!TextUtils.isEmpty(json)) {
            return new Gson().fromJson(json, User.class);
        } else {
            return null;

        }
    }


    @Override
    public void cleanSet() {
        SPUtil.put(YmApplication.getContext(), SPUtil.SPkeys.VALUE_INIT_SET, "");
    }
}
