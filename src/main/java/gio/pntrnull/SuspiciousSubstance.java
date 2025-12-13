package gio.pntrnull;

import net.minecraft.block.AirBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SuspiciousSubstance extends Item {

    public SuspiciousSubstance(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        // 播放声音.
        user.playSound(SoundEvents.BLOCK_GRASS_PLACE, 1.0F, 1.0F);
        ItemStack stack = user.getStackInHand(hand);
        if (stack.getCount() < stack.getMaxCount()) {
            stack.increment(1);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        AirBlock air = new::AirBlock()
        return ActionResult.SUCCESS;
    }
}
