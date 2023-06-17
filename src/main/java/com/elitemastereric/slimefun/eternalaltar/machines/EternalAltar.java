package com.elitemastereric.slimefun.eternalaltar.machines;

import java.util.List;

import javax.annotation.Nonnull;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.settings.IntRangeSetting;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.altar.AncientAltar;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.altar.AltarRecipe;

public class EternalAltar extends SlimefunItem {

    /**
     * The default speed multiplier for the {@link EternalAltar}.
     * Here, it's 4x faster than the {@link AncientAltar}.
     */
    private static final int DEFAULT_STEP_DELAY = 8 / 4;

    private final ItemSetting<Integer> stepDelay = new IntRangeSetting(this, "step-delay", 0, DEFAULT_STEP_DELAY, Integer.MAX_VALUE);

    public EternalAltar(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        addItemSetting(stepDelay);
    }

    public int getStepDelay() {
        return stepDelay.getValue();
    }

    @Nonnull
    public List<AltarRecipe> getRecipes() {
        return getBaseAltarRecipes();
    }

    List<AltarRecipe> getBaseAltarRecipes() {
        return ((AncientAltar) SlimefunItems.ANCIENT_ALTAR.getItem()).getRecipes();
    }
}
