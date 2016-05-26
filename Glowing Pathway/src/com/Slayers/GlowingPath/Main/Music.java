package com.Slayers.GlowingPath.Main;

import javafx.scene.media.*;

public class Music {
	
	public static Media hb;
	public static MediaPlayer mp;
	
	public static void playMusic(String s) {
		hb = new Media(Main.class.getClassLoader().getResource(s).toString());
		mp = new MediaPlayer(hb);
		mp.play();
	}
	
	public static void disposeMusic() {
		mp.dispose();
	}
	
	public static void changeMusic(String s) {
		disposeMusic();
		playMusic(s);
	}
	
}
