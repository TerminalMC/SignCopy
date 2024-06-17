/*
 * Copyright 2023, 2024 NotRyken
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.terminalmc.signcopy;

import net.neoforged.fml.common.Mod;

@Mod(SignCopy.MOD_ID)
public class SignCopyNeoForge {
    public SignCopyNeoForge() {
        SignCopy.init();
    }
}
