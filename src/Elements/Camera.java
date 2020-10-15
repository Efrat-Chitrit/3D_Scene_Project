/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Elements;
import Primitives.*;
public class Camera {
	Point3D P0;
	Vector Vup;
	Vector Vright;
	Vector Vtoward;
	
	
	// ***************** Constructors ********************** //
	
	public Camera() {//default constructor
		P0 = new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
		Vup = new Vector(new Point3D(new Coordinate(0),new Coordinate(1),new Coordinate(0)));//y=(0,1,0)
		Vright = new Vector(new Point3D(new Coordinate(1),new Coordinate(0),new Coordinate(0)));//x=(1,0,0)
		Vtoward = new Vector(new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(-1)));//z=(0,0,-1)
	}
	public Camera(Point3D p0, Vector vup, Vector vright, Vector vtoward) {//parameters constructor
		P0 = p0;
		Vup = vup;
		Vright = vright;
		Vtoward = vtoward;
	}
	
	public Camera(Camera camToCopy) {//copy constructor
		P0 = new Point3D(camToCopy.getP0());
		Vup = new Vector(camToCopy.getVup());
		Vright = new Vector(camToCopy.getVright());
		Vtoward = new Vector(camToCopy.getVtoward());
	}
	// ***************** Getters/Setters ********************** // 
	public Point3D getP0() {
		return P0;
	}
	public void setP0(Point3D p0) {
		P0 = p0;
	}
	public Vector getVup() {
		return Vup;
	}
	public void setVup(Vector vup) {
		Vup = vup;
	}
	public Vector getVright() {
		return Vright;
	}
	public void setVright(Vector vright) {
		Vright = vright;
	}
	public Vector getVtoward() {
		return Vtoward;
	}
	public void setVtoward(Vector vtoward) {
		Vtoward = vtoward;
	}

	
	
	// ***************** Administration  ******************** //

	
	@Override
	public String toString() {
		return "Camera: P0=" + P0 + ", Vup=" + Vup + ", Vright=" + Vright + ", Vtoward=" + Vtoward + ".";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (P0 == null) {
			if (other.P0 != null)
				return false;
		} else if (!P0.equals(other.P0))
			return false;
		if (Vright == null) {
			if (other.Vright != null)
				return false;
		} else if (!Vright.equals(other.Vright))
			return false;
		if (Vtoward == null) {
			if (other.Vtoward != null)
				return false;
		} else if (!Vtoward.equals(other.Vtoward))
			return false;
		if (Vup == null) {
			if (other.Vup != null)
				return false;
		} else if (!Vup.equals(other.Vup))
			return false;
		return true;
	}


//***************** Operations ******************** //

public Ray constructRayThroughPixel (int Nx, int Ny, double x, double y,
        double screenDist, double screenWidth,
        double screenHeight, int flag) throws Exception
{//this function return a Ray that send from the Camera (P0) to the specific pixel (that it's details are in the parameters of the function)
	
	int jumpX=1,jumpY=1;//this condition add for the improvement the color in sides-it help to create 5 rays from each pixel
	if(flag==0)//up-left of the pixel
	{
		jumpX=0;
	    jumpY=0;
	}
	if(flag==1)//up-right of the pixel
	{
		jumpX=2;
		jumpY=0;
	}
	if(flag==2)//middle of the pixel
	{
		jumpX=1;
		jumpY=1;
	}
	if(flag==3)//down-left of the pixel
	{
		jumpX=1;
		jumpY=2;
	}
	if(flag==4)//down-right of the pixel
	{
		jumpX=2;
		jumpY=2;
	}
	Point3D pc= new Point3D(P0);
	Vector v2= new Vector(Vtoward); //z ציר
	v2.normalize();
	v2.scale(screenDist);
	pc.add(v2);//pc is the center of the view plane
	double Rx=screenWidth/Nx;//width of 1 pixel
	double Ry=screenHeight/Ny;//height of 1 pixel
	double tmp1=(x-(Nx/2.0))*Rx+(Rx/2)*jumpX;//part of the formula
	double tmp2=(y-(Ny/2.0))*Ry+(Ry/2)*jumpY;//part of the formula
	Vector right=new Vector (Vright);//x ציר
	Vector up=new Vector (Vup);//y ציר
	right.scale(tmp1);//x החלק של הנוסחא השפיע על ציר
	up.scale(tmp2);//y החלק של הנוסחא השפיע על ציר
	pc.add(right);
	pc.substract(up);
	Vector p=new Vector(new Point3D(pc));
	p.normalize();//normalize the direction vector of the ray
	return(new Ray(P0,p));//return the ray
	
	
}
}



