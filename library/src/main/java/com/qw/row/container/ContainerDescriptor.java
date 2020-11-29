package com.qw.row.container;

import com.qw.row.group.GroupDescriptor;

import java.util.ArrayList;

public class ContainerDescriptor {
    public ArrayList<GroupDescriptor> groupDescriptors;

    public ContainerDescriptor(ArrayList<GroupDescriptor> groupDescriptors) {
        this.groupDescriptors = groupDescriptors;
    }
}
