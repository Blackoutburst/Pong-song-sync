package Engine;
import org.blackoutburst.graphics.Colors;
import org.blackoutburst.utils.Vector2f;
import org.newdawn.slick.opengl.Texture;

public class ParticlesTouch extends Particles{


	public ParticlesTouch(Texture texture, float x, float y, int width, int height, Colors color, boolean removed, int rotation, float alpha, int randomRotation, boolean fade, Vector2f direction) {
		super(texture, x, y, width, height, color, removed, rotation, alpha, randomRotation, fade, direction);
	}

	//Update the particles
	protected void update() {

		x += direction.x * 2;
		y += direction.y * 2;

		color = new Colors(color.red, color.green, color.blue, alpha);
		alpha -= 0.01f;
		
		if(alpha <= 0) {
			removed = true;
		}
	}

}
