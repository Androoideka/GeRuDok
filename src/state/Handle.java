package state;

public enum Handle {
	NORTH, SOUTH, EAST, WEST, SOUTHEAST, SOUTHWEST, NORTHEAST, NORTHWEST;
	
	static final int handleSize=8;
	
	public static int getSize() {
		return handleSize;
	}
}
