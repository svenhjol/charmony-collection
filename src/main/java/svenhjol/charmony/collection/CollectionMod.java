package svenhjol.charmony.collection;

import net.minecraft.resources.ResourceLocation;
import svenhjol.charmony.core.annotations.ModDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.enums.Side;

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

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}