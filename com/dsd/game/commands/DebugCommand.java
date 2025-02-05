package com.dsd.game.commands;

import com.dsd.game.core.Game;
import com.dsd.game.controller.DebugController;
import com.revivedstandards.commands.Command;
import java.awt.event.KeyEvent;

/**
 * Command that defines what happens when the user presses the "K"; it will draw
 * the debug information text.
 *
 * [Group Name: Data Structure Deadheads]
 *
 * @author Joshua, Ronald, Rinty Last Updated: 12/10/2019
 */
public class DebugCommand extends Command {

    //  Miscellaneous reference variables.
    public Game game;

    public DebugCommand(Game _game) {
        this.game = _game;
        this.bind(game.getKeyboard(), KeyEvent.VK_K);
    }

    @Override
    public void pressed(float _dt) {
        DebugController.DEBUG_MODE = !DebugController.DEBUG_MODE;
    }
    
}
