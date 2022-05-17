package cn.mcbugdev.anabyss;

import cn.mcbugdev.anabyss.init.Registration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AnabyssTab extends CreativeModeTab {
    public AnabyssTab() {
        super("anabyss");
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(Registration.NETHERITE_DIAMOND.get());
    }
}
