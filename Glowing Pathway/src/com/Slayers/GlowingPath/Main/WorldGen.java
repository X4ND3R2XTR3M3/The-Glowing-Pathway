package com.Slayers.GlowingPath.Main;

import java.awt.Color;

public class WorldGen {
	
	public static void genLevel1() {
		Main.carpet = Color.GRAY;
		for(int x = 0; x < Main.bosX; x++) {
			for (int y = 0; y < Main.bosY; y++) {
				int fixedY = Math.abs(Main.h/Main.tileSize-Main.bosY); 
				if(y==0&&x<Main.bosX/2-1||y==0&&x>Main.bosX/2+1) {
					Creation.walls[x][y].setType(1);
				} else if((y==0||y==Main.bosY-1)&&x==Main.bosX/2) {
					Creation.walls[x][y].setType(0);
				} else if(x>0&&y>0) {
					Creation.walls[x][y].setType(0);
				}
				if(y>0&&x<Main.bosX/4) {
					Creation.walls[x][y].setType(1);
				}
				if(y>0&&x>Main.bosX/4*3) {
					Creation.walls[x][y].setType(1);
				}
				if(y==Main.bosY-2&&x<Main.bosX/2-1||y==Main.bosY-2&&x>Main.bosX/2+1) {
					Creation.walls[x][y-fixedY].setType(1);
				}
			}
		}
	}
	
	public static void genLevel2() {
		Main.carpet = Color.CYAN;
		for(int x = 0; x < Main.bosX; x++) {
			for (int y = 0; y < Main.bosY; y++) {
				int fixedY = Math.abs(Main.h/Main.tileSize-Main.bosY); 
				if(y==0&&x<Main.bosX/2-1||y==0&&x>Main.bosX/2+1) {
					Creation.walls[x][y].setType(1);
				} else if((y==0||y==Main.bosY-1)&&x==Main.bosX/2) {
					Creation.walls[x][y].setType(0);
				} else if(x>0&&y>0) {
					Creation.walls[x][y].setType(0);
				}
				if(y>0&&x<Main.bosX/4) {
					Creation.walls[x][y].setType(1);
				}
				if(y>0&&x>Main.bosX/4*3) {
					Creation.walls[x][y].setType(1);
				}
				if(y==Main.bosY-2&&x<Main.bosX/2-1||y==Main.bosY-2&&x>Main.bosX/2+1) {
					Creation.walls[x][y-fixedY].setType(1);
				}
			}
		}
	}
	
	public static void genLevel3() {
		Main.carpet = Color.MAGENTA;
		for(int x = 0; x < Main.bosX; x++) {
			for (int y = 0; y < Main.bosY; y++) {
				int fixedY = Math.abs(Main.h/Main.tileSize-Main.bosY); 
				if(y==0&&x<Main.bosX/2-1||y==0&&x>Main.bosX/2+1) {
					Creation.walls[x][y].setType(1);
				} else if((y==0||y==Main.bosY-1)&&x==Main.bosX/2) {
					Creation.walls[x][y].setType(0);
				} else if(x>0&&y>0) {
					Creation.walls[x][y].setType(0);
				}
				if(y>0&&x<Main.bosX/4) {
					Creation.walls[x][y].setType(1);
				}
				if(y>0&&x>Main.bosX/4*3) {
					Creation.walls[x][y].setType(1);
				}
				if(y==Main.bosY/2&&x==Main.bosX/4*3-1) {
					Creation.walls[x][y].setType(2);
				}
				if(y==Main.bosY-2&&x<Main.bosX/2-1||y==Main.bosY-2&&x>Main.bosX/2+1) {
					Creation.walls[x][y-fixedY].setType(1);
				}
			}
		}
	}
	
	public static void genLevel4() {
		Main.carpet = Color.GRAY;
		for(int x = 0; x < Main.bosX; x++) {
			for (int y = 0; y < Main.bosY; y++) {
				int fixedY = Math.abs(Main.h/Main.tileSize-Main.bosY); 
				if(y==0) {
					Creation.walls[x][y].setType(1);
				}
				if(y>0&&x<Main.bosX/4) {
					Creation.walls[x][y].setType(1);
				}
				if(y>0&&x>Main.bosX/4*3) {
					Creation.walls[x][y].setType(1);
				}
				if(y==Main.bosY/2&&x==Main.bosX/4+1) {
					Creation.walls[x][y].setType(2);
				}
				if(y==Main.bosY/2&&x==Main.bosX/4*3+1) {
					Creation.walls[x][y].setType(2);
				}
				if(y==Main.bosY-2) {
					Creation.walls[x][y-fixedY].setType(1);
				}
			}
		}
	}
}
