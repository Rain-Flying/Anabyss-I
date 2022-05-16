
package cn.mcbugdev.anabyss.init;

import cn.mcbugdev.anabyss.api.BiomeInjector;
import cn.mcbugdev.anabyss.utils.Reference;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;

import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.Biome;

import cn.mcbugdev.anabyss.biome.UnetheritedBiome;

@Mod.EventBusSubscriber
public class AnabyssBiomes {


	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(UnetheritedBiome::init);
	}
	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		BiomeInjector.addBiomeGen(event,DimensionType.NETHER_LOCATION,Registration.UNETHERITED.getId(),Blocks.STONE.defaultBlockState(),Blocks.STONE.defaultBlockState(),Blocks.STONE.defaultBlockState());
	}
}
