package com.xxTFxx.siberianadv.util;

import com.xxTFxx.siberianadv.init.ModBlocks;
import com.xxTFxx.siberianadv.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(Side.CLIENT)
public class ModelRegistryHandler {
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerModel(ModItems.STALINIUM_INGOT);
		registerModel(ModItems.SOVIET_ANTHEM);
		registerModel(ModItems.STALINIUM_SWORD);		
		registerModel(ModItems.COFFECUP);
		
		registerModel(Item.getItemFromBlock(ModBlocks.STALINIUM_BLOCK));
		registerModel(Item.getItemFromBlock(ModBlocks.BARBEDWIRE));
		registerModel(Item.getItemFromBlock(ModBlocks.CUP));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SNOWM), 0, new ModelResourceLocation("snow", "inventory"));
		
	}
	private static void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
 