package model;

import java.util.Random;

public class Bidder implements Observer {
    public Bidder(String name, double maxBid) {
        this.name = name;
        this.maxBid = maxBid;
    }

    private String name;
    private double personalBid;
    private double currentBid;
    private double maxBid;

    public String getName() {
        return name;
    }

    public double getPersonalBid() {
        return personalBid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public double getMaxBid() {
        return maxBid;
    }


    @Override
    public void update(Subject subject, Object obj) {
        currentBid = (double)obj;
        System.out.println(this.name + ": has update with the most recent high bid");
        if (currentBid >= maxBid){
            System.out.println(this.name + ": I can't bid any higher!");
        }else {
            makeBid(currentBid);
        }
    }

    public void makeBid(double currentBid){
        Random rand = new Random();
        personalBid = (double) rand.nextInt((int) 10) + (currentBid + 1);

        System.out.println(name + "'s bid is: $" + personalBid);
    }
}
