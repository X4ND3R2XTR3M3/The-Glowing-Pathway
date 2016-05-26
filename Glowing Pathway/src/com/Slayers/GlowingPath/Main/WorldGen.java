package com.Slayers.GlowingPath.Main;



public class WorldGen {
	
	public static void genLevel1() {
		for(int x = 0; x < Main.bosX; x++) {
			for (int y = 0; y < Main.bosY; y++) {
				if(x==0&&y==0) {
					Creation.walls[x][y].setType(1);
				}
				if(x>0&&y>0) {
					Creation.walls[x][y].setType(0);
				}
			}
		}
	}
}
