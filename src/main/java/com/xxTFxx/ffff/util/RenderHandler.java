package com.xxTFxx.ffff.util;

import com.xxTFxx.ffff.entity.EntitySiberiaMan;
import com.xxTFxx.ffff.entity.render.RenderSiberiaMan;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySiberiaMan.class, new IRenderFactory<EntitySiberiaMan>() {
			@Override
			public Render<? super EntitySiberiaMan> createRenderFor(RenderManager manager) {
				
				return new RenderSiberiaMan(manager);
			}
		});
	}
}
