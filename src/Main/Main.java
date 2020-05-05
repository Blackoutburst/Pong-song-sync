package Main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.blackoutburst.display.DisplayManager;
import org.blackoutburst.graphics.LightManager;
import org.blackoutburst.graphics.Render;
import org.blackoutburst.utils.Loader;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import Engine.ParticlesManager;
import Engine.Score;
import Engine.ShaderManager;
import Engine.TextureLoader;
import Entity.Ball;
import Entity.Ghosting;
import Entity.IA;
import Entity.Player;

public class Main {
	
	
	public static int score1 = 0, score2 = 0, line = 0, value = 0; 
	private static boolean showGhost = false, showFPS = false;
	private static boolean F1 = false, F2 = false, F12 = false, T = false, start = false;
	private static long lastFPS; 
	private static int fps, trueFPS;
	public static float v1;
	private static float v2;
	private static Music song;
	
	
	public static void updateFPS() {
	    if (getTime() - lastFPS > 1000) {
	    	trueFPS = fps;
	        fps = 0; //reset the FPS counter
	        lastFPS += 1000; //add one second
	    }
	    fps++;
	}
	
	public static long getTime() {
	    return System.nanoTime() / 1000000;
	}
	
	//Initialization
	public static void main(String[] args) {
		
		lastFPS = getTime();
		Thread t = new Thread(new Runnable() {
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					try {
						Ghosting.update();
						Player.collide();
						IA.collide();
					} catch (Exception e) {}
				}
			}
			
		});
		t.setDaemon(true);
		t.setName("Ghost calcul");
		t.start();
		
		
		
		//System.setProperty ( "org.lwjgl.opengl.Window.undecorated" , "true" ) ;
		DisplayManager.create(1920, 1080, true, false, "Pong", true, false, null, null);
		TextureLoader.load();
		Loader.loadDefaultFont(true);
		LightManager.loadShader();
		ShaderManager.loadShaderVertical();
		ShaderManager.loadShaderHorizontal();
		Mouse.setGrabbed(true);
		loadSongOGG("song");
		update();
	}
	
	

    public static void loadSongOGG(String filepath) {
		try {
			song = new Music(filepath+".ogg");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	//Update  /  Render game loop
	public static void update() {
		while(true) {
			updateFPS();
			DisplayManager.update();
			GL11.glClearColor(0, 0, 0, 0);
			
			Player.update();
			IA.update();
			Ball.update();
			
			if(start) {
				Ball.speed = (float) (((IA.X - Player.X)-60)/(v2-v1));
			
				if(Ball.speed < 36 && Ball.speed > 34) {
					Ball.speed = 35.5f;
				}
				
				if(Ball.speed < 6 && Ball.speed > 3) {
					Ball.speed = 5.5f;
				}
				if(Ball.speed < 3) {
					Ball.speed = 2.62f;
				}
			}
			value ++;
			
			try {
				String str1 = Files.readAllLines(Paths.get("test.txt")).get(line);
				String str2 = Files.readAllLines(Paths.get("test.txt")).get(line+1);
				String[] astr1 = str1.split(",");
				String[] astr2 = str2.split(",");
				
				v1 = Float.valueOf(astr1[2])/17.067707799f;
				v2 = Float.valueOf(astr2[2])/17.067707799f;
			} catch (IOException e) {}
			
	
			
			
		
			/*
			System.out.println("V : "+Ball.speed);
			System.out.println("T : "+(v2-v1));
			System.out.println("D : "+(((IA.X - Player.X)-100)));
			System.out.println("D2 : "+(((Ball.x - Player.X)-20)));
			System.out.println("D3 : "+(((IA.X - Ball.x)-20)));
		 */

			if(Keyboard.isKeyDown(Keyboard.KEY_T) && !T) {
				song.play(1.0f, 1.0f);
				Ball.speed = (float) (((IA.X - Player.X)-60)/(v2-v1));
				start = true;
			}
			
			T = Keyboard.isKeyDown(Keyboard.KEY_T) ? true : false;
			
			Score.render();
			Player.render();
			IA.render();
			Ball.render();
			
			if(showGhost) {
				Ghosting.render();
			}
			
			if(showFPS) {
				Render.drawTextRight(Display.getWidth(), 0, trueFPS+" FPS", Color.green);
				Render.drawTextLeft(0, 0, "Ball speed : "+Ball.speed, Color.green);
			}
			
			ParticlesManager.update();
			
			if(Keyboard.isKeyDown(Keyboard.KEY_F1) && !F1) {
				showGhost = showGhost ? false : true;
			}
			
			F1 = Keyboard.isKeyDown(Keyboard.KEY_F1) ? true : false;
			
			
			
			if(Keyboard.isKeyDown(Keyboard.KEY_F2) && !F2) {
				showFPS = showFPS ? false : true;
			}
			
			F2 = Keyboard.isKeyDown(Keyboard.KEY_F2) ? true : false;
			
			
			if(Keyboard.isKeyDown(Keyboard.KEY_F12) && !F12) {
				GL11.glReadBuffer(GL11.GL_FRONT);
				int width = Display.getDisplayMode().getWidth();
				int height= Display.getDisplayMode().getHeight();
				int bpp = 4;
				ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);
				GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer );
				
				
				
				File file = new File("screenshot.png");
				String format = "PNG";
				BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				   
				for(int x = 0; x < width; x++) 
				{
				    for(int y = 0; y < height; y++)
				    {
				        int i = (x + (width * y)) * bpp;
				        int r = buffer.get(i) & 0xFF;
				        int g = buffer.get(i + 1) & 0xFF;
				        int b = buffer.get(i + 2) & 0xFF;
				        image.setRGB(x, height - (y + 1), (0xFF << 24) | (r << 16) | (g << 8) | b);
				    }
				}
				   
				try {
				    ImageIO.write(image, format, file);
				} catch (IOException e) { e.printStackTrace(); }
				
			}
			
			F12 = Keyboard.isKeyDown(Keyboard.KEY_F12) ? true : false;
			
			
		}
	}
}
