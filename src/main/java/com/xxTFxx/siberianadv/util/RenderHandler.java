package com.xxTFxx.siberianadv.util;

import com.xxTFxx.siberianadv.entity.EntitySiberiaMan;
import com.xxTFxx.siberianadv.entity.render.RenderSiberiaMan;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	
	public static void registerEntityRenders()
	{
		/*RenderingRegistry.registerEntityRenderingHandler(EntitySiberiaMan.class, new IRenderFactory<EntitySiberiaMan>() {
			@Override
			public Render<? super EntitySiberiaMan> createRenderFor(RenderManager manager) {
				
				return new RenderSiberiaMan(manager);
			}
		});*/
	}
}
