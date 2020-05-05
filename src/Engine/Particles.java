package Engine;
import org.blackoutburst.graphics.Colors;
import org.blackoutburst.utils.Vector2f;
import org.newdawn.slick.opengl.Texture;

public abstract class Particles {
	
	protected Texture texture;
	protected float x;
	protected float y;
	protected int width;
	protected int height;
	protected Colors color;
	protected boolean removed;
	protected int rotation;
	protected float alpha;
	protected int randomRotation;
	protected boolean fade;
	protected Vector2f direction;
	
	
	//Constructor
	public Particles(Texture texture, float x, float y, int width, int height, Colors color, boolean removed, int rotation, float alpha, int randomRotation, boolean fade, Vector2f direction) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.removed = removed;
		this.rotation = rotation;
		this.alpha = alpha;
		this.randomRotation = randomRotation;
		this.fade = fade;
		this.direction = direction;
	}
	
	
	//Update methods
	protected abstract void update();
}
