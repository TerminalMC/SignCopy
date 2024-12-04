/*
 * SignCopy by TerminalMC
 *
 * To the extent possible under law, the person who associated CC0 with
 * SignCopy has waived all copyright and related or neighboring rights
 * to SignCopy.
 *
 * You should have received a copy of the CC0 legalcode along with this
 * work. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

package dev.terminalmc.signcopy;

import net.fabricmc.api.ClientModInitializer;

public class SignCopyFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Main initialization
        SignCopy.init();
    }
}
