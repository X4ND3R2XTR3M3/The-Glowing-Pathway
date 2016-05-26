package com.Slayers.GlowingPath.Main;

import java.awt.Graphics;
import java.awt.Image;

public class DrawWall {
	
	public static void drawBlocks(Graphics g) {
		Image tmpImage;
		int tmpX;
		int tmpY;
		for(int x =  0; x < Main.bosX; x++) {
			for(int y = 0; y < Main.bosY; y++) {
				tmpX = Creation.walls[x][y].getX();
				tmpY = Creation.walls[x][y].getY();
				tmpImage = Creation.walls[x][y].getImage();
//				System.out.println(x + " | " + tmpImage + " | " + tmpX + " | " + tmpY);
				g.drawImage(tmpImage, tmpX, tmpY, null);
			}
		}
	}
}
