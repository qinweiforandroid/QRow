package com.qw.row.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

import com.qw.row.group.GroupView;
import com.qw.row.core.OnRowClickListener;
import com.qw.row.utils.RowUtil;
import com.qw.row.utils.RowLog;


public class ContainerView extends LinearLayout implements OnTouchListener {

    private Context context;
    private OnRowClickListener listener;
    private ContainerDescriptor descriptor;

    public ContainerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeView(context);
    }

    public ContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(context);
    }

    public ContainerView(Context context) {
        super(context);
        initializeView(context);
    }

    private void initializeView(Context context) {
        this.context = context;
        setOrientation(VERTICAL);
        setOnTouchListener(this);
    }

    public void initializeData(ContainerDescriptor descriptor, OnRowClickListener listener) {
        this.descriptor = descriptor;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        removeAllViews();
        if (descriptor.groupDescriptors != null && descriptor.groupDescriptors.size() > 0) {
            GroupView groupView;
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            params.topMargin = RowUtil.dip2px(context, 10);

            for (int i = 0; i < descriptor.groupDescriptors.size(); i++) {
                groupView = new GroupView(context);
                groupView.initializeData(descriptor.groupDescriptors.get(i), listener);
                groupView.notifyDataChanged();
                addView(groupView, params);
            }
        } else {
            setVisibility(View.GONE);
        }
    }

    /**
     * @param v
     * @param event
     * @return
     * @see OnTouchListener#onTouch(View,
     * MotionEvent)
     */
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    /**
     * @param event
     * @return
     * @see View#onTouchEvent(MotionEvent)
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    /**
     * @param ev
     * @return
     * @see android.view.ViewGroup#onInterceptTouchEvent(MotionEvent)
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getPointerCount() > 1) {
            RowLog.e(ev.getTouchMinor() + "," + ev.getPointerCount());
            return true;
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            default:
                break;
        }
        return false;
    }
}
