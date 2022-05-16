package cn.mcbugdev.anabyss.blocks;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class IncompleteStone extends BlockBase {
    public static Properties properties = Properties.of(Material.STONE).sound(SoundType.NETHERRACK).destroyTime(6.0F);

    public IncompleteStone() {
        super(properties);
    }

}