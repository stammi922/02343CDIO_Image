package main;

import gui.MainFrame;

import java.awt.image.BufferedImage;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class Main {

	public static void main(String[] args) {
//		JFrame.setDefaultLookAndFeelDecorated(true);
//		JDialog.setDefaultLookAndFeelDecorated(true);
//
//		try {
//			UIManager.setLookAndFeel(new MetalLookAndFeel());
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}
//
//		new initFrame();
//		   FrameGrabber grabber = new FrameGrabber();
//		    if (grabber.init()==true) {
//		        BufferedImage frame = grabber.grab();
//		    }
		MainFrame main = new MainFrame();
	}

}
