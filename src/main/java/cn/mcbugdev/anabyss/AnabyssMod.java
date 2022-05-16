/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and it won't get overwritten.
 *    If you change your modid or package, you need to apply these changes to this file MANUALLY.
 *
 *    Settings in @Mod annotation WON'T be changed in case of the base mod element
 *    files lock too, so you need to set them manually here in such case.
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package cn.mcbugdev.anabyss;

import cn.mcbugdev.anabyss.init.Registration;
import cn.mcbugdev.anabyss.utils.Reference;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;

import cn.mcbugdev.anabyss.init.AnabyssBiomes;

@Mod(Reference.MOD_ID)
public class AnabyssMod {
	public AnabyssMod() {

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		Registration.REGISTRY.register(bus);

		Registration.BLOCKS.register(bus);

		Registration.ITEMS.register(bus);
	}
}
