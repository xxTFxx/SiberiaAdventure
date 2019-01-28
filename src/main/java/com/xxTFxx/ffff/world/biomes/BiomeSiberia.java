package com.xxTFxx.ffff.world.biomes;

import java.util.Random;

import com.xxTFxx.ffff.entity.EntitySiberiaBear;
import com.xxTFxx.ffff.entity.EntitySiberiaMan;
import com.xxTFxx.ffff.init.BiomeInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenTaiga2;

public class BiomeSiberia extends Biome{

	private boolean logged = false;

	protected static final WorldGenTaiga2 TREE = new WorldGenTaiga2(true);
	
	public BiomeSiberia(BiomeProperties properties) {
		super(properties.setBaseHeight(0.01F).setHeightVariation(0.05F).setTemperature(-0.5F).setRainfall(0.6F).setSnowEnabled());
		properties.setBaseHeight(0.01F);
		this.decorator.treesPerChunk = 4;
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySiberiaBear.class, 15, 1, 4));
		this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityWolf.class, 8, 4, 4));
        this.spawnableCreatureList.add(new Biome.SpawnListEntry(EntityRabbit.class, 5, 2, 3));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySiberiaMan.class, 94, 1, 3));
		
		
	}
	
	@Override
	public WorldGenTaiga2 getRandomTreeFeature(Random rand) {
		return TREE;
	}
	
	@Override
	public void genTerrainBlocks(final World worldIn, final Random random, final ChunkPrimer chunkPrimer, final int x, final int z, final double stoneNoise) {
		super.genTerrainBlocks(worldIn, random, chunkPrimer, x, z, stoneNoise);

		if (!logged) {
			logged = true;
			//System.out.printf("---------------------------Generating BIOME test at %d,%d", x, z);
			System.out.println("---------------------------Generating BIOME test at " + x + z);
		}
	}
	
}
