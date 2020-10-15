/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Primitives;

public class Ray implements Comparable<Ray>
{
	protected Point3D start;
	protected Vector direction;
	
	// ***************** Constructors ********************** //
	public Ray() //constructor
	{
		this.start = new Point3D();//(0,0,0)
		this.direction = new Vector();//(0,0,0)
	}
	public Ray(Point3D start, Vector direction)//parameter constructor
	{
		this.start = start;
		this.direction = direction;
	}
	public Ray(Ray r) //copy constructor
	{
		this.start = new Point3D(r.getStart());
		this.direction = new Vector(r.getDirection());
	}
	
	// ***************** Getters/Setters ********************** // 
	public Point3D getStart() {
		return start;
	}
	public void setStart(Point3D start) {
		this.start = start;
	}
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	
	// ***************** Administration  ******************** // 
		@Override
		public int compareTo(Ray r)//return 0 if this ray is equal to the ray r parameter, else it returns 1
		{
			if(this.start.compareTo(r.getStart())==0 && this.direction.compareTo(r.getDirection())==0)
				return 0;//equals
			return 1;//not equals
		}
		
		@Override
		public String toString() {
			return "start=" + start + ", direction=" + direction;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Ray other = (Ray) obj;
			if (direction == null) {
				if (other.direction != null)
					return false;
			} else if (!direction.equals(other.direction))
				return false;
			if (start == null) {
				if (other.start != null)
					return false;
			} else if (!start.equals(other.start))
				return false;
			return true;
		}

}
