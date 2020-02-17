import javax.swing.JFrame;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
public class LineDrawing implements GLEventListener {
	private GLU glu; 
	public static void main(String[] args) {
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		LineDrawing b = new LineDrawing();
		glcanvas.addGLEventListener(b);
		glcanvas.setSize(400,400);
		final JFrame jframe = new JFrame("Basic Frame");
		jframe.add(glcanvas);
		jframe.setSize(800,800);
		jframe.setVisible(true);
	}
	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
			drawLine(gl, 0,0,100,100);
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
		 	
	}

	@Override
	public void init(GLAutoDrawable gld) {
		// TODO Auto-generated method stub
		GL2 gl = gld.getGL().getGL2();
		glu = new GLU();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glViewport(-250, -150, 250, 150);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-250.0,250.0,-150.0,150.0);
		
	}
	private void drawLine(GL2 gl, int x1,int y1,int x2,int y2){
		gl.glPointSize(1.0f);
		gl.glBegin(GL2.GL_POINT_BIT);
		int dx=(x2-x1),dy=(y2-y1),x=x1,y=y1,p=2*dy-dx;
		while(x<x2){
			if(p<0)
				p += 2*dy;
			else{
				p += 2*dy - 2*dx;
				y++;
			}
			x++;
			gl.glVertex2i(x, y);
		}
		gl.glEnd();
	}
	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,int arg4) {
		// TODO Auto-generated method stub	
	}
}