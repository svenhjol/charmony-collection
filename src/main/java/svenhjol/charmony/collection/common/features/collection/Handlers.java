package svenhjol.charmony.collection.common.features.collection;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import svenhjol.charmony.core.base.Setup;

import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

public class Handlers extends Setup<Collection> {
    private static final Map<BlockPos, UUID> BREAKING = new WeakHashMap<>();

    public Handlers(Collection feature) {
        super(feature);
    }

    public boolean hasCollection(Player player) {
        var collection = Collection.feature().registers.attribute.get();
        var playerAttributes = player.getAttributes();

        return playerAttributes.hasAttribute(collection)
            && playerAttributes.getValue(collection) > 0;
    }

    public void startBreaking(Player player, BlockPos pos) {
        if (hasCollection(player)) {
            BREAKING.put(pos, player.getUUID());
        }
    }

    public void stopBreaking(BlockPos pos) {
        BREAKING.remove(pos);
    }

    /**
     * @see net.minecraft.world.level.block.Block#popResource(Level, BlockPos, ItemStack)
     */
    public boolean trySpawnToInventory(Level level, BlockPos pos, ItemStack stack) {
        if (level instanceof ServerLevel serverLevel
            && !stack.isEmpty()
            && serverLevel.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
            if (BREAKING.containsKey(pos)) {
                var player = serverLevel.getPlayerByUUID(BREAKING.get(pos));
                if (player != null) {
                    player.getInventory().placeItemBackInInventory(stack);
                    feature().advancements.usedCollection((ServerPlayer) player);
                    return true;
                }
            }
        }

        return false;
    }
}
