package com.Slayers.GlowingPath.Main;



public class WorldGen {
	
	public static void genLevel1() {
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
				if(y==Main.bosY-(3+fixedY)&&x<Main.bosX/2-1||y==Main.bosY-(3+fixedY)&&x>Main.bosX/2+1) {
					Creation.walls[x][y].setType(1);
				}
			}
		}
	}
}
