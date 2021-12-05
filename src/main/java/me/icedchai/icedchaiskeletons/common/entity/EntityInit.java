package me.icedchai.icedchaiskeletons.common.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static me.icedchai.icedchaiskeletons.icedchaiSkeletons.MODID;

public final class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES,
        MODID);
    public static final RegistryObject<EntityType<SkeletonKnight>> SKNIGHT = ENTITY.register("skeleton_knight", () ->
            EntityType.Builder.of(SkeletonKnight::new, MobCategory.MONSTER).sized(0.6f, 1.99f).build(new ResourceLocation(MODID, "skeleton_knight").toString()));
    public static final RegistryObject<EntityType<StrayKnight>> STKNIGHT = ENTITY.register("stray_knight", () ->
            EntityType.Builder.of(StrayKnight::new, MobCategory.MONSTER).sized(0.6f, 1.99f).build(new ResourceLocation(MODID, "stray_knight").toString()));
    public static final RegistryObject<EntityType<WitherArcher>> WARCHER = ENTITY.register("wither_archer", () ->
            EntityType.Builder.of(WitherArcher::new, MobCategory.MONSTER).sized(0.7f, 2.4f).build(new ResourceLocation(MODID, "wither_archer").toString()));
}
