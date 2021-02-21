package io.github.mrxbox98.notenoughupdatesExtra;

import io.github.mrxbox98.notenoughupdatesExtra.minion.Minion;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;

public class XboxEventListener {

    static ArrayList<String> onTickEvents = new ArrayList<String>();

    public static void register()
    {
        MinecraftForge.EVENT_BUS.register(new XboxEventListener());
    }


    /**
     * Handles all gui events
     *
     * @param event The event object
     */
    @SubscribeEvent
    public void onGuiBackgroundDraw(GuiScreenEvent.BackgroundDrawnEvent event)
    {
        Minion.onGuiBackgroundDraw(event);
    }

    @SubscribeEvent
    public void onDrawScreen(GuiScreenEvent.DrawScreenEvent event)
    {

    }

    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event)
    {
        if(event.gui instanceof GuiChest)
        {
            GuiChest chest = (GuiChest)event.gui;
            String type = MinionUtils.checkMinion(chest);
        }
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event)
    {
        MinionUtils.onTick(event);
    }
}
