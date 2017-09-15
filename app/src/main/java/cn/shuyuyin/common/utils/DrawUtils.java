package cn.shuyuyin.common.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by wz on 17-9-15.
 */

public class DrawUtils {

    //提供一个指定颜色和圆角半径的Drawable对象
    public static GradientDrawable getDrawable(int rgb, float radius){
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(rgb);//设置颜色
        gradientDrawable.setGradientType(GradientDrawable.RECTANGLE);//设置显示的样式
        gradientDrawable.setCornerRadius(radius);//设置圆角的半径
        gradientDrawable.setStroke(1,rgb);//描边
        return gradientDrawable;
    }

    public static StateListDrawable getSelector(Drawable normalDrawable, Drawable pressDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        //给当前的颜色选择器添加选中图片指向状态，未选中图片指向状态
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed}, pressDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, normalDrawable);
        //设置默认状态
        stateListDrawable.addState(new int[]{}, normalDrawable);
        return stateListDrawable;
    }
}
