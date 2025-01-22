package svenhjol.charmony.collection.common.mixins.collection;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import svenhjol.charmony.collection.common.features.collection.Collection;

@Mixin(ServerPlayerGameMode.class)
public class ServerPlayerGameModeMixin {
    @Final
    @Shadow
    protected ServerPlayer player;
    
    @Inject(method = "destroyBlock", at = @At("HEAD"))
    private void hookTryBreakBlockBegin(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        Collection.feature().handlers.startBreaking(player, pos);
    }
    
    @Inject(method = "destroyBlock", at = @At("TAIL"))
    private void hookTryBreakBlockEnd(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        Collection.feature().handlers.stopBreaking(pos);
    }
}