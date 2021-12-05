package me.icedchai.icedchaiskeletons.common.event;

import me.icedchai.icedchaiskeletons.common.config.OptionsHolder;
import me.icedchai.icedchaiskeletons.common.entity.EntityInit;
import me.icedchai.icedchaiskeletons.icedchaiSkeletons;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = icedchaiSkeletons.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class CommonForgeEvents {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void spawnEntities(BiomeLoadingEvent event) {

        MobSpawnInfoBuilder builder = event.getSpawns();
        if (event.getCategory() != Biome.BiomeCategory.MUSHROOM) {

            builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.SKNIGHT.get(), OptionsHolder.COMMON.skeletonWeight.get(), 4, 4));

        }
        if(event.getCategory()== Biome.BiomeCategory.ICY){
            builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityInit.STKNIGHT.get(), OptionsHolder.COMMON.strayWeight.get(), 4, 4));
        }

    }


}

