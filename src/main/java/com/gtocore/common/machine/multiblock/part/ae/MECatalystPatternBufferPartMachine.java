package com.gtocore.common.machine.multiblock.part.ae;

import com.gtolib.api.machine.trait.NotifiableCatalystHandler;
import com.gtolib.api.machine.trait.NotifiableNotConsumableItemHandler;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import org.jetbrains.annotations.NotNull;

public final class MECatalystPatternBufferPartMachine extends MEPatternBufferPartMachineKt {

    public MECatalystPatternBufferPartMachine(IMachineBlockEntity holder) {
        super(holder, 27);
    }

    @Override
    @NotNull
    NotifiableNotConsumableItemHandler createShareInventory() {
        return new NotifiableCatalystHandler(this, 9, false);
    }
}
