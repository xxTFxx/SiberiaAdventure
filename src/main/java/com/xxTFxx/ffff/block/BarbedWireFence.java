package com.xxTFxx.ffff.block;

import com.xxTFxx.ffff.Main;
import com.xxTFxx.ffff.init.ModBlocks;
import com.xxTFxx.ffff.tabs.ModTab;

import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BarbedWireFence extends BlockPane{

	public BarbedWireFence(String name) {
		super(Material.IRON, false);
		setUnlocalizedName(Main.MOD_ID + "." + name);
		setRegistryName(name);
		setCreativeTab(ModTab.Mod_Tab);
		setSoundType(SoundType.METAL);
		
		setHardness(10.0F);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		entityIn.setInWeb();
		entityIn.attackEntityFrom(DamageSource.FALL, 2);
	}
	
	@Override
	public boolean canPaneConnectTo(IBlockAccess world, BlockPos pos, EnumFacing dir) {
		BlockPos other = pos.offset(dir);
        IBlockState state = world.getBlockState(other);
        if(!other.getClass().equals(BarbedWire.class))
        {
        	return state.getBlock().canBeConnectedTo(world, other, dir.getOpposite()) || attachesTo(world, state, other, dir.getOpposite());        	
        }
        else return false;
	}

}
