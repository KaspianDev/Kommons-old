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

package com.github.kaspiandev.kommons.spigot.recipes;

import dev.dejvokep.boostedyaml.block.implementation.Section;
import org.apache.commons.lang3.tuple.Pair;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@SuppressWarnings("unused")
public class RecipeBuilder {

    private final NamespacedKey key;
    private final ItemStack item;
    private final ShapedRecipe recipe;
    private String[] shape;
    private final Map<Character, RecipeChoice> ingredients = new HashMap<>();

    public RecipeBuilder(NamespacedKey key, ItemStack item) {
        this.key = key;
        this.item = item;
        this.recipe = new ShapedRecipe(key, item);
    }

    public NamespacedKey getKey() {
        return this.key;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public RecipeBuilder setShape(@NotNull String[] shape) {
        if (shape.length > 3 || shape.length < 1)
            throw new IllegalArgumentException("Recipe shape must be 3 lines.");

        for (String line : shape) {
            if (line.length() > 3) throw new IllegalArgumentException("Recipe line must be 3 elements.");
        }

        this.shape = shape;
        return this;
    }

    public RecipeBuilder setIngredient(char letter, Material material) {
        this.ingredients.put(letter, new RecipeChoice.MaterialChoice(material));
        return this;
    }

    @SafeVarargs
    public final RecipeBuilder setIngredients(Pair<Character, Material>... ingredient) {
        Arrays.stream(ingredient).forEach((pair) ->
                this.ingredients.put(pair.getLeft(), new RecipeChoice.MaterialChoice(pair.getRight())));
        return this;
    }

    public RecipeBuilder setIngredients(@NotNull Section configSection) {
        for (Object obj : configSection.getKeys()) {
            RecipeChoice choice = new RecipeChoice.MaterialChoice(Material.valueOf(
                    configSection.getString(obj.toString())));
            this.ingredients.put(obj.toString().charAt(0), choice);
        }
        return this;
    }

    public ShapedRecipe build() {
        this.recipe.shape(this.shape);
        this.ingredients.forEach(this.recipe::setIngredient);
        return this.recipe;
    }

}