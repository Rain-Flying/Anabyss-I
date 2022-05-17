package cn.mcbugdev.anabyss.init;

import cn.mcbugdev.anabyss.biome.UnetheritedBiome;
import cn.mcbugdev.anabyss.blocks.IncompleteStone;
import cn.mcbugdev.anabyss.items.DimensionKey;
import cn.mcbugdev.anabyss.items.ItemBase;
import cn.mcbugdev.anabyss.items.NetheriteDiamond;
import cn.mcbugdev.anabyss.utils.Reference;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,Reference.MOD_ID);
    public static final RegistryObject<Block> INCOMPLETE_STONE = BLOCKS.register("incomplete_stone", IncompleteStone::new);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,Reference.MOD_ID);
    public static final RegistryObject<Item> DIMENSION_KEY = ITEMS.register("dimension_key", DimensionKey::new);
    public static final RegistryObject<Item> NETHERITE_NUGGET = ITEMS.register("netherite_nugget",()->new ItemBase(Reference.ANABYSS_TAB));
    public static final RegistryObject<Item> NETHERITE_DIAMOND = ITEMS.register("netherite_diamond", NetheriteDiamond::new);
    public static final RegistryObject<Item> INCOMPLETE_STONE_ITEM = ITEMS.register("incomplete_stone",()->new BlockItem(INCOMPLETE_STONE.get(),new Item.Properties().tab(Reference.ANABYSS_TAB)));
    public static final RegistryObject<Item> NETHERITE_STICK = ITEMS.register("netherite_stick",()->new ItemBase(Reference.ANABYSS_TAB));
    public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, Reference.MOD_ID);
    public static final RegistryObject<Biome> UNETHERITED = REGISTRY.register("unetherited", UnetheritedBiome::unetherited);
}
