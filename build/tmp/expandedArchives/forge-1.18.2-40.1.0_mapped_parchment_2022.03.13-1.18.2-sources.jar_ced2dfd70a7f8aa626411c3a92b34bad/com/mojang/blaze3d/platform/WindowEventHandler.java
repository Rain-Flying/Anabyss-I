package com.mojang.blaze3d.platform;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface WindowEventHandler {
   void setWindowActive(boolean pWindowActive);

   void resizeDisplay();

   void cursorEntered();
}