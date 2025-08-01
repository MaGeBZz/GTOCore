package com.gtocore.common.data;

import com.gtocore.common.fluid.GelidCryotheumFluid;
import com.gtocore.common.fluid.types.GelidCryotheumFluidType;

import com.gtolib.GTOCore;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class GTOFluids {

    public static final DeferredRegister<FluidType> FLUID_TYPE = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, GTOCore.MOD_ID);
    public static final RegistryObject<FluidType> GELID_CRYOTHEUM_TYPE = FLUID_TYPE.register("gelid_cryotheum", GelidCryotheumFluidType::new);

    public static final DeferredRegister<Fluid> FLUID = DeferredRegister.create(ForgeRegistries.FLUIDS, GTOCore.MOD_ID);
    public static final RegistryObject<FlowingFluid> GELID_CRYOTHEUM = FLUID.register("gelid_cryotheum", GelidCryotheumFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_GELID_CRYOTHEUM = FLUID.register("flowing_gelid_cryotheum", GelidCryotheumFluid.Flowing::new);
}
