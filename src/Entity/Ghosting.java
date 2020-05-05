package Entity;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.blackoutburst.graphics.Colors;
import org.blackoutburst.graphics.Render;
import org.blackoutburst.utils.Vector2f;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.ShapeRenderer;

import Engine.PointOfPoint;

public class Ghosting {

	
	
	public static final Shape ghost = new Ellipse(Display.getWidth()/2, Display.getHeight()/2, 20, 20);
	
	public static float speed = 10;
	public static List<Point> hitPos = new ArrayList<Point>();
	public static List<PointOfPoint> hitPoint = new ArrayList<PointOfPoint>();
	
	public static boolean lock = false;
	
	public static float x = (Display.getWidth()/2)-20,y = (Display.getHeight()/2)-20;
	
	public static Vector2f direction = new Vector2f((float)Math.cos(Math.toRadians(180)),(float)Math.sin(Math.toRadians(180)));
	
	public static void update() {
		if(!lock) {
			x += direction.x*speed;
			y += direction.y*speed;
			ghost.setLocation(x,y);
		}
		
		//Up bound
		if(y < 0) {
			y = 0;
			direction.y = Math.abs(direction.y);
			hitPos.add(new Point((int) (x+20),(int) (y+20)));
		}
		
		
		//Down bound
		if(y+40 > Display.getHeight()) {
			y = Display.getHeight() - 40;
			direction.y = -Math.abs(direction.y);
			hitPos.add(new Point((int) (x+20),(int) (y+20)));
		}
		
		//Left bound
		if(x-60 < 0 && !Ball.player) {
			lock = true;
			x = 60;
			hitPos.add(new Point((int) (x+20),(int) (y+20)));
			int i = 0;
			Point p0 = null;
			for(Point p : hitPos) {
				if(i == 0) {p0 = p;}
				if(i == 1) {i = 0;hitPoint.add(new PointOfPoint(p0,p));p0 = p;};
				i++;
			}
		}
		
		
		//Right bound
		if(x+40+60 > Display.getWidth() && Ball.player) {
			lock = true;
			x = Display.getWidth()-40-60;
			hitPos.add(new Point((int) (x+20),(int) (y+20)));
			int i = 0;
			Point p0 = null;
			for(Point p : hitPos) {
				if(i == 0) {p0 = p;}
				if(i == 1) {i = 0;hitPoint.add(new PointOfPoint(p0,p));p0 = p;};
				i++;
			}
		}
	}
	
	
	//Render ghost ball
	public static void render() {
		GL11.glColor3f(0, 1, 0);
		ShapeRenderer.draw(ghost);
		try {
			for(PointOfPoint p : hitPoint) {
				Render.pointLine(p.p0, p.p1, Colors.GREEN);
			}
		}catch(Exception e) {}
		
	}
	
}
