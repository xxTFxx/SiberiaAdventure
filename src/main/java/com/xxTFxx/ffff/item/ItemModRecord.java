package com.xxTFxx.ffff.item;

import com.xxTFxx.ffff.Main;
import com.xxTFxx.ffff.tabs.ModTab;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;

public class ItemModRecord extends ItemRecord{

	public ItemModRecord(String name, SoundEvent soundIn) {
		super(name, soundIn);
		
		setUnlocalizedName(Main.MOD_ID + "." + name);
		setRegistryName(Main.MOD_ID , name);
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
		setCreativeTab(ModTab.Mod_Tab);
	}
	

}
