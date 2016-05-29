package com.Slayers.GlowingPath.Main;

import java.awt.Image;


public class Block_Images {
	
	public static Image getBlockRes(int type) {
		if(type == 1) {
			return WallImage.getWall();
		}
		if(type == 2) {
			return StairImage.getStair();
		}
		return null;
	}
}
