package com.xxTFxx.ffff.world.gen;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import com.xxTFxx.ffff.Main;
import com.xxTFxx.ffff.world.gen.generators.WorldGenStructure;

import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTableList;
import scala.actors.threadpool.Arrays;

public class Structure_mine1 {
	/*public boolean generate(World world, Random rand, BlockPos position , int chance ,Class<?>...classes ) {
		
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		WorldServer worldserver = (WorldServer) world;
		MinecraftServer minecraftserver = world.getMinecraftServer();
		TemplateManager templatemanager = worldserver.getStructureTemplateManager();
		Template template = templatemanager.getTemplate(minecraftserver, new ResourceLocation(Main.MOD_ID+":mine1"));
		
		Class<?> biome = world.provider.getBiomeForCoords(position).getClass();
		
		if(classesList.contains(biome))
		{
			if(rand.nextInt(chance) == 0)
			{
				
			
				if(WorldGenStructure.canSpawnHere(template, worldserver, position)) {
					position.add(0, -5, 0);
					IBlockState iblockstate = world.getBlockState(position);
					world.notifyBlockUpdate(position, iblockstate, iblockstate, 3);
					
					PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
							.setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null)
							.setReplacedBlock((Block) null).setIgnoreStructureBlock(false);
					
					template.getDataBlocks(position, placementsettings);
					template.addBlocksToWorld(world, position.add(0, 1, 0), placementsettings);
					
					
					 Map<BlockPos, String> map = template.getDataBlocks(position, placementsettings);
		
			         for (Entry<BlockPos, String> entry : map.entrySet())
			         {
			             if ("chest".equals(entry.getValue()))
			             {
			                 BlockPos blockpos2 = entry.getKey();
			                 world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
			                 TileEntity tileentity = world.getTileEntity(blockpos2);
		
			                 if (tileentity instanceof TileEntityChest)
			                 {
			                     ((TileEntityChest)tileentity).setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
			                 }
			                 
			             }
			            
			             }
	         
	     
			         	return true;
				}
			}
		}
		
		return false;
	}*/
}
