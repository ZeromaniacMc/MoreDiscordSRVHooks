package me.zeromaniac.types;

import static me.zeromaniac.common.StringHelper.validateString;
import static me.zeromaniac.common.StringHelper.validateUrlOrAttachment;

public class Footer extends Type {
    String text;
    String icon;

    public Footer(String text, String icon) {
        this.text = text;
        this.icon = validateUrlOrAttachment(icon);

        validate();
    }

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    protected void validate() {
        this.isValid = validateString(text);
    }
}
