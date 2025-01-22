package svenhjol.charmony.collection.common.features.collection;

import svenhjol.charmony.collection.CollectionMod;
import svenhjol.charmony.core.annotations.FeatureDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.base.SidedFeature;
import svenhjol.charmony.core.enums.Side;

@FeatureDefinition(side = Side.Common, description = "Tools with the Collection enchantment automatically pick up drops.")
public final class Collection extends SidedFeature {
    public final Advancements advancements;
    public final Handlers handlers;
    public final Registers registers;

    public Collection(Mod mod) {
        super(mod);
        registers = new Registers(this);
        handlers = new Handlers(this);
        advancements = new Advancements(this);
    }

    public static Collection feature() {
        return CollectionMod.instance().sidedFeature(Collection.class);
    }
}