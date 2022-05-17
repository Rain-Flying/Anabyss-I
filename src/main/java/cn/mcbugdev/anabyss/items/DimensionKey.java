package cn.mcbugdev.anabyss.items;

import cn.mcbugdev.anabyss.world.AbyssTeleporter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DimensionKey extends Item {
    public DimensionKey() {
        super(new Properties().tab(CreativeModeTab.TAB_MISC));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        InteractionResultHolder<ItemStack> ar = super.use(pLevel, pPlayer,pUsedHand);
        if (pPlayer instanceof ServerPlayer _player && !_player.level.isClientSide()) {
            ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("anabyss:abyss"));
            if (_player.level.dimension() == destinationType)
                return ar;
            ServerLevel nextLevel = _player.server.getLevel(destinationType);
            if (nextLevel != null) {
                _player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
                _player.changeDimension(nextLevel,new AbyssTeleporter());
                BlockState state = Blocks.AIR.defaultBlockState();
                BlockState state1 = Blocks.OBSIDIAN.defaultBlockState();
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY(),_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()+1,_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()+2,_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()+2,_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()+2,_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()+2,_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()+2,_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()+2,_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()+2,_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()+1,_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()+1,_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()+1,_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()+1,_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()+1,_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()+1,_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY(),_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY(),_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY(),_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY(),_player.getZ()),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY(),_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY(),_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY(),_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY(),_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()+1,_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()+1,_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()+2,_player.getZ()-1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()+2,_player.getZ()+1),state,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()-1,_player.getZ()),state1,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()-1,_player.getZ()),state1,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()-1,_player.getZ()-1),state1,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()-1,_player.getZ()-1),state1,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()-1,_player.getZ()),state1,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()-1,_player.getZ()+1),state1,4);
                _player.level.setBlock(new BlockPos(_player.getX(),_player.getY()-1,_player.getZ()+1),state1,4);
                _player.level.setBlock(new BlockPos(_player.getX()+1,_player.getY()-1,_player.getZ()-1),state1,4);
                _player.level.setBlock(new BlockPos(_player.getX()-1,_player.getY()-1,_player.getZ()+1),state1,4);
                _player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
                for (MobEffectInstance _effectinstance : _player.getActiveEffects())
                    _player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
                _player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
            }
        }
        return ar;
    }
}
