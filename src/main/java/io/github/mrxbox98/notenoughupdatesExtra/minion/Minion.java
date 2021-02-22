package io.github.mrxbox98.notenoughupdatesExtra.minion;

import io.github.moulberry.notenoughupdates.core.util.render.RenderUtils;
import io.github.moulberry.notenoughupdates.core.util.render.TextRenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;

import java.util.ArrayList;

public class Minion {
    private int resourcePerHour=0;
    private int resourcePerDay=0;
    private int profitPerHour=0;
    private int profitPerDay=0;

    public static ArrayList<Minion> minions = new ArrayList<Minion>();

    public static String currentMinion = "";

    private static final Minecraft mc = Minecraft.getMinecraft();

    //-------------------------------------------------------
    //                   Minion Registry
    //-------------------------------------------------------
    public static final Minion COBBLESTONE_1=new Minion(128,128,"Cobblestone Minion I");
    public static final Minion COBBLESTONE_2=new Minion(128,128,"Cobblestone Minion II");
    public static final Minion COBBLESTONE_3=new Minion(150,150,"Cobblestone Minion III");
    public static final Minion COBBLESTONE_4=new Minion(150,150,"Cobblestone Minion IV");
    public static final Minion COBBLESTONE_5=new Minion(180,180,"Cobblestone Minion V");
    public static final Minion COBBLESTONE_6=new Minion(180,180,"Cobblestone Minion VI");
    public static final Minion COBBLESTONE_7=new Minion(200,200,"Cobblestone Minion VII");
    public static final Minion COBBLESTONE_8=new Minion(200,200,"Cobblestone Minion VIII");
    public static final Minion COBBLESTONE_9=new Minion(225,225,"Cobblestone Minion IX");
    public static final Minion COBBLESTONE_10=new Minion(225,225,"Cobblestone Minion X");
    public static final Minion COBBLESTONE_11=new Minion(257,257,"Cobblestone Minion XI");

    public static final Minion COAL_1=new Minion(120,120,"Coal Minion I");
    public static final Minion COAL_2=new Minion(120,120,"Coal Minion II");
    public static final Minion COAL_3=new Minion(120,120,"Coal Minion III");


    private String name;

    public Minion(int resourcePerHour, int profitPerHour, String name)
    {
        this.resourcePerHour=resourcePerHour;
        this.resourcePerDay=resourcePerHour*24;
        this.profitPerHour=profitPerHour;
        this.profitPerDay=profitPerHour*24;
        this.name=name;


    }

    public int getResourcePerHour() {
        return resourcePerHour;
    }

    public int getResourcePerDay() {
        return resourcePerDay;
    }

    public int getProfitPerHour() {
        return profitPerHour;
    }

    public int getProfitPerDay() {
        return profitPerDay;
    }

    public static void addMinions()
    {
        minions.add(COBBLESTONE_1);
        minions.add(COBBLESTONE_2);
        minions.add(COBBLESTONE_3);
        minions.add(COBBLESTONE_4);
        minions.add(COBBLESTONE_5);
        minions.add(COBBLESTONE_6);
        minions.add(COBBLESTONE_7);
        minions.add(COBBLESTONE_8);
        minions.add(COBBLESTONE_9);
        minions.add(COBBLESTONE_10);
        minions.add(COBBLESTONE_11);
    }

    public static Minion findMinion(String name)
    {
        for(int i=0;i<minions.size();i++)
        {
            if(minions.get(i).name.equals(name))
            {
                return minions.get(i);
            }
        }
        return null;
    }



    public static int getResourceGenerated(String name)
    {
        if(findMinion(name) == null)
        {
            return 0;
        }
        return findMinion(name).getResourcePerHour();
    }

    public static int getProfitGenerated(String name)
    {
        if(findMinion(name) == null)
        {
            return 0;
        }
        return findMinion(name).getProfitPerHour();
    }

    public static void onGuiBackgroundDraw(GuiScreenEvent.BackgroundDrawnEvent event)
    {
        if(!(event.gui instanceof GuiContainer) || currentMinion.length()==0)
        {
            return;
        }

        RenderUtils.drawFloatingRect(410,85,200,100);
        TextRenderUtils.drawStringCentered("Resources Generated: " + String.valueOf(getResourceGenerated(currentMinion)),mc.fontRendererObj,500,135,false,150);
        TextRenderUtils.drawStringCentered("Profit Generated: " + String.valueOf(getProfitGenerated(currentMinion)),mc.fontRendererObj,500,145,false,150);
    }
}
