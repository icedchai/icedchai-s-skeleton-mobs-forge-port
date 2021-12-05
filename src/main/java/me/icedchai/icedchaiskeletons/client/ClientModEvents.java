package me.icedchai.icedchaiskeletons.client;

import me.icedchai.icedchaiskeletons.common.entity.EntityInit;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.StrayRenderer;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static me.icedchai.icedchaiskeletons.icedchaiSkeletons.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {


    private ClientModEvents() {}


    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(EntityInit.SKNIGHT.get(), SkeletonRenderer::new);
        event.registerEntityRenderer(EntityInit.WARCHER.get(), WitherSkeletonRenderer::new);
        event.registerEntityRenderer(EntityInit.STKNIGHT.get(), StrayRenderer::new);
    }
}
