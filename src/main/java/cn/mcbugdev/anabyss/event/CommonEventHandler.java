package cn.mcbugdev.anabyss.event;

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
}
