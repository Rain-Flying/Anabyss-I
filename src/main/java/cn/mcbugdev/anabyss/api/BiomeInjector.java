package cn.mcbugdev.anabyss.api;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraftforge.event.server.ServerAboutToStartEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class BiomeInjector {
    public static final Climate.ParameterPoint PARAMETER_POINT = new Climate.ParameterPoint(Climate.Parameter.span(-0.042857142857f, 0.042857142857f),
            Climate.Parameter.span(-0.042857142857f, 0.042857142857f), Climate.Parameter.span(0.467142857143f, 0.552857142857f),
            Climate.Parameter.span(0.757142857143f, 0.842857142857f), Climate.Parameter.point(0),
            Climate.Parameter.span(0.054975890189f, 0.140690175903f), 0);
        private static SurfaceRules.RuleSource anySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock,
                                                              BlockState underwaterBlock) {
            return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
                    SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)),
                                            SurfaceRules.state(underwaterBlock))),
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock))));
        }
        public static void addBiomeGen(ServerAboutToStartEvent event,ResourceKey<DimensionType> type,ResourceLocation id,BlockState block1,BlockState block2,BlockState block3) {
            MinecraftServer server = event.getServer();
            Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY);
            Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
            WorldGenSettings worldGenSettings = server.getWorldData().worldGenSettings();
            for (Map.Entry<ResourceKey<LevelStem>, LevelStem> entry : worldGenSettings.dimensions().entrySet()) {
                DimensionType dimensionType = entry.getValue().typeHolder().value();
                if (dimensionType == dimensionTypeRegistry.getOrThrow(type)) {
                    ChunkGenerator chunkGenerator = entry.getValue().generator();
                    if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
                        List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters.values());
                        parameters.add(new Pair<>(PARAMETER_POINT,
                                biomeRegistry.getOrCreateHolder(ResourceKey.create(Registry.BIOME_REGISTRY, id))));
                        MultiNoiseBiomeSource moddedNoiseSource = new MultiNoiseBiomeSource(new Climate.ParameterList<>(parameters),
                                noiseSource.preset);
                        chunkGenerator.biomeSource = moddedNoiseSource;
                        chunkGenerator.runtimeBiomeSource = moddedNoiseSource;
                    }
                    if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
                        NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
                        SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
                        if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
                            List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
                            surfaceRules.add(2, anySurfaceRule(ResourceKey.create(Registry.BIOME_REGISTRY, id),
                                    block1, block2,block3));
                            NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(),
                                    noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
                                    noiseGeneratorSettings.noiseRouter(),
                                    SurfaceRules.sequence(surfaceRules.toArray(SurfaceRules.RuleSource[]::new)),
                                    noiseGeneratorSettings.seaLevel(), noiseGeneratorSettings.disableMobGeneration(),
                                    noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(),
                                    noiseGeneratorSettings.useLegacyRandomSource());
                            noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
                        }
                    }
                }
            }
        }
}
