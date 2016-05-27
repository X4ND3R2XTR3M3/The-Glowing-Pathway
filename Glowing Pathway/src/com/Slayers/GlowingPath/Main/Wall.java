package com.Slayers.GlowingPath.Main;

import java.awt.Image;

public class Wall {
	
	private int x, y, type;
	private Image BlockImage;
	
	public Wall(int setX, int setY) {
		x = setX * 32;
		y = setY * 32;
	}
	
	public Image getImage() {
		return BlockImage;
	}
	
	
	public int getType() {
		return type;
	}
	
	public void setType(int ltype) {
		type=ltype;
		BlockImage = Block_Images.getBlockRes(type);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
