package com.example.kevin.shogigame.pieces;

import com.example.kevin.shogigame.game.Game;
import com.example.kevin.shogigame.grid.Location;

import java.util.ArrayList;

/**
 *
 * @author Kevin Minter
 */
public class SilverGeneral extends Piece{

    public SilverGeneral(boolean isWhite, Game game, Location location){
        super(isWhite, game, location);
        promoted = false;
    }

    @Override
    public Piece copy() {
        return new SilverGeneral(isWhite(), getGame(), getLocation().copy());
    }

    @Override
    public ArrayList<Location> getAttackedLocations() {
        ArrayList<Location> locs = new ArrayList<Location>(8);
        if(promoted){
            int dir = isWhite() ? 0 : 180;
            for(int dirChange = 0; dirChange <= 90; dirChange += 45) {
                Location l1 = getLocation().getAdjacentLocation(dir+dirChange);
                if(getGrid().isValid(l1)) {
                    locs.add(l1);
                }
                if(dirChange!=0) {
                    Location l2 = getLocation().getAdjacentLocation(dir - dirChange);
                    if(getGrid().isValid(l2)) {
                        locs.add(l2);
                    }
                }
            }
            dir = isWhite() ? 180 : 0;
            Location l = getLocation().getAdjacentLocation(dir);
            if(getGrid().isValid(l)) {
                locs.add(l);
            }
        }else {
            for (int dir = 45; dir < 360; dir += 90) {
                Location l = getLocation().getAdjacentLocation(dir);
                if (getGrid().isValid(l)) {
                    locs.add(l);
                }
            }
            int dir = isWhite() ? 0 : 180;
            Location l = getLocation().getAdjacentLocation(dir);
            if (getGrid().isValid(l)) {
                locs.add(l);
            }
        }
        return locs;
    }
}