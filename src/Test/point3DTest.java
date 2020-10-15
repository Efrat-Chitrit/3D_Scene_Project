/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import Primitives.*;

public class point3DTest {

	@Test
	public void testAdd() {
		Point3D p=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
		Point3D p1=new Point3D(new Coordinate(-1),new Coordinate(-2),new Coordinate(-3));
		Point3D p2=new Point3D();
		p.add(new Vector(p1));
		assertEquals(p,p2);
	}
	@Test
	public void testSubstract() {
		Point3D p=new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3));
		Point3D p1=new Point3D(p);
		Point3D p2=new Point3D();
		p.substract(new Vector(p1));
		assertEquals(p,p2);
	}
}
