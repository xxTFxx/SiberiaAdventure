package com.xxTFxx.siberianadv.tileentity;

import com.xxTFxx.siberianadv.energy.CustomEnergyStorage;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBoat;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntitySimpleGenerator extends TileEntity implements ITickable{

	public ItemStackHandler handler = new ItemStackHandler(1);
	private CustomEnergyStorage storage = new CustomEnergyStorage(10000);
	public int energy = storage.getEnergyStored();
	private int capacity = storage.getMaxEnergyStored();
	private String customName;
	public int burnTime , totalBurnTime;
	
	@Override
	public void update() {
		if(!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0)) && (getFuelValue(handler.getStackInSlot(0)) + energy) <= capacity)
		{
			totalBurnTime = getTotalBurnTime(handler.getStackInSlot(0));
			burnTime++;
			if(burnTime >= getFuelValue(handler.getStackInSlot(0))/16 )
			{
				energy += getFuelValue(handler.getStackInSlot(0));
				handler.getStackInSlot(0).shrink(1);
				burnTime = 0;
				totalBurnTime = 0;
			}
		}
		
	}
	
	private int getTotalBurnTime(ItemStack stackIn)
	{
		if(!stackIn.isEmpty())
		{
			return getFuelValue(stackIn)/16;
		}
		return 0;
	}
	
	private int getFuelValue(ItemStack stackInSlot) {
		if (stackInSlot.isEmpty())
        {
            return 0;
        }
        else
        {
            int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stackInSlot);
            if (burnTime >= 0) return burnTime;
            Item item = stackInSlot.getItem();

            if (item == Item.getItemFromBlock(Blocks.WOODEN_SLAB))
            {
                return 120;
            }
            else if (item == Item.getItemFromBlock(Blocks.WOOL))
            {
                return 100;
            }
            else if (item == Item.getItemFromBlock(Blocks.CARPET))
            {
                return 64;
            }
            else if (item == Item.getItemFromBlock(Blocks.LADDER))
            {
                return 300;
            }
            else if (item == Item.getItemFromBlock(Blocks.WOODEN_BUTTON))
            {
                return 100;
            }
            else if (Block.getBlockFromItem(item).getDefaultState().getMaterial() == Material.WOOD)
            {
                return 300;
            }
            else if (item == Item.getItemFromBlock(Blocks.COAL_BLOCK))
            {
                return 16000;
            }
            else if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName()))
            {
                return 200;
            }
            else if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName()))
            {
                return 200;
            }
            else if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName()))
            {
                return 200;
            }
            else if (item == Items.STICK)
            {
                return 100;
            }
            else if (item != Items.BOW && item != Items.FISHING_ROD)
            {
                if (item == Items.SIGN)
                {
                    return 200;
                }
                else if (item == Items.COAL)
                {
                    return 1600;
                }
                else if (item == Items.LAVA_BUCKET)
                {
                    return 20000;
                }
                else if (item != Item.getItemFromBlock(Blocks.SAPLING) && item != Items.BOWL)
                {
                    if (item == Items.BLAZE_ROD)
                    {
                        return 2400;
                    }
                    else if (item instanceof ItemDoor && item != Items.IRON_DOOR)
                    {
                        return 200;
                    }
                    else
                    {
                        return item instanceof ItemBoat ? 400 : 0;
                    }
                }
                else
                {
                    return 100;
                }
            }
            else
            {
                return 300;
            }
        }
    }

	private boolean isItemFuel(ItemStack stackInSlot) {
		return getFuelValue(stackInSlot) > 0;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability.equals(CapabilityEnergy.ENERGY))
		{
			return (T)this.storage;
		}
		if(capability.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY))
		{
			return (T)this.handler;
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		
		if(capability.equals(CapabilityEnergy.ENERGY))
		{
			return true;
		}
		if(capability.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY))
		{
			return true;
		}
		return super.hasCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("BurnTime", this.burnTime);
		compound.setInteger("GUIEnergy", this.energy);
		compound.setString("Name" ,getDisplayName().toString());
		this.storage.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.burnTime = compound.getInteger("BurnTime");
		this.energy = compound.getInteger("GUIEnergy");
		this.customName = compound.getString("Name");
		this.storage.readFromNBT(compound);
	}
	
	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentTranslation("container.simple_generator");
	}
	
	public int getEnergyStored()
	{
		return this.energy;
	}
	
	public int getMaxEnergyStored()
	{
		return this.storage.getMaxEnergyStored();
	}
	
	public int getField(int id)
	{
		switch (id) {
		case 0:
			return this.energy;
		case 1:
			return this.burnTime;
		case 2:
			return this.totalBurnTime;
		case 3:
			return this.capacity;
		default:
			return 0;
		}
	}
	
	public void setField(int id , int value)
	{
		switch (id) {
		case 0:
			this.energy = value;
		case 1:
			this.burnTime = value;

		}
	}
	
	public boolean isUsableByPlayer(EntityPlayer player)
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}
	
	
	
	
	
	
	
	
}
