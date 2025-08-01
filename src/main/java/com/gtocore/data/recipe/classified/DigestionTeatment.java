package com.gtocore.data.recipe.classified;

import com.gtocore.common.data.GTOMaterials;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gtocore.common.data.GTORecipeTypes.DIGESTION_TREATMENT_RECIPES;
import static com.gtocore.common.data.GTORecipeTypes.DISTILLATION_RECIPES;

final class DigestionTeatment {

    public static void init() {
        DIGESTION_TREATMENT_RECIPES.recipeBuilder("rare_earth_oxide_dust")
                .inputItems(TagPrefix.dust, GTOMaterials.SodiumOxide, 3)
                .inputFluids(GTOMaterials.RareEarthChlorides.getFluid(1000))
                .outputItems(TagPrefix.dust, GTOMaterials.RareEarthOxide)
                .outputFluids(GTMaterials.SaltWater.getFluid(1000))
                .EUt(1920)
                .duration(800)
                .blastFurnaceTemp(2580)
                .save();

        DIGESTION_TREATMENT_RECIPES.recipeBuilder("naquadah_contain_rare_earth_dust")
                .inputItems(TagPrefix.dust, GTOMaterials.NaquadahContainRareEarthFluoride)
                .inputFluids(GTMaterials.Hydrogen.getFluid(2000))
                .outputItems(TagPrefix.dust, GTOMaterials.NaquadahContainRareEarth)
                .outputFluids(GTMaterials.HydrofluoricAcid.getFluid(2000))
                .EUt(491520)
                .duration(800)
                .blastFurnaceTemp(6800)
                .save();

        DIGESTION_TREATMENT_RECIPES.recipeBuilder("rare_earth_metal_dust")
                .inputItems(TagPrefix.dust, GTOMaterials.RareEarthOxide)
                .inputFluids(GTMaterials.Hydrogen.getFluid(1000))
                .outputItems(TagPrefix.dust, GTOMaterials.RareEarthMetal)
                .outputFluids(GTMaterials.Water.getFluid(500))
                .EUt(7680)
                .duration(400)
                .blastFurnaceTemp(1760)
                .save();

        DISTILLATION_RECIPES.recipeBuilder("enriched_naquadah_fuel")
                .inputFluids(GTOMaterials.RadonCrackedEnrichedAquadah.getFluid(1000))
                .outputFluids(GTOMaterials.EnrichedNaquadahFuel.getFluid(800))
                .outputFluids(GTMaterials.NaquadriaWaste.getFluid(100))
                .outputFluids(GTMaterials.Radon.getFluid(200))
                .outputFluids(GTMaterials.Fluorine.getFluid(200))
                .EUt(30720)
                .duration(600)
                .save();

        DISTILLATION_RECIPES.recipeBuilder("naquadah_fuel")
                .inputFluids(GTOMaterials.FluorineCrackedAquadah.getFluid(1000))
                .outputFluids(GTOMaterials.NaquadahFuel.getFluid(800))
                .outputFluids(GTMaterials.NitricAcid.getFluid(200))
                .outputFluids(GTMaterials.EnrichedNaquadahWaste.getFluid(100))
                .outputFluids(GTMaterials.Ammonia.getFluid(200))
                .outputFluids(GTMaterials.Fluorine.getFluid(200))
                .EUt(122880)
                .duration(600)
                .save();

        DISTILLATION_RECIPES.recipeBuilder("diphenylmethane_diisocyanate_dust")
                .inputFluids(GTOMaterials.DiphenylmethanediisocyanateMixture.getFluid(1000))
                .outputItems(TagPrefix.dust, GTOMaterials.DiphenylmethaneDiisocyanate, 29)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(5000))
                .EUt(1920)
                .duration(700)
                .save();

        DISTILLATION_RECIPES.recipeBuilder("turpentine")
                .inputFluids(GTOMaterials.SteamCrackedTurpentine.getFluid(1000))
                .outputFluids(GTOMaterials.Turpentine.getFluid(1000))
                .outputFluids(GTMaterials.Naphtha.getFluid(900))
                .EUt(1920)
                .duration(400)
                .save();

        DISTILLATION_RECIPES.recipeBuilder("rawradox")
                .inputFluids(GTOMaterials.RawRadox.getFluid(5000))
                .outputItems(TagPrefix.dust, GTMaterials.Ash, 5)
                .outputFluids(GTMaterials.OilHeavy.getFluid(600))
                .outputFluids(GTMaterials.Oil.getFluid(300))
                .outputFluids(GTMaterials.Creosote.getFluid(1000))
                .outputFluids(GTMaterials.Water.getFluid(1400))
                .outputFluids(GTMaterials.Bacteria.getFluid(50))
                .outputFluids(GTMaterials.FermentedBiomass.getFluid(50))
                .outputFluids(GTOMaterials.SuperHeavyRadox.getFluid(100))
                .outputFluids(GTOMaterials.HeavyRadox.getFluid(100))
                .outputFluids(GTOMaterials.DilutedXenoxene.getFluid(100))
                .outputFluids(GTOMaterials.LightRadox.getFluid(100))
                .outputFluids(GTOMaterials.SuperLightRadox.getFluid(100))
                .EUt(491520)
                .duration(800)
                .save();

        DISTILLATION_RECIPES.recipeBuilder("dilutedxenoxene")
                .inputFluids(GTOMaterials.DilutedXenoxene.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Ash)
                .outputFluids(GTOMaterials.Xenoxene.getFluid(250))
                .outputFluids(GTOMaterials.LightRadox.getFluid(300))
                .EUt(491520)
                .duration(200)
                .save();

        DISTILLATION_RECIPES.recipeBuilder("radox_gas")
                .inputFluids(GTOMaterials.CrackedRadox.getFluid(1000))
                .outputItems(TagPrefix.dust, GTMaterials.Ash)
                .outputFluids(GTOMaterials.RadoxGas.getFluid(100))
                .outputFluids(GTOMaterials.LightRadox.getFluid(200))
                .EUt(491520)
                .duration(600)
                .save();
    }
}
