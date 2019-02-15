package com.xxTFxx.siberianadv.util;

import com.xxTFxx.siberianadv.Main;
import com.xxTFxx.siberianadv.block.BarbedWire;
import com.xxTFxx.siberianadv.block.BarbedWireFence;
import com.xxTFxx.siberianadv.block.BasicBlock;
import com.xxTFxx.siberianadv.block.CupBlock;
import com.xxTFxx.siberianadv.block.SnowMod;
import com.xxTFxx.siberianadv.compat.OreDictionaryCompat;
import com.xxTFxx.siberianadv.init.BiomeInit;
import com.xxTFxx.siberianadv.init.EntityInit;
import com.xxTFxx.siberianadv.init.ModBlocks;
import com.xxTFxx.siberianadv.init.ModItems;
import com.xxTFxx.siberianadv.item.CoffeCup;
import com.xxTFxx.siberianadv.item.ItemBase;
import com.xxTFxx.siberianadv.item.ItemModRecord;
import com.xxTFxx.siberianadv.item.ItemModSword;
import com.xxTFxx.siberianadv.materials.ModMaterials;
import com.xxTFxx.siberianadv.tileentity.TileEntitySimpleGenerator;
import com.xxTFxx.siberianadv.util.handlers.GUIHandler;
import com.xxTFxx.siberianadv.world.biomes.BiomeSiberia;
import com.xxTFxx.siberianadv.world.gen.WorldGenCustomStructures;
import com.xxTFxx.siberianadv.world.gen.generators.WorldGenStructure;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockSnowBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class RegistryHandler {
	
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		final Block[] blocks = {
			new BasicBlock(Material.IRON , SoundType.METAL , "stalinium_block" , 5.0F),
			new BarbedWire("barbedwire"),
			new BarbedWireFence("barbedwirefence"),
			new CupBlock(Material.WOOD, SoundType.GLASS, "cup", 0.3F),
			ModBlocks.SIMPLE_GENERATOR
			//new SnowMod("snowm")
		};
		event.getRegistry().registerAll(blocks);
		GameRegistry.registerTileEntity(TileEntitySimpleGenerator.class, new ResourceLocation(Main.MOD_ID + ":simple_generator"));
	}
	
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		final Item[] items = {
				ModItems.STALINIUM_INGOT,
				new ItemModRecord("soviet_anthem" , ModSoundEvent.SOVIET_ANTHEM),
				new ItemModSword(ModMaterials.MOD_TOOL , "stalinium_sword"),
				new CoffeCup("coffecup"),
				new ItemBase("bear_fur"),
				ModItems.USHANKA,
				ModItems.BEAR_MEAT_RAW
		};
		
		final Item[] itemBlocks = {
			new ItemBlock(ModBlocks.STALINIUM_BLOCK).setRegistryName(ModBlocks.STALINIUM_BLOCK.getRegistryName()),	
			new ItemBlock(ModBlocks.BARBEDWIRE).setRegistryName(ModBlocks.BARBEDWIRE.getRegistryName()),
			new ItemBlock(ModBlocks.BARBEDWIREFENCE).setRegistryName(ModBlocks.BARBEDWIREFENCE.getRegistryName()),
			new ItemBlock(ModBlocks.CUP).setRegistryName(ModBlocks.CUP.getRegistryName()),
			new ItemBlock(ModBlocks.SIMPLE_GENERATOR).setRegistryName(ModBlocks.SIMPLE_GENERATOR.getRegistryName())
			//new ItemBlock(ModBlocks.SNOWM).setRegistryName(ModBlocks.SNOWM.getRegistryName())
		};
		
		
		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
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
		OreDictionaryCompat.registerOres();
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.MOD_ID , new GUIHandler());
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
	}
	
	@SubscribeEvent
	public static void onRegisterBlocksEvent(final RegistryEvent.Register<Block> event) {

		event.getRegistry().register(

			(new SnowMod() {
			})
				.setRegistryName("minecraft:snow")
				.setUnlocalizedName("snow")
		);
	}

	
}
