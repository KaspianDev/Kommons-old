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

package com.github.kaspiandev.kommons.spigot.item.rarities;

import org.bukkit.Material;

@SuppressWarnings("unused")
public enum ItemRarities {

    // Start UNCOMMON

    CREEPER_BANNER_PATTERN(Material.CREEPER_BANNER_PATTERN, Rarity.UNCOMMON),
    SKULL_BANNER_PATTERN(Material.SKULL_BANNER_PATTERN, Rarity.UNCOMMON),
    EXPERIENCE_BOTTLE(Material.EXPERIENCE_BOTTLE, Rarity.UNCOMMON),
    DRAGON_BREATH(Material.DRAGON_BREATH, Rarity.UNCOMMON),
    ELYTRA(Material.ELYTRA, Rarity.UNCOMMON),
    PLAYER_HEAD(Material.PLAYER_HEAD, Rarity.UNCOMMON),
    SKELETON_SKULL(Material.SKELETON_SKULL, Rarity.UNCOMMON),
    ZOMBIE_HEAD(Material.ZOMBIE_HEAD, Rarity.UNCOMMON),
    DRAGON_HEAD(Material.DRAGON_HEAD, Rarity.UNCOMMON),
    CREEPER_HEAD(Material.CREEPER_HEAD, Rarity.UNCOMMON),
    WITHER_SKELETON_SKULL(Material.WITHER_SKELETON_SKULL, Rarity.UNCOMMON),
    HEART_OF_THE_SEA(Material.HEART_OF_THE_SEA, Rarity.UNCOMMON),
    TOTEM_OF_UNDYING(Material.TOTEM_OF_UNDYING, Rarity.UNCOMMON),
    ENCHANTED_BOOK(Material.ENCHANTED_BOOK, Rarity.UNCOMMON),

    // Start RARE

    BEACON(Material.BEACON, Rarity.RARE),
    CONDUIT(Material.CONDUIT, Rarity.RARE),
    END_CRYSTAL(Material.END_CRYSTAL, Rarity.RARE),
    GOLDEN_APPLE(Material.GOLDEN_APPLE, Rarity.RARE),
    MUSIC_DISC_13(Material.MUSIC_DISC_13, Rarity.RARE),
    MUSIC_DISC_11(Material.MUSIC_DISC_11, Rarity.RARE),
    MUSIC_DISC_BLOCKS(Material.MUSIC_DISC_BLOCKS, Rarity.RARE),
    MUSIC_DISC_CAT(Material.MUSIC_DISC_CAT, Rarity.RARE),
    MUSIC_DISC_CHIRP(Material.MUSIC_DISC_CHIRP, Rarity.RARE),
    MUSIC_DISC_FAR(Material.MUSIC_DISC_FAR, Rarity.RARE),
    MUSIC_DISC_MALL(Material.MUSIC_DISC_MALL, Rarity.RARE),
    MUSIC_DISC_MELLOHI(Material.MUSIC_DISC_MELLOHI, Rarity.RARE),
    MUSIC_DISC_OTHERSIDE(Material.MUSIC_DISC_OTHERSIDE, Rarity.RARE),
    MUSIC_DISC_PIGSTEP(Material.MUSIC_DISC_PIGSTEP, Rarity.RARE),
    MUSIC_DISC_5(Material.MUSIC_DISC_5, Rarity.RARE),
    MUSIC_DISC_WAIT(Material.MUSIC_DISC_WAIT, Rarity.RARE),
    MUSIC_DISC_WARD(Material.MUSIC_DISC_WARD, Rarity.RARE),
    MUSIC_DISC_STRAD(Material.MUSIC_DISC_STRAD, Rarity.RARE),
    MUSIC_DISC_STAL(Material.MUSIC_DISC_STAL, Rarity.RARE),

    // Start EPIC

    FLOWER_BANNER_PATTERN(Material.FLOWER_BANNER_PATTERN, Rarity.EPIC),
    GLOBE_BANNER_PATTERN(Material.GLOBE_BANNER_PATTERN, Rarity.EPIC),
    MOJANG_BANNER_PATTERN(Material.MOJANG_BANNER_PATTERN, Rarity.EPIC),
    PIGLIN_BANNER_PATTERN(Material.PIGLIN_BANNER_PATTERN, Rarity.EPIC),
    COMMAND_BLOCK(Material.COMMAND_BLOCK, Rarity.EPIC),
    CHAIN_COMMAND_BLOCK(Material.CHAIN_COMMAND_BLOCK, Rarity.EPIC),
    REPEATING_COMMAND_BLOCK(Material.REPEATING_COMMAND_BLOCK, Rarity.EPIC),
    DRAGON_EGG(Material.DRAGON_EGG, Rarity.EPIC),
    STRUCTURE_BLOCK(Material.STRUCTURE_BLOCK, Rarity.EPIC),
    STRUCTURE_VOID(Material.STRUCTURE_VOID, Rarity.EPIC),
    JIGSAW(Material.JIGSAW, Rarity.EPIC),
    LIGHT(Material.LIGHT, Rarity.EPIC),
    BARRIER(Material.BARRIER, Rarity.EPIC),
    COMMAND_BLOCK_MINECART(Material.COMMAND_BLOCK_MINECART, Rarity.EPIC),
    DEBUG_STICK(Material.DEBUG_STICK, Rarity.EPIC),
    KNOWLEDGE_BOOK(Material.KNOWLEDGE_BOOK, Rarity.EPIC),
    ENCHANTED_GOLDEN_APPLE(Material.ENCHANTED_GOLDEN_APPLE, Rarity.EPIC);

    private final Material material;
    private final Rarity rarity;

    ItemRarities(Material material, Rarity rarity) {
        this.material = material;
        this.rarity = rarity;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Material getMaterial() {
        return material;
    }

}
