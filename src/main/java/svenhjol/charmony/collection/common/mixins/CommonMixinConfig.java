package svenhjol.charmony.collection.common.mixins;

import svenhjol.charmony.core.base.MixinConfig;
import svenhjol.charmony.core.enums.Side;
import svenhjol.charmony.collection.CollectionMod;

public class CommonMixinConfig extends MixinConfig {
    @Override
    protected String modId() {
        return CollectionMod.ID;
    }

    @Override
    protected String modRoot() {
        return "svenhjol.charmony.collection";
    }

    @Override
    protected Side side() {
        return Side.Common;
    }
}
