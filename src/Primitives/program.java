/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Primitives;

public class program {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try{
			Vector vec1=new Vector(new Point3D(new Coordinate(1),new Coordinate(7),new Coordinate(5)));
		    Vector vec2=new Vector(new Point3D(new Coordinate(4),new Coordinate(3),new Coordinate(0)));
	        System.out.println("vec2:");
			System.out.println(vec2);
			System.out.println("vec2 length is "+vec2.length());
			vec2.normalize();
			System.out.println("vec2 after normalize:");
			System.out.println(vec2);
			System.out.println("vec2 length is "+vec2.length());
			System.out.println("vec1:");
			System.out.println(vec1);
			vec1.add(vec2);
			System.out.println("vec1+=vec2:");
			System.out.println(vec1);
			vec1.subtract(vec2);
			System.out.println("vec1-=vec2:");
			System.out.println(vec1);
			System.out.println("vec1 X vec2:");
			System.out.println(vec1.crossProduct(vec2));
			System.out.println("vec1 * vec2:");
			System.out.println(vec1.dotProduct(vec2));
			vec1.scale(2);
			System.out.println("2* vec1="+vec1);
			if(vec1.compareTo(vec2)==0)
				System.out.println("vec1=vec2");
				else
					System.out.println("vec1 is not equal to vec2");
					
			Vector vec3=new Vector(vec1);
			System.out.println("vec3= "+ vec3);
			if(vec1.compareTo(vec3)==0)
				System.out.println("vec1=vec3");
				else
					System.out.println("vec1 is not equal to vec3");
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
/*The output is:
vec2:
(4.0,3.0,0.0)
vec2 length is 5.0
vec2 after normalize:
(0.8,0.6000000000000001,0.0)
vec2 length is 1.0
vec1:
(1.0,7.0,5.0)
vec1+=vec2:
(1.8,7.6,5.0)
vec1-=vec2:
(1.0,7.0,5.0)
vec1 X vec2:
(-3.0000000000000004,4.0,-5.0)
vec1 * vec2:
5.000000000000001
2* vec1=(2.0,14.0,10.0)
vec1 is not equal to vec2
vec3= (2.0,14.0,10.0)
vec1=vec3*/
