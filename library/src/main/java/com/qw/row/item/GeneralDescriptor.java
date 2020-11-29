package com.qw.row.item;

import com.qw.row.core.RowDescriptor;
import com.qw.row.core.Type;

public class GeneralDescriptor extends RowDescriptor {
    private int iconResId;
    private String label;

    public GeneralDescriptor() {
        this.type = Type.ROW_ANDROID;
    }

    public int getIcon() {
        return iconResId;
    }

    public String getLabel() {
        return label;
    }

    public static class Builder {
        private int id;
        private int iconResId;
        private String label;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setIcon(int iconResId) {
            this.iconResId = iconResId;
            return this;
        }

        public Builder setLabel(String label) {
            this.label = label;
            return this;
        }

        public GeneralDescriptor builder() {
            GeneralDescriptor rowDescriptor = new GeneralDescriptor();
            rowDescriptor.iconResId = iconResId;
            rowDescriptor.label = label;
            rowDescriptor.id = id;
            return rowDescriptor;
        }
    }
}
