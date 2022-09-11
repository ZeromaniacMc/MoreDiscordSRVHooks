package me.zeromaniac.types;

import static me.zeromaniac.common.StringHelper.validateString;
import static me.zeromaniac.common.StringHelper.validateUrlOrAttachment;

public class Title extends Type {
    String text;
    String url;

    public Title(String text, String url) {
        this.text = text;
        this.url = validateUrlOrAttachment(url);

        validate();
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    @Override
    protected void validate() {
        this.isValid = validateString(text);
    }
}
