package cn.mcbugdev.anabyss.event;

import cn.mcbugdev.anabyss.utils.Reference;
import net.minecraft.core.Registry;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber
public class CommonEventHandler {
    @SubscribeEvent
    public static void commonEvent(FMLCommonSetupEvent event){
        event.enqueueWork(()->{
        });
    }
    @SubscribeEvent
    public static void joinWorld(EntityJoinWorldEvent event){
    }
}
