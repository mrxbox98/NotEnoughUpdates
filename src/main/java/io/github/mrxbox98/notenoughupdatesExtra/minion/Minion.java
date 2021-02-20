package io.github.mrxbox98.notenoughupdatesExtra.minion;

import java.util.ArrayList;

public class Minion {
    private int resourcePerHour=0;
    private int resourcePerDay=0;
    private int profitPerHour=0;
    private int profitPerDay=0;

    static ArrayList<Minion> minions = new ArrayList<Minion>();


    //-------------------------------------------------------
    //                   Minion Registry
    //-------------------------------------------------------
    static final Minion COBBLESTONE_1=new Minion(128,128,"Cobblestone Minion I");
    static final Minion COBBLESTONE_2=new Minion(128,128,"Cobblestone Minion II");
    static final Minion COBBLESTONE_3=new Minion(150,150,"Cobblestone Minion III");
    static final Minion COBBLESTONE_4=new Minion(150,150,"Cobblestone Minion IV");
    static final Minion COBBLESTONE_5=new Minion(180,180,"Cobblestone Minion V");
    static final Minion COBBLESTONE_6=new Minion(180,180,"Cobblestone Minion VI");
    static final Minion COBBLESTONE_7=new Minion(200,200,"Cobblestone Minion VII");
    static final Minion COBBLESTONE_8=new Minion(200,200,"Cobblestone Minion VIII");
    static final Minion COBBLESTONE_9=new Minion(225,225,"Cobblestone Minion IX");
    static final Minion COBBLESTONE_10=new Minion(225,225,"Cobblestone Minion X");
    static final Minion COBBLESTONE_11=new Minion(257,257,"Cobblestone Minion XI");


    private String name;

    public Minion(int resourcePerHour, int profitPerHour, String name)
    {
        this.resourcePerHour=resourcePerHour;
        this.resourcePerDay=resourcePerHour*24;
        this.profitPerHour=profitPerHour;
        this.profitPerDay=profitPerHour*24;
        this.name=name;
    }

    public static void addMinions()
    {

    }
}
