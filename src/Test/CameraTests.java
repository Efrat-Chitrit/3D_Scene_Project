/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import Primitives.*;
import Elements.*;
public class CameraTests {

	@Test
	public void testRaysConstruction1() throws Exception {
		Camera cam=new Camera();
		Ray result= cam.constructRayThroughPixel (3, 3, 0, 0,1, 9,9,2);
		Vector v=new Vector(new Point3D(new Coordinate(-3),new Coordinate(3),new Coordinate(-1)));
		v.normalize();
		assertEquals(result,new Ray(new Point3D(cam.getP0()),v));

		
	}

	@Test
	public void testRaysConstruction2() throws Exception {
		Camera cam=new Camera();
		Ray result= cam.constructRayThroughPixel (3, 3, 2, 2,1, 9,9,2);
		Vector v=new Vector(new Point3D(new Coordinate(3),new Coordinate(-3),new Coordinate(-1)));
		v.normalize();
		assertEquals(result,new Ray(new Point3D(cam.getP0()),v));

		
	}
}
