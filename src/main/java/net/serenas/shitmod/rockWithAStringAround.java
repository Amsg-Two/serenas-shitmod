package net.serenas.shitmod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class rockWithAStringAround extends Item {

    public rockWithAStringAround(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World World, PlayerEntity PlayerEntity, Hand Hand) {
    var messageToSay = Math.random();
    if (messageToSay < 0.3) {
        PlayerEntity.sendMessage(new LiteralText("I'm a faggot"), false);
    } else if (messageToSay > 0.3) {
        if (messageToSay < 0.6) {
            PlayerEntity.sendMessage(new LiteralText("I'm a tranny"), false);
        }
    } else if (messageToSay > 0.6) {
        PlayerEntity.sendMessage(new LiteralText("I'm a mick"), false);
    }
    

    return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(Hand));
    }

    
}