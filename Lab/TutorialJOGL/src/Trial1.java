import javax.swing.JFrame;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

public class Trial1 implements GLEventListener{

	private GLU glu = new GLU();

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
	} 

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		final GL2 gl = drawable.getGL().getGL2();
		if(height < 0) {
			height = 1;
		}
		
		float h= (float)width / (float)height;
		gl.glViewport(2, -2, 2, -2);
		gl.glBegin(GL2.GL_LINE_LOOP);
		gl.glVertex3d(0.5, 0.1, 0);
		gl.glVertex3d(-0.1,0.1,0);

		gl.glVertex3d(-0.1,-0.1,0);
		gl.glVertex3d(0.5,-0.1,0);
		gl.glEnd();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		glcanvas.setSize(400, 400);

		Trial1 ob1 = new Trial1();
		glcanvas.addGLEventListener(ob1);
		final JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.getContentPane().add(glcanvas);
		frame.setVisible(true);
		frame.setLocation(800,350);
	}

}
