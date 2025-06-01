package svenhjol.charmony.collection;

import svenhjol.charmony.api.core.ModDefinition;
import svenhjol.charmony.api.core.Side;
import svenhjol.charmony.core.base.Mod;

@ModDefinition(
    id = CollectionMod.ID,
    sides = {Side.Client, Side.Common},
    name = "Collection",
    description = "Tools with the Collection enchantment automatically pick up drops.")
public final class CollectionMod extends Mod {
    public static final String ID = "charmony-collection";
    private static CollectionMod instance;

    private CollectionMod() {}

    public static CollectionMod instance() {
        if (instance == null) {
            instance = new CollectionMod();
        }
        return instance;
    }
}