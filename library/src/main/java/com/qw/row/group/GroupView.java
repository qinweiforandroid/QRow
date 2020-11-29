package com.qw.row.group;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qw.row.R;
import com.qw.row.core.OnRowClickListener;
import com.qw.row.core.RowDescriptor;
import com.qw.row.core.Row;
import com.qw.row.core.RowFactory;
import com.qw.row.utils.DensityUtil;


public class GroupView extends LinearLayout {

    private Context context;
    private OnRowClickListener listener;
    private GroupDescriptor groupDescriptor;
    private View titleContainer;
    private TextView mGroupViewTitleLabel;
    private LinearLayout mGroupViewContainer;

    public GroupView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeView(context);
    }

    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public GroupView(Context context) {
        super(context);
        initializeView(context);
    }

    private void initializeView(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.widget_row_group_general, this);
        titleContainer = findViewById(R.id.mGroupViewTitleContainer);
        mGroupViewTitleLabel = findViewById(R.id.mGroupViewTitleLabel);
        mGroupViewContainer = findViewById(R.id.mGroupViewContainer);
    }

    public void initializeData(GroupDescriptor groupDescriptor, OnRowClickListener listener) {
        this.listener = listener;
        this.groupDescriptor = groupDescriptor;
    }

    public void notifyDataChanged() {
        if (groupDescriptor.rowDescriptors != null && groupDescriptor.rowDescriptors.size() > 0) {
            if (TextUtils.isEmpty(groupDescriptor.title)) {
                titleContainer.setVisibility(View.GONE);
            } else {
                mGroupViewTitleLabel.setText(groupDescriptor.title);
            }
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = DensityUtil.dip2px(context, 16);
            Row rowView;
            View line;
            RowDescriptor rowDescriptor;
            for (int i = 0; i < groupDescriptor.rowDescriptors.size(); i++) {
                rowDescriptor = groupDescriptor.rowDescriptors.get(i);
                rowView = RowFactory.create(context, rowDescriptor.type);
                rowView.initData(rowDescriptor, listener);
                rowView.notifyDataChanged();
                mGroupViewContainer.addView(rowView);
                if (i != groupDescriptor.rowDescriptors.size() - 1) {
                    line = new View(context);
                    line.setBackgroundColor(getResources().getColor(R.color.widgets_general_row_line));
                    mGroupViewContainer.addView(line, params);
                }
            }
        } else {
            setVisibility(View.GONE);
        }
    }
}
