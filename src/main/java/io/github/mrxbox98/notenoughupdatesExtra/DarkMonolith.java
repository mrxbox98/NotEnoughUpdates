package io.github.mrxbox98.notenoughupdatesExtra;

import io.github.moulberry.notenoughupdates.miscfeatures.CustomItemEffects;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.model.animation.Animation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

public class DarkMonolith {

    public static boolean tracers;

    private final Minecraft mc = Minecraft.getMinecraft();

    private static ArrayList<BlockPos> eggs = new ArrayList<BlockPos>();

    private BlockPos currBlock = new BlockPos(0,0,0);

    public static void addBlocks()
    {
        eggs.add(new BlockPos(-15,236,-92));
        eggs.add(new BlockPos(49,202,-162));
        eggs.add(new BlockPos(56,214,-25));
        eggs.add(new BlockPos(128,187,58));
        eggs.add(new BlockPos(150,196,190));
        eggs.add(new BlockPos(61,204,181));
        eggs.add(new BlockPos(91,187,131));
        eggs.add(new BlockPos(77,160,162));
        eggs.add(new BlockPos(-9,162,109));
        eggs.add(new BlockPos(1,183,25));
        eggs.add(new BlockPos(1,170,0));
        eggs.add(new BlockPos(-94,201,-30));
        eggs.add(new BlockPos(-91,221,-53));
        eggs.add(new BlockPos(-64,206,-63));
    }

    public BlockPos checkBlocks()
    {
        for(int i=0;i<eggs.size();i++)
        {
            if(Minecraft.getMinecraft().theWorld.getBlockState(eggs.get(i)).getBlock() instanceof BlockDragonEgg)
            {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§aDark Monolith at " + eggs.get(i).toString()));

                return eggs.get(i);

            }
        }
        return null;
    }

    public static void register()
    {
        addBlocks();
        MinecraftForge.EVENT_BUS.register(new DarkMonolith());
    }





    @SubscribeEvent
    public void onWorldRenderLast(RenderWorldLastEvent event)
    {
        //System.out.println("XBOX CODE:" + "onWorldRenderLast(RenderWorldLastEvent event) WORKED!!");
        if(!tracers)
        {
            return;
        }
        for(int i=0;i<Minecraft.getMinecraft().theWorld.loadedEntityList.size();i++)
        {
            drawTracer(Minecraft.getMinecraft().theWorld.loadedEntityList.get(i),event.partialTicks);
        }
        /*
        BlockPos temp = checkBlocks();
        if(temp!=null)
        {
            drawBlock(temp,event.partialTicks);
        }
        */



    }

    public void drawTracer(Entity entity, float partialTicks)
    {
        float f = partialTicks;
        float px = (float)mc.thePlayer.posX;
        float py = (float)mc.thePlayer.posY;
        float pz = (float)mc.thePlayer.posZ;
        float mx = (float)mc.thePlayer.prevPosX;
        float my = (float)mc.thePlayer.prevPosY;
        float mz = (float)mc.thePlayer.prevPosZ;
        float dx = mx + ( px - mx ) * f;
        float dy = my + ( py - my ) * f;
        float dz = mz + ( pz - mz ) * f;

        float px2 = (float)entity.posX;
        float py2 = (float)entity.posY;
        float pz2 = (float)entity.posZ;
        float mx2 = (float)entity.prevPosX;
        float my2 = (float)entity.prevPosY;
        float mz2 = (float)entity.prevPosZ;
        float dx2 = mx2 + ( px2 - mx2 ) * f;
        float dy2 = my2 + ( py2 - my2 ) * f;
        float dz2 = mz2 + ( pz2 - mz2 ) * f;

        drawTracerLine(0, 1.62, 0, dx2-dx, dy2-dy, dz2-dz, 1F, 1F, 1F, 0.45F, 5F);
    }

    public void drawBlock(BlockPos pos, float partialTicks)
    {
        float f = partialTicks;
        float px = (float)mc.thePlayer.posX;
        float py = (float)mc.thePlayer.posY;
        float pz = (float)mc.thePlayer.posZ;
        float mx = (float)mc.thePlayer.prevPosX;
        float my = (float)mc.thePlayer.prevPosY;
        float mz = (float)mc.thePlayer.prevPosZ;
        float dx = mx + ( px - mx ) * f;
        float dy = my + ( py - my ) * f;
        float dz = mz + ( pz - mz ) * f;

        drawBlock(pos.getX()-dx,pos.getY()-dy,pos.getZ()-dz);
    }

    private void drawBlock( float px, float py, float pz )
    {
        drawTracerLine(px+1D, py+1.0D, pz, px, py+1.0D, pz, 1F, 1F, 1F, 0.45F, 5F);
        drawTracerLine(px+1D, py, pz, px, py, pz, 1F, 1F, 1F, 0.45F, 5F);
        drawTracerLine(px+1D, py+1.0D, pz+1, px, py+1.0D, pz+1, 1F, 1F, 1F, 0.45F, 5F);
        drawTracerLine(px+1D, py, pz+1, px, py, pz+1, 1F, 1F, 1F, 0.45F, 5F);
        drawTracerLine(px+1D, py+1D, pz, px+1D, py+1D, pz+1, 1F, 1F, 1F, 0.45F, 5F);
        drawTracerLine(px+1D, py, pz, px+1D, py, pz+1, 1F, 1F, 1F, 0.45F, 5F);
        drawTracerLine(px, py+1D, pz, px, py+1D, pz+1, 1F, 1F, 1F, 0.45F, 5F);
        drawTracerLine(px, py, pz, px, py, pz+1, 1F, 1F, 1F, 0.45F, 5F);

    }

    public static void drawTracerLine(double x, double y, double z, double x2, double y2, double z2, float red, float green, float blue, float alpha, float lineWidth) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        // GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(lineWidth);
        GL11.glColor4f(red, green, blue, alpha);
        GL11.glBegin(2);
        GL11.glVertex3d(x2, y2, z2);
        GL11.glVertex3d(x, y, z);
        GL11.glEnd();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
        // GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }


    /**
     * Draws a bounding box around the Dark Monolith
     */
    public static void drawBoundingBox()
    {

    }


}
