package com.xxTFxx.siberianadv.init;

import com.xxTFxx.siberianadv.Main;
import com.xxTFxx.siberianadv.block.BlockSimpleGenerator;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(Main.MOD_ID)
public class ModBlocks {
	public static final Block STALINIUM_BLOCK = null;
	
	public static final Block BARBEDWIRE = null;
	public static final Block BARBEDWIREFENCE = null;
	public static final Block CUP = null;
	public static final Block SNOWM = null;
	public static final Block SIMPLE_GENERATOR = new BlockSimpleGenerator("simple_generator");

}
