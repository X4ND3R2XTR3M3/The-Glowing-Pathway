package com.Slayers.GlowingPath.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseTest implements MouseListener, MouseMotionListener {

	public int X;
	public int Y;
	public boolean Click, RClick;
	
	public void init() {
		X = 0;
		Y = 0;
		Click = false;
		RClick = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
		String s = "Button-Click.wav";
		PlaySound.playSound(s);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
		System.out.println("mouePressed");
		if(e.getButton() == MouseEvent.BUTTON1) {
			Click = true;
			RClick = false;
		}
		if(e.getButton() == MouseEvent.BUTTON3) {
			RClick = true;
			Click = false;
		}
		String s = "Button-Click.wav";
		PlaySound.playSound(s);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Click = false;
		RClick = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
}
