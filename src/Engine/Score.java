package Engine;

import Main.Main;
import org.blackoutburst.graphics.Colors;
import org.blackoutburst.graphics.Render;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Score {

	public static void render() {
			
		String p1 = String.valueOf(Main.score1);
		String p2 = String.valueOf(Main.score2);
		
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		//Render player 1 score
		for(int i = 0; i < 2; i++) {
			if(p1.length() == 1) {
				switch(p1) {
					case "1": Render.quadS(TextureLoader.s1, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case "2": Render.quadS(TextureLoader.s2, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case "3": Render.quadS(TextureLoader.s3, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case "4": Render.quadS(TextureLoader.s4, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case "5": Render.quadS(TextureLoader.s5, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case "6": Render.quadS(TextureLoader.s6, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case "7": Render.quadS(TextureLoader.s7, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case "8": Render.quadS(TextureLoader.s8, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case "9": Render.quadS(TextureLoader.s9, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					default : Render.quadS(TextureLoader.s0, Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
				}
			}else {
				switch(p1.charAt(0)) {
					case '1': Render.quadS(TextureLoader.s1, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '2': Render.quadS(TextureLoader.s2, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '3': Render.quadS(TextureLoader.s3, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '4': Render.quadS(TextureLoader.s4, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '5': Render.quadS(TextureLoader.s5, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '6': Render.quadS(TextureLoader.s6, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '7': Render.quadS(TextureLoader.s7, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '8': Render.quadS(TextureLoader.s8, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '9': Render.quadS(TextureLoader.s9, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					default : Render.quadS(TextureLoader.s0, Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
				}
				switch(p1.charAt(1)) {
					case '1': Render.quadS(TextureLoader.s1, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '2': Render.quadS(TextureLoader.s2, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '3': Render.quadS(TextureLoader.s3, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '4': Render.quadS(TextureLoader.s4, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '5': Render.quadS(TextureLoader.s5, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '6': Render.quadS(TextureLoader.s6, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '7': Render.quadS(TextureLoader.s7, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '8': Render.quadS(TextureLoader.s8, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					case '9': Render.quadS(TextureLoader.s9, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
					default : Render.quadS(TextureLoader.s0, Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(0,0.5f,1), 0); break;
				}
			}
			
			
			//Same for player 2
			if(p2.length() == 1) {
				switch(p2) {
					case "1": Render.quadS(TextureLoader.s1, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case "2": Render.quadS(TextureLoader.s2, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case "3": Render.quadS(TextureLoader.s3, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case "4": Render.quadS(TextureLoader.s4, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case "5": Render.quadS(TextureLoader.s5, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case "6": Render.quadS(TextureLoader.s6, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case "7": Render.quadS(TextureLoader.s7, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case "8": Render.quadS(TextureLoader.s8, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case "9": Render.quadS(TextureLoader.s9, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					default : Render.quadS(TextureLoader.s0, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
				}
			}else {
				switch(p2.charAt(0)) {
					case '1': Render.quadS(TextureLoader.s1, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '2': Render.quadS(TextureLoader.s2, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '3': Render.quadS(TextureLoader.s3, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '4': Render.quadS(TextureLoader.s4, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '5': Render.quadS(TextureLoader.s5, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '6': Render.quadS(TextureLoader.s6, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '7': Render.quadS(TextureLoader.s7, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '8': Render.quadS(TextureLoader.s8, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '9': Render.quadS(TextureLoader.s9, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					default : Render.quadS(TextureLoader.s0, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 - Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
				}
				switch(p2.charAt(1)) {
					case '1': Render.quadS(TextureLoader.s1, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '2': Render.quadS(TextureLoader.s2, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '3': Render.quadS(TextureLoader.s3, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '4': Render.quadS(TextureLoader.s4, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '5': Render.quadS(TextureLoader.s5, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '6': Render.quadS(TextureLoader.s6, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '7': Render.quadS(TextureLoader.s7, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '8': Render.quadS(TextureLoader.s8, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					case '9': Render.quadS(TextureLoader.s9, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
					default : Render.quadS(TextureLoader.s0, Display.getWidth() - Display.getWidth()/4 - Display.getHeight()/12 + Display.getHeight()/12, Display.getHeight()/2 - Display.getHeight()/12, Display.getHeight()/6, Display.getHeight()/6, new Colors(1,0.5f,0), 0); break;
				}
			}
		}
		
	}
}
