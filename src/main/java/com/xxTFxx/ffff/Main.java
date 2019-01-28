package com.xxTFxx.ffff;

import org.apache.logging.log4j.Logger;

import com.xxTFxx.ffff.proxy.IProxy;
import com.xxTFxx.ffff.util.RegistryHandler;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MOD_ID , name = Main.NAME, version = Main.VERSION, acceptedMinecraftVersions = Main.MC_VERSION)
public class Main {
	
	public static final String MOD_ID = "ffff";
	public static final String NAME = "MOIST";
	public static final String VERSION = "1.0";
	public static final String MC_VERSION = "1.12.2";
	
	public static final String CLIENT_PROXY_CLASS = "com.xxTFxx.ffff.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.xxTFxx.ffff.proxy.ServerProxy";
	
	public static final int ENTITY_SIBERIAMAN = 140;
	public static final int ENTITY_SIBERIABEAR = 141;
	
	public static Logger logger;
	
	@SidedProxy(clientSide = Main.CLIENT_PROXY_CLASS, serverSide = Main.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		proxy.PreInit(event);
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		proxy.init(event);
		RegistryHandler.initRegistries(event);
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		proxy.PostInit(event);
		RegistryHandler.postInitRegistries(event);
	}
	
}
