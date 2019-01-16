package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable{

    private String description;
    private List<Doable> subs;

    private boolean complete;



    public Todo(String description) {
        this.description = description;
        subs = new LinkedList<>();

        complete = false;

    }

    // getters
    public boolean getStatus() { return complete; }

    public List<Doable> getSubs() {
        return subs;
    }


    public boolean addDoable(Todo td) {
        if (!subs.contains(td)) {
            subs.add(td);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeDoables(Task t) {
        if (subs.contains(t)) {
            subs.remove(t);
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void complete() {
        boolean aresubsComplete = true;
        for(Doable d: subs){
            if(! d.complete){
                aresubsComplete = false;
            }
        }
        complete = aresubsComplete;
    }

    @Override
    public void display(String indentSpace) {
        System.out.println(indentSpace + getDescription());
        for (Doable d : subs){
            d.display(indentSpace+ "  ");
        }

    }
}