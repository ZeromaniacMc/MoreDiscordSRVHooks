package me.zeromaniac.types;

import static me.zeromaniac.common.StringHelper.validateString;

public class Image extends Type {
    String imageName;
    byte[] image;

    public Image(String imageName, byte[] image) {
        this.imageName = imageName;
        this.image = image;

        validate();
    }

    public String getImageName() {
        return imageName;
    }

    public byte[] getImage() {
        return image;
    }

    @Override
    protected void validate() {
        this.isValid = validateString(imageName) && image != null;
    }
}
