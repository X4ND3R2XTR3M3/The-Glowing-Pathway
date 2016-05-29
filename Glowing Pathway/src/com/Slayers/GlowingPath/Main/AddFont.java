package com.Slayers.GlowingPath.Main;

import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

@SuppressWarnings("serial")
public class AddFont extends Main {
	
	private static Font ttfBase = null;
	private static Font telefraficoFont = null;
	private static InputStream myStream = null;
	
	public static Font createFont(String f, int s) {
		try {
			myStream = new BufferedInputStream(new FileInputStream("src/"+f));
			ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
			telefraficoFont = ttfBase.deriveFont(Font.PLAIN, 50);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Font not loaded.");
		}
		return telefraficoFont;
	}
	
}
