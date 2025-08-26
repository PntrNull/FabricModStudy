package gio.pntrnull;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabModStudy implements ModInitializer {

	public static final String MOD_ID = "fabmodstudy";
	// MOD_ID 是 Mod 的唯一识别符.

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    // Logger 用于向 Console 中写入 Mod 的 Info, Warn 和 Error.
    // Logger 通常用 MOD_ID 注册, 以方便 Debug.

    @Override
	public void onInitialize() {
		/* onInitialize() 中的代码将会在 Minecraft 加载 Mods 时运行.
		 * 因此这里应用于物品的初始化.
		 */

		LOGGER.info("Hello Fabric world!");
		// 由 Logger 向 Console 中输出一条信息.

		ModItems.initialize();
		// 引用 ModItems 中的 initialize() 方法以静态加载 ModItems 类,
		// 顺便做一些基本的初始化 (比如将物品添加到某个物品组).
    }
}