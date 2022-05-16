package cn.mcbugdev.anabyss.blocks;

import cn.mcbugdev.anabyss.interfaces.IBaseBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public abstract class BlockBase extends Block{
    public BlockBase(Properties properties) {
        super(properties);
    }
}
