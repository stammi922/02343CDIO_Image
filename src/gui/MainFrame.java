package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.media.jai.PlanarImage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import main.Controller;
import main.FilterTest;

import com.sun.media.jai.widget.DisplayJAI;

public class MainFrame {
	PlanarImage dispImg;
	FilterTest filteredImg;
	int width;
	int height;
	Controller cntrl = new Controller();
	
	public MainFrame() {
		test();
		detectDisplayRes();
		init();
	}
	public void init(){
		//Test
		 JFrame frame = new JFrame();
		 frame.setTitle("DisplayJAI: "+dispImg);
		Container contentPane = frame.getContentPane();
	    contentPane.setLayout(new BorderLayout());
	    // Create an instance of DisplayJAI.
	    DisplayJAI dj = new DisplayJAI(cntrl.getFilteredImage());
	    // Add to the JFrame’s ContentPane an instance of JScrollPane
	    // containing the DisplayJAI instance.
	    contentPane.add(new JScrollPane(dj),BorderLayout.CENTER);
	    // Add a text label with the image information.
	    contentPane.add(new JLabel(cntrl.getImageInfo()),BorderLayout.SOUTH);
	    // Set the closing operation so the application is finished.
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(width, height); // adjust the frame size.
	    frame.setVisible(true); // show the frame.
	}
	public void test(){
		cntrl.setCaptureList("test.jpg");
		cntrl.setChoice(1);
	}
	public void detectDisplayRes() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		this.width = gd.getDisplayMode().getWidth();
		this.height = gd.getDisplayMode().getHeight();
	}
}
