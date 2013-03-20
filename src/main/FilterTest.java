package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import javax.media.jai.JAI;
import javax.media.jai.KernelJAI;
import javax.media.jai.PlanarImage;

public class FilterTest {
	ArrayList<String> captureList;
	PlanarImage image;
	PlanarImage editImg;
	String imageInfo;
	int userChoice;

	public FilterTest() {
		
		loadImg();
	}

	public void loadImg() {
		this.image = JAI.create("fileload", captureList.get(0));
		// Get some information about the image
		this.imageInfo = "Dimensions: " + image.getWidth() + "x"
				+ image.getHeight() + " Bands:" + image.getNumBands();
		editImg = filterImg(image, userChoice);
	}

	public PlanarImage filterImg(PlanarImage img, int choice) {
		PlanarImage tmp_img;
		// Looks at the filterchoice
		switch (choice) {
		// Chooses the gradient filter for the input image
		case 0:
			float data_h[] = new float[] { 1.0F, 0.0F, -1.0F, 1.414F, 0.0F,
					-1.414F, 1.0F, 0.0F, -1.0F };
			float data_v[] = new float[] { -1.0F, -1.414F, -1.0F, 0.0F, 0.0F,
					0.0F, 1.0F, 1.414F, 1.0F };
			KernelJAI kern_h = new KernelJAI(3, 3, data_h);
			KernelJAI kern_v = new KernelJAI(3, 3, data_v);
			// Create the Gradient operation.
			return tmp_img = (PlanarImage) JAI.create("gradientmagnitude",
					image, kern_h, kern_v);
			// Choose the image smoothing filter
		case 1:
			int kernelSize = 15;

			float[] kernelMatrix = new float[kernelSize * kernelSize];

			for (int k = 0; k < kernelMatrix.length; k++)

				kernelMatrix[k] = 1.0f / (kernelSize * kernelSize);
			KernelJAI kernel = new KernelJAI(kernelSize, kernelSize,
					kernelMatrix);
			return tmp_img = JAI.create("convolve", img, kernel);
			// Edge Detection filter
		case 2:
			float[] kernelMatrix_0 = { -1, -2, -1,

			0, 0, 0, 1, 2, 1 };
			KernelJAI kernel_0 = new KernelJAI(3, 3, kernelMatrix_0);
			return tmp_img = JAI.create("convolve", img, kernel_0);
			// Inverting an RGB image
		case 3:
			return tmp_img = JAI.create("bandselect", img,
					new int[] { 2, 1, 0 });/* Edit the values to use different multiplier*/
		case 4:
			//Yet to come
		default:
			return img;
		}
	}
	public PlanarImage getImg(){
		return editImg;
	}
	public String getImgInfo(){
		return imageInfo;
	}
	public void setImg(String str){
		if(!str.equals("") || !str.equals(null)){
		captureList.add(Controller.);
		}
		else
			System.out.println("No image added quals 0");
	}
	public void setChoice(int userChoice){
		this.userChoice = userChoice;
	}
	
}
