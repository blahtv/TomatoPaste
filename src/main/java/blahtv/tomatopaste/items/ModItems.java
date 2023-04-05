package blahtv.tomatopaste.items;

import blahtv.tomatopaste.TomatoPaste;
import blahtv.tomatopaste.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, TomatoPaste.MOD_ID);


    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", 
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", 
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> PIZZA_CRUST = ITEMS.register("pizza_crust", 
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> SAUCE_BUCKET = ITEMS.register("sauce_bucket", 
        () -> new BucketItem( () -> ModFluids.TOMATO_SAUCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
