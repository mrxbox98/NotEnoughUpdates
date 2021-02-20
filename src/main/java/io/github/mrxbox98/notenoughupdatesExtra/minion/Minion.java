package io.github.mrxbox98.notenoughupdatesExtra.minion;

import java.util.ArrayList;

public class Minion {
    private int resourcePerHour=0;
    private int resourcePerDay=0;
    private int profitPerHour=0;
    private int profitPerDay=0;

    static ArrayList<Minion> minions = new ArrayList<Minion>();

    private String name;

    public Minion(int resourcePerHour, int profitPerHour, String name)
    {
        this.resourcePerHour=resourcePerHour;
        this.resourcePerDay=resourcePerHour*24;
        this.profitPerHour=profitPerHour;
        this.profitPerDay=profitPerHour*24;
    }
}
