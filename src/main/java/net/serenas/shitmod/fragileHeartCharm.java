package net.serenas.shitmod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class fragileHeartCharm extends Item {

    public fragileHeartCharm(Settings settings) {
        super(settings);
    }

    public int availableSlots = 1;

    @Override
    public TypedActionResult<ItemStack> use(World World, PlayerEntity Playerentity, Hand Hand) {
        
        if (availableSlots > 0) {
            availableSlots--;
            Playerentity.sendMessage(new LiteralText("You have " + availableSlots + "charm notches left."), false);
            Playerentity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*1000000, 2));
            Playerentity.getMainHandStack().damage(50,Playerentity,e-> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
            availableSlots++;
    
        } else if (availableSlots < 1) {
            Playerentity.sendMessage(new LiteralText("You don't have enough charm notches to do that!"), true);
        }


        return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, Playerentity.getStackInHand(Hand));
    }
}
