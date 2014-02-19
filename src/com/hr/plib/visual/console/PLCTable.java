package com.hr.plib.visual.console;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a console menu. Using different classes, it can achieve
 * different type of menus.
 * 
 * @author Harshavardhan Ramesh - Oct 4, 2013
 */
// TODO: Code the PLCTable class and make it pretty looking!
public class PLCTable {

	private List<List<String>> info = new ArrayList<List<String>>();

	public PLCTable() {
		super();
	}

	public void append(String[] text) {
		ArrayList<String> info = new ArrayList<>();
		for (String s : text) {
			info.add(s);
		}
		this.info.add(info);
	}

}