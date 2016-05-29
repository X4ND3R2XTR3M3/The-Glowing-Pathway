package com.Slayers.GlowingPath.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class DrawPlayer {

	public static void drawPlayer(Graphics g) {
		if(Main.portalFound&&Main.drawQuestion) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("SansSerif", Font.ITALIC, 20));
			g.drawString("?", Player.getX() + 32, Player.getY() - 45);
		}
		g.drawImage(Player.getImage(), Player.getX(), Player.getY() - Main.tileSize, null);
	}
}
