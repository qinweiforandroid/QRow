package com.qw.row.core;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class Row extends LinearLayout {

    public Row(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }

    public Row(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public Row(Context context) {
        super(context);
        initView(context, null);
    }

    protected abstract void initView(Context context, AttributeSet attrs);

    /**
     * @param rowDescriptor
     * @param listener
     */
    public abstract void initData(RowDescriptor rowDescriptor, OnRowClickListener listener);

    /**
     * 更新ui
     */
    public abstract void notifyDataChanged();

    /**
     * 获取id
     *
     * @return
     */
    public abstract int getRowId();
}
