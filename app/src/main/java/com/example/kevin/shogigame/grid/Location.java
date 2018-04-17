package com.example.kevin.shogigame.grid;

/**
 * Represents a location on a chessboard. 
 * @author Kevin
 */
public class Location {
	private int rank, file;

    public static final int UP = 0;
    public static final int UPRIGHT = 45;
	public static final int RIGHT = 90;
	public static final int DOWNRIGHT = 135;
	public static final int DOWN = 180;
	public static final int DOWNLEFT = 225;
    public static final int LEFT = 270;
    public static final int UPLEFT = 315;
	
    /**
     * Create a new location.
     * @param rank The location's rank
     * @param file The location's file
     */
	public Location(int rank, int file) {
		super();
		this.rank = rank;
		this.file = file;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Location))
			return false;
		
		Location loc = (Location) o;
		return loc.file == file && loc.rank == rank;
	}
	
	/**
	 * Gets an adjacent location to this object in the given direction.
	 * @param direction The direction to move in.
	 * @return An adjacent location.
	 * @throws IllegalArgumentException if the direction is not a multiple of
	 * forty-five degrees.
	 */
	public Location getAdjacentLocation(int direction) throws IllegalArgumentException {
		while(direction < 0)
			direction += 360;
		direction %= 360;
		
		switch(direction) {
			case UP:
				return new Location(rank + 1, file);
			case UPRIGHT:
				return new Location(rank + 1, file + 1);
			case UPLEFT:
				return new Location(rank + 1, file - 1);
			case LEFT:
				return new Location(rank, file - 1);
			case RIGHT:
				return new Location(rank, file + 1);
			case DOWNRIGHT:
				return new Location(rank - 1, file + 1);
			case DOWN:
				return new Location(rank - 1, file);
			case DOWNLEFT:
				return new Location(rank - 1, file - 1);
			default:
				throw new IllegalArgumentException("" + direction + " is not a" + " multiple of 45 degrees.");
		}
	}
	
	/**
	 * @return The column number of this location.
	 */
	public int getFile() {
		return file;
	}
	
	/**
	 * @return The row number of this location.
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * @return A copy of this location.
	 */
	public Location copy() {
		return new Location(rank, file);
	}
	
	@Override
	public int hashCode() {
		return rank * 3737 + file;
	}
	
	@Override
	public String toString() {
		if(rank < 0 || rank > 8 || file < 0 || file > 8) {
			return "(" + file + ", " + rank + ")";
		}
		
		StringBuilder str = new StringBuilder(2);
		str.append((char)('a' + file));
		str.append((char)('1' + rank));
		return str.toString();
	}
}