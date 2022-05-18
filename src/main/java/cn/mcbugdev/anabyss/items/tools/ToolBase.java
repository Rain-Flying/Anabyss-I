package cn.mcbugdev.anabyss.items.tools;

import cn.mcbugdev.anabyss.utils.Reference;
import net.minecraft.world.item.*;

public class ToolBase extends TieredItem {
    public ToolBase() {
        super(Tiers.NETHERITE,new Properties().tab(Reference.ANABYSS_TAB).stacksTo(1));
    }
    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemstack) {
        return new ItemStack(this);
    }

    @Override
    public boolean isRepairable(ItemStack itemstack) {
        return false;
    }

}
