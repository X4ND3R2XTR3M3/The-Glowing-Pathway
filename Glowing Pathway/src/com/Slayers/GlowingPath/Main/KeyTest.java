package com.Slayers.GlowingPath.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyTest implements KeyListener{

	public void init() {
		Player.right = false;
		Player.left = false;
		Player.up = false;
		Player.down = false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		
		if(KeyCode == KeyEvent.VK_A) {
			Player.left = true;
			Player.right = false;
			Player.up = false;
			Player.down = false;
		}
		
		if(KeyCode == KeyEvent.VK_D) {
			Player.right = true;
			Player.left = false;
			Player.up = false;
			Player.down = false;
		}
		
		if(KeyCode == KeyEvent.VK_W) {
			Player.right = false;
			Player.left = false;
			Player.up = true;
			Player.down = false;
		}
		
		if(KeyCode == KeyEvent.VK_S) {
			Player.right = false;
			Player.left = false;
			Player.up = false;
			Player.down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int KeyCode = e.getKeyCode();
		
		if(KeyCode == KeyEvent.VK_A) {
			Player.right = false;
			Player.left = false;
			Player.up = false;
			Player.down = false;
		}
		
		if(KeyCode == KeyEvent.VK_D) {
			Player.right = false;
			Player.left = false;
			Player.up = false;
			Player.down = false;
		}
		
		if(KeyCode == KeyEvent.VK_W) {
			Player.right = false;
			Player.left = false;
			Player.up = false;
			Player.down = false;
		}
		
		if(KeyCode == KeyEvent.VK_S) {
			Player.right = false;
			Player.left = false;
			Player.up = false;
			Player.down = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
