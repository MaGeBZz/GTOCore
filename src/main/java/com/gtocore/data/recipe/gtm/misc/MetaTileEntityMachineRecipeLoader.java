package com.gtocore.data.recipe.gtm.misc;

import com.gtocore.common.data.machines.GTAEMachines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import appeng.core.definitions.AEItems;
import appeng.core.definitions.AEParts;

import java.util.Locale;
import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.LD_FLUID_PIPE;
import static com.gregtechceu.gtceu.common.data.GTBlocks.LD_ITEM_PIPE;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gtocore.common.data.GTORecipeTypes.ASSEMBLER_RECIPES;

public final class MetaTileEntityMachineRecipeLoader {

    public static void init(Consumer<FinishedRecipe> provider) {
        // Reservoir Hatch
        ASSEMBLER_RECIPES.recipeBuilder("reservoir_hatch")
                .inputItems(COVER_INFINITE_WATER)
                .inputItems(FLUID_IMPORT_HATCH[EV])
                .inputItems(ELECTRIC_PUMP_EV)
                .outputItems(RESERVOIR_HATCH)
                .duration(300).EUt(VA[EV])
                .save();

        registerLaserRecipes();

        // Energy Output Hatches

        VanillaRecipeHelper.addShapedRecipe(provider, true, "dynamo_hatch_ulv", ENERGY_OUTPUT_HATCH[ULV].asStack(),
                " V ", "SHS", "   ",
                'S', new MaterialEntry(spring, Lead),
                'V', VOLTAGE_COIL_ULV.asStack(),
                'H', HULL[ULV].asStack());

        ASSEMBLER_RECIPES.recipeBuilder("dynamo_hatch_ulv")
                .inputItems(HULL[ULV])
                .inputItems(spring, Lead, 2)
                .inputItems(VOLTAGE_COIL_ULV)
                .outputItems(ENERGY_OUTPUT_HATCH[ULV])
                .duration(200).EUt(VA[ULV])
                .save();

        VanillaRecipeHelper.addShapedRecipe(provider, true, "dynamo_hatch_lv", ENERGY_OUTPUT_HATCH[LV].asStack(),
                " V ", "SHS", "   ",
                'S', new MaterialEntry(spring, Tin),
                'V', VOLTAGE_COIL_LV.asStack(),
                'H', HULL[LV].asStack());

        ASSEMBLER_RECIPES.recipeBuilder("dynamo_hatch_lv")
                .inputItems(HULL[LV])
                .inputItems(spring, Tin, 2)
                .inputItems(VOLTAGE_COIL_LV)
                .outputItems(ENERGY_OUTPUT_HATCH[LV])
                .duration(200).EUt(VA[LV])
                .save();

        VanillaRecipeHelper.addShapedRecipe(provider, true, "dynamo_hatch_mv", ENERGY_OUTPUT_HATCH[MV].asStack(),
                " V ", "SHS", " P ",
                'P', ULTRA_LOW_POWER_INTEGRATED_CIRCUIT.asStack(),
                'S', new MaterialEntry(spring, Copper),
                'V', VOLTAGE_COIL_MV.asStack(),
                'H', HULL[MV].asStack());

        ASSEMBLER_RECIPES.recipeBuilder("dynamo_hatch_mv")
                .inputItems(HULL[MV])
                .inputItems(spring, Copper, 2)
                .inputItems(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT)
                .inputItems(VOLTAGE_COIL_MV)
                .outputItems(ENERGY_OUTPUT_HATCH[MV])
                .duration(200).EUt(VA[MV])
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("dynamo_hatch_hv")
                .inputItems(HULL[HV])
                .inputItems(spring, Gold, 2)
                .inputItems(LOW_POWER_INTEGRATED_CIRCUIT, 2)
                .inputItems(VOLTAGE_COIL_HV)
                .inputFluids(SodiumPotassium, 1000)
                .outputItems(ENERGY_OUTPUT_HATCH[HV])
                .duration(200).EUt(VA[HV])
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("dynamo_hatch_ev")
                .inputItems(HULL[EV])
                .inputItems(spring, Aluminium, 2)
                .inputItems(POWER_INTEGRATED_CIRCUIT, 2)
                .inputItems(VOLTAGE_COIL_EV)
                .inputFluids(SodiumPotassium, 2000)
                .outputItems(ENERGY_OUTPUT_HATCH[EV])
                .duration(200).EUt(VA[EV])
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("dynamo_hatch_iv")
                .inputItems(HULL[IV])
                .inputItems(spring, Tungsten, 2)
                .inputItems(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .inputItems(VOLTAGE_COIL_IV)
                .inputFluids(SodiumPotassium, 3000)
                .outputItems(ENERGY_OUTPUT_HATCH[IV])
                .duration(200).EUt(VA[IV])
                .save();

        // Energy Input Hatches

        VanillaRecipeHelper.addShapedRecipe(provider, true, "energy_hatch_ulv", ENERGY_INPUT_HATCH[ULV].asStack(),
                " V ", "CHC", "   ",
                'C', new MaterialEntry(cableGtSingle, RedAlloy),
                'V', VOLTAGE_COIL_ULV.asStack(),
                'H', HULL[ULV].asStack());

        ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_ulv")
                .inputItems(HULL[ULV])
                .inputItems(cableGtSingle, RedAlloy, 2)
                .inputItems(VOLTAGE_COIL_ULV)
                .outputItems(ENERGY_INPUT_HATCH[ULV])
                .duration(200).EUt(VA[ULV])
                .save();

        VanillaRecipeHelper.addShapedRecipe(provider, true, "energy_hatch_lv", ENERGY_INPUT_HATCH[LV].asStack(),
                " V ", "CHC", "   ",
                'C', new MaterialEntry(cableGtSingle, Tin),
                'V', VOLTAGE_COIL_LV.asStack(),
                'H', HULL[LV].asStack());

        ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_lv")
                .inputItems(HULL[LV])
                .inputItems(cableGtSingle, Tin, 2)
                .inputItems(VOLTAGE_COIL_LV)
                .outputItems(ENERGY_INPUT_HATCH[LV])
                .duration(200).EUt(VA[LV])
                .save();

        VanillaRecipeHelper.addShapedRecipe(provider, true, "energy_hatch_mv", ENERGY_INPUT_HATCH[MV].asStack(),
                " V ", "CHC", " P ",
                'C', new MaterialEntry(cableGtSingle, Copper),
                'P', ULTRA_LOW_POWER_INTEGRATED_CIRCUIT.asStack(),
                'V', VOLTAGE_COIL_MV.asStack(),
                'H', HULL[MV].asStack());

        ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_mv")
                .inputItems(HULL[MV])
                .inputItems(cableGtSingle, Copper, 2)
                .inputItems(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT)
                .inputItems(VOLTAGE_COIL_MV)
                .outputItems(ENERGY_INPUT_HATCH[MV])
                .duration(200).EUt(VA[MV])
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_hv")
                .inputItems(HULL[HV])
                .inputItems(cableGtSingle, Gold, 2)
                .inputItems(LOW_POWER_INTEGRATED_CIRCUIT, 2)
                .inputItems(VOLTAGE_COIL_HV)
                .inputFluids(SodiumPotassium, 1000)
                .outputItems(ENERGY_INPUT_HATCH[HV])
                .duration(200).EUt(VA[HV])
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_ev")
                .inputItems(HULL[EV])
                .inputItems(cableGtSingle, Aluminium, 2)
                .inputItems(POWER_INTEGRATED_CIRCUIT, 2)
                .inputItems(VOLTAGE_COIL_EV)
                .inputFluids(SodiumPotassium, 2000)
                .outputItems(ENERGY_INPUT_HATCH[EV])
                .duration(200).EUt(VA[EV])
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_iv")
                .inputItems(HULL[IV])
                .inputItems(cableGtSingle, Tungsten, 2)
                .inputItems(HIGH_POWER_INTEGRATED_CIRCUIT, 2)
                .inputItems(VOLTAGE_COIL_IV)
                .inputFluids(SodiumPotassium, 3000)
                .outputItems(ENERGY_INPUT_HATCH[IV])
                .duration(200).EUt(VA[IV])
                .save();

        // Power Transformers
        for (int tier = 0; tier < POWER_TRANSFORMER.length; tier++) {
            var hatch = POWER_TRANSFORMER[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_power_transformer")
                    .inputItems(HI_AMP_TRANSFORMER_4A[tier])
                    .inputItems(GTCraftingComponents.PUMP.get((tier / 2 + 1)))
                    .inputItems(GTCraftingComponents.CABLE_TIER_UP_OCT.get(tier))
                    .inputItems(GTCraftingComponents.CABLE_HEX.get(tier))
                    .inputItems(GTCraftingComponents.SMALL_SPRING_TRANSFORMER.get(tier))
                    .inputItems(GTCraftingComponents.SPRING_TRANSFORMER.get(tier))
                    .inputFluids(Lubricant, 2000)
                    .outputItems(hatch)
                    .duration(100).EUt(VA[tier])
                    .save();
        }

        // 4A Energy Hatches
        for (int tier = 0; tier < ENERGY_INPUT_HATCH_4A.length; tier++) {
            var hatch = ENERGY_INPUT_HATCH_4A[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_4a_" + GTValues.VN[tier].toLowerCase(Locale.ROOT))
                    .inputItems(ENERGY_INPUT_HATCH[tier])
                    .inputItems(GTCraftingComponents.WIRE_QUAD.get(tier), 2)
                    .inputItems(GTCraftingComponents.PLATE.get(tier), 2)
                    .outputItems(hatch)
                    .duration(100).EUt(VA[tier])
                    .save();
        }

        // 16A Energy Hatches
        for (int tier = 0; tier < ENERGY_INPUT_HATCH_16A.length; tier++) {
            var hatch = ENERGY_INPUT_HATCH_16A[tier];
            if (hatch == null) continue;

            MachineDefinition transformer;
            if (tier == (GTCEuAPI.isHighTier() ? MAX : UHV)) {
                transformer = HI_AMP_TRANSFORMER_4A[tier - 1];
            } else {
                transformer = TRANSFORMER[tier];
            }

            ASSEMBLER_RECIPES.recipeBuilder("energy_hatch_16a_" + GTValues.VN[tier].toLowerCase(Locale.ROOT))
                    .inputItems(transformer)
                    .inputItems(ENERGY_INPUT_HATCH_4A[tier])
                    .inputItems(GTCraftingComponents.WIRE_OCT.get(tier), 2)
                    .inputItems(GTCraftingComponents.PLATE.get(tier), 4)
                    .outputItems(hatch)
                    .duration(200).EUt(VA[tier])
                    .save();
        }

        // 64A Substation Energy Hatches
        for (int tier = 0; tier < SUBSTATION_ENERGY_INPUT_HATCH.length; tier++) {
            var hatch = SUBSTATION_ENERGY_INPUT_HATCH[tier];
            if (hatch == null) continue;

            MachineDefinition transformer;
            if (tier == (GTCEuAPI.isHighTier() ? MAX : UHV)) {
                transformer = POWER_TRANSFORMER[tier - 1];
            } else {
                transformer = POWER_TRANSFORMER[tier];
            }

            ASSEMBLER_RECIPES.recipeBuilder("substation_energy_hatch_" + GTValues.VN[tier].toLowerCase(Locale.ROOT))
                    .inputItems(transformer)
                    .inputItems(ENERGY_INPUT_HATCH_16A[tier])
                    .inputItems(GTCraftingComponents.WIRE_HEX.get(tier), 2)
                    .inputItems(GTCraftingComponents.PLATE.get(tier), 6)
                    .outputItems(hatch)
                    .duration(400).EUt(VA[tier])
                    .save();
        }

        // 4A Dynamo Hatches
        for (int tier = 0; tier < ENERGY_OUTPUT_HATCH_4A.length; tier++) {
            var hatch = ENERGY_OUTPUT_HATCH_4A[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder("dynamo_hatch_4a_" + GTValues.VN[tier].toLowerCase(Locale.ROOT))
                    .inputItems(ENERGY_OUTPUT_HATCH[tier])
                    .inputItems(GTCraftingComponents.WIRE_QUAD.get(tier), 2)
                    .inputItems(GTCraftingComponents.PLATE.get(tier), 2)
                    .outputItems(hatch)
                    .duration(100).EUt(VA[tier - 1])
                    .save();
        }

        // 16A Dynamo Hatches
        for (int tier = 0; tier < ENERGY_OUTPUT_HATCH_16A.length; tier++) {
            var hatch = ENERGY_OUTPUT_HATCH_16A[tier];
            if (hatch == null) continue;

            MachineDefinition transformer;
            if (tier == (GTCEuAPI.isHighTier() ? MAX : UHV)) {
                transformer = HI_AMP_TRANSFORMER_4A[tier - 1];
            } else {
                transformer = TRANSFORMER[tier];
            }

            ASSEMBLER_RECIPES.recipeBuilder("dynamo_hatch_16a_" + GTValues.VN[tier].toLowerCase(Locale.ROOT))
                    .inputItems(transformer)
                    .inputItems(ENERGY_OUTPUT_HATCH_4A[tier])
                    .inputItems(GTCraftingComponents.WIRE_OCT.get(tier), 2)
                    .inputItems(GTCraftingComponents.PLATE.get(tier), 4)
                    .outputItems(hatch)
                    .duration(200).EUt(VA[tier])
                    .save();
        }

        // 64A Substation Dynamo Hatches
        for (int tier = 0; tier < SUBSTATION_ENERGY_OUTPUT_HATCH.length; tier++) {
            var hatch = SUBSTATION_ENERGY_OUTPUT_HATCH[tier];
            if (hatch == null) continue;

            MachineDefinition transformer;
            if (tier == (GTCEuAPI.isHighTier() ? MAX : UHV)) {
                transformer = POWER_TRANSFORMER[tier - 1];
            } else {
                transformer = POWER_TRANSFORMER[tier];
            }
            if (transformer == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder("substation_dynamo_hatch_" + GTValues.VN[tier].toLowerCase(Locale.ROOT))
                    .inputItems(transformer)
                    .inputItems(ENERGY_OUTPUT_HATCH_16A[tier])
                    .inputItems(GTCraftingComponents.WIRE_HEX.get(tier), 2)
                    .inputItems(GTCraftingComponents.PLATE.get(tier), 6)
                    .outputItems(hatch)
                    .duration(400).EUt(VA[tier])
                    .save();
        }

        // Maintenance Hatch

        ASSEMBLER_RECIPES.recipeBuilder("maintenance_hatch")
                .inputItems(HULL[LV])
                .circuitMeta(8)
                .outputItems(MAINTENANCE_HATCH)
                .duration(100).EUt(VA[LV])
                .save();

        // Multiblock Miners

        ASSEMBLER_RECIPES.recipeBuilder("ev_large_miner")
                .inputItems(HULL[EV])
                .inputItems(frameGt, Titanium, 4)
                .inputItems(CustomTags.IV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_EV, 4)
                .inputItems(ELECTRIC_PUMP_EV, 4)
                .inputItems(CONVEYOR_MODULE_EV, 4)
                .inputItems(gear, Tungsten, 4)
                .circuitMeta(2)
                .outputItems(GTMultiMachines.LARGE_MINER[EV])
                .duration(400).EUt(VA[EV]).save();

        ASSEMBLER_RECIPES.recipeBuilder("iv_large_miner")
                .inputItems(HULL[IV])
                .inputItems(frameGt, TungstenSteel, 4)
                .inputItems(CustomTags.IV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_IV, 4)
                .inputItems(ELECTRIC_PUMP_IV, 4)
                .inputItems(CONVEYOR_MODULE_IV, 4)
                .inputItems(gear, Iridium, 4)
                .circuitMeta(2)
                .outputItems(GTMultiMachines.LARGE_MINER[IV])
                .duration(400).EUt(VA[IV]).save();

        ASSEMBLER_RECIPES.recipeBuilder("luv_large_miner")
                .inputItems(HULL[LuV])
                .inputItems(frameGt, HSSS, 4)
                .inputItems(CustomTags.LuV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_LuV, 4)
                .inputItems(ELECTRIC_PUMP_LuV, 4)
                .inputItems(CONVEYOR_MODULE_LuV, 4)
                .inputItems(gear, Ruridit, 4)
                .circuitMeta(2)
                .outputItems(GTMultiMachines.LARGE_MINER[LuV])
                .duration(400).EUt(VA[LuV]).save();

        // Multiblock Fluid Drills

        ASSEMBLER_RECIPES.recipeBuilder("mv_fluid_drilling_rig")
                .inputItems(HULL[MV])
                .inputItems(frameGt, Steel, 4)
                .inputItems(CustomTags.MV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_MV, 4)
                .inputItems(ELECTRIC_PUMP_MV, 4)
                .inputItems(gear, VanadiumSteel, 4)
                .circuitMeta(2)
                .outputItems(GTMultiMachines.FLUID_DRILLING_RIG[MV])
                .duration(400).EUt(VA[MV])
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("hv_fluid_drilling_rig")
                .inputItems(HULL[EV])
                .inputItems(frameGt, Titanium, 4)
                .inputItems(CustomTags.EV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_EV, 4)
                .inputItems(ELECTRIC_PUMP_EV, 4)
                .inputItems(gear, TungstenCarbide, 4)
                .circuitMeta(2)
                .outputItems(GTMultiMachines.FLUID_DRILLING_RIG[HV])
                .duration(400).EUt(VA[EV])
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("ev_fluid_drilling_rig")
                .inputItems(HULL[LuV])
                .inputItems(frameGt, TungstenSteel, 4)
                .inputItems(CustomTags.LuV_CIRCUITS, 4)
                .inputItems(ELECTRIC_MOTOR_LuV, 4)
                .inputItems(ELECTRIC_PUMP_LuV, 4)
                .inputItems(gear, Osmiridium, 4)
                .circuitMeta(2)
                .outputItems(GTMultiMachines.FLUID_DRILLING_RIG[EV])
                .duration(400).EUt(VA[LuV])
                .save();

        // Long Distance Pipes
        ASSEMBLER_RECIPES.recipeBuilder("long_distance_item_endpoint")
                .inputItems(pipeLargeItem, Tin, 2)
                .inputItems(plate, Steel, 8)
                .inputItems(gear, Steel, 2)
                .circuitMeta(1)
                .inputFluids(SolderingAlloy, L / 2)
                .outputItems(LONG_DIST_ITEM_ENDPOINT, 2)
                .duration(400).EUt(16)
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("long_distance_fluid_endpoint")
                .inputItems(pipeLargeFluid, Bronze, 2)
                .inputItems(plate, Steel, 8)
                .inputItems(gear, Steel, 2)
                .circuitMeta(1)
                .inputFluids(SolderingAlloy, L / 2)
                .outputItems(LONG_DIST_FLUID_ENDPOINT, 2)
                .duration(400).EUt(16)
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("long_distance_item_pipe")
                .inputItems(pipeLargeItem, Tin, 2)
                .inputItems(plate, Steel, 8)
                .circuitMeta(2)
                .inputFluids(SolderingAlloy, L / 2)
                .outputItems(LD_ITEM_PIPE, 64)
                .duration(600).EUt(24)
                .save();

        ASSEMBLER_RECIPES.recipeBuilder("long_distance_fluid_pipe")
                .inputItems(pipeLargeFluid, Bronze, 2)
                .inputItems(plate, Steel, 8)
                .circuitMeta(2)
                .inputFluids(SolderingAlloy, L / 2)
                .outputItems(LD_FLUID_PIPE, 64)
                .duration(600).EUt(24)
                .save();

        // ME Parts

        if (GTCEu.Mods.isAE2Loaded()) {

            ItemStack meInterface = AEParts.INTERFACE.stack(1);
            ItemStack accelerationCard = AEItems.SPEED_CARD.stack(2);

            ASSEMBLER_RECIPES.recipeBuilder("me_export_hatch")
                    .inputItems(FLUID_EXPORT_HATCH[EV])
                    .inputItems(meInterface.copy())
                    .inputItems(accelerationCard.copy())
                    .outputItems(GTAEMachines.FLUID_EXPORT_HATCH_ME)
                    .duration(300).EUt(VA[HV])
                    .save();

            ASSEMBLER_RECIPES.recipeBuilder("me_import_hatch")
                    .inputItems(FLUID_IMPORT_HATCH[EV])
                    .inputItems(meInterface.copy())
                    .inputItems(accelerationCard.copy())
                    .outputItems(GTAEMachines.FLUID_IMPORT_HATCH_ME)
                    .duration(300).EUt(VA[HV])
                    .save();

            ASSEMBLER_RECIPES.recipeBuilder("me_export_bus")
                    .inputItems(ITEM_EXPORT_BUS[EV])
                    .inputItems(meInterface.copy())
                    .inputItems(accelerationCard.copy())
                    .outputItems(GTAEMachines.ITEM_EXPORT_BUS_ME)
                    .duration(300).EUt(VA[HV])
                    .save();

            ASSEMBLER_RECIPES.recipeBuilder("me_import_bus")
                    .inputItems(ITEM_IMPORT_BUS[EV])
                    .inputItems(meInterface.copy())
                    .inputItems(accelerationCard.copy())
                    .outputItems(GTAEMachines.ITEM_IMPORT_BUS_ME)
                    .duration(300).EUt(VA[HV])
                    .save();

            ASSEMBLER_RECIPES.recipeBuilder("me_stocking_import_bus")
                    .inputItems(ITEM_IMPORT_BUS[IV])
                    .inputItems(meInterface.copy())
                    .inputItems(CONVEYOR_MODULE_IV)
                    .inputItems(SENSOR_IV)
                    .inputItems(accelerationCard.copyWithCount(4))
                    .outputItems(GTAEMachines.STOCKING_IMPORT_BUS_ME)
                    .duration(300).EUt(VA[IV])
                    .save();

            ASSEMBLER_RECIPES.recipeBuilder("me_stocking_import_hatch")
                    .inputItems(FLUID_IMPORT_HATCH[IV])
                    .inputItems(meInterface.copy())
                    .inputItems(ELECTRIC_PUMP_IV)
                    .inputItems(SENSOR_IV)
                    .inputItems(accelerationCard.copyWithCount(4))
                    .outputItems(GTAEMachines.STOCKING_IMPORT_HATCH_ME)
                    .duration(300).EUt(VA[IV])
                    .save();
        }
    }

    private static void registerLaserRecipes() {
        // 256A Laser Target Hatches
        for (int tier = 0; tier < LASER_INPUT_HATCH_256.length; tier++) {
            var hatch = LASER_INPUT_HATCH_256[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_256a_laser_target_hatch")
                    .inputItems(HULL[tier])
                    .inputItems(lens, Diamond)
                    .inputItems(GTCraftingComponents.SENSOR.get(tier))
                    .inputItems(GTCraftingComponents.PUMP.get(tier))
                    .inputItems(GTCraftingComponents.CABLE.get(tier), 4)
                    .circuitMeta(1)
                    .outputItems(hatch)
                    .duration(300).EUt(VA[tier])
                    .save();
        }

        // 256A Laser Source Hatches
        for (int tier = 0; tier < LASER_OUTPUT_HATCH_256.length; tier++) {
            var hatch = LASER_OUTPUT_HATCH_256[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_256a_laser_source_hatch")
                    .inputItems(HULL[tier])
                    .inputItems(lens, Diamond)
                    .inputItems(GTCraftingComponents.EMITTER.get(tier))
                    .inputItems(GTCraftingComponents.PUMP.get(tier))
                    .inputItems(GTCraftingComponents.CABLE.get(tier), 4)
                    .circuitMeta(1)
                    .outputItems(hatch)
                    .duration(300).EUt(VA[tier])
                    .save();
        }

        // 1024A Laser Target Hatches
        for (int tier = 0; tier < LASER_INPUT_HATCH_1024.length; tier++) {
            var hatch = LASER_INPUT_HATCH_1024[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_1024a_laser_target_hatch")
                    .inputItems(HULL[tier])
                    .inputItems(lens, Diamond, 2)
                    .inputItems(GTCraftingComponents.SENSOR.get(tier), 2)
                    .inputItems(GTCraftingComponents.PUMP.get(tier), 2)
                    .inputItems(GTCraftingComponents.CABLE_DOUBLE.get(tier), 4)
                    .circuitMeta(2)
                    .outputItems(hatch)
                    .duration(600).EUt(VA[tier])
                    .save();
        }

        // 1024A Laser Source Hatches
        for (int tier = 0; tier < LASER_OUTPUT_HATCH_1024.length; tier++) {
            var hatch = LASER_OUTPUT_HATCH_1024[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_1024a_laser_source_hatch")
                    .inputItems(HULL[tier])
                    .inputItems(lens, Diamond, 2)
                    .inputItems(GTCraftingComponents.EMITTER.get(tier), 2)
                    .inputItems(GTCraftingComponents.PUMP.get(tier), 2)
                    .inputItems(GTCraftingComponents.CABLE_DOUBLE.get(tier), 4)
                    .circuitMeta(2)
                    .outputItems(hatch)
                    .duration(600).EUt(VA[tier])
                    .save();
        }

        // 4096A Laser Target Hatches
        for (int tier = 0; tier < LASER_INPUT_HATCH_4096.length; tier++) {
            var hatch = LASER_INPUT_HATCH_4096[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_4096a_laser_target_hatch")
                    .inputItems(HULL[tier])
                    .inputItems(lens, Diamond, 4)
                    .inputItems(GTCraftingComponents.SENSOR.get(tier), 4)
                    .inputItems(GTCraftingComponents.PUMP.get(tier), 4)
                    .inputItems(GTCraftingComponents.CABLE_QUAD.get(tier), 4)
                    .circuitMeta(3)
                    .outputItems(hatch)
                    .duration(1200).EUt(VA[tier])
                    .save();
        }

        // 4096A Laser Source Hatches
        for (int tier = 0; tier < LASER_OUTPUT_HATCH_4096.length; tier++) {
            var hatch = LASER_OUTPUT_HATCH_4096[tier];
            if (hatch == null) continue;

            ASSEMBLER_RECIPES.recipeBuilder(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_4096a_laser_output_hatch")
                    .inputItems(HULL[tier])
                    .inputItems(lens, Diamond, 4)
                    .inputItems(GTCraftingComponents.EMITTER.get(tier), 4)
                    .inputItems(GTCraftingComponents.PUMP.get(tier), 4)
                    .inputItems(GTCraftingComponents.CABLE_QUAD.get(tier), 4)
                    .circuitMeta(3)
                    .outputItems(hatch)
                    .duration(1200).EUt(VA[tier])
                    .save();
        }
    }
}
