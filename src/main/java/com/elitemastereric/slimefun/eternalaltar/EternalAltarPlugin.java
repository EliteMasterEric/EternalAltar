package com.elitemastereric.slimefun.eternalaltar;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.elitemastereric.slimefun.eternalaltar.listeners.EternalAltarListener;
import com.elitemastereric.slimefun.eternalaltar.machines.EternalAltar;

import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.altar.AncientPedestal;

public class EternalAltarPlugin extends JavaPlugin implements SlimefunAddon {

    private Config cfg;

    private ItemGroup itemGroup;

    public static SlimefunItemStack ETERNAL_ALTAR;

    @Override
    public void onEnable() {
        cfg = new Config(this);

        ETERNAL_ALTAR = new SlimefunItemStack("ETERNAL_ALTAR",
        Material.ENCHANTING_TABLE, "&dEternal Altar", "", "&4E&6N&eH&aA&2N&1C&5E&dD &5Multi-Block Altar for",
        "&5magical Crafting Processes");

        itemGroup = new ItemGroup(new NamespacedKey(this, "eternal_altar"),
                new CustomItemStack(ETERNAL_ALTAR, "&dEternal Altar"));

        new EternalAltar(itemGroup, ETERNAL_ALTAR, RecipeType.MAGIC_WORKBENCH,
                new ItemStack[] {
                        null, SlimefunItems.ANCIENT_ALTAR, null,
                        SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.ENCHANTMENT_RUNE,
                        SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.WITHER_PROOF_OBSIDIAN
                }).register(this);

        new EternalAltarListener(this, (EternalAltar) ETERNAL_ALTAR.getItem(), (AncientPedestal) SlimefunItems.ANCIENT_PEDESTAL.getItem());
    }

    public Config getCfg() {
        return cfg;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/EliteMasterEric/RudimentaryMaterialGenerators/issues";
    }
}
