/*
 * Copyright 2023, 2024 NotRyken
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.terminalmc.signcopy;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = SignCopy.MOD_ID, dist = Dist.CLIENT)
public class SignCopyNeoForge {
    public SignCopyNeoForge() {
        SignCopy.init();
    }
}
