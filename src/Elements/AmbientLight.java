/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class AmbientLight extends Light {

	protected double ka;
	
	// ***************** Constructors ********************** //	
	public AmbientLight() {
		super();//for deafult color
		this.ka = 0.1;//נתון
	}
	public AmbientLight(double _ka) {
		super();//for deafult color
		this.ka = _ka;
	}

	public AmbientLight(AmbientLight l1) {
		super(l1);//in order to copy the color from "l1" to this
		this.ka =l1.getKa();
	}
	public AmbientLight(double k,Color c) {
		super(c);
		this.ka =k;
	}

	// ***************** Getters/Setters ********************** //
	public double getKa() {
		return ka;
	}
	public void setKa(double ka) {
		this.ka = ka;
	}
	
	// ***************** Administration  ******************** //
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (Double.doubleToLongBits(ka) != Double.doubleToLongBits(other.ka))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AmbientLight: ka=" + ka;
	}
	
	//***************** Operations ******************** // 

	@Override
	public Color getIntensity(Point3D point) 
	{
		//color*ka
		int red=(int)(ka*color.getRed());
		int green=(int)(ka*color.getGreen());
		int blue=(int)(ka*color.getBlue());
		return(new Color(red,green,blue));
	}

	public Vector getL(Point3D point)//return a default vector
	{
		return new Vector();//(0,0,0)
	}
}
