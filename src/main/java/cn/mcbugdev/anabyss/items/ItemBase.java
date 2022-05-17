package cn.mcbugdev.anabyss.items;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemBase extends Item {
    public ItemBase(CreativeModeTab tab) {
        super(new Properties().tab(tab));
    }
    public ItemBase(CreativeModeTab tab, Rarity rarity) {
        super(new Properties().tab(tab).rarity(rarity));
    }
    public ItemBase(CreativeModeTab tab, Rarity rarity,int durability) {
        super(new Properties().tab(tab).rarity(rarity).durability(durability));
    }
    public ItemBase(CreativeModeTab tab, Rarity rarity, int durability, FoodProperties foodProperties) {
        super(new Properties().tab(tab).rarity(rarity).durability(durability).food(foodProperties));
    }
}
