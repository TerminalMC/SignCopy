/*
 * Copyright 2023, 2024 NotRyken
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.terminalmc.signcopy.mixin;

import dev.terminalmc.signcopy.SignCopy;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignBlock.class)
public class MixinSignBlock {
    @Inject(method = "useItemOn", at = @At("HEAD"))
    public void onSignUse(ItemStack itemStack, BlockState state, Level world, BlockPos pos,
                          Player player, InteractionHand hand, BlockHitResult hitResult,
                          CallbackInfoReturnable<InteractionResult> cir) {
        if (world.getBlockEntity(pos) instanceof SignBlockEntity sign &&
                sign.isWaxed() && itemStack.isEmpty()) {
            SignCopy.copiedText = sign.getFrontText();
            player.displayClientMessage(Component.literal("Text copied from sign!"), true);
        }
    }
}
