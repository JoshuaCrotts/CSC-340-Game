package com.dsd.game.userinterface.shop.weapons.views;

import com.dsd.game.objects.weapons.enums.WeaponType;
import com.dsd.game.userinterface.shop.weapons.models.FastRifleButton;
import com.revivedstandards.util.StdOps;
import java.awt.Graphics2D;

/**
 * This is the view for purchasing the Fast Rifle (PPSh-41), or purchasing its
 * ammunition.
 *
 * @author Joshua
 */
public class FastRifleButtonView extends ShopButtonView {

    public FastRifleButtonView(FastRifleButton _rifleButton) {
        super(_rifleButton, StdOps.loadImage("src/resources/img/items/icons/FastRifle_icon.png"));
    }

    @Override
    public void tick() {
        //  Only update the text if the user has the rifle in their inventory.
        if (this.parentButton.getGame().getPlayer().getInventory().hasWeapon(WeaponType.FAST_RIFLE) == null) {
            this.text.setText("PPSh-41 $" + this.parentButton.getPrice());
        } else {
            this.text.setText("PPSh-41 AMMO (71/$" + this.parentButton.getPricePerMagazine() + ")");
        }
        super.tick();
    }

    @Override
    public void render(Graphics2D _g2) {
        super.render(_g2);
    }
}
