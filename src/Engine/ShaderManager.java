package Engine;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_ONE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_STENCIL_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_STENCIL_TEST;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUniform2f;
import static org.lwjgl.opengl.GL20.glUniform3f;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glValidateProgram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.blackoutburst.graphics.LightManager;
import org.blackoutburst.utils.Camera;
import org.lwjgl.opengl.Display;

public class ShaderManager {
	
	private static int fragmentShaderH = glCreateShader(GL_FRAGMENT_SHADER);
	private static int shaderProgramH = glCreateProgram();
	
	private static int fragmentShaderV = glCreateShader(GL_FRAGMENT_SHADER);
	private static int shaderProgramV = glCreateProgram();
	
	//Load shader
	public static void loadShaderVertical() {
		StringBuilder fragmentShaderSource = new StringBuilder();
		InputStream in = LightManager.class.getResourceAsStream("/shaderV.frag");
		try {
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			while ((line = reader.readLine()) != null) {
				fragmentShaderSource.append(line).append("\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		glShaderSource(fragmentShaderV, fragmentShaderSource);
		glCompileShader(fragmentShaderV);
		if (glGetShaderi(fragmentShaderV, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Fragment shader not compiled!");
		}

		glAttachShader(shaderProgramV, fragmentShaderV);
		glLinkProgram(shaderProgramV);
		glValidateProgram(shaderProgramV);


		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_STENCIL_TEST);

	}
	
	
	//Load Shader
	public static void loadShaderHorizontal() {
		StringBuilder fragmentShaderSource = new StringBuilder();
		InputStream in = LightManager.class.getResourceAsStream("/shaderH.frag");
		try {
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			while ((line = reader.readLine()) != null) {
				fragmentShaderSource.append(line).append("\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		glShaderSource(fragmentShaderH, fragmentShaderSource);
		glCompileShader(fragmentShaderH);
		if (glGetShaderi(fragmentShaderH, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Fragment shader not compiled!");
		}

		glAttachShader(shaderProgramH, fragmentShaderH);
		glLinkProgram(shaderProgramH);
		glValidateProgram(shaderProgramH);


		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_STENCIL_TEST);

	}
	
	//Render line method
	public static void renderSingleVLine(float x, float y, float red, float green, float blue, float scale) {
		
		if(x > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			glUseProgram(shaderProgramH);
			glUniform2f(glGetUniformLocation(shaderProgramH, "lightLocation"), x+Camera.getX(), Display.getHeight() - y-Camera.getY());
			glUniform3f(glGetUniformLocation(shaderProgramH, "lightColor"), red*scale, green*scale, blue*scale);
			glBlendFunc(GL_ONE, GL_ONE);
	
			glBegin(GL_QUADS); {
				glVertex2f(-Camera.getX(), -Camera.getY());
				glVertex2f(-Camera.getX(), -Camera.getY()+Display.getHeight());
				glVertex2f(-Camera.getX() +Display.getWidth(), -Camera.getY()+Display.getHeight());
				glVertex2f(-Camera.getX() +Display.getWidth(), -Camera.getY());
			} glEnd();
	
			glUseProgram(0);
			glClear(GL_STENCIL_BUFFER_BIT);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		}
	}


	//Render line method
	public static void renderSingleHLine(float x, float y, float red, float green, float blue, float scale) {
		if(x > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			glUseProgram(shaderProgramV);
			glUniform2f(glGetUniformLocation(shaderProgramV, "lightLocation"), x+Camera.getX(), Display.getHeight() - y-Camera.getY());
			glUniform3f(glGetUniformLocation(shaderProgramV, "lightColor"), red*scale, green*scale, blue*scale);
			glBlendFunc(GL_ONE, GL_ONE);
	
			glBegin(GL_QUADS); {
				glVertex2f(-Camera.getX(), -Camera.getY());
				glVertex2f(-Camera.getX(), -Camera.getY()+Display.getHeight());
				glVertex2f(-Camera.getX() +Display.getWidth(), -Camera.getY()+Display.getHeight());
				glVertex2f(-Camera.getX() +Display.getWidth(), -Camera.getY());
			} glEnd();
	
			glUseProgram(0);
			glClear(GL_STENCIL_BUFFER_BIT);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		}
	}
}
