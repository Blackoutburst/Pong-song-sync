package Engine;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

public class ParticlesManager {
	public static List<Particles> particles = new ArrayList<Particles>();
	
	public static void update() {

		
		//Update & Render particles
		
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		
	//	GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		TextureLoader.light.bind();
		GL11.glBegin(GL11.GL_QUADS);
		for(Particles p : particles) {
			if(!p.removed) {
				p.update();
				
				
				GL11.glColor4f(p.color.red, p.color.green, p.color.blue, p.color.alpha);
		        GL11.glTexCoord2f((0), (0));GL11.glVertex2f(p.x - p.width/2, (p.y - p.height/2));
		        GL11.glTexCoord2f((1), (0));GL11.glVertex2f((p.x - p.width/2) + p.width, (p.y - p.height/2));
		        GL11.glTexCoord2f((1), (1));GL11.glVertex2f((p.x - p.width/2) + p.width, (p.y - p.height/2) + p.height);
		        GL11.glTexCoord2f((0), (1));GL11.glVertex2f((p.x - p.width/2), (p.y - p.height/2) + p.height);
				
			        GL11.glColor4f(p.color.red, p.color.green, p.color.blue, p.color.alpha);
			        GL11.glTexCoord2f((0), (0));GL11.glVertex2f(p.x - p.width/4, (p.y - p.height/4));
			        GL11.glTexCoord2f((1), (0));GL11.glVertex2f((p.x - p.width/4) + p.width/2, (p.y - p.height/4));
			        GL11.glTexCoord2f((1), (1));GL11.glVertex2f((p.x - p.width/4) + p.width/2, (p.y - p.height/4) + p.height/2);
			        GL11.glTexCoord2f((0), (1));GL11.glVertex2f((p.x - p.width/4), (p.y - p.height/4) + p.height/2);
			        
			        GL11.glColor4f(p.color.red, p.color.green, p.color.blue, p.color.alpha);
			        GL11.glTexCoord2f((0), (0));GL11.glVertex2f((p.x - p.width), (p.y - p.height));
			        GL11.glTexCoord2f((1), (0));GL11.glVertex2f((p.x - p.width) + p.width*2, (p.y - p.height));
			        GL11.glTexCoord2f((1), (1));GL11.glVertex2f((p.x - p.width) + p.width*2, (p.y - p.height) + p.height*2);
			        GL11.glTexCoord2f((0), (1));GL11.glVertex2f((p.x - p.width), (p.y - p.height) + p.height*2);
			}
		}
		GL11.glEnd();
		
		
		//Render particles light;
		/*
		GL11.glBegin(GL11.GL_QUADS);
		for(Particles p : particles) {
			if(!p.removed) {
			}
		}
		GL11.glEnd();
*/
		//Remove dead particles
		int size = particles.size();
			for(int i = 0; i < size; i ++) {
				Particles p = particles.get(i);
				if(p.removed) {
					particles.remove(p);
					size--;
				}
			}
		
	}
	
}
