/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;
import Primitives.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class vectorTest {

	@Test
	public void testAdd() {
		Vector v=new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
		Vector v1=new Vector(new Point3D(new Coordinate(-1),new Coordinate(-2),new Coordinate(-3)));
		Vector v2=new Vector();//(0,0,0)
		v.add(v1);
		assertEquals(v,v2);
	}
	@Test
	public void testSubstract() {
		Vector v=new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
		Vector v1=new Vector(v);//(1,2,3)
		Vector v2=new Vector();//(0,0,0)
		v.subtract(v1);
		assertEquals(v,v2);
	}
	@Test
	public void testScaling() {
		Vector v=new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
		Vector v2=new Vector(new Point3D(new Coordinate(-5),new Coordinate(-10),new Coordinate(-15)));
		v.scale(-5);
		assertEquals(v,v2);
	}
	@Test
	public void testDotProduct() {
		Vector v=new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
		Vector v1=new Vector(new Point3D(new Coordinate(4),new Coordinate(5),new Coordinate(6)));
		double temp=v.dotProduct(v1);
		assertEquals(temp,32,0);
	}
	@Test
	public void testLength() {
		Vector v=new Vector(new Point3D(new Coordinate(0),new Coordinate(4),new Coordinate(3)));
		double temp=v.length();
		 assertEquals(temp,5,0);
	}
	@Test
	public void testNormalize() throws Exception {
		Vector v=new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
		double help=1.0/Math.sqrt((Math.pow(1, 2)+Math.pow(2, 2)+Math.pow(3, 2)));
		double help1=2.0/Math.sqrt((Math.pow(1, 2)+Math.pow(2, 2)+Math.pow(3, 2)));
		double help2=3.0/Math.sqrt((Math.pow(1, 2)+Math.pow(2, 2)+Math.pow(3, 2)));
		Vector v1=new Vector(new Point3D(new Coordinate(help),new Coordinate(help1),new Coordinate(help2)));
		v.normalize();
		assertEquals(v,v1);
	}
	@Test
	public void testCrossProduct() {
		Vector v=new Vector(new Point3D(new Coordinate(1),new Coordinate(2),new Coordinate(3)));
		Vector v1=new Vector(new Point3D(new Coordinate(4),new Coordinate(5),new Coordinate(6)));
		Vector v2=v.crossProduct(v1);
		Vector v3=new Vector(new Point3D(new Coordinate(-3),new Coordinate(6),new Coordinate(-3)));
		assertEquals(v2,v3);
	}
	
}
