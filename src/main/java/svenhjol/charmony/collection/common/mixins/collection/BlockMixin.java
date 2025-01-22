package svenhjol.charmony.collection.common.mixins.collection;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import svenhjol.charmony.collection.common.features.collection.Collection;

import java.util.function.Supplier;

@Mixin(Block.class)
public class BlockMixin {

    @WrapWithCondition(
        method = "popResource(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/item/ItemStack;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/Block;popResource(Lnet/minecraft/world/level/Level;Ljava/util/function/Supplier;Lnet/minecraft/world/item/ItemStack;)V"
        )
    )
    private static boolean checkPosAndCancelDrops(Level level, Supplier<ItemEntity> supplier, ItemStack stack, @Local(argsOnly = true) BlockPos pos) {
        return !Collection.feature().handlers.trySpawnToInventory(level, pos, stack);
    }

    @WrapWithCondition(
        method = "popResourceFromFace",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/Block;popResource(Lnet/minecraft/world/level/Level;Ljava/util/function/Supplier;Lnet/minecraft/world/item/ItemStack;)V"
        )
    )
    private static boolean checkPosAndCancelDropsFromFace(Level level, Supplier<ItemEntity> supplier, ItemStack stack, @Local(argsOnly = true) BlockPos pos) {
        return !Collection.feature().handlers.trySpawnToInventory(level, pos, stack);
    }
}