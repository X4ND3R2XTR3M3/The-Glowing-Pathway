package com.Slayers.GlowingPath.Main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlaySound {
	
	public static void playSound(String s) {
		try {
			URL url = new URL(s);
			Clip clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(url);
	        clip.open(ais);

		} catch (Exception e) {
			
		}
		
	}
	
}
