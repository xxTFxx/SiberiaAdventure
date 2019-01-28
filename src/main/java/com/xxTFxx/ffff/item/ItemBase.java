package com.xxTFxx.ffff.item;

import com.xxTFxx.ffff.Main;
import com.xxTFxx.ffff.init.ModItems;
import com.xxTFxx.ffff.tabs.ModTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item{

	public ItemBase(String name)
	{
		setUnlocalizedName(Main.MOD_ID + "." + name);
		setRegistryName(name);
		setCreativeTab(ModTab.Mod_Tab);

	}
	


}
