package com.qw.row.core;

import androidx.annotation.NonNull;

/**
 * @author qinwei
 */
public interface OnRowClickListener {
    /**
     * row被点击
     *
     * @param rowView
     */
    void onRowClick(@NonNull Row rowView);
}