package com.xxTFxx.ffff.util;

import com.xxTFxx.ffff.Main;
import com.xxTFxx.ffff.block.BarbedWire;
import com.xxTFxx.ffff.block.BarbedWireFence;
import com.xxTFxx.ffff.block.BasicBlock;
import com.xxTFxx.ffff.init.BiomeInit;
import com.xxTFxx.ffff.init.EntityInit;
import com.xxTFxx.ffff.init.ModBlocks;
import com.xxTFxx.ffff.item.ItemBase;
import com.xxTFxx.ffff.item.ItemModRecord;
import com.xxTFxx.ffff.item.ItemModSword;
import com.xxTFxx.ffff.materials.ModMaterials;
import com.xxTFxx.ffff.world.biomes.BiomeSiberia;
import com.xxTFxx.ffff.world.gen.WorldGenCustomStructures;
import com.xxTFxx.ffff.world.gen.generators.WorldGenStructure;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class RegistryHandler {
	
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		final Block[] blocks = {
			new BasicBlock(Material.IRON , SoundType.METAL , "stalinium_block" , 5.0F),
			new BarbedWire("barbedwire"),
			new BarbedWireFence("barbedwirefence")
		};
		event.getRegistry().registerAll(blocks);
	}
	
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		final Item[] items = {
				new ItemBase("stalinium_ingot"),
				new ItemModRecord("soviet_anthem" , ModSoundEvent.SOVIET_ANTHEM),
				new ItemModSword(ModMaterials.MOD_TOOL , "stalinium_sword")
		};
		
		final Item[] itemBlocks = {
			new ItemBlock(ModBlocks.STALINIUM_BLOCK).setRegistryName(ModBlocks.STALINIUM_BLOCK.getRegistryName()),	
			new ItemBlock(ModBlocks.BARBEDWIRE).setRegistryName(ModBlocks.BARBEDWIRE.getRegistryName()),
			new ItemBlock(ModBlocks.BARBEDWIREFENCE).setRegistryName(ModBlocks.BARBEDWIREFENCE.getRegistryName())
		};
		
		
		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
		ModelLoader.setCustomModelResourceLocation(ItemBlock.getItemFromBlock(ModBlocks.BARBEDWIRE), 0 , new ModelResourceLocation(ModBlocks.BARBEDWIRE.getRegistryName() , "inventory"));
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		ModSoundEvent.registerSounds();
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		EntityInit.registerEnities();
		RenderHandler.registerEntityRenders();
	}
	
	public static void initRegistries(FMLInitializationEvent event)
	{
		
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
	}

	
}
