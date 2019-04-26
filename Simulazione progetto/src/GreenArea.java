
public class GreenArea {
	
	public static final int N_PARAMETER = 10;
	private int zona;
	private int area;
	private int locID;
	private String locName;
	private String description;
	private String type;
	private String classification;
	private String classificationISTAT;
	private String owner;
	private double surface;
	
	// Constructor
	public GreenArea(int zona, int area, int locID, String locName, String description, String type,
			String classification, String classificationISTAT, String owner, double surface) {

		this.zona = zona;
		this.area = area;
		this.locID = locID;
		this.locName = locName;
		this.description = description;
		this.type = type;
		this.classification = classification;
		this.classificationISTAT = classificationISTAT;
		this.owner = owner;
		this.surface = surface;
	}
	
	public GreenArea() {}

	
	// Getters
	public int getZona() {
		return zona;
	}

	public int getArea() {
		return area;
	}

	public int getLocID() {
		return locID;
	}

	public String getLocName() {
		return locName;
	}

	public String getDescription() {
		return description;
	}

	public String getType() {
		return type;
	}

	public String getClassification() {
		return classification;
	}

	public String getClassificationISTAT() {
		return classificationISTAT;
	}

	public String getOwner() {
		return owner;
	}

	public double getSurface() {
		return surface;
	}
	
	public void setZona(int zona) {
		this.zona = zona;
	}


	public void setArea(int area) {
		this.area = area;
	}


	public void setLocID(int locID) {
		this.locID = locID;
	}


	public void setLocName(String locName) {
		this.locName = locName;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void setClassification(String classification) {
		this.classification = classification;
	}


	public void setClassificationISTAT(String classificationISTAT) {
		this.classificationISTAT = classificationISTAT;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public void setSurface(double surface) {
		this.surface = surface;
	}


	// ToString method
	@Override
	public String toString() {
		return "GreenArea [zona=" + zona + ", area=" + area + ", locID=" + locID + ", locName=" + locName
				+ ", description=" + description + ", type=" + type + ", classification=" + classification
				+ ", classificationISTAT=" + classificationISTAT + ", owner=" + owner + ", surface=" + surface + "mq]";
	}


}
