package Entity;
import java.util.Random;

import org.blackoutburst.graphics.Colors;
import org.blackoutburst.graphics.LightManager;
import org.blackoutburst.utils.Vector2f;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

import Engine.ParticlesManager;
import Engine.ParticlesTouch;
import Engine.ShaderManager;
import Engine.TextureLoader;
import Main.Main;

public class Ball {

	
	
	public static final Shape ball = new Ellipse(Display.getWidth()/2, Display.getHeight()/2, 20, 20);
	
	public static float speed = 0;
	
	private static float alpha1 = 0, alpha2 = 0, alphaL = 0, alphaR = 0;
	public static float alphaC = 0;
	
	public static boolean player = false;
	
	
	private static Random rand = new Random();
	
	public static float x = Player.X+20,y = (Display.getHeight()/2)-21;
	
	public static Vector2f direction = new Vector2f((float)Math.cos(Math.toRadians(180)),(float)Math.sin(Math.toRadians(181)));
	


	
	public static void update() {
		x += direction.x*speed;
		y += direction.y*speed;
		ball.setLocation(x,y);
		
		
		//Left bound
		if(x < -500 && !player) {
			alphaL = 1;
			resetposition();
			Main.score2++;
			
			int p = rand.nextInt(60)+30;
			for(int i = 0; i < p; i ++) {
		         int size = rand.nextInt(20)+10;
		         float xd =  (float) Math.cos(Math.toRadians(rand.nextInt(360)));
					float yd =  (float) Math.sin(Math.toRadians(rand.nextInt(360)));
			         Vector2f v = new Vector2f(Math.abs(xd),yd);
	             ParticlesManager.particles.add(new ParticlesTouch(TextureLoader.texture, 0, (Display.getHeight()/p)*i, size, size, new Colors(0,0.5f,1), false, 0, 1,
	            		 rand.nextInt(1 + 1 + 5) - 5, false,
	            		v));
			}
			
		}
		
		
		//Right bound
		if(x-500 > Display.getWidth() && player) {
			alphaR = 1;
			resetposition();
			Main.score1++;
			
			int p = rand.nextInt(60)+30;
			for(int i = 0; i < p; i ++) {
		         int size = rand.nextInt(20)+10;
		         float xd =  (float) Math.cos(Math.toRadians(rand.nextInt(360)));
					float yd =  (float) Math.sin(Math.toRadians(rand.nextInt(360)));
			         Vector2f v = new Vector2f(-Math.abs(xd),yd);
	             ParticlesManager.particles.add(new ParticlesTouch(TextureLoader.texture, Display.getWidth(), (Display.getHeight()/p)*i, size, size, new Colors(1,0.1f,0), false, 0, 1,
	            		 rand.nextInt(1 + 1 + 5) - 5, false,
	            		 v));
			}
			
		}
		
		
		//Up bound
		if(y < 0) {
			y = 0;
			alpha1 = 1;
			direction.y = Math.abs(direction.y);
			for(int i = 0; i < rand.nextInt(10)+10; i ++) {
		         int size = rand.nextInt(20)+10;
		         float xd =  (float) Math.cos(Math.toRadians(rand.nextInt(360)));
		         float yd =  (float) Math.sin(Math.toRadians(rand.nextInt(360)));
			         Vector2f v = new Vector2f(xd,Math.abs(yd));
	             ParticlesManager.particles.add(new ParticlesTouch(TextureLoader.texture, x+10 + size/2, y + size/2, size, size, new Colors(1,0.2f,1), false, 0, 1,
	            		 rand.nextInt(1 + 1 + 5) - 5, false,
	            		v));
			}
		}
		
		
		//Down bound
		if(y+40 > Display.getHeight()) {
			y = Display.getHeight() - 40;
			alpha2 = 1;
			direction.y = -Math.abs(direction.y);
			for(int i = 0; i < rand.nextInt(10)+10; i ++) {
		         int size = rand.nextInt(20)+10;
		         float xd =  (float) Math.cos(Math.toRadians(rand.nextInt(360)));
					float yd =  (float) Math.sin(Math.toRadians(rand.nextInt(360)));
			         Vector2f v = new Vector2f(xd,-Math.abs(yd));
	             ParticlesManager.particles.add(new ParticlesTouch(TextureLoader.texture, x+10 + size/2, y + size/2, size, size, new Colors(1,0.2f,1), false, 0, 1,
	            		 rand.nextInt(1 + 1 + 5) - 5, false,
	            		 v));
			}
		}
		
		
		//Speed limiter
	//	if(speed > 50) {speed = 50;}
	
		
		//Create follow particles
		particles();
		
	}
	
	
	//Restore default ball position and speed
	private static void resetposition() {
		x = player ? 20 :  Display.getWidth() - 60;
		y = (Display.getHeight()/2)-20;
		Ghosting.x = x;
		Ghosting.y = y;
		speed = 10;
		Ghosting.speed = speed;
		ball.setLocation(x,y);
		Vector2f v = player ? new Vector2f((float)Math.cos(Math.toRadians(0)),(float)Math.sin(Math.toRadians(1))) : new Vector2f((float)Math.cos(Math.toRadians(180)),(float)Math.sin(Math.toRadians(181))) ;
		direction = v;
		player = player ? true : false ;
		Ghosting.direction = direction;
		Ghosting.lock = false;
		
	}
	
	
	//Create follow particles
	private static void particles() {
		Random rand = new Random();
		
		
		for(int i = 0; i < 2; i++) {
			int size = rand.nextInt(20)+10;
	         
	        float xd =  (float) Math.cos(Math.toRadians(rand.nextInt(360)));
			float yd =  (float) Math.sin(Math.toRadians(rand.nextInt(360)));
	         
			Colors color = player ?  new Colors(0,0.5f,1) : new Colors(1,0.5f,0) ;
			
			
	         Vector2f v = new Vector2f(xd/2,yd/2);
	            ParticlesManager.particles.add(new ParticlesTouch(TextureLoader.texture, x + size/2, y + size/2, size/2, size/2, color, false, 0, 1,
	           		 rand.nextInt(1 + 1 + 5) - 5, false,v));
	         }
	           
	            
	            //Mid line particles
	            int yr = rand.nextInt(Display.getHeight());
	            int size = rand.nextInt(20)+10;
		        float xd =  (float) Math.cos(Math.toRadians(rand.nextInt(360)));
				float yd =  (float) Math.sin(Math.toRadians(rand.nextInt(360)));
	            Vector2f v = new Vector2f(xd,yd);
	            ParticlesManager.particles.add(new ParticlesTouch(TextureLoader.texture, Display.getWidth()/2 + size/4, yr + size/4, size/4, size/4, new Colors(alphaC,alphaC,alphaC,alphaC), false, 0, 1,
		           		 rand.nextInt(1 + 1 + 5) - 5, false,v));
	            
	}
	
