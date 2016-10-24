package com.scene.myapplication.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * @FileName:com.scene.myapplication.utils.ToastUtil.java
 * @功能描述：
 * @author: scene
 * @date: 2016-10-21 16:27
 */
public class ToastUtil {
    private static Toast toast = null;

    public static void showToast(Context context, CharSequence text) {
        if (text == null || TextUtils.isEmpty(text)) {
            return;
        }
        int toastTime;
        if (text.length() > 10) {
            toastTime = Toast.LENGTH_LONG;
        } else {
            toastTime = Toast.LENGTH_SHORT;
        }
        if (toast == null) {
            toast = Toast.makeText(context, text, toastTime);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
}
