package svenhjol.charmony.collection.common;

import net.fabricmc.api.ModInitializer;
import svenhjol.charmony.collection.CollectionMod;
import svenhjol.charmony.collection.common.features.collection.Collection;
import svenhjol.charmony.api.core.Side;

public final class CommonInitializer implements ModInitializer {
    @Override
    public void onInitialize() {
        // Ensure charmony is launched first.
        svenhjol.charmony.core.common.CommonInitializer.init();

        // Prepare and run the mod.
        var mod = CollectionMod.instance();
        mod.addSidedFeature(Collection.class);
        mod.run(Side.Common);
    }
}
