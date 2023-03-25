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

import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class RecipeManager {

    List<RecipeBuilder> recipes = new ArrayList<>();

    public RecipeManager addRecipe(RecipeBuilder recipe) {
        this.recipes.add(recipe);
        return this;
    }

    public List<RecipeBuilder> getRecipes() {
        return this.recipes;
    }

    public void registerAll() {
        recipes.forEach((recipeBuilder -> Bukkit.addRecipe(recipeBuilder.build())));
    }

    public void register(@NotNull RecipeBuilder recipe) {
        Bukkit.addRecipe(recipe.build());
    }

}
