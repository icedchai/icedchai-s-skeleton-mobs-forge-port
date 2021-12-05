package me.icedchai.icedchaiskeletons.common.event;

import me.icedchai.icedchaiskeletons.common.entity.EntityInit;
import me.icedchai.icedchaiskeletons.common.entity.SkeletonKnight;
import me.icedchai.icedchaiskeletons.common.entity.StrayKnight;
import me.icedchai.icedchaiskeletons.common.entity.WitherArcher;
import me.icedchai.icedchaiskeletons.icedchaiSkeletons;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = icedchaiSkeletons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.SKNIGHT.get(), SkeletonKnight.createSKnightAttributes().build());
        event.put(EntityInit.STKNIGHT.get(), StrayKnight.createStKnightAttributes().build());
        event.put(EntityInit.WARCHER.get(), WitherArcher.createWArcherAttributes().build());
    }
    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        SpawnPlacements.register(EntityInit.SKNIGHT.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Monster::checkMonsterSpawnRules);
    }

}