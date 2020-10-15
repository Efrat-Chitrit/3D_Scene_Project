/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.*;

public class Sphere extends Geometry {
 
	protected double radius;
    protected Point3D p;
 
 
//***************** Constructors ********************** //
public Sphere() {//constructor
	super();
	this.radius =0;
	this.p = new Point3D();//(0,0,0)
}
public Sphere(double radius, Point3D p) {//parameter constructor 
	super();
	this.radius = radius;
	this.p = p;

}
public Sphere(double radius, Point3D p,Color color,Material material) {//parameter constructor 
	super(color,material);
	this.radius = radius;
	this.p = p;

}
public Sphere(Sphere s) {//copy constructor
	super((Geometry) s);//in order to copy the emission and the material from "s" to this
	this.radius = s.getRadius();
	this.p = new Point3D(s.getP());
}
 
//***************** Getters/Setters ********************** // 

public double getRadius() {
	return radius;
}
public void setRadius(double radius) {
	this.radius = radius;
}
public Point3D getP() {
	return p;
}
public void setP(Point3D p) {
	this.p = p;
}

//***************** Administration  ******************** //
	@Override
	public String toString() {
		return "p= "+p.toString()+", radius= "+radius;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	
	//***************** Operations ******************** // 

	public Vector getNormal(Point3D point) throws Exception {//this function return the normal vector in a specific point
		// TODO Auto-generated method stub
		Point3D temp1=new Point3D(point);
		temp1.substract(new Vector(new Point3D(p)));//the normal it's the vector from the point of the sphere and the point the function get
		Vector result= new Vector(temp1);
		result.normalize();//normalize the normal
		return result;
	}



	




	public List<Point3D> findIntersections(Ray r)//this function return the intersection of the sphere with the ray r 
{
	Point3D center=new Point3D(p);
	Vector start=new Vector(r.getStart());
	center.substract(start);
	Vector L=new Vector(center);//L=O-P0
	double tm=L.dotProduct(r.getDirection());//tm=L*V
	
	double d=Math.sqrt(Math.pow(L.length(),2)-Math.pow(tm,2));//d=(|L|^2-tm^2)^0.5
	List<Point3D>lst=new ArrayList<Point3D>();
	if(d<=radius)
	{
		double th=Math.sqrt(Math.pow(radius, 2)-Math.pow(d, 2));//(r^2-d^2)^0.5
		double t1=tm-th;
		double t2=tm+th;
		if(t1>0)
		{
			Vector V=new Vector(r.getDirection());
			V.scale(t1);
			Point3D P1=new Point3D(r.getStart());
			P1.add(V);//P1=P0+t1*V
			lst.add(P1);
		}	
		if(t2>0)
		{
			Vector V1=new Vector(r.getDirection());
			V1.scale(t2);
			Point3D P2=new Point3D(r.getStart());
			P2.add(V1);//P2=P0+t2*V
			lst.add(P2);
		
		}
	}
	return lst;
		
}
	
}
