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
	public static int w, h, scene, level, tileSize = 32, bosX, bosY, loadingC = 255;
	public static Font retroF = null;
	public static MouseTest mt = new MouseTest();
	public static KeyTest kt = new KeyTest();
	public static boolean music = true, musicplaying = false, loadT = false, portalFound = false, drawQuestion = false;
	public static Color carpet = Color.GRAY;
	
	
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
		@SuppressWarnings("unused")
		JFXPanel fxpanel = new JFXPanel();
		File file = new File("TutorialComplete.txt");
		@SuppressWarnings("unused")
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
		kt = new KeyTest();
		mt = new MouseTest();
		mt.init();
		kt.init();
		f.addMouseListener(mt);
		f.addMouseMotionListener(mt);
		f.addKeyListener(kt);
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
			retroF = AddFont.createFont("8-bit.ttf", 50);
			g.setColor(Color.WHITE);
			if (checkHover((getSize().width - sw) / 2, getSize().height / 2, (getSize().width - sw) / 2 + sw,
					getSize().height / 2 + sh)) {
				g.setColor(Color.YELLOW);
			}
			g.drawString(begin, (getSize().width - sw) / 2, getSize().height /2);
			String gp = "Glowing Pathway";
			String bx = "By: The Youngsters";
			int gpw = fm.stringWidth(gp);
			Font f = new Font("Trojan Pro", Font.BOLD, 10);
			g.setFont(f);
			g.setColor(Color.WHITE);
			g.drawString(gp, (getSize().width - gpw/5) / 2, getSize().height-100);
			g.drawString(bx, (getSize().width - gpw/10) / 2, getSize().height-75);
			if (mt.Click || mt.RClick) {
				if (checkClickButton((getSize().width - sw) / 2, getSize().height / 2, (getSize().width - sw) / 2 + sw,
						getSize().height / 2 + sh)) {
					scene=2;
					String s = "Button-Click.wav";
					PlaySound.playSound(s);
				}
			}
		}
		if (scene==2)  {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getSize().width, getSize().height);
			g.setFont(retroF);
			FontMetrics fm = g.getFontMetrics();
			String load = "Load";
			String strnew = "New";
			String options = "Options";
			int sw = fm.stringWidth(load);
			int sh = fm.getHeight();
			retroF = AddFont.createFont("8-bit.ttf", 50);
			if (loadT) {
				g.setColor(Color.WHITE);
					if (checkHover((getSize().width - sw) / 2, getSize().height / 2, (getSize().width - sw) / 2 + sw,
							getSize().height / 2 + sh)) {
						g.setColor(Color.YELLOW);
					}
			} else {
				g.setColor(Color.GRAY);
			}
			g.drawString(load, (getSize().width - sw) / 2, getSize().height / 2);
			g.setColor(Color.WHITE);
			if (checkHover((getSize().width - sw) / 2 + 8, getSize().height / 2 - 100, (getSize().width - sw) / 2 + sw + 8,
					getSize().height / 2 + sh - 100)) {
				g.setColor(Color.YELLOW);
			}
			g.drawString(strnew, (getSize().width - sw) / 2 + 8, getSize().height / 2 - 100);
			g.setColor(Color.WHITE);
			if (checkHover((getSize().width - sw) / 2 + 8, getSize().height / 2 + 100, (getSize().width - sw) / 2 + sw + 8,
					getSize().height / 2 + sh + 100)) {
				g.setColor(Color.YELLOW);
			}
			g.drawString(options, (getSize().width - sw) / 2 - 60, getSize().height / 2 + 100);
			if (mt.Click || mt.RClick) {
				//Load Button
				if (checkClickButton((getSize().width - sw) / 2, getSize().height / 2, (getSize().width - sw) / 2 + sw,
						getSize().height / 2 + sh) && loadT) {
					scene=101;
					level=1;
					String s = "Button-Click.wav";
					PlaySound.playSound(s);
				}
				//New Button
				if (checkHover((getSize().width - sw) / 2 + 8, getSize().height / 2 - 100, (getSize().width - sw) / 2 + sw + 8,
						getSize().height / 2 + sh - 100)) {
					scene=101;
					level=1;
					String s = "Button-Click.wav";
					PlaySound.playSound(s);
				}
				//Option Button
				if (checkHover((getSize().width - sw) / 2 + 8, getSize().height / 2 + 100, (getSize().width - sw) / 2 + sw + 8,
						getSize().height / 2 + sh + 100)) {
					scene=5;
					String s = "Button-Click.wav";
					PlaySound.playSound(s);
				}
			}
		}
		if (scene==3) {
			g.setColor(Color.CYAN);
			g.fillRect(0, 0, getSize().width, getSize().height);
		}
		if (scene==5) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getSize().width, getSize().height);
			g.setColor(Color.BLUE);
			g.drawString("TODO", getSize().width / 2, getSize().height / 2);
		}
		if (scene==101&&level==1) {
			if(loadingC>0){
				loadingC--;
			}
			if (loadingC==0) {
				scene=101;
			}
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
			Creation.create(level);
			g.setColor(carpet);
			g.fillRect(0, 0, getSize().width, getSize().height);
			DrawPlayer.drawPlayer(g);
			DrawWall.drawBlocks(g);
			retroF = new Font("SansSerif", Font.ITALIC, 50);
			g.setFont(retroF);
			g.drawString("The Story...", 20, 100);
			Color c = new Color(0, 0, 0, loadingC);
			g.setColor(c);
			g.fillRect(0, 0, getSize().width, getSize().height);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (loadingC==0) {
				Player.updateCutScene();
			}
		}
		if (scene==101&&level==2) {
			Creation.create(level);
			g.setColor(carpet);
			g.fillRect(0, 0, getSize().width, getSize().height);
			DrawWall.drawBlocks(g);
			DrawPlayer.drawPlayer(g);
			Player.updateCutScene();
			g.setColor(Color.GRAY);
			retroF = new Font("SansSerif", Font.ITALIC, 50);
			g.setFont(retroF);
			g.drawString("of a young man...", 20, 100);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (scene==101&&level==3) {
			Creation.create(level);
			g.setColor(carpet);
			g.fillRect(0, 0, getSize().width, getSize().height);
			DrawWall.drawBlocks(g);
			DrawPlayer.drawPlayer(g);
			Player.updateCutScene();
			g.setColor(Color.GRAY);
			retroF = new Font("SansSerif", Font.ITALIC, 50);
			g.setFont(retroF);
			g.drawString("and his life...", 20, 100);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (scene==101&&level==4) {
			Creation.create(level);
			g.setColor(carpet);
			g.fillRect(0, 0, getSize().width, getSize().height);
			DrawWall.drawBlocks(g);
			DrawPlayer.drawPlayer(g);
			Player.updateCutScene();
			g.setColor(Color.GRAY);
			retroF = new Font("SansSerif", Font.ITALIC, 50);
			g.setFont(retroF);
			g.drawString("who discovers the", 20, 100);
			g.drawString("unthinkable...", 50, 150);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
