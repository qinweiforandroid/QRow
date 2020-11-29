package com.qw.row.group;

import com.qw.row.core.RowDescriptor;

import java.util.ArrayList;

public class GroupDescriptor {
    public String title = "";
    public ArrayList<RowDescriptor> rowDescriptors = new ArrayList<>();

    public GroupDescriptor setTitle(String title) {
        this.title = title;
        return this;
    }

    public GroupDescriptor add(RowDescriptor descriptor) {
        rowDescriptors.add(descriptor);
        return this;
    }

}
