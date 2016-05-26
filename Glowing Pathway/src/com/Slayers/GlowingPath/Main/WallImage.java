package com.Slayers.GlowingPath.Main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class WallImage {

	public static ImageIcon wall = new ImageIcon(Main.class.getClassLoader().getResource("Wall"));
	
	public static Image getWall() {
		return wall.getImage();
	}
	
}
