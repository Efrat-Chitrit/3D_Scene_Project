/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Elements.Camera;
import Geometries.*;
import Primitives.*;
public class sphereTest {

	@Test
	public void testGetNormal() throws Exception {//normal test
		Sphere s=new Sphere(1,new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0)));
		Point3D p1=new Point3D(new Coordinate(-1),new Coordinate(0),new Coordinate(0));
		Vector v=s.getNormal(p1);
		assertEquals(v,new Vector(p1));
	}
	
	@Test
	public void testfindIntersection() throws Exception {//when the sphere smaller than the view plane
		Camera camera=new Camera();
		Sphere sphere=new Sphere(1, new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-3)));
		List<Point3D> help=new ArrayList<Point3D>();
		List<Point3D> intersectionPoint=new ArrayList<Point3D>();
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
		{
				help=(sphere.findIntersections(camera.constructRayThroughPixel(3, 3, j,i, 1, 9, 9,2)));
			    intersectionPoint.addAll(help);
				
		}
		assertEquals(2,intersectionPoint.size());
	}
	
	@Test
	public void testfindIntersection1() throws Exception {//when the view plane is inside the sphere
		Camera camera=new Camera();
		Sphere sphere=new Sphere(90, new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1)));
		List<Point3D> help=new ArrayList<Point3D>();
		List<Point3D> intersectionPoint=new ArrayList<Point3D>();
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
		{
				help=(sphere.findIntersections(camera.constructRayThroughPixel(3, 3, j,i, 1, 9, 9,2)));
			    intersectionPoint.addAll(help);
				
		}
		assertEquals(9,intersectionPoint.size());
	}
}
