package cn.mcbugdev.anabyss.init;

import cn.mcbugdev.anabyss.biome.UnetheritedBiome;
import cn.mcbugdev.anabyss.blocks.IncompleteStone;
import cn.mcbugdev.anabyss.utils.Reference;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,Reference.MOD_ID);
    public static final RegistryObject<Block> INCOMPLETE_STONE = BLOCKS.register("incomplete_stone", IncompleteStone::new);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,Reference.MOD_ID);
    public static final RegistryObject<Item> INCOMPLETE_STONE_ITEM = ITEMS.register("incomplete_stone",()->new BlockItem(INCOMPLETE_STONE.get(),new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, Reference.MOD_ID);
    public static final RegistryObject<Biome> UNETHERITED = REGISTRY.register("unetherited", UnetheritedBiome::unetherited);
}
