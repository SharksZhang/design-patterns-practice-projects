package model;

public abstract class Doable {
    public boolean complete;
    public abstract String getDescription();
    public abstract void complete();
    public abstract void display(String indentSpace);
}
