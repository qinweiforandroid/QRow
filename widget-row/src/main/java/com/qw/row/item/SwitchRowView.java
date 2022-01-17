package com.qw.row.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.qw.row.R;
import com.qw.row.core.OnRowClickListener;
import com.qw.row.core.Row;
import com.qw.row.core.RowDescriptor;

/**
 * 开关row
 */
public class SwitchRowView extends Row {
    private ImageView mWidgetRowIconImg;
    private TextView mWidgetRowLabel;
    private OnRowClickListener listener;
    private SwitchRowDescriptor descriptor;
    private Switch mWidgetSwitch;

    public SwitchRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SwitchRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwitchRowView(Context context) {
        super(context);
    }

    @Override
    protected void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.widget_row_switch, this);
        int padding = (int) getContext().getResources().getDimension(R.dimen.widget_general_row_padding);
        setPadding(padding, padding, padding, padding);
        setGravity(Gravity.CENTER_VERTICAL);
        mWidgetRowLabel = (TextView) findViewById(R.id.mWidgetRowLabel);
        mWidgetRowIconImg = (ImageView) findViewById(R.id.mWidgetRowIconImg);
        mWidgetSwitch = (Switch) findViewById(R.id.mWidgetSwitch);
    }

    @Override
    public void initData(RowDescriptor rowDescriptor, OnRowClickListener listener) {
        this.listener = listener;
        this.descriptor = (SwitchRowDescriptor) rowDescriptor;
    }

    @Override
    public void notifyDataChanged() {
        if (descriptor.getIcon() == 0) {
            mWidgetRowIconImg.setVisibility(View.GONE);
        } else {
            mWidgetRowIconImg.setBackgroundResource(descriptor.getIcon());
        }
        mWidgetRowLabel.setText(descriptor.getLabel());
        setChecked(descriptor.isChecked());
        mWidgetSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (listener != null) {
                    listener.onRowClick(SwitchRowView.this);
                }
            }
        });
    }

    @Override
    public int getRowId() {
        return descriptor.id;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
        mWidgetSwitch.setOnCheckedChangeListener(listener);
    }

    public boolean isChecked() {
        return mWidgetSwitch.isChecked();
    }

    public void setChecked(boolean checked) {
        mWidgetSwitch.setChecked(checked);
    }

    public void setLabel(String text) {
        mWidgetRowLabel.setText(text);
    }
}
