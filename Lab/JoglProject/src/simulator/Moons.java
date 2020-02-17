package simulator;

import com.jogamp.opengl.*;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.texture.Texture;

public class Moons {
	GL2 gl;
	GLU glu;
	Texture harshTexture;
	float angle;
	float distance;
	float rotationAngle = 0;
	float speed = 0;
	float radius;

	public Moons(GL2 gl, GLU glu, Texture harshTexture, float speed, float distance, float radius) {
		this.gl = gl;
		this.glu = glu;
		this.harshTexture = harshTexture;
		this.speed = speed;
		this.distance = distance;
		this.radius = radius;
	}
	public void display() {
		gl.glPushMatrix();
		angle = (angle + speed) % 360f;
		float x = (float) Math.sin(Math.toRadians(angle)) * distance;
		float y = (float) Math.cos(Math.toRadians(angle)) * distance;
		float z = 0;
		gl.glTranslatef(x, y, z);
		harshTexture.enable(gl);
		harshTexture.bind(gl);
		rotationAngle = 30;
		gl.glPushMatrix();
		gl.glRotatef(rotationAngle, 0.2f, 0.1f, 0);
		GLUquadric harsh = glu.gluNewQuadric();
		glu.gluQuadricTexture(harsh, true);
		glu.gluSphere(harsh, radius, 16, 16);
		glu.gluDeleteQuadric(harsh);
		gl.glPopMatrix();
		gl.glPopMatrix();
	}
}