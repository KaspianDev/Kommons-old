/*
 *     Kommons - Set of common utilities for my projects.
 *     Copyright (C) 2023 Kaspian
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.kaspiandev.kommons.spigot.builders;

import com.github.kaspiandev.kommons.spigot.enchant.LeveledEnchant;
import com.github.kaspiandev.kommons.spigot.pdc.PDCUtils;
import com.github.kaspiandev.kommons.spigot.utils.EnchantUtils;
import com.github.kaspiandev.kommons.spigot.utils.SkullUtils;
import com.google.common.collect.Multimap;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@SuppressWarnings("unused")
public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta itemMeta;

    public ItemBuilder(Material material) {
        this(new ItemStack(material), 1);
    }

    public ItemBuilder(ItemStack item) {
        this(item, 1);
    }

    public ItemBuilder(ItemStack item, int amount) {
        this.item = item;
        this.item.setAmount(amount);
        this.itemMeta = this.item.getItemMeta();
    }

    public ItemBuilder name(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
        this.itemMeta.setLore(lore);
        return this;
    }

    public ItemBuilder lore(@NotNull String lore) {
        this.itemMeta.setLore(List.of(lore));
        return this;
    }

    public ItemBuilder enchant(Plugin plugin, String name, int level) {
        this.itemMeta.addEnchant(EnchantUtils.getByName(plugin, name), level, true);
        return this;
    }

    public ItemBuilder enchant(LeveledEnchant enchant) {
        this.itemMeta.addEnchant(enchant.enchantment(), enchant.level(), true);
        return this;
    }

    public ItemBuilder enchants(List<LeveledEnchant> enchants) {
        enchants.forEach(this::enchant);
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.item.setAmount(amount);
        return this;
    }

    public ItemBuilder addString(NamespacedKey key, String value) {
        PDCUtils.setString(itemMeta.getPersistentDataContainer(), key, value);
        return this;
    }

    public ItemBuilder addInteger(NamespacedKey key, Integer value) {
        PDCUtils.setInteger(itemMeta.getPersistentDataContainer(), key, value);
        return this;
    }

    public ItemBuilder addDouble(NamespacedKey key, Double value) {
        PDCUtils.setDouble(itemMeta.getPersistentDataContainer(), key, value);
        return this;
    }

    public ItemBuilder setTextureBase64(String base64) {
        ((SkullMeta) this.itemMeta).setOwnerProfile(SkullUtils.getProfileBase64(base64));
        return this;
    }

    @SuppressWarnings("java:S117")
    public ItemBuilder setTextureURL(String URL) {
        ((SkullMeta) this.itemMeta).setOwnerProfile(SkullUtils.getProfile(URL));
        return this;
    }

    public ItemBuilder addFlag(ItemFlag itemFlag) {
        this.itemMeta.addItemFlags(itemFlag);
        return this;
    }

    public ItemBuilder addFlags(ItemFlag... itemFlags) {
        this.itemMeta.addItemFlags(itemFlags);
        return this;
    }

    public ItemBuilder addFlags(@NotNull List<String> itemFlags) {
        itemFlags.forEach((flag) -> this.itemMeta.addItemFlags(ItemFlag.valueOf(flag)));
        return this;
    }

    public ItemBuilder modifyAttribute(Attribute attribute, AttributeModifier modifier) {
        this.itemMeta.addAttributeModifier(attribute, modifier);
        return this;
    }

    public ItemBuilder modifyAttributes(Multimap<Attribute, AttributeModifier> attributes) {
        this.itemMeta.setAttributeModifiers(attributes);
        return this;
    }

    public ItemStack build() {
        this.item.setItemMeta(this.itemMeta);
        return item;
    }

}
