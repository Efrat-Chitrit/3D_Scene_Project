/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.*;

public class Triangle extends Geometry implements Comparable<Triangle> ,FlatGeometry{

	protected Point3D p1;
	protected Point3D p2;
	protected Point3D p3;
	// ***************** Constructors ********************** // 
	public Triangle() {//default constructor 
		super();
		this.p1 = new Point3D();
		this.p2 = new Point3D();
		this.p3 = new Point3D();
	}
	public Triangle(Point3D p1, Point3D p2, Point3D p3) {//parameter constructor 
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	public Triangle(Point3D p1, Point3D p2, Point3D p3,Color color, Material material) {//parameter constructor 
		super(color,material);
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	public Triangle(Triangle triangle) {//copy constructor
		super((Geometry) triangle);//in order to copy the emission and the material from "triangle" to this
		this.p1 = new Point3D(triangle.getP1());
		this.p2 = new Point3D(triangle.getP2());
		this.p3 = new Point3D(triangle.getP3());
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getP1() {
		return p1;
	}
	
	public void setP1(Point3D p1) {
		this.p1 = p1;
	}
	public Point3D getP2() {
		return p2;
	}
	public void setP2(Point3D p2) {
		this.p2 = p2;
	}
	public Point3D getP3() {
		return p3;
	}
	public void setP3(Point3D p3) {
		this.p3 = p3;
	}
	
	// ***************** Administration  ******************** //
	@Override
	public int compareTo(Triangle t)////return 0 if this triangle is equal to the triangle t parameter, else it returns 1
	{
		if(t.getP1().compareTo(p1)==0&&t.getP2().compareTo(p2)==0&&t.getP3().compareTo(p3)==0)
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
		Triangle other = (Triangle) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "p1= "+p1.toString()+", p2= "+p2.toString()+", p3= "+p3.toString();
	}
	
	// ***************** Operations ******************** // 

	public Vector getNormal(Point3D point) throws Exception {//this function return the normal vector in a specific point
		// TODO Auto-generated method stub
		Point3D temp1=new Point3D(p1);
		Point3D temp2=new Point3D(p1);
		temp1.substract(new Vector(new Point3D(p2))); 
		Vector v1=new Vector(new Point3D(temp1));//first direction vector of triangle
		temp2.substract(new Vector(new Point3D(p3)));
		Vector v2=new Vector(new Point3D(temp2));//second direction vector of triangle 
		Vector result=v1.crossProduct(v2);//get a normal by crossProduct of the 2 direction vectors
		result.normalize();//normalize the normal
		return result;
	}

	
	public List<Point3D> findIntersections(Ray r) throws Exception //this function return the intersection of the triangle with the ray r 
	{
		Point3D point=new Point3D(p1);
		point.substract(new Vector(new Point3D(p2)));
		Vector v1=new Vector(point);
		Point3D point2=new Point3D(p1);
		point2.substract(new Vector(new Point3D(p3)));
		Vector v2=new Vector(point2);
		Plane plane=new Plane(v1.crossProduct(v2),new Point3D(p1));//the plane that the triangle is on it
		List<Point3D> help=plane.findIntersections(r);
		if(help.isEmpty())//the plane does not have intersections point
			return help;
		Point3D T1=new Point3D(p1);
		Point3D T2=new Point3D(p2);
		T1.substract(new Vector(r.getStart()));
		Vector V1=new Vector(T1);//V1=T1-P0
		T2.substract(new Vector(r.getStart()));
		Vector V2=new Vector(T2);//V2=T2-P0
		Point3D T3=new Point3D(p3);
		T3.substract(new Vector(r.getStart()));
		Vector V3=new Vector(T3);//V3=T3-P0
		Vector N1=V1.crossProduct(V2);
		N1.normalize();//N1=(V1xV2)/|V1xV2|
		Vector N2=V2.crossProduct(V3);
		N2.normalize();//N2=(V2xV3)/|V2xV3|
		Vector N3=V3.crossProduct(V1);
		N3.normalize();//N3=(V3xV1)/|V3xV1|
		Point3D P=new Point3D(help.get(0));
		P.substract(new Vector(r.getStart()));//P=P-P0
		if(N1.dotProduct(new Vector(P))> 0 && N2.dotProduct(new Vector(P))>0 && N3.dotProduct(new Vector(P))>0)
			return help;//if sign((P-P0)*N1)==sign((P-P0)*N2)==sign((P-P0)*N3)==+
		if(N1.dotProduct(new Vector(P))< 0 && N2.dotProduct(new Vector(P))<0 && N3.dotProduct(new Vector(P))<0)
			return help;//if sign((P-P0)*N1)==sign((P-P0)*N2)==sign((P-P0)*N3)==-
		else//if the signs of the dot product are not equal
			return new ArrayList<Point3D>();
		
	}
	

}
