package com.dsd.game.userinterface.model;

import com.dsd.game.userinterface.MouseEventInterface;
import com.revivedstandards.main.StandardGame;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Subclass of StandardButton - exits the game when the user presses it.
 *
 * @author Joshua
 */
public class ExitButton extends StandardButton implements MouseEventInterface {

    private final StandardGame sg;

    public ExitButton(StandardGame _sg, int _x, int _y, int _width, int _height, String _text, Color _color) {
        super(_x, _y, _width, _height, _text, _color);

        this.sg = _sg;
    }

    @Override
    public void render(Graphics2D _g2) {
        super.render(_g2);
    }

    @Override
    public void onMouseClick() {
        this.sg.stopGame();
    }

    @Override
    public void onMouseHover() {
    }
}
