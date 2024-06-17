/*
 * Copyright 2023, 2024 NotRyken
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.terminalmc.signcopy;

import net.fabricmc.api.ClientModInitializer;

public class SignCopyFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SignCopy.init();
    }
}
