package cn.mrxus.ym.util;

import java.text.DecimalFormat;

/**
 * Created by mrxus on 16/9/7.
 */
public class StringUtil {
    /**
     * 带百分比的字符串转换成数字,舍去小数部分
     * @param str
     * @return
     */
    public static int str2int(String str) {
        if (str.contains("%")) {
            str = str.replaceAll("%", "");
            int f = Integer.valueOf(str);
            return f;
        }
        return 0;
    }
}
