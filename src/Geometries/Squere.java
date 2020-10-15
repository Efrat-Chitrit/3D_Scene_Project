/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Primitives.Coordinate;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public class Squere extends Geometry implements Comparable<Squere> ,FlatGeometry
{
	
	protected Point3D p1; //up left
	protected Point3D p2; //up right
	protected Point3D p3; //down left
	protected Point3D p4; //down right
	
	// ***************** Constructors ********************** // 
	
		public Squere() {//default constructor 
			super();
			this.p1 = new Point3D(-50,50,-150);
			this.p2 = new Point3D(50,50,-150);
			this.p3 = new Point3D(-50,-50,-150);
			this.p4 = new Point3D(50,-50,-150);
		}
		public Squere(Point3D p1, Point3D p4) {//parameter constructor 
			super();

			Point3D _p2 = new Point3D(p4.getX(),p1.getY(),p1.getZ());
			Point3D _p3 = new Point3D(p1.getX(),p4.getY(),p4.getZ());
			
			this.p1 = p1;
			this.p2 = _p2;
			this.p3 = _p3;
			this.p4 = p4;
		}

		public Squere(Point3D p1, Point3D p4,Color color, Material material) {//parameter constructor 
			super(color,material);
			
			Point3D _p2 = new Point3D(p4.getX(),p1.getY(),p1.getZ());
			Point3D _p3 = new Point3D(p1.getX(),p4.getY(),p4.getZ());
			
			this.p1 = p1;
			this.p2 = _p2;
			this.p3 = _p3;
			this.p4 = p4;
		}
		
		public Squere(Squere squere) {//copy constructor
			super((Geometry) squere);//in order to copy the emission and the material from "squere" to this
			
			Point3D _p2 = new Point3D(squere.p4.getX(),squere.p1.getY(),squere.p1.getZ());
			Point3D _p3 = new Point3D(squere.p1.getX(),squere.p4.getY(),squere.p4.getZ());
			
			this.p1 = new Point3D(squere.getP1());
			this.p2 = new Point3D(_p2);
			this.p3 = new Point3D(_p3);
			this.p4 = new Point3D(squere.getP4());
		}
		
		// ***************** Getters/Setters ********************** // 

		public Point3D getP1() {
			return p1;
		}
		public void setP1(Point3D p1) {
			this.p1 = p1;
		}
		public Point3D getP4() {
			return p4;
		}
		public void setP4(Point3D p4) {
			this.p4 = p4;
		}
		// ***************** Administration  ******************** //
		@Override
		public int compareTo(Squere s)////return 0 if this squere is equal to the squere s parameter, else it returns 1
		{
			if(s.getP1().compareTo(p1)==0 && s.getP4().compareTo(p4)==0)
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
			Squere other = (Squere) obj;
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
			if (p4 == null) {
				if (other.p4 != null)
					return false;
			} else if (!p4.equals(other.p4))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Squere: p1=" + p1 + " , p2=" + p2 + " , p3=" + p3 + " , p4=" + p4;
		}
		
		// ***************** Operations ******************** // 
		public Vector getNormal(Point3D point) throws Exception {//this function return the normal vector in a specific point
		Point3D _p1 = new Point3D(this.p1);
		Point3D _p2 = new Point3D(this.p2);
		//Point3D _p3 = new Point3D(this.p3);
		Point3D _p4 = new Point3D(this.p4);
		
		Triangle rightTriangle = new Triangle(_p1,_p2,_p4);
		
		return rightTriangle.getNormal(point);

		}
		
		public List<Point3D> findIntersections(Ray r) throws Exception
		{
			Point3D _p1 = new Point3D(this.p1);
			Point3D _p2 = new Point3D(this.p2);
			Point3D _p3 = new Point3D(this.p3);
			Point3D _p4 = new Point3D(this.p4);
			
			//Divide the square into 2 triangles. One - upper right, and the other - lower left.
			Triangle rightTriangle = new Triangle(_p1,_p2,_p4);
			Triangle leftTriangle = new Triangle(_p1,_p3,_p4);
			
			List<Point3D> rightTriangleList = rightTriangle.findIntersections(r); //the intersection points from the right triangle
			List<Point3D> leftTriangleList = leftTriangle.findIntersections(r); //the intersection points from the left triangle
			
			List<Point3D> squereIntersections = rightTriangleList;
			
			squereIntersections.addAll(leftTriangleList); //the intersection points of all the square

			return squereIntersections;
		}

}
