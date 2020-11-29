package com.qw.row.core;


import android.content.Context;

import com.qw.row.item.GeneralRowView;
import com.qw.row.item.IosRowView;
import com.qw.row.item.SwitchRowView;
import com.qw.row.item.UserIconRowView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


public class RowFactory {

    private static HashMap<String, Class<? extends Row>> mRows = new HashMap<>();

    static {
        mRows.put(Type.ROW_ANDROID, GeneralRowView.class);
        mRows.put(Type.ROW_IOS, IosRowView.class);
        mRows.put(Type.ROW_AVATAR, UserIconRowView.class);
        mRows.put(Type.ROW_SWITCH, SwitchRowView.class);
    }

    public static void put(String type, Class<? extends Row> clazz) {
        if (!mRows.containsKey(type)) {
            mRows.put(type, clazz);
        }
    }

    public static Row create(Context context, String type) {
        if (!isSupport(type)) {
            throw new IllegalArgumentException("not support type " + type);
        }
        try {
            Class clazz = mRows.get(type);
            assert clazz != null;
            Constructor constructor = clazz.getDeclaredConstructor(Context.class);
            constructor.setAccessible(true);
            return (Row) constructor.newInstance(new Object[]{context});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isSupport(String row) {
        return mRows.containsKey(row);
    }
}
