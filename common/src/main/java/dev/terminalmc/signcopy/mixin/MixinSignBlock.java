/*
 * Copyright 2024 TerminalMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
