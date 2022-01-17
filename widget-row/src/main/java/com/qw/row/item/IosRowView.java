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
import com.qw.row.core.Row;
import com.qw.row.core.OnRowClickListener;
import com.qw.row.core.RowDescriptor;


public class IosRowView extends Row implements OnClickListener {
    private ImageView mWidgetRowActionImg;
    private ImageView mWidgetRowIconImg;
    private TextView mWidgetRowLabel;
    private OnRowClickListener listener;
    private IosDescriptor rowDescriptor;
    private TextView mWidgetRowValueLabel;

    public IosRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public IosRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IosRowView(Context context) {
        super(context);
    }


    @Override
    protected void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.widget_row_ios, this);
        int padding = (int) getContext().getResources().getDimension(R.dimen.widget_general_row_padding);
        setPadding(padding, padding, padding, padding);
        setGravity(Gravity.CENTER_VERTICAL);
        mWidgetRowIconImg = (ImageView) findViewById(R.id.mWidgetRowIconImg);
        mWidgetRowLabel = (TextView) findViewById(R.id.mWidgetRowLabel);
        mWidgetRowValueLabel = (TextView) findViewById(R.id.mWidgetRowValueLabel);
        mWidgetRowActionImg = (ImageView) findViewById(R.id.mWidgetRowActionImg);
    }

    @Override
    public void initData(RowDescriptor rowDescriptor, OnRowClickListener listener) {
        this.rowDescriptor = (IosDescriptor) rowDescriptor;
        this.listener = listener;
    }


    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onRowClick(this);
        }
    }


    @Override
    public void notifyDataChanged() {
        if (rowDescriptor != null) {
            if (rowDescriptor.getIcon() == 0) {
                mWidgetRowIconImg.setVisibility(View.GONE);
            } else {
                mWidgetRowIconImg.setBackgroundResource(rowDescriptor.getIcon());
            }
            mWidgetRowLabel.setText(rowDescriptor.getLabel());
            mWidgetRowValueLabel.setText(rowDescriptor.getValue());
            if (rowDescriptor.id != 0) {
                setBackgroundResource(R.drawable.widgets_general_row_select);
                mWidgetRowActionImg.setBackgroundResource(R.drawable.action_row);
                mWidgetRowActionImg.setVisibility(View.VISIBLE);
                setOnClickListener(this);
            } else {
                mWidgetRowActionImg.setVisibility(View.GONE);
            }
        } else {
            setVisibility(View.GONE);
        }
    }

    @Override
    public int getRowId() {
        return rowDescriptor.id;
    }
}
