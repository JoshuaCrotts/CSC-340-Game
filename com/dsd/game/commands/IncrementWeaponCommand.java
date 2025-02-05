package com.dsd.game.commands;

import com.dsd.game.core.Game;
import com.dsd.game.objects.Player;
import com.dsd.game.objects.weapons.enums.WeaponSelection;
import com.revivedstandards.commands.Command;
import com.sun.glass.events.KeyEvent;

/**
 * Command representing when the user increments their weapon counter position.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty Last Updated: 12/10/2019
 */
public class IncrementWeaponCommand extends Command {

    // Miscellaneous reference variables.
    private final Game game;
    private final Player player;

    public IncrementWeaponCommand(Game _game, Player _player) {
        this.game = _game;
        this.player = _player;
        this.bind(this.game.getKeyboard(), KeyEvent.VK_C);
    }

    @Override
    public void pressed(float _dt) {
        if (this.player.isAttacking() || this.game.isShop()) {
            return;
        }
        this.player.getInventory().changeWeapon(WeaponSelection.INCREMENT);
    }
    
}
