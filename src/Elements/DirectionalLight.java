/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Elements;

import java.awt.Color;

import Primitives.*;

public class DirectionalLight extends Light {

	protected Vector direction;
	// ***************** Constructors ********************** //	
	
	public DirectionalLight(Vector direction,Color color) {
		super(color);
		this.direction = direction;
	}
	
	public DirectionalLight(DirectionalLight l) {
		super(l);//in order to copy the color from "l" to this
		this.direction = new Vector(l.getDirection());
	}

	// ***************** Getters/Setters ********************** //
	public Vector getDirection() {
		return direction;
	}


	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	
	// ***************** Administration  ******************** //
	
	
	@Override
	public Color getIntensity(Point3D point) {//return color(Il=I)
		return new Color(color.getRed(),color.getGreen(),color.getBlue());
	}


    public Vector getL(Point3D point)
    {
    	return new Vector(direction);
    }


	

	
}
