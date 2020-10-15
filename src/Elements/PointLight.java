/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Elements;

import java.awt.Color;

import Primitives.Point3D;
import Primitives.Vector;

public class PointLight extends Light {

	protected Point3D position;
	protected double kc;
	protected double kl;
	protected double kq;
	
	// ***************** Constructors ********************** //
	public PointLight(Point3D position, double kc, double kl, double kq,Color color) {
		super(color);
		this.position = position;
		this.kc = kc;
		this.kl = kl;
		this.kq = kq;
	}
	public PointLight(PointLight l) {
		super(l);//in order to copy the color from "l" to this
		this.position =new Point3D(l.getPosition());
		this.kc = l.getKc();
		this.kl = l.getKl();
		this.kq = l.getKq();
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D getPosition() {
		return position;
	}
	public void setPosition(Point3D position) {
		this.position = position;
	}
	public double getKc() {
		return kc;
	}
	public void setKc(double kc) {
		this.kc = kc;
	}
	public double getKl() {
		return kl;
	}
	public void setKl(double kl) {
		this.kl = kl;
	}
	public double getKq() {
		return kq;
	}
	public void setKq(double kq) {
		this.kq = kq;
	}

	
	// ***************** Administration  ******************** //
	
	@Override
	public String toString() {
		return "PointLight [position=" + position + ", kc=" + kc + ", kl=" + kl + ", kq=" + kq + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(kc) != Double.doubleToLongBits(other.kc))
			return false;
		if (Double.doubleToLongBits(kl) != Double.doubleToLongBits(other.kl))
			return false;
		if (Double.doubleToLongBits(kq) != Double.doubleToLongBits(other.kq))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
	
	//***************** Operations ******************** // 

	@Override
	public Color getIntensity(Point3D point) throws Exception {
		double d=point.distance(position);//d=point-position
		double tmp=((kc)+kl*d+kq*(Math.pow(d, 2)));//tmp=kc+kl*d+kq_d^2
		if(tmp==0)
			throw new Exception();
		if(tmp<1)
			tmp=1;
		tmp=1/tmp;//tmp=1/(kc+kl*d+kq_d^2)
		Color c=scaleColor(color,tmp);//color*1/(kc+kl*d+kq_d^2)
		return c;//color*1/(kc+kl*d+kq_d^2)
	}
	
	public Vector getL(Point3D point) throws Exception//this function returns the direction between the position point to the point parameter
    {
		Point3D point2=new Point3D(point);
		point2.substract(new Vector(position));
		Vector h=new Vector(point2);
		h.normalize();
    	return new Vector(h);
    }
	private Color scaleColor(Color color, double n)//this function returns the result of scale*colors
    //if one of the RGB is bigger than 255, it puts in this field 255
    {
		double red=color.getRed()*n;
    	if(red>255)
    		red=255;
    	double green=color.getGreen()*n;
    	if(green>255)
    		green=255;
    	double blue=color.getBlue()*n;
    	if(blue>255)
    		blue=255;
    	return new Color((int)red,(int)green,(int)blue);
    }
}
