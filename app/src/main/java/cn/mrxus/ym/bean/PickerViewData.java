package cn.mrxus.ym.bean;

import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * Created by mrxus on 16/8/26.
 */
public class PickerViewData implements IPickerViewData {
    private String content;

    public PickerViewData(String content) {
        this.content = content;
    }

    @Override
    public String getPickerViewText() {
        return content;
    }
}
