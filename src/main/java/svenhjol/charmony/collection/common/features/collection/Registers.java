package svenhjol.charmony.collection.common.features.collection;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.enchantment.Enchantment;
import svenhjol.charmony.core.base.Setup;
import svenhjol.charmony.core.common.CommonRegistry;

import java.util.function.Supplier;

public class Registers extends Setup<Collection> {
    public final Supplier<Holder<Attribute>> attribute;
    public final ResourceKey<Enchantment> enchantment;

    public Registers(Collection feature) {
        super(feature);
        var registry = CommonRegistry.forFeature(feature);

        enchantment = registry.enchantment("collection");
        attribute = registry.attribute("player.automatic_item_pickup", () -> new RangedAttribute(
            "attribute.name.player.charmony-collection.automatic_item_pickup", 0.0, 0.0, 1.0).setSyncable(true));

        // Must attach the collection attribute to the player for it to function.
        registry.entityAttribute(() -> EntityType.PLAYER, attribute);
    }
}
