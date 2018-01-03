package ucm.onlinedvdstore.model;

public class DVDModel {
	private int id;
	private String dvdCategory;
	private String dvdName;
	private String dvdDescription;
	private double dvdPrice;
	private String imagePath;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDvdCategory() {
		return dvdCategory;
	}
	public void setDvdCategory(String dvdCategory) {
		this.dvdCategory = dvdCategory;
	}
	public String getDvdName() {
		return dvdName;
	}
	public void setDvdName(String dvdName) {
		this.dvdName = dvdName;
	}
	public String getDvdDescription() {
		return dvdDescription;
	}
	public void setDvdDescription(String dvdDescription) {
		this.dvdDescription = dvdDescription;
	}
	public double getDvdPrice() {
		return dvdPrice;
	}
	public void setDvdPrice(double dvdPrice) {
		this.dvdPrice = dvdPrice;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
