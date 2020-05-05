package Entity;
import java.awt.Point;
import java.util.Random;

import org.blackoutburst.graphics.Colors;
import org.blackoutburst.graphics.Render;
import org.blackoutburst.utils.Vector2f;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import Engine.ParticlesManager;
import Engine.ParticlesTouch;
import Engine.TextureLoader;
import Main.Main;

public class IA {

	
	
	public static float  X = Display.getWidth() - 60;
	private static float y = (Display.getHeight()/2)-20;
	
	public static void collide() {
		if(Ball.player && Ball.y+20 > y-200 && Ball.y < y+340 && Ball.x+20 > X) {{Ball.direction.x = -Ball.direction.x;Ball.player=false;particles();ballDirection();Ball.x = Player.X + 1840;Ball.alphaC = 1;}}
	}
	
	
	
	public static void update() {
		
		X = Display.getWidth() - 60;
		//Go to the ball hit point
		for(int i = 0; i < 7; i++) {
			if(Ball.player) {
				y -= y+20 > Ghosting.y ? 20: 0;
				y += y-0 < Ghosting.y ? 20: 0;
			}else {
				y -= y+20 > Display.getHeight()/2 ? 20 : 0;
				y += y+20 < Display.getHeight()/2 ? 20 : 0;	
			}
		}
	
	
		
			//Bounds
		if(y-160 < 0) {y = 160;}
		if(y+300 > Display.getHeight()) {y = Display.getHeight()-300;}
			
	}

	private static void ballDirection() {
		Main.line ++;
		Ball.direction = new Vector2f(-1,(float)Math.sin(Math.toRadians(Ball.y - y)/2));
		Ghosting.direction = new Vector2f(-1,(float)Math.sin(Math.toRadians(Ball.y - y)/2));
		Ghosting.x = Ball.x;
		Ghosting.y = Ball.y;
		Ghosting.speed = Ball.speed;
		Ghosting.hitPos.clear();
		Ghosting.hitPoint.clear();
		Ghosting.hitPos.add(new Point((int) (Ball.x+20),(int) (Ball.y+20)));
		Ghosting.lock = false;
	}

	//Add touch particles
	private static void particles() {
		Random rand = new Random();
		for(int i = 0; i < rand.nextInt(10)+10; i ++) {
	         int size = rand.nextInt(20)+10;
	         float xd =  (float) Math.cos(Math.toRadians(rand.nextInt(360)));
	     				float yd =  (float) Math.sin(Math.toRadians(rand.nextInt(360)));
	     		         Vector2f v = new Vector2f(-Math.abs(xd),yd);
            ParticlesManager.particles.add(new ParticlesTouch(TextureLoader.texture, X + size/2, Ball.y + 25, size, size, new Colors(1,0.5f,0), false, 0, 1,
           		 rand.nextInt(1 + 1 + 5) - 5, false,
           		 v));
		}
	}
	
	//Render the player
	public static void render() {
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		Render.quadS(TextureLoader.player, X, y-100, 60, 340, Colors.ORANGE, 0);
		Render.quadS(TextureLoader.player, X, y-100, 60, 340, Colors.ORANGE, 0);
	}
	
	
}
