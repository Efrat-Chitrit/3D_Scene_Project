/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Primitives;

public class Point3D extends Point2D{
	
	protected Coordinate z;
	
	// ***************** Constructors ********************** // 
	public Point3D()//constructor
	{
		super();
		z=new Coordinate();//=0
		// => (0,0,0)
	}
	public Point3D(Coordinate a, Coordinate b, Coordinate c) {//parameter constructor
		super(a,b);
		this.z = c;
	}
	public Point3D(double a, double b, double c) {//parameter constructor
		super(new Coordinate(a),new Coordinate(b));
		this.z = new Coordinate(c);
	}
	public Point3D(Point3D p) //copy constructor
	{
		this.x = new Coordinate(p.getX());
		this.y = new Coordinate( p.getY());
		this.z= new Coordinate(p.getZ());
	}
	
	// ***************** Getters/Setters ********************** // 
	public Coordinate getZ() {
		return z;
	}
	
	public void setZ(Coordinate z) {
		this.z = z;
	}
	
	// ***************** Administration  ******************** // 
	
	//@Override
	public int compareTo(Point3D p)//return 0 if this point is equal to the point p parameter, else it returns 1
	{
		if(this.x.compareTo(p.getX())==0&&this.y.compareTo(p.getY())==0 && this.z.compareTo(p.getZ())==0)
			return 0;//equals
		return 1;//not equals
	}
	@Override
	public String toString() {
		return "(" + x + "," + y +","+z+ ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}
	// ***************** Operations ******************** // 
		public double distance(Point3D p)//calculate the distance between this point and the p parameter
		{
			Point3D temp=new Point3D(this);// ********
			temp.x.substract(p.getX());
			temp.y.substract(p.getY());
			temp.z.substract(p.getZ());
			return(Math.sqrt(Math.pow(temp.getX().getCoordinate(), 2)+Math.pow(temp.getY().getCoordinate(), 2)+Math.pow(temp.getZ().getCoordinate(), 2))); 
		}
		public void add(Vector vector) {//add to this point -the vector parameter (coordinate by coordinate)
			
			this.x.add(vector.getHead().getX());
			this.y.add(vector.getHead().getY());
			this.z.add(vector.getHead().getZ());

		}
		
		public void substract(Vector vector) {//sub from this point the vector parameter (coordinate by coordinate)
			
			this.x.substract(vector.getHead().getX());
			this.y.substract(vector.getHead().getY());
			this.z.substract(vector.getHead().getZ());

		}
}
