package me.icedchai.icedchaiskeletons.common.item;

import me.icedchai.icedchaiskeletons.common.entity.EntityInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static me.icedchai.icedchaiskeletons.icedchaiSkeletons.MODID;

public class ModItems {

    public static final CreativeModeTab TAB = new CreativeModeTab(14, "skeleton_spawn_eggs"){
            public ItemStack makeIcon(){return new ItemStack(Items.BONE);}
    };


    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<ForgeSpawnEggItem> SKNIGHT_SPAWN_EGG = ITEM.register("skeleton_knight_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.SKNIGHT,12698049, 4802870, new Item.Properties().tab(TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> STKNIGHT_SPAWN_EGG = ITEM.register("stray_knight_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.STKNIGHT,6387319, 14543540, new Item.Properties().tab(TAB)));

}
