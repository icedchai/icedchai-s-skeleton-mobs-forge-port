package me.icedchai.icedchaiskeletons;

import me.icedchai.icedchaiskeletons.common.config.OptionsHolder;
import me.icedchai.icedchaiskeletons.common.entity.EntityInit;
import me.icedchai.icedchaiskeletons.common.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static me.icedchai.icedchaiskeletons.icedchaiSkeletons.MODID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MODID)
public class icedchaiSkeletons
{

    public static  final String MODID = "icedchaiskeletons";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public icedchaiSkeletons() {
        // Register the setup method for modloading
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModItems.ITEM.register(bus);
        EntityInit.ENTITY.register(bus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, OptionsHolder.COMMON_SPEC);

    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code

    }


    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
