package com.gtocore.common.machine.multiblock.electric.assembly;

import com.gtocore.common.machine.multiblock.part.HugeBusPartMachine;
import com.gtocore.data.IdleReason;

import com.gtolib.api.machine.multiblock.ElectricMultiblockMachine;
import com.gtolib.api.recipe.Recipe;
import com.gtolib.api.recipe.ingredient.FastSizedIngredient;
import com.gtolib.api.recipe.modifier.RecipeModifierFunction;

import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.transfer.item.CustomItemStackHandler;
import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public final class AdvancedAssemblyLineMachine extends ElectricMultiblockMachine {

    public AdvancedAssemblyLineMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    private List<CustomItemStackHandler> itemStackTransfers = new ArrayList<>();

    @Nullable
    @Override
    protected Recipe getRealRecipe(@NotNull Recipe recipe) {
        FastSizedIngredient[] recipeIngredients = getRecipeIngredients(recipe);
        int size = recipeIngredients.length;
        if (itemStackTransfers.size() < size) return null;
        if (!validateIngredientStacks(this, size, recipeIngredients)) {
            setIdleReason(IdleReason.ORDERED);
            return null;
        }
        return RecipeModifierFunction.laserLossOverclocking(this, RecipeModifierFunction.hatchParallel(this, recipe));
    }

    /**
     * 从给定的GTRecipe对象中获取配方所需的原料。
     *
     * @param recipe 包含配方信息的GTRecipe对象
     * @return 一个包含配方所需原料的Ingredient数组
     */
    private static FastSizedIngredient[] getRecipeIngredients(GTRecipe recipe) {
        var inputs = recipe.inputs.get(ItemRecipeCapability.CAP);
        FastSizedIngredient[] ingredients = new FastSizedIngredient[inputs.size()];
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i).getContent() instanceof FastSizedIngredient ingredient && !ingredient.isEmpty()) {
                ingredients[i] = ingredient;
            } else {
                ingredients[i] = null;
            }
        }
        return ingredients;
    }

    /**
     * 验证AdvancedAssemblyLineMachine中的配料堆栈是否满足给定的匹配配料。
     *
     * @param lineMachine       AdvancedAssemblyLineMachine对象
     * @param size              配料的数量
     * @param recipeIngredients 用于匹配的配料数组
     * @return 如果所有配料堆栈匹配则返回true，否则返回false
     */
    private static boolean validateIngredientStacks(AdvancedAssemblyLineMachine lineMachine, int size, FastSizedIngredient[] recipeIngredients) {
        Set<Item> itemSet = new ObjectOpenHashSet<>();
        for (int i = 0; i < size; i++) {
            FastSizedIngredient currentIngredient = recipeIngredients[i];
            if (currentIngredient == null) continue;
            if (!isValidStorage(itemSet, lineMachine.itemStackTransfers.get(i), currentIngredient)) return false;
        }
        return true;
    }

    /**
     * 判断指定的存储是否有效。
     *
     * @param storage           指定的ItemStackTransfer存储对象
     * @param currentIngredient 当前的成分
     * @return 如果存储中的所有物品相同并且匹配当前成分，则返回true，否则返回false
     */
    private static boolean isValidStorage(Set<Item> itemSet, CustomItemStackHandler storage, FastSizedIngredient currentIngredient) {
        Item item = Items.AIR;
        itemSet.clear();
        var slots = storage.getSlots();
        for (int j = 0; j < slots; j++) {
            Item i = storage.getStackInSlot(j).getItem();
            if (i == Items.AIR) continue;
            itemSet.add(item);
            item = i;
        }

        return itemSet.size() == 1 && currentIngredient.testItem(item);
    }

    @Override
    public Comparator<IMultiPart> getPartSorter() {
        return Comparator.comparing(p -> p.self().getPos(), RelativeDirection.RIGHT.getSorter(getFrontFacing(), getUpwardsFacing(), isFlipped()));
    }

    /**
     * 当结构形成时调用的方法。
     * 在此方法中，设置部件的排序方式，并初始化itemStackTransfers字段。
     * itemStackTransfers字段存储了通过筛选和映射获取的所有ItemBusPartMachine实例的库存存储区。
     * 此外，该方法还调用了父类的onStructureFormed方法以执行超类中的相关逻辑。
     */
    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        itemStackTransfers = new ArrayList<>();
        for (Object part : getParts()) {
            if (part instanceof ItemBusPartMachine itemBusPart) {
                itemStackTransfers.add(itemBusPart.getInventory().storage);
            } else if (part instanceof HugeBusPartMachine hugeBusPartMachine) {
                itemStackTransfers.add(hugeBusPartMachine.getInventory().storage);
            }
        }
    }
}
