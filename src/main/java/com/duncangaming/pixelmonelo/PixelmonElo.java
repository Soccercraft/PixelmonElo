package com.duncangaming.pixelmonelo;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.PixelmonEventHandler;
import com.pixelmonmod.pixelmon.api.events.battles.BattleEndEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = PixelmonElo.MODID, name = PixelmonElo.NAME, version = PixelmonElo.VERSION, dependencies = PixelmonElo.DEPENDENCIES)
public class PixelmonElo
{
    Events events = new Events();
    public static final String MODID = "pixelmonelo";
    public static final String NAME = "Pixelmon Elo";
    public static final String VERSION = "1.0";
    public static final String DEPENDENCIES = "after:pixelmon";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(events);
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }



}
