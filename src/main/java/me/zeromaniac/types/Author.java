package me.zeromaniac.types;

import static me.zeromaniac.common.StringHelper.validateString;
import static me.zeromaniac.common.StringHelper.validateUrlOrAttachment;

public class Author extends Type {
    String name;
    String url;
    String icon;

    public Author(String name, String url, String icon) {
        this.name = name;
        this.url = validateUrlOrAttachment(url);
        this.icon = validateUrlOrAttachment(icon);

        validate();
    }

    public String getUrl() {
        return url;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    @Override
    protected void validate() {
        this.isValid = validateString(name);
    }
}
