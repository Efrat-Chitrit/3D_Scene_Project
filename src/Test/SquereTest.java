/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geometries.Squere;
import Geometries.Triangle;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;

class SquereTest {

	@Test
	public void testGetNormal() throws Exception {//normal test
		Point3D p1=new Point3D(-100,100,-140);
		Point3D p4=new Point3D(100,-100,-140);
		Squere s=new Squere(p1,p4);
		Vector v=s.getNormal(p1);

		Point3D n=new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1));
		Vector N = new Vector(n);
		
//		System.out.println(s);
//		System.out.println("v is: "+v);
//		System.out.println("N is: "+N);
		
		assertEquals(v,N);
	}

}
