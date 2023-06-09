package blahtv.tomatopaste.fluid;

import blahtv.tomatopaste.TomatoPaste;
import blahtv.tomatopaste.blocks.ModBlocks;
import blahtv.tomatopaste.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flowing");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS =
        DeferredRegister.create(ForgeRegistries.FLUIDS, TomatoPaste.MOD_ID);

    public static final RegistryObject<FlowingFluid> TOMATO_SAUCE =
        FLUIDS.register("tomato_sauce", () -> new ForgeFlowingFluid.Source(ModFluids.SAUCE_PROP));
    public static final RegistryObject<FlowingFluid> TOMATO_SAUCE_FLOWING =
        FLUIDS.register("tomato_sauce_flowing", () -> new ForgeFlowingFluid.Flowing(ModFluids.SAUCE_PROP));
        
    public static final ForgeFlowingFluid.Properties SAUCE_PROP = new ForgeFlowingFluid.Properties(
        () -> TOMATO_SAUCE.get(), () -> TOMATO_SAUCE_FLOWING.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOWING_RL)
        .density(15).luminosity(2).viscosity(5).sound(null, null).overlay(WATER_OVERLAY_RL)
        .color(0xbffcba03)).slopeFindDistance(2).levelDecreasePerBlock(2).block(() -> ModFluids.SAUCE.get())
        .bucket(() -> ModItems.SAUCE_BUCKET.get());

    public static final RegistryObject<LiquidBlock> SAUCE = ModBlocks.BLOCKS.register("sauce",
    () -> new LiquidBlock(() -> ModFluids.TOMATO_SAUCE.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

    public static void register(IEventBus eventBus)
    {
        FLUIDS.register(eventBus);
    }
}
