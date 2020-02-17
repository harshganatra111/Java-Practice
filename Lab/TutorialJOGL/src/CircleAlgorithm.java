import java.util.*;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.*;

import javax.swing.JFrame;

public class CircleAlgorithm implements GLEventListener
{
	Scanner in =new Scanner(System.in);
public void display (GLAutoDrawable drawable) {
int x=in.nextInt();
int y=in.nextInt();
int c=in.nextInt();
GL2 gl = drawable. getGL(). getGL2();
gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
drawCircle(gl,x,y,c);
}
public void dispose(GLAutoDrawable arg0)
{
}
public void init(GLAutoDrawable gld)
{
GL2 gl=gld.getGL().getGL2();	
GLU glu= new GLU();
gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
gl.glMatrixMode(GL2.GL_PROJECTION);
gl.glLoadIdentity();
glu.gluOrtho2D(-250.0,250.0,-150.0,150.0);

}
private void drawCircle(GL2 gl, int x1, int y1, int r) {
gl.glPointSize(1.0f);
gl.glBegin(GL2.GL_POINTS);
int x=0,y=r,p=1-r;
while(x<y)
{
  if(p<0)
	p+=2*x+5;
else {
	p+=2*(x-y)+5;
	y--;
}
x++;
	circleSymmetry(gl,x1,y1,x,y);
	System.out.println("x:" + x + "Y:" + y);
}
gl.glEnd();//end drawing of points
}

public void circleSymmetry(GL2 gl,int xc,int yc,int x,int y)
{
gl.glColor3f(1f,0f,0f);
gl.glVertex2i(xc+x , yc+y );
gl.glVertex2i(xc-x , yc+y );
gl.glVertex2i(xc+x , yc-y );
gl.glVertex2i(xc-x , yc-y );
gl.glVertex2i(xc+y , yc+x );
gl.glVertex2i(xc+y , yc-x ); 
gl.glVertex2i(xc-y , yc+x );
gl.glVertex2i(xc-y , yc-x );
}
public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4)
{
}
public static void main(String[] args)
{
// TODO Auto-generated method stub

final GLProfile profile=GLProfile.get(GLProfile.GL2);
GLCapabilities capabalities= new GLCapabilities(profile);
final GLCanvas glcanvas= new GLCanvas(capabalities);
CircleAlgorithm c = new CircleAlgorithm();
glcanvas.addGLEventListener(c);
glcanvas.setSize(400,400);
final JFrame Frame=new JFrame("basic frame");
Frame.add(glcanvas);
Frame.setSize(1920,1080);
Frame.setVisible(true);

}
}