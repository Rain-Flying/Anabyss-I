package cn.mcbugdev.anabyss.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.templatesystem.GravityProcessor;

import java.util.Objects;

public abstract class AbyssMonster extends Monster {
    protected AbyssMonster(EntityType<? extends AbyssMonster> entityType, Level level) {
        super(entityType, level);
    }
}
