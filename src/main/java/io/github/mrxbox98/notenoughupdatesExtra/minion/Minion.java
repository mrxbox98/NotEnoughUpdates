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

    public static void addMinions()
    {

    }

    public static void onGuiBackgroundDraw(GuiScreenEvent.BackgroundDrawnEvent event)
    {
        if(!(event.gui instanceof GuiContainer))
        {
            return;
        }
        //if(currentMinion.length()!=0)
        RenderUtils.drawFloatingRect(410,85,100,100);
        TextRenderUtils.drawStringCentered("Test",mc.fontRendererObj,460,135,true,100);
    }
}
