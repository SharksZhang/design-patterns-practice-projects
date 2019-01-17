package model;

public abstract class Doable {
    public boolean complete;

    // getters
    public boolean getStatus() { return complete; }

    public abstract String getDescription();
    public abstract void complete();
    public abstract void display(String indentSpace);
}
