package com.Slayers.GlowingPath.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.embed.swing.JFXPanel;

public class Main extends JPanel {

	private static final long serialVersionUID = 4239857866088994254L;
	public static Display f = new Display();
	public static int w, h, scene, tileSize = 32, bosX, bosY;
	public static Font retroF = null;
	public static MouseTest mt = new MouseTest();
	public static boolean music = true, musicplaying = false;
	
	
	public Main() {
		getDisplayMaxHeight();
		getDisplayMaxWidth();
		setBackground(Color.BLACK);
	}
	
	
	public static void getDisplayMaxWidth() {
		double i = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getMaxX();
		w = (int) i;
		bosX = (int) Math.ceil(w/tileSize);
	}
	
	public static void getDisplayMaxHeight() {
		double i = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getMaxY();
		h = (int) i;
		bosY = (int) Math.ceil(h/tileSize);
	}
	
	public static void main(String args[]) {
		Main game = new Main();
		JFXPanel fxpanel = new JFXPanel();
		File file = new File("TutorialComplete.txt");
		PrintWriter ouput;
		try {
			ouput = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		getDisplayMaxWidth();
		getDisplayMaxHeight();
		f.add(game);
		f.setSize(w, h);
		f.setResizable(true);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Glowing Path");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    if (retroF == null) {
                    	retroF = AddFont.createFont("C:\\Users\\Xander\\Glowing Path\\Glowing Path\\src\\Resources\\Fonts\\8-bit.ttf", 50);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
		mt = new MouseTest();
		mt.init();
		f.addMouseListener(mt);
		f.addMouseMotionListener(mt);
		
		scene=0;
	}
	
	public void paint(Graphics g) {
		if (scene==0) {
			setBackground(Color.BLACK);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getSize().width, getSize().height);
			g.setFont(retroF);
			FontMetrics fm = g.getFontMetrics();
			String begin = "Begin";
			int sw = fm.stringWidth(begin);
			int sh = fm.getHeight();
			retroF = new Font(Font.SANS_SERIF, Font.BOLD, 50);
			g.setColor(Color.WHITE);
			if (checkHover((getSize().width - sw) / 2, getSize().height / 2, (getSize().width - sw) / 2 + sw,
					getSize().height / 2 + sh)) {
				g.setColor(Color.YELLOW);
			}
			g.drawString("Begin", (getSize().width - sw) / 2, getSize().height /2);
			String gp = "Glowing Pathway";
			String bx = "By: Xander Hughes";
			int gpw = fm.stringWidth(gp);
			int bxw = fm.stringWidth(bx);
			Font f = new Font("Trojan Pro", Font.BOLD, 10);
			g.setFont(f);
			//g.drawString("Glowing Pathway", (getSize().width - gpw/5) / 2, getSize().height-100);
			//g.drawString("By: Xander Hughes", (getSize().width - gpw/10) / 2, getSize().height-75);
			/*
			Color c = new Color(255, 255, 255, 0);
			g.setColor(c);
			g.drawRect((getSize().width - sw) / 2, getSize().height /2, sw, sh - 100);
			*/
			if(music == false) {
				Music.disposeMusic();
				musicplaying = false;
			}
			if(music && (musicplaying == false)) {
				System.out.println(this.getClass().getResourceAsStream("Button-Click.wav"));
				String s = "Emotional Music - River of Tears (No Voice).mp3";
				Music.playMusic(s);
				musicplaying = true;
			}
			if (mt.Click || mt.RClick) {
				if (checkClickButton((getSize().width - sw) / 2, getSize().height / 2, (getSize().width - sw) / 2 + sw,
						getSize().height / 2 + sh)) {
					scene=2;
					String s = "Button-Click.wav";
					PlaySound.playSound(s);
				}
			}
		}
		if (scene==2) {
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, getSize().width, getSize().height);
			DrawWall.drawBlocks(g);
		}
		repaint();
	}


	public static boolean testTutorialComplete() {
		return false;
	}
	
	public static boolean checkClickButton(int x, int y, int mX, int mY) {
		/*
		System.out.println("X: " + x + ":" + mt.X + ":" + mX);
		System.out.println("---");
		System.out.println("Y: " + y + ":" + mt.Y + ":" + mY);
		System.out.println("");
		System.out.println("");
		*/
		if (mt.X > x && mt.X < mX) {
			if (mt.Y > y && mt.Y < mY) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkHover(int x, int y, int mX, int mY) {
		/*
		System.out.println("X: " + x + ":" + mt.X + ":" + mX);
		System.out.println("---");
		System.out.println("Y: " + y + ":" + mt.Y + ":" + mY);
		System.out.println("");
		System.out.println("");
		*/
		if (mt.X > x && mt.X < mX) {
			if (mt.Y > y && mt.Y < mY) {
				return true;
			}
		}
		return false;
	}
	
}
