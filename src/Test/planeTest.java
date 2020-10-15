/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import Elements.Camera;
import Geometries.*;
import Primitives.*;

public class planeTest {

	@Test
	public void testGetNormal() throws Exception {
		Point3D p=new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0));
		Point3D p1=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
		Plane pl=new Plane(new Vector(p),p1);
		Vector v=pl.getNormal(p);
		assertEquals(v,new Vector(p));
	}
	@Test
	public void testfindIntersections() throws Exception {
		Camera camera=new Camera();
		Plane plane=new Plane(new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1))
				),new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3)));
		List<Point3D> help=new ArrayList<Point3D>();
		List<Point3D> intersectionPoint=new ArrayList<Point3D>();
		int count=0;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
		{
				help=(plane.findIntersections(camera.constructRayThroughPixel(3, 3, j,i, 1, 9, 9,2)));
				count+=help.size();
				intersectionPoint.addAll(help);
				
		}
		assertEquals(9,count);
	}
	@Test
	public void testfindIntersections1() throws Exception {
		Camera camera=new Camera();
		Vector tmp=new Vector(new Point3D(new Coordinate(7),new Coordinate(5),new Coordinate(-3)));
		tmp.normalize();
		Plane plane=new Plane(tmp,new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3)));
		List<Point3D> help=new ArrayList<Point3D>();
		List<Point3D> intersectionPoint=new ArrayList<Point3D>();
		int count=0;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
		{
				//Ray r=camera.constructRayThroughPixel(3, 3, j,i, 1, 9, 9);
				//System.out.println(r);
				help=(plane.findIntersections(camera.constructRayThroughPixel(3, 3, j,i, 1, 9, 9,2)));
				// System.out.println(help.size());
				count+=help.size();
				intersectionPoint.addAll(help);
				
				
		}
		/*for(int i=0;i<intersectionPoint.size();i++){
		    System.out.println(intersectionPoint.get(i).toString());
		} */
		assertEquals(9,count);
	}
	@Test
	public void testfindIntersections2() throws Exception {
		Camera camera=new Camera();
		Vector tmp=new Vector(new Point3D(new Coordinate(0),new Coordinate(2),new Coordinate(0)));
		tmp.normalize();
		Plane plane=new Plane(tmp,new Point3D(new Coordinate(0),new Coordinate(2),new Coordinate(-3)));
		List<Point3D> help=new ArrayList<Point3D>();
		List<Point3D> intersectionPoint=new ArrayList<Point3D>();
		int count=0;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
		{
				help=(plane.findIntersections(camera.constructRayThroughPixel(3, 3, j,i, 1, 9, 9,2)));
				count+=help.size();
				intersectionPoint.addAll(help);
				
				
		}
		
		assertEquals(6,count);
	}
}

