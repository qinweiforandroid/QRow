package com.qw.row.item;


import com.qw.row.core.RowDescriptor;
import com.qw.row.core.Type;

public class IosDescriptor extends RowDescriptor {
    private int icon;
    private String label;
    private String value;

    public IosDescriptor() {
        this.type = Type.ROW_IOS;
    }

    public static class Builder {
        private int id;
        private int icon;
        private String label;
        private String value;

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

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public IosDescriptor builder() {
            IosDescriptor rowDescriptor = new IosDescriptor();
            rowDescriptor.id = id;
            rowDescriptor.icon = icon;
            rowDescriptor.label = label;
            rowDescriptor.value = value;
            return rowDescriptor;
        }
    }

    public int getIcon() {
        return icon;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }
}