/*
 * Copyright 2023, 2024 NotRyken
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.terminalmc.signcopy;

import dev.terminalmc.signcopy.util.ModLogger;
import net.minecraft.world.level.block.entity.SignText;

public class SignCopy {
    public static final String MOD_ID = "signcopy";
    public static final String MOD_NAME = "SignCopy";
    public static final ModLogger LOG = new ModLogger(MOD_NAME);

    public static SignText copiedText;

    public static void init() {
    }
}
