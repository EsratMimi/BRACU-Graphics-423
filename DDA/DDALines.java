/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package opengl;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author sbiswas.amit
 */
public class DDALines implements GLEventListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     * @param gld
     */
    @Override
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    /**
     * Take care of drawing here.
     * @param drawable
     */
    @Override
    public void display(GLAutoDrawable drawable) { 
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        /*
         * put your code here
         */
        DDA(gl, -100, -50, 60, 70);
        DDA(gl, -200, -50, 60, 70);
        DDA(gl, -200, -50, -100, -50);
        

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }

    private void DDA(GL2 gl, int x1, int y1, int x2, int y2) {
       //write your own code
       gl.glPointSize(3.0f);
       gl.glColor3d(1, 0, 0);
       
       float m,x,y, dx,dy;
       dx=x2-x1;
       dy=y2-y1;
       m=dy/dx;
       x=x1;
       y=y1;
 
    	   if(m<1 && m>-1) {
    		   while(x<x2) {
    			   x=x+1;
    			   y=(y+m);
    			   gl.glBegin(GL2.GL_POINTS);

    		       gl.glVertex2d(x, y);
    		       gl.glVertex2d(x2, y2);	
    		       gl.glEnd();
    		   }
    	   }
    	   else {
    		   while(y<y2) {
    			   x=x+(1/m);
    			   y=y+1;
    			   gl.glBegin(GL2.GL_POINTS);

    		       gl.glVertex2d(x, y);
    		       gl.glVertex2d(x2, y2);	
    		       gl.glEnd();
    		   }
    		   
    	   }
       
      
    }
    
    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
}
