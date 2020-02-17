
import com.jogamp.nativewindow.Capabilities;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.awt.GLJPanel;
import javax.swing.*;
import java.awt.*;
public class JOGL implements GLEventListener {
	
	public void display(GLAutoDrawable arg0)
	{
		
	}
	public void dispose(GLAutoDrawable arg0)
	{
		
	}
	public void init(GLAutoDrawable arg0)
	{
		
	}
	public void reshape(GLAutoDrawable arg0,int arg1,int arg2,int arg3,int arg4)
	{
		
	}
	

	public static void main(String[] args) 
	{
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		JOGL b = new JOGL();
		glcanvas.addGLEventListener(b);
		glcanvas.setSize(400,400);
		final JFrame frame = new JFrame("Basic Frame");
		frame.add(glcanvas);
		frame.setSize(800,800);
		frame.setVisible(true);	
	}
}
