package me.zeromaniac.types;

public abstract class Type {
    boolean isValid;

    public boolean isValid() {
        return isValid;
    }

    abstract protected void validate();
}
