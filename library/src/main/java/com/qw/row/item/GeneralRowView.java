package com.qw.row.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.qw.row.R;
import com.qw.row.core.OnRowClickListener;
import com.qw.row.core.RowDescriptor;
import com.qw.row.core.Row;


public class GeneralRowView extends Row implements OnClickListener {
    private ImageView mRowIconImg;
    private TextView mRowLabel;
    private GeneralDescriptor descriptor;
    private OnRowClickListener listener;

    public GeneralRowView(Context context) {
        super(context);
    }

    @Override
    protected void initView(Context context, AttributeSet attrs) {
        int padding = (int) getContext().getResources().getDimension(R.dimen.widget_general_row_padding);
        setPadding(padding, padding, padding, padding);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.widget_row_android, this);
        mRowIconImg = findViewById(R.id.mRowIconImg);
        mRowLabel = findViewById(R.id.mRowLabel);
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onRowClick(this);
        }
    }

    @Override
    public void initData(RowDescriptor rowDescriptor, OnRowClickListener listener) {
        if (rowDescriptor instanceof GeneralDescriptor) {
            this.listener = listener;
            this.descriptor = (GeneralDescriptor) rowDescriptor;
        } else {
            throw new IllegalArgumentException("GeneralRowDescriptor can use");
        }
    }

    @Override
    public void notifyDataChanged() {
        if (descriptor == null) {
            setVisibility(View.GONE);
            return;
        }
        if (descriptor.getIcon() == 0) {
            mRowIconImg.setVisibility(View.GONE);
        } else {
            mRowIconImg.setBackgroundResource(descriptor.getIcon());
        }
        mRowLabel.setText(descriptor.getLabel());
        if (descriptor.getId() != 0) {
            setOnClickListener(this);
            setBackgroundResource(R.drawable.widgets_general_row_select);
        }
    }

    @Override
    public int getRowId() {
        return descriptor.getId();
    }
}