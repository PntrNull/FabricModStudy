package gio.pntrnull;

import java.util.function.Function;

import net.minecraft.item.*;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

// 以上代码全部为 Visual Studio Code 自动补全
// 以下代码全部引用自 Fabric 文档
// 注释为自行添加

public class ModItems {

    private ModItems() {
        /* 这里面本来应该写构造方法的, 但是 tutorial 里面没写所以我也不知道写什么 */
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        /** register() 方法用来注册物品.
         * name 是这个物品的名称 (也即将被添加至注册表内的 id).
         */

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(FabModStudy.MOD_ID, name));
        // 这个物品在注册表内的 id.

        Item item = itemFactory.apply(settings.registryKey(itemKey));
        // 需要注册的内容的实例.

        Registry.register(Registries.ITEM, itemKey, item);
        // 在注册表内注册物品.
        // 其中 Registries.ITEM 是这个物品所在的注册表 (ITEM).

        return item; // 返回物品实例, 以便后续使用.
    }

    public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new, new Item.Settings());
    // 创建物品.

    public static void initialize() {
        /**  ModItems 类的初始化.
         * 在 FabModStudy 里面会引用这个方法来加载这个类,
         * 从而达到注册物品的效果.
         * 另外这个方法中会做一些基本的初始化.
         */

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.SUSPICIOUS_SUBSTANCE));
    } 
}

// Debug Daily

// 为啥这玩意写完之后 runClient 没有这个物品啊
// 已 Debug, 没有在 entrypoint 类的 onInitialize() 里面
// 引用 ModItems 类中的方法以静态加载 ModItems 类.
// p.s. 我说怎么感觉少点东西, entrypoint 里面没有做初始化怎么调用物品类嘛...
