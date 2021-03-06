package com.Slayers.GlowingPath.Main;

public class Creation {

	protected static Wall[][] walls;
	
	
	public static void create(int level) {
		walls = new Wall[Main.bosX + 1][Main.bosY + 1];
		for(int x = 0; x < Main.bosX; x++) {
			for(int y = 0; y < Main.bosY; y++) {
				walls[x][y] = new Wall(x, y);
			}
		}
		if (level==1) {
			WorldGen.genLevel1();
		}
		if (level==2) {
			WorldGen.genLevel2();
		}
		if (level==3) {
			WorldGen.genLevel3();
		}
		if (level==4) {
			WorldGen.genLevel4();
		}
	}
}