	//Render ball and line
	public static void render() {

		if(alpha1 > 0) {alpha1 -=0.01f;}
		if(alpha2 > 0) {alpha2 -=0.01f;}
		if(alphaL > 0) {alphaL -=0.01f;}
		if(alphaR > 0) {alphaR -=0.01f;}
		if(alphaC > 0) {alphaC -=0.05f;}
		
		ShaderManager.renderSingleHLine(500, 1, 1, 0.1f, 1, 2+(alpha1*4));
		ShaderManager.renderSingleHLine(500, Display.getHeight()-1, 1, 0.1f, 1, 2+(alpha2*4));
		
		ShaderManager.renderSingleVLine(1, 500, 0, 0.5f, 1, 2+(alphaL*8));
		ShaderManager.renderSingleVLine(Display.getWidth()-1, 500, 1, 0.1f, 0, 2+(alphaR*8));
		
			
		ShaderManager.renderSingleVLine(Display.getWidth()/2, 500, 1, 1, 1, 1+(alphaC*8));
		
		if(player) {
			LightManager.renderSingleLight(x+20, y+20, 0, 0.8f, 1, (speed/3));
		}else {
			LightManager.renderSingleLight(x+20, y+20, 1, 0.5f, 0, (speed/3));
		}
	}
	
}
