package com.qw.row.item;


import com.qw.row.core.RowDescriptor;
import com.qw.row.core.Type;

public class SwitchRowDescriptor extends RowDescriptor {
    private String label;
    private int icon;
    private boolean checked;

    public SwitchRowDescriptor() {
        this.type = Type.ROW_SWITCH;
    }

    public static class Builder {
        private int id;
        private int icon;
        private String label;
        private boolean checked;

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

        public Builder setChecked(boolean checked) {
            this.checked = checked;
            return this;
        }

        public SwitchRowDescriptor builder() {
            SwitchRowDescriptor descriptor = new SwitchRowDescriptor();
            descriptor.id = id;
            descriptor.icon = icon;
            descriptor.label = label;
            descriptor.checked = checked;
            return descriptor;
        }
    }

    public String getLabel() {
        return label;
    }

    public int getIcon() {
        return icon;
    }

    public boolean isChecked() {
        return checked;
    }

}
