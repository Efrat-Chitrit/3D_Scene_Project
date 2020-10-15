/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Primitives;
public class Point2D implements Comparable<Point2D> {
	 protected Coordinate x;
	 protected Coordinate y;
	 
	// ***************** Constructors ********************** // 
	 public Point2D() //constructor
	 {
			this.x =new Coordinate();//=0
			this.y =new Coordinate();//=0
		}
	public Point2D(Coordinate x, Coordinate y) //parameter constructor
	{
		this.x = x;
		this.y = y;
	}
	public Point2D(Point2D p) //copy constructor
	{
		this.x = new Coordinate(p.getX());
		this.y = new Coordinate(p.getY());
	}
	
	// ***************** Getters/Setters ********************** // 
	public Coordinate getX() {
		return x;
	}
	public void setX(Coordinate x) {
		this.x = x;
	}
	public Coordinate getY() {
		return y;
	}
	public void setY(Coordinate y) {
		this.y = y;
	}
	
	// ***************** Administration  ******************** // 
	@Override
	public int compareTo(Point2D p)//return 0 if this point is equal to the point p parameter, else it returns 1
	{
		if(this.x.compareTo(p.getX())==0&&this.y.compareTo(p.getY())==0)
			return 0;
		return 1;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	

}
