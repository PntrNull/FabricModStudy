package gio.pntrnull;

import java.util.function.Function;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.*;

// 以上代码全部为 Visual Studio Code 自动补全
// 以下代码全部引用自 Fabric 文档
// 注释为自行添加

// 卧槽 为啥这玩意写完之后 runClient 没有这个物品啊

public class ModItems {
    // register() 方法用来注册物品.
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // 为物品创建注册表.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FabModStudy.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new, new Item.Settings());
    // 这里注册物品并且为这个对象赋值.

    // TODO: 给下面填满注释.

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
		.register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));

    }

    public class FabricDocsReferenceItems implements ModInitializer {
        @Override
        public void onInitialize() {
            ModItems.initialize();
        }
    }
    // Get the event for modifying entries in the ingredients group.
// And register an event handler that adds our suspicious item to the ingredients group.
}