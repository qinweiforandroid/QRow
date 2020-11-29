package com.qw.row.item;


import com.qw.row.core.RowDescriptor;
import com.qw.row.core.Type;

public class UserIconRowDescriptor extends RowDescriptor {
    private String label;
    private String avatar;
    private int icon;


    public static class Builder {
        private int id;
        private int icon;
        private String label;
        private String avatar;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setIcon(int icon) {
            this.icon = icon;
            return this;
        }

        public Builder setLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder setAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserIconRowDescriptor builder() {
            UserIconRowDescriptor rowDescriptor = new UserIconRowDescriptor();
            rowDescriptor.id = id;
            rowDescriptor.icon = icon;
            rowDescriptor.label = label;
            rowDescriptor.avatar = avatar;
            return rowDescriptor;
        }
    }

    public String getLabel() {
        return label;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getIcon() {
        return icon;
    }

    public UserIconRowDescriptor() {
        this.type = Type.ROW_AVATAR;
    }

}