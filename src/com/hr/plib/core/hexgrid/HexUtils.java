package com.hr.plib.core.hexgrid;

import static java.lang.Math.*;

public final class HexUtils {

	public static int distance(HexLocation loc1, HexLocation loc2) {
		return max(
				max(abs(loc2.getX() - loc1.getX()),
						abs(loc2.getY() - loc1.getY())),
				abs(loc2.getZ() - loc1.getZ()));
	}
	
	public static int xOffset(HexLocation loc1, HexLocation loc2) {
		return loc2.getX() - loc1.getX();
	}
	
	public static int yOffset(HexLocation loc1, HexLocation loc2) {
		return loc2.getY() - loc1.getY();
	}
	
	public static int zOffset(HexLocation loc1, HexLocation loc2) {
		return loc2.getZ() - loc1.getZ();
	}
	
}