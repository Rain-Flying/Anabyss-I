package cn.mcbugdev.anabyss.interfaces;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public interface IBaseBlock {
     BlockBehaviour.Properties properties(Material material);
     BlockBehaviour.Properties properties(Material material, float destroyTime);
     BlockBehaviour.Properties properties(Material material, SoundType sound);
     BlockBehaviour.Properties properties(Material material, SoundType sound, float destroyTime);
}
