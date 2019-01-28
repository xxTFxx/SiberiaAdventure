package com.xxTFxx.ffff.item;

import com.xxTFxx.ffff.Main;
import com.xxTFxx.ffff.tabs.ModTab;

import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword{
	
	public ItemModSword(ToolMaterial material , float damage , float speed , String name) {
		super(material);
		setUnlocalizedName(Main.MOD_ID + "." + name);
		setRegistryName(name);
		setCreativeTab(ModTab.Mod_Tab);
	}
	
	public ItemModSword(ToolMaterial material , String name) {
		this(material ,material.getAttackDamage() , material.getEfficiency() , name);
	}
}
