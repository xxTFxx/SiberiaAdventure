package com.xxTFxx.ffff.entity.render;

import com.xxTFxx.ffff.entity.EntitySiberiaMan;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelIllager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVindicator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.util.ResourceLocation;

public class RenderSiberiaMan extends RenderLiving<EntitySiberiaMan>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/illager/vindicator.png");

	public RenderSiberiaMan(RenderManager manager) {
		super(manager, new ModelIllager(0.0F, 0.0F, 64, 64), 0.5F);
	}

	@Override
	protected void applyRotations(EntitySiberiaMan entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySiberiaMan entity) {

		return TEXTURE;
	}
	

	
}
