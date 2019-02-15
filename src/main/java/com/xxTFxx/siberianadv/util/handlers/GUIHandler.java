package com.xxTFxx.siberianadv.util.handlers;

import com.xxTFxx.siberianadv.Main;
import com.xxTFxx.siberianadv.container.ContainerSimpleGenerator;
import com.xxTFxx.siberianadv.gui.GUISimpleGenerator;
import com.xxTFxx.siberianadv.tileentity.TileEntitySimpleGenerator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler{

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Main.GUI_SIMPLE_GENERATOR) return new GUISimpleGenerator(player.inventory, (TileEntitySimpleGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == Main.GUI_SIMPLE_GENERATOR) return new ContainerSimpleGenerator(player.inventory, (TileEntitySimpleGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
}
