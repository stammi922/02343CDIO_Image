package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.media.jai.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import com.sun.media.jai.widget.DisplayJAI;

public class TestClass {
	public static void main(String[] args) {
		// Load the image which file name was passed as the first argument to
	    // the application.
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
		String[] imgList = new String[1];
		imgList[0] = "test.jpg"; 
	    PlanarImage image = JAI.create("fileload", imgList[0]);
	    // Get some information about the image
	    String imageInfo =
	      "Dimensions: "+image.getWidth()+"x"+image.getHeight()+
	      " Bands:"+image.getNumBands();
	    // Create a frame for display.
	    JFrame frame = new JFrame();
	    frame.setTitle("DisplayJAI: "+imgList[0]);
	    // Get the JFrame’s ContentPane.	
	    float data_h[] = new float[] { 1.0F, 0.0F, -1.0F,
	    		1.414F, 0.0F, -1.414F,
	    		1.0F, 0.0F, -1.0F};
	    		float data_v[] = new float[] {-1.0F, -1.414F, -1.0F,
	    		0.0F, 0.0F, 0.0F,
	    		1.0F, 1.414F, 1.0F};
	    		KernelJAI kern_h = new KernelJAI(3,3,data_h);
	    		KernelJAI kern_v = new KernelJAI(3,3,data_v);
	    		// Create the Gradient operation.
	    		PlanarImage temp_img =
	    		(PlanarImage)JAI.create("gradientmagnitude", image,
	    		kern_h, kern_v);
	    		
	    		// Display the image.
	    		
	    Container contentPane = frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());
	    // Create an instance of DisplayJAI.
	    DisplayJAI dj = new DisplayJAI(temp_img);
	    // Add to the JFrame’s ContentPane an instance of JScrollPane
	    // containing the DisplayJAI instance.
	    contentPane.add(new JScrollPane(dj),BorderLayout.CENTER);
	    // Add a text label with the image information.
	    contentPane.add(new JLabel(imageInfo),BorderLayout.SOUTH);
	    // Set the closing operation so the application is finished.
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(width, height); // adjust the frame size.
	    frame.setVisible(true); // show the frame.

	}

}
