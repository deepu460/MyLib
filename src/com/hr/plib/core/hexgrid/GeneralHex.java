package com.hr.plib.core.hexgrid;

public class GeneralHex implements Hex {

	private HexLocation loc;

	public GeneralHex(HexLocation loc) {
		this.loc = loc;
	}

	public HexLocation getLocation() {
		return loc;
	}

}