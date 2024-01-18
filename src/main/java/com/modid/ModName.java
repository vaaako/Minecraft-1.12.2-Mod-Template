package com.modid;

import com.modid.proxy.CommonProxy;
import com.modid.tabs.ModTab;
import com.modid.handlers.RegistryEvent;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;

import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModName.MODID, name = ModName.NAME, version = ModName.VERSION)
public class ModName {
	public static final String MODID = "modid";
	public static final String NAME = "ModName";
	public static final String VERSION = "1.0";
	
	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public static final String CLIENT = "com.modid.proxy.ClientProxy";
	public static final String SERVER = "com.modid.proxy.CommonProxy";

	public static final CreativeTabs CREATIVE_TAB = new ModTab("modidtab");

	@Instance
	public static ModName instance;

	@SidedProxy(clientSide = ModName.CLIENT, serverSide = ModName.SERVER)
	public static CommonProxy proxy;


	/* EVENTS */
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)  {
		RegistryEvent.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		RegistryEvent.initRegistries(event);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		RegistryEvent.postInitRegistries(event);
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {
		RegistryEvent.serverRegistries(event);
	}
}
