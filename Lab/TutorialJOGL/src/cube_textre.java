import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
public class cube_textre implements GLEventListener{
private GLU glu = new GLU();
private float xrot,yrot,zrot;
private int texture;
Texture tex;
private static void drawface(GL2 gl)
{
gl.glBegin(GL2.GL_QUADS);
gl.glNormal3f(0,0,1);
gl.glTexCoord2d(0, 0);
gl.glVertex3d(-1, -1, 1);
gl.glTexCoord2d(1, 0);
gl.glVertex3d(1, -1, 1);
gl.glTexCoord2d(1, 1);
gl.glVertex3d(1, 1, 1);
gl.glTexCoord2d(0, 1);
gl.glVertex3d(-1, 1, 1);
gl.glEnd();
}
public void display( GLAutoDrawable drawable ) {
final GL2 gl = drawable.getGL().getGL2();
gl.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT ); 
gl.glLoadIdentity();
// gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
//gl.glRotatef( rquad, 1.0f, 1.0f, 1.0f ); //
gl.glRotatef(xrot, 1.0f, 1.0f, 1.0f); 
gl.glRotatef(yrot, 0.0f, 1.0f, 0.0f);
gl.glRotatef(zrot, 0.0f, 0.0f, 1.0f);
gl.glPushMatrix();
gl.glColor3f(1,0,0);
drawface(gl);
gl.glPushMatrix();
gl.glRotated(90,1,0,0);
gl.glColor3f(0, 1, 0);
drawface(gl);
gl.glPopMatrix();
gl.glPushMatrix();
gl.glRotated(180,1,0,0);
gl.glColor3f(0, 0,1);
drawface(gl);
gl.glPopMatrix();
gl.glPushMatrix();
gl.glRotated(-90,1,0,0);
gl.glColor3f(1, 1, 0);
drawface(gl);
gl.glPopMatrix();

gl.glPushMatrix();
gl.glRotated(90,0,1,0);
gl.glColor3f(0, 1, 1);
drawface(gl);
gl.glPopMatrix();

gl.glPushMatrix();
gl.glRotated(-90,0,1,0);
gl.glColor3f(1, 1, 1);
drawface(gl);
gl.glPopMatrix();
gl.glPopMatrix();


//rquad -=1.0f;
xrot+=.1f;
yrot+=.1f;
zrot+=.1f;
}

public void dispose( GLAutoDrawable drawable ) {
// TODO Auto-generated method stub
}

public void init( GLAutoDrawable arg0 ) {

GL2 gl2 = arg0.getGL().getGL2();
gl2.glMatrixMode(GL2.GL_PROJECTION);
gl2.glOrtho(-2, 2, -2, 2, -2, 2); // simple orthographic projection
gl2.glMatrixMode(GL2.GL_MODELVIEW);
gl2.glClearColor( 0.5F, 0.5F, 0.5F, 1 );
//gl2.glEnable(GL2.GL_DEPTH_TEST);
gl2.glEnable(GL2.GL_TEXTURE_2D);
try
{
File im = new File("C:\\Users\\HARSH\\Desktop\\androidparty.jpg");
Texture t = TextureIO.newTexture(im, true);
texture= t.getTextureObject(gl2);
}
catch(IOException e)
{
e.printStackTrace();
}
}

public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {

}
public static void main( String[] args ) {
final GLProfile profile = GLProfile.get( GLProfile.GL2 );
GLCapabilities capabilities = new GLCapabilities( profile );
// The canvas 
final GLCanvas glcanvas = new GLCanvas( capabilities );
cube_textre cube = new cube_textre();
glcanvas.addGLEventListener( cube );
glcanvas.setSize( 400, 400 );
final JFrame frame = new JFrame ( " Textured cube" );
frame.getContentPane().add( glcanvas );
frame.setSize( frame.getContentPane().getPreferredSize() );
frame.setVisible( true );
final FPSAnimator animator = new FPSAnimator( glcanvas, 300,true );
animator.start();
}
}