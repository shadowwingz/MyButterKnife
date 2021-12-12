package com.shadowwingz.lib_reflection;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class Binding {
  public static void bind(Activity activity) {
    // 遍历 Activity 的所有字段
    for (Field field : activity.getClass().getDeclaredFields()) {
      // 找出有 BindView 的字段
      BindView bindView = field.getAnnotation(BindView.class);
      if (bindView != null) {
        // 取出 BindView 的值，比如 R.id.tv_show
        // 然后进行 findViewById 实例化控件
        View view = activity.findViewById(bindView.value());
        try {
          // 绕过 Java 的权限控制，强制给字段赋值。
          field.setAccessible(true);
          // 使用反射给控件赋值
          field.set(activity, view);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
