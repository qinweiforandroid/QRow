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
import com.qw.row.core.Row;
import com.qw.row.core.RowDescriptor;
import com.qw.row.utils.RowImageLoader;


/**
 * 用戶头像row
 */
public class UserIconRowView extends Row implements OnClickListener {
    private ImageView mRowActionImg;
    private ImageView mRowIconImg;
    private TextView mRowLabel;
    private OnRowClickListener listener;
    private UserIconRowDescriptor rowDescriptor;
    private ImageView mUserIconImg;

    public UserIconRowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public UserIconRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UserIconRowView(Context context) {
        super(context);
    }


    @Override
    protected void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.widget_row_user_icon, this);
        int padding = (int) getContext().getResources().getDimension(R.dimen.widget_general_row_padding);
        setPadding(padding, padding, padding, padding);
        setGravity(Gravity.CENTER_VERTICAL);
        mRowIconImg = (ImageView) findViewById(R.id.mRowIconImg);
        mRowLabel = (TextView) findViewById(R.id.mRowLabel);
        mUserIconImg = (ImageView) findViewById(R.id.mUserIconImg);
        mRowActionImg = (ImageView) findViewById(R.id.mRowActionImg);
    }

    @Override
    public void initData(RowDescriptor rowDescriptor, OnRowClickListener listener) {
        this.listener = listener;
        this.rowDescriptor = (UserIconRowDescriptor) rowDescriptor;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onRowClick(this);
        }
    }

    @Override
    public void notifyDataChanged() {
        if (rowDescriptor.getIcon() == 0) {
            mRowIconImg.setVisibility(View.GONE);
        } else {
            mRowIconImg.setBackgroundResource(rowDescriptor.getIcon());
        }
        RowImageLoader.load(rowDescriptor.getAvatar(), mUserIconImg);
        mRowLabel.setText(rowDescriptor.getLabel());
        if (rowDescriptor.id != 0) {
            setBackgroundResource(R.drawable.widgets_general_row_select);
            mRowActionImg.setBackgroundResource(R.drawable.action_row);
            mRowActionImg.setVisibility(View.VISIBLE);
            setOnClickListener(this);
        } else {
            mRowActionImg.setVisibility(View.GONE);
        }
    }

    @Override
    public int getRowId() {
        return rowDescriptor.id;
    }
}