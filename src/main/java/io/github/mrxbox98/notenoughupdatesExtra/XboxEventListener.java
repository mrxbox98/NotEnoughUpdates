package io.github.mrxbox98.notenoughupdatesExtra;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class XboxEventListener {


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
        if(event.gui instanceof GuiContainer)
        {
            System.out.println("In a container test");
        }
    }
}
