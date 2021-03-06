package com.example.kevin.shogigame.pieces;


import com.example.kevin.shogigame.game.Game;
import com.example.kevin.shogigame.grid.Location;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Kevin Minter
 */
public class GoldGeneral extends Piece {

    public GoldGeneral(boolean isWhite, Game game, Location location) {
        super(isWhite, game, location);
        promoted = true;
    }

    @Override
    public Piece copy() {
        GoldGeneral g = new GoldGeneral(isWhite(), getGame(), getLocation().copy());
        return g;
    }

    @Override
    public ArrayList<Location> getAttackedLocations() {
        ArrayList<Location> locs = new ArrayList<Location>(8);
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
        return locs;
    }
}
