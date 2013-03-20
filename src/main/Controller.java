package main;

import java.util.ArrayList;

import javax.media.jai.PlanarImage;

public class Controller {
	ArrayList<String> tmp_imgList;
	int choice;
	FilterTest filters;
	
	public Controller() {
		filters = new FilterTest();
	}
	public  PlanarImage getFilteredImage(){
		return  filters.getImg();
	}
	public String getImageInfo(){
		return filters.getImgInfo();
	}
	public void setCaptureList(String str){
		filters.setImg(str);
		System.out.println("Passed String"+tmp_imgList.get(0));
	}
	public void setChoice(int choice){
		filters.setChoice(choice);
	}
}
