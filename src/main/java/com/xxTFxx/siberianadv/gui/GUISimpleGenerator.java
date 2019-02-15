package com.xxTFxx.siberianadv.gui;

import com.xxTFxx.siberianadv.Main;
import com.xxTFxx.siberianadv.container.ContainerSimpleGenerator;
import com.xxTFxx.siberianadv.tileentity.TileEntitySimpleGenerator;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUISimpleGenerator extends GuiContainer{
	
	private static final ResourceLocation TEXTURES = new ResourceLocation(Main.MOD_ID + ":textures/gui/simple_generator.png");
	private final InventoryPlayer player;
	private final TileEntitySimpleGenerator tileentity;
	
	public GUISimpleGenerator(InventoryPlayer player , TileEntitySimpleGenerator tileentity) {
		super(new ContainerSimpleGenerator(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		String tileName = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) -5, 6, 4210752);
		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 7, this.ySize - 96 + 2, 4210752);
		this.fontRenderer.drawString(Integer.toString(this.tileentity.getEnergyStored()), 115, 72, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int k = this.getEnergyStoredScaled(75);
		this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 7, 176, 32, 16, 75 - k);
		
		int l = this.getBurnProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 113, this.guiTop + 32, 176, 14, l+1, 16);
	}
	
	private int getEnergyStoredScaled(int pixels)
	{
		int i = this.tileentity.getField(0);
		int j = this.tileentity.getField(3);
		return i != 0 && j != 0 ? i * pixels / j : 0; 
	}
	
	private int getBurnProgressScaled(int pixels)
	{
		int i = this.tileentity.getField(1);
		int j = this.tileentity.getField(2);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
	
}
