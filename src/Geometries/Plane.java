/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.*;

public class Plane extends Geometry implements Comparable<Plane>,FlatGeometry{

	protected Vector normal;
	protected Point3D p;
	
	// ***************** Constructors ********************** //
	public Plane() {//default constructor
		super();
		this.normal = new Vector();//(0,0,0)
		this.p = new Point3D();//(0,0,0)
	}
	
	public Plane(Vector vector, Point3D p) {//parameter constructor 
		super();
		this.normal = vector;
		this.p = p;
	}
	
	public Plane(Vector vector, Point3D p,Material material,Color color) {//parameter constructor 
		super(color,material);
		this.normal = vector;
		this.p = p;
	}
	
	public Plane(Plane plane) {//copy constructor
		super((Geometry)plane);//in order to copy the emission and the material from "plane" to "p"
		this.normal = new Vector(plane.getNormal());
		this.p = new Point3D(plane.getP());
	}
	// ***************** Getters/Setters ********************** // 
	public Vector getNormal() {
		return normal;
	}
	
	public void setNormal(Vector vector) {
		this.normal = vector;
	}
	public Point3D getP() {
		return p;
	}
	public void setP(Point3D p) {
		this.p = p;
	}
	
	
	public Vector getNormal(Point3D point) throws Exception {//this function return the normal vector in a specific point
		// TODO Auto-generated method stub
		Vector result=new Vector(normal);
		result.normalize();
		return result;//return the normal of the plane-after normalize
	}
	
	// ***************** Administration  ******************** //
	
	@Override
	public int compareTo(Plane plane)////return 0 if this plane is equal to the plane parameter, else it returns 1
	{
		if(normal.compareTo(plane.getNormal())==0 && p.compareTo(plane.getP())==0)
		   return 0;
		return 1;
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (normal == null) {
			if (other.normal != null)
				return false;
		} else if (!normal.equals(other.normal))
			return false;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "vector= "+normal.toString()+ ", p= "+p.toString();
	}
	
	// ***************** Operations ******************** // 

	public List<Point3D> findIntersections(Ray r)//this function return the intersection of the plane with the ray r 
	{
		Vector v=new Vector(normal);
		v.scale(-1);//-N
		Point3D p1=new Point3D(r.getStart());//p1=P0
		p1.substract(new Vector(new Point3D(p)));//p1=P0-Q0
		Vector v1=new Vector(p1);//V1=P0-Q0
		List<Point3D> intersections=new ArrayList<Point3D>();
		double help=(normal.dotProduct(r.getDirection()));//help=N*V
		if(help==0)
			return intersections;
		double tmp=1/help;//tmp=1/(N*V)
		v1.scale(tmp);//v1=(P0-Q0)/(N*V)
		double t=v.dotProduct(v1);//t=-N*(P0-Q0)/(N*V)
		if(t>0)
		{Point3D result=new Point3D(r.getStart());//result=P0
		Vector direction=new Vector(r.getDirection());//direction=V
		direction.scale(t);//tV
		result.add(direction);//result=P0+tV
		intersections.add(result);//add point
		}
		return(intersections);
	
	}

}
