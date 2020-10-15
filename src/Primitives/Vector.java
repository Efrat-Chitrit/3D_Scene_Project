/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Primitives;

public class Vector implements Comparable<Vector> {
	
	protected Point3D head;
	
	// ***************** Constructors ********************** // 
	public Vector()//constructor
	{
		head=new Point3D();//(0,0,0)
	}
	public Vector(Point3D head)//parameter constructor 
	{
		this.head = head;
	}
	public Vector(Vector v)//copy constructor
	{
		head=new Point3D(v.getHead());
	}
	
	// ***************** Getters/Setters ********************** // 
	public Point3D getHead() {
		return head;
	}
	public void setHead(Point3D head) {
		this.head = head;
	}
	
	// ***************** Administration  ******************** // 
	@Override
	public int compareTo(Vector v)////return 0 if this vector is equal to the vector v parameter, else it returns 1
	{
		return this.head.compareTo(v.getHead());//compareTo from Point3D
		
	}
	@Override
	public String toString() {
		return head.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}
	
	// ***************** Operations ******************** // 
	
	public void add (Vector vector )//add to this vector -the vector parameter (coordinate by coordinate)
	{
		head.getX().add(vector.head.getX());
		head.getY().add(vector.head.getY());
		head.getZ().add(vector.head.getZ());
	}
	public void subtract (Vector vector )//sub from this vector -the vector parameter (coordinate by coordinate)
	{  
		head.getX().substract(vector.head.getX());
		head.getY().substract(vector.head.getY());
		head.getZ().substract(vector.head.getZ());
	
	}
	public void scale(double scalingFacor)//multiplier this vector in a scale (multi[lier every coordinate in the scale parameter)
	{
		head.setX(new Coordinate(scalingFacor*head.getX().getCoordinate()));
		head.setY(new Coordinate(scalingFacor*head.getY().getCoordinate()));
		head.setZ(new Coordinate(scalingFacor*head.getZ().getCoordinate()));
	}
	public double length()//calculates the length of this vector and it returns it
	{
		return(Math.sqrt(Math.pow(head.getX().getCoordinate(), 2)+Math.pow(head.getY().getCoordinate(), 2)+Math.pow(head.getZ().getCoordinate(), 2)));
	}
	public void normalize() throws Exception//normalize the vector (throw exception if the length of the vector is 0)
	{
		double distance=this.length();
		if(distance!=0)
			this.scale(1/distance);
		else
			throw new Exception("Cannot divide in 0");
	}
	public Vector crossProduct (Vector vector)//calculate :this vector X vector parameter (X=cross product), it returns the result vector.
	{
		return (new Vector(
				new Point3D(
			     new Coordinate(this.head.getY().getCoordinate()*vector.head.getZ().getCoordinate()-this.head.getZ().getCoordinate()*vector.head.getY().getCoordinate())
				,new Coordinate(this.head.getZ().getCoordinate()*vector.head.getX().getCoordinate()-this.head.getX().getCoordinate()*vector.head.getZ().getCoordinate()),
				 new Coordinate(this.head.getX().getCoordinate()*vector.head.getY().getCoordinate()-this.head.getY().getCoordinate()*vector.head.getX().getCoordinate()))));
	}
	public double dotProduct(Vector vector)//calculate :this vector * vector parameter (*=dot product), it returns the result .
	{
		return(head.getX().getCoordinate()*vector.head.getX().getCoordinate()+
				head.getY().getCoordinate()*vector.head.getY().getCoordinate()+
				head.getZ().getCoordinate()*vector.head.getZ().getCoordinate());
	}

	
	

}
	
