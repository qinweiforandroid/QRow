package com.qw.row.core;

import android.content.Context;

/**
 * Created by qinwei on 2019-12-19 19:57
 * email: qinwei_it@163.com
 */
public interface IRowFactory<T> {
    T create(Context context);
}
