package com.javayhu.kiss.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * 和View组件相关的工具类
 * <p>
 * Created by javayhu on 2017/3/6.
 */
public class ViewUtils {

    private ViewUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T extends View> T find(View view, int id) {
        if (view == null) {
            return null;
        }
        return (T) view.findViewById(id);
    }

    public static void setBackground(@NonNull View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            view.setBackground(drawable);
        else
            view.setBackgroundDrawable(drawable);
    }

    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return context.getDrawable(id);
        else
            return context.getResources().getDrawable(id);
    }

}
