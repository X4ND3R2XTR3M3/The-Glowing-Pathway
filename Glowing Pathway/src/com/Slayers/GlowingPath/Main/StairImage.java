package com.Slayers.GlowingPath.Main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class StairImage {

	public static ImageIcon stair = new ImageIcon(Main.class.getClassLoader().getResource("Wall.png"));
	
	public static Image getStair() {
		return stair.getImage();
	}
	
}
