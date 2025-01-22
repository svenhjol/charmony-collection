package svenhjol.charmony.collection.common.features.collection;

import net.minecraft.server.level.ServerPlayer;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.helpers.AdvancementHelper;

public final class Advancements extends Setup<Collection> {
    public Advancements(Collection feature) {
        super(feature);
    }

    public void usedCollection(ServerPlayer player) {
        AdvancementHelper.trigger("used_collection", player);
    }
}
