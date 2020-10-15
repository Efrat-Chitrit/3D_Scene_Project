/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Elements;

import java.awt.Color;

import Primitives.*;

public abstract class Light {

	protected Color color;
	
	// ***************** Constructors ********************** //
	public Light() {
		super();
		this.color = new Color(255,255,255);//white
	}
	public Light(Color color) {
		super();
		this.color = color;
	}
	public Light(Light light) {
		super();
		this.color =new Color(light.getColor().getRed(),light.getColor().getGreen(),
				light.getColor().getBlue());
	}

	// ***************** Getters/Setters ********************** //
	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
	
	// ***************** Administration  ******************** //

	public abstract Color getIntensity(Point3D point) throws Exception;//returns the intensity in a spesific point
	
	
	 public abstract Vector getL(Point3D point) throws Exception;//returns the vector between the light source and the point parameter 
	 //(if the light has no L, it returns a default vector)
}
