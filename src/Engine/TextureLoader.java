package Engine;
import org.blackoutburst.utils.Loader;
import org.newdawn.slick.opengl.Texture;

public class TextureLoader {

	public static Texture player, light, texture, 
	s0,s1,s2,s3,s4,s5,s6,s7,s8,s9;
	
	//Load texture
	public static void load() {
		player = Loader.loadPNG("res/texture/p");
		light = Loader.loadPNG("res/texture/light");
		s0 = Loader.loadPNG("res/texture/0");
		s1 = Loader.loadPNG("res/texture/1");
		s2 = Loader.loadPNG("res/texture/2");
		s3 = Loader.loadPNG("res/texture/3");
		s4 = Loader.loadPNG("res/texture/4");
		s5 = Loader.loadPNG("res/texture/5");
		s6 = Loader.loadPNG("res/texture/6");
		s7 = Loader.loadPNG("res/texture/7");
		s8 = Loader.loadPNG("res/texture/8");
		s9 = Loader.loadPNG("res/texture/9");
	}
	
	
}
