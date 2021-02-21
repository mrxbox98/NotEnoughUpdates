package io.github.mrxbox98.notenoughupdatesExtra;

import io.github.mrxbox98.notenoughupdatesExtra.minion.Minion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.Sys;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MinionUtils {
    private static final Minecraft mc = Minecraft.getMinecraft();

    static int resourcePerHour=0;
    static int resourcePerDay=0;
    static int moneyPerHour=0;
    static int moneyPerDay=0;

    static int ticks=0;

    static boolean waitingTicks=false;




    /**
     * Checks if a gui is a minion
     * @param chest The chestGui
     * @return nothing currently
     */
    public static String checkMinion(GuiChest chest)
    {
        wait1Ticks();

        return "";
    }

    /**
     * Checks a container what minion it is
     * @return the minion type or "" if there is no minion
     */
    public static String checkMinion()
    {
        if(!(mc.currentScreen instanceof GuiChest))
        {
            return "";
        }
        GuiChest chest = (GuiChest) mc.currentScreen;

        Container container = chest.inventorySlots;

        IInventory inventory = ((ContainerChest)container).getLowerChestInventory();

        //System.out.println(inventory.getSizeInventory());


        if(inventory.getStackInSlot(5)!=null)
        {
            String name=inventory.getStackInSlot(5).getDisplayName();

            Minion.currentMinion=name;
            return name;
        }
        waitingTicks=false;
        Minion.currentMinion="";
        return "";
    }

    public static void wait1Ticks()
    {
        waitingTicks=true;
    }

    public static void onTick(TickEvent.ClientTickEvent event)
    {
        if(waitingTicks && ticks==1)
        {
            checkMinion();
        }
        else if(waitingTicks)
        {
            ticks++;
        }
        else if(!waitingTicks)
        {
            ticks=0;
        }
    }
}
