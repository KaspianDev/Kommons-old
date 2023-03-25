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

import com.github.kaspiandev.kommons.spigot.pdc.PDCUtils;
import com.github.kaspiandev.kommons.spigot.pdc.objects.IntegerPDC;
import com.github.kaspiandev.kommons.spigot.pdc.objects.PDCObject;
import com.github.kaspiandev.kommons.spigot.pdc.objects.StringPDC;
import com.github.kaspiandev.kommons.spigot.utils.SkullUtils;
import com.github.kaspiandev.kommons.universal.pairs.Pair;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class ItemBuilder {

    private final List<PDCObject<?>> pdcObjects = new ArrayList<>();
    private final List<ItemFlag> itemFlags = new ArrayList<>();
    private final Multimap<Attribute, AttributeModifier> attributes = ArrayListMultimap.create();
    private String URL;
    private final ItemStack item;
    private String name;
    private int amount;
    private Map<Enchantment, Integer> enchantmentMap;
    private PersistentDataContainer pdc;
    private String base64;
    private List<String> lore = new ArrayList<>();

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
        this.amount = 1;
    }

    public ItemBuilder(ItemStack item) {
        this.item = item;
        this.amount = 1;
    }

    public ItemBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemBuilder lore(@NotNull String lore) {
        this.lore.addAll(Arrays.asList(lore.split("\\n+")));
        return this;
    }

    public ItemBuilder lore(@NotNull String... lore) {
        for (String line : lore) {
            this.lore.addAll(Arrays.asList(line.split("\\n+")));
        }
        return this;
    }

    public ItemBuilder enchant(Plugin plugin, String name, int level) {
        this.enchantmentMap.put(Enchantment.getByKey(new NamespacedKey(plugin, name)), level);
        return this;
    }

    public ItemBuilder enchant(Enchantment enchant, int level) {
        this.enchantmentMap.put(enchant, level);
        return this;
    }

    public ItemBuilder enchants(Map<Enchantment, Integer> enchantmentMap) {
        this.enchantmentMap.putAll(enchantmentMap);
        return this;
    }

    @SafeVarargs
    public final ItemBuilder enchantsByKeys(Plugin plugin, @NotNull Pair<String, Integer>... enchants) {
        for (Pair<String, Integer> pair : enchants) {
            this.enchantmentMap.put(Enchantment.getByKey(new NamespacedKey(plugin, pair.getLeft())), pair.getRight());
        }
        return this;
    }

    @SafeVarargs
    public final ItemBuilder enchants(Plugin plugin, @NotNull Pair<Enchantment, Integer>... enchants) {
        for (Pair<Enchantment, Integer> pair : enchants) {
            this.enchantmentMap.put(pair.getLeft(), pair.getRight());
        }
        return this;
    }

    public ItemBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemBuilder string(NamespacedKey key, String value) {
        pdcObjects.add(new StringPDC(key, value));
        return this;
    }

    public ItemBuilder integer(NamespacedKey key, Integer value) {
        pdcObjects.add(new IntegerPDC(key, value));
        return this;
    }

    public ItemBuilder setTextureBase64(String base64) {
        this.base64 = base64;
        return this;
    }

    public ItemBuilder setTextureURL(String URL) {
        this.URL = URL;
        return this;
    }

    public ItemBuilder addFlag(ItemFlag itemFlag) {
        this.itemFlags.add(itemFlag);
        return this;
    }

    public ItemBuilder addFlags(ItemFlag... itemFlags) {
        this.itemFlags.addAll(Arrays.asList(itemFlags));
        return this;
    }

    public ItemBuilder addFlags(String... itemFlags) {
        Arrays.stream(itemFlags).forEach((itemFlag) -> this.itemFlags.add(ItemFlag.valueOf(itemFlag)));
        return this;
    }

    public ItemBuilder addFlags(@NotNull List<String> itemFlags) {
        itemFlags.forEach((flag) -> this.itemFlags.add(ItemFlag.valueOf(flag)));
        return this;
    }

    public ItemBuilder modifyAttribute(Attribute attribute, AttributeModifier modifier) {
        this.attributes.put(attribute, modifier);
        return this;
    }

    public ItemBuilder modifyAttributes(Multimap<Attribute, AttributeModifier> attributes) {
        this.attributes.putAll(attributes);
        return this;
    }

    public ItemStack build() {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setLore(lore);
            if (!name.isBlank()) meta.setDisplayName(name);
            for (Map.Entry<Attribute, AttributeModifier> entry : attributes.entries())
                meta.setAttributeModifiers(attributes);
            for (ItemFlag flag : itemFlags) meta.addItemFlags(flag);
            for (PDCObject<?> pdcObject : pdcObjects) {
                PDCUtils.setPDCObject(pdc, pdcObject);
            }
        }
        if (meta instanceof SkullMeta skull) {
            if (base64 != null) {
                skull.setOwnerProfile(SkullUtils.getProfileBase64(base64, null));
            } else if (URL != null) {
                skull.setOwnerProfile(SkullUtils.getProfile(URL, null));
            }
        }
        item.setAmount(amount);
        if (enchantmentMap != null) {
            item.addEnchantments(enchantmentMap);
        }
        item.setItemMeta(meta);
        return item;
    }

}