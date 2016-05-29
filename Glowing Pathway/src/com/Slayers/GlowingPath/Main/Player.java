package com.Slayers.GlowingPath.Main;

import java.awt.*;

import javax.swing.*;

public class Player {
	
	private static ImageIcon playerR = new ImageIcon(Main.class.getClassLoader().getResource("TempPlayer.png"));
	private static ImageIcon playerL = new ImageIcon(Main.class.getClassLoader().getResource("TempPlayerLeft.png"));
	
	public static double speed = 1;
	public static int x = Main.w/2, Xdisplacement, y = Main.h/2,inhs = 1, blockX = (int) Math.floor(x/32), blockY = (int) Math.floor(y/32), jHeight = (int) (20), jCount = 0;
	public static String iteminhand = "dirt";
	public static boolean right = false, left = false, up = false, down = false, fright = true, fleft = false;
	public static int GrassAmount = 0, DirtAmount = 0, StoneAmount = 0, BlueOreAmount = 0;
	
	public static String getItemInHand() {
		return iteminhand;
	}
	
	public static int getINHStrength() {
		return inhs;
	}
	
	public static void setItemInHand(String s) {
		iteminhand = s;
	}
	
	public static void setINHStrength(int i) {
		inhs = i;
	}
	
	public static Image getImage() {
		if(fright) {
			return playerR.getImage();			
		} else if(fleft) {
			return playerL.getImage();			
		} else {
			return null;
		}
		
	}
	
	public static void setFacing(int i) {
		if(i == 1) {
			fright = true;
			fleft = false;
		}
		if(i == 2) {
			fleft = true;
			fright = false;
		}
	}
	
	public static void update() {
		updateX();
		updateY();
		updateBlock();
	}
	
	public static void updateY() {
		if(getBlockY() >= Main.bosY - 1) {
			return;
		} 
		if(up) {
			if(Creation.walls[(int) blockX][(int) blockY].getType() == 0 && Creation.walls[(int) blockX][(int) (blockY-2)].getType() == 0) {
				y-=speed;
			}
		}
		
		if(down) {
			if(Creation.walls[(int) blockX][(int) blockY].getType() == 0 && Creation.walls[(int) blockX][(int) (blockY+1)].getType() == 0) {
				y+=speed;
			}
		}
	}
	
	public static void updateX() {
		if(getBlockY() >= Main.bosY - 1) {
			return;
		} 
		if(right) {
			if(Creation.walls[(int) (blockX+1)][(int) blockY].getType() == 0 && Creation.walls[(int) (blockX+1)][(int) (blockY-1)].getType() == 0 ) {
				x+=speed;
			}
			setFacing(1);
		}
		
		if(left) {
			if(Creation.walls[(int) (blockX-1)][(int) blockY].getType() == 0 && Creation.walls[(int) (blockX-1)][(int) (blockY-1)].getType() == 0 ) {
				x-=speed;
			}
			setFacing(2);
		}
	}
	
	public static void updateBlock() {
		blockX = (int) Math.floor(x/32);
		blockY = (int) Math.floor(y/32);
	}
	
	public static void updateItem() {
		
	}
	
	public static int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
	
	public static int getBlockX() {
		return (int) blockX;
	}
	
	public static int getBlockY() {
		return (int) blockY;
	}
	
	public static void setXDisplacement(int i) {
		Xdisplacement = i;
	}

	public static void updateCutScene() {
		if(Main.scene==101&&Main.level==1) {
			if(y>=0) {
				y--;
			}
			if(y==0) {
				y=Main.h;
				Main.level=2;
			}
		}
		if(Main.scene==101&&Main.level==2) {
			if(y>=0) {
				y--;
			}
			if(y==0) {
				y=Main.h;
				Main.level=3;
			}
		}
		if(Main.scene==101&&Main.level==3) {
			if(y>Main.h/2+32) {
				y--;
			}
			if(y==Main.h/2+32&&x<Main.w/4*3-2) {
				x++;
			}
			if(x==Main.w/4*3-4) {
				x=Main.w/4+10;
				y=Main.h/2+32;
				Main.level=4;
			}
		}
		if(Main.scene==101&&Main.level==4) {
			if(x<Main.w/4+30) {
				x++;
			}
			if(x==Main.w/4+10) {
				Main.portalFound = true;
				Main.drawQuestion = true;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Main.drawQuestion = false;
				x++;
			}
			if (x>Main.w/4+10) {
				x++;
			}
			if(x==Main.w/4*3-2) {
				Main.scene=102;
				Main.level=1;
			}
		}
	}
	
}
