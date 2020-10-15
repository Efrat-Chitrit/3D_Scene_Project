/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Renderer;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Elements.Light;
import Geometries.*;
import Scene.*;
import Primitives.*;

public class Render {

	private Scene scene;
	private ImageWriter imageWriter;
	private static int RECURSION_LEVEL=3;

	//***************** Constructors ********************** //
	public Render() {
		this.scene =new Scene();
		this.imageWriter = new ImageWriter("image",500,500,500,500);
	}

	public Render(Scene scene, ImageWriter imageWriter) {
		super();
		this.scene = scene;
		this.imageWriter = imageWriter;
	}

	public Render(Render render) {
		this.scene = new Scene(render.getScene());
		this.imageWriter = new ImageWriter(render.getImageWriter());
	}

	//***************** Getters/Setters ********************** // 
	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public ImageWriter getImageWriter() {
		return imageWriter;
	}

	public void setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
	}

	// ***************** Administration  ******************** //
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (imageWriter == null) {
			if (other.imageWriter != null)
				return false;
		} else if (!imageWriter.equals(other.imageWriter))
			return false;
		if (scene == null) {
			if (other.scene != null)
				return false;
		} else if (!scene.equals(other.scene))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Render: "+ "scene=" + scene + ", imageWriter=" + imageWriter;
	}

	// ***************** Operations ******************** // 

	public void renderImage() throws Exception//this function creates a image of the geometries (scene), from the camera view. 
	{
		double sumRed=0;
		double sumGreen=0;
		double sumBlue=0;
		int height=imageWriter.getNy();
		int width=imageWriter.getNx();
		//For each point (i,j) in the view plane
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				sumRed=0;
				sumGreen=0;
				sumBlue=0;
				for(int k=0;k<5;k++)//this while is to construct 5 rays for every pixel 
				{ 
					Ray ray = scene.getCamera().constructRayThroughPixel
							(imageWriter.getNx(), imageWriter.getNy(), j, i,
									scene.getDistanceViewPlane(), imageWriter.getWidth(),
									imageWriter.getHeight(),k);//it creates a ray from the camera to the pixel
					Map<Geometry,List<Point3D>> intersectionPoints =getSceneRayIntersections(ray);//intersectionPoints gets all the intersection points with all of the geometries
					if (intersectionPoints.isEmpty())//if there are no intersection points, writes the background color in this pixel
						{sumRed+=scene.getBackground().getRed();
					    sumGreen+=scene.getBackground().getGreen();
					    sumBlue+=scene.getBackground().getBlue();
						}
					else//add the color in the closest point in the intersection points list.
					{
						Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
						for(Entry<Geometry, Point3D> entry: closestPoint.entrySet())
						{
							Color sumColor=calcColor(entry.getKey(),entry.getValue(),ray); //הצבע בנקודה הכי קרובה 
							sumRed+=sumColor.getRed();
						    sumGreen+=sumColor.getGreen();
						    sumBlue+=sumColor.getBlue();
						}
					}
				}
				sumRed/=5;//average of the colors of 5 rays
				sumGreen/=5;//average of the colors of 5 rays
				sumBlue/=5;//average of the colors of 5 rays
				Color sumColor=addColor(new Color((int)sumRed,(int)sumGreen,(int)sumBlue),new Color(0,0,0));//average of the multi-rays
				imageWriter.writePixel(j, i, sumColor);

			}
		}
	}

	//############

	public void printGrid(int interval)//this function prints grid to the image (not to the path), divides the screen to grid by interval
	{
		int height=imageWriter.getNy();
		int width=imageWriter.getNx();
		//divides the screen to grid by interval and put white color in the lines of the grid
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				if(i%interval==0||j%interval==0||j==499||i==499)
				{
					imageWriter.writePixel(i,j,255,255,255);
				}
			}
		}
	}

	//############

	private Color calcColor(Geometry geometry,Point3D p ,Ray inRay) throws Exception//this function calculates the color in the point p, it sends 0 
	//in order to begin the counting of the recursion (till the recursion level)
	{
		return 	calcColor(geometry,p ,inRay,0);
	}
	
	//############

	private Color calcColor(Geometry geometry,Point3D p ,Ray inRay,int level) throws Exception//this function calculates the color in the point p
	{
		try{
			if (level == RECURSION_LEVEL) //for recrusive calls
				return new Color(0, 0, 0);
			Color ambientLight = scene.getAmbientLight().getIntensity(p);//ambient
			Color emissionLight = geometry.getEmission();//emission
			Iterator<Light> lightsIt= scene.getLightsIterator();//איטרטור לראש רשימת מקורות האור בסצינה
			Color diffuseLight= new Color(0,0,0);
			Color specularLight=new Color(0,0,0);
			while(lightsIt.hasNext())//כל עוד לא הגענו לסוף רשימת מקורות האור
			{
				Light light =lightsIt.next();

				if (!occluded(light, p, geometry))
					//במקרה שהנקודה על הגיאומטריה לא מוסתרת מאותו מקור אור שעכשיו "שלפנו" מהרשימה-אז נחשב את הצבע באותה נקודה
				{

					Color temp=calcDiffusiveComp(geometry.getMaterial().getKd(),//temp is the sum of all the diffusive light on the geometry
							geometry.getNormal(p),light.getL(p),light.getIntensity(p));

					//הגדרנו אותו קודם-זה בעצם סוכם כל פעם את הדפיוז החדש עם הדפיוז הישן
					diffuseLight=addColor(diffuseLight,temp);

					Point3D p0=new Point3D(p);
					p0.substract(new Vector(scene.getCamera().getP0()));
					Color temp1=calcSpecularComp(geometry.getMaterial().getKs(),//temp1 is the sum of all the specular light on the geometry
							new Vector(p0),geometry.getNormal(p),
							light.getL(p),geometry.getMaterial().getN(),light.getIntensity(p));


	    			//הגדרנו אותו קודם-זה בעצם סוכם כל פעם את הספקולר החדש עם הספקולר הישן
					specularLight=addColor(specularLight,temp1);
				}

			}
			// Recursive call for a reflected ray
			double Kr = geometry.getMaterial().getKr();//Kr
			Color reflectedLight = new Color(0,0,0);//reflectedLight will be the color that mult with Kr and returned 
			if(Kr!=0)//if the geometry is reflected
			{
				Color reflectedColor=new Color(0,0,0);//reflectedColor will be the color that will return from the recrusive call
				//יוצר קרן השתקפות
				Ray reflectedRay = constructReflectedRay(geometry.getNormal(p), p, inRay);//create the reflected ray
				Map<Geometry,List<Point3D>> intersectionPointsReflect= getSceneRayIntersections(reflectedRay);//get all the intersection points of this ray
			
				if (geometry instanceof FlatGeometry)//FlatGeometry can not have intersection with itself
					intersectionPointsReflect.remove(geometry);
				Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPointsReflect);//get the closest intersection point

				for(Entry<Geometry, Point3D> entry: closestPoint.entrySet())//go over the closest point
				{
					if(entry.getValue()!=null)
						//יצרנו אותו קודם ועכשיו סוכמים לתוכו את הערך שיחזור מהקריאה לרקורסיה עבור השלב הבא
						reflectedColor=calcColor(entry.getKey(),entry.getValue(),reflectedRay,level+1);//call to calcColor-recrusive
					reflectedLight = scaleColor(reflectedColor,Kr);//the color-Kr*reflectedColor
				}
			}

			// Recursive call for a refracted ray
			double Kt = geometry.getMaterial().getKt();//Kt
			Color refractedLight=new Color(0,0,0);//refractedLight will be the color that mult with Kt and returned 
			if(Kt!=0)//if the geometry is refracted
			{   
				Color refractedColor=new Color(0,0,0);//refractedColor will be the color that will return from the recrusive call
				//יוצר קרן השתברות
				Ray refractedRay = constructRefractedRay(geometry.getNormal(p), p, inRay);//create the refracted ray
				Map<Geometry,List<Point3D>> intersectionPointsRefract= getSceneRayIntersections(refractedRay);//get all the intersection points
				//of this ray
				if (geometry instanceof FlatGeometry)//FlatGeometry can not have intersection with itself
					intersectionPointsRefract.remove(geometry);
				Map<Geometry,Point3D> closestPoint1=getClosestPoint(intersectionPointsRefract);//get the closest intersection point
				for(Entry<Geometry, Point3D> entry: closestPoint1.entrySet())//go over the closest point
				{
					if(entry.getValue()!=null)
					{
						 //יצרנו אותו קודם ועכשיו סוכמים לתוכו את הערך שיחזור מהקריאה לרקורסיה עבור השלב הבא
						refractedColor=calcColor(entry.getKey(),entry.getValue(),refractedRay,level+1);//call to calcColor-recrusive
						refractedLight = scaleColor(refractedColor,Kt);//the color-Kt*refractedColor
					}
				}
			}

			Color help1=addColor(addColor(ambientLight,emissionLight),addColor(specularLight,diffuseLight));
			return addColor(addColor(help1,reflectedLight),refractedLight);//return: ambientLight+emissionLight+specularLight+diffuseLight+reflectedLight+refractedLight
		}//end of try
		catch(Exception e)
		{
			System.out.println(e);
			return Color.BLACK;
		}//end of catch
	}//end of calcColor

	//############

	private Ray constructReflectedRay(Vector normal, Point3D p, Ray inRay) throws Exception{//קרן השתקפות
		//return a reflected ray from income ray,intersection
		//point and the normal of the geometry in this point
		Vector N=new Vector(normal);//N
		N.normalize();
		Vector D=new Vector(inRay.getDirection());
		D.normalize();
		double help1=-2*(D.dotProduct(N));//-2*(D*N)
		N.scale(help1);//-2*(D*N)*N
		D.add(N);//D-2*(D*N)*N
		D.normalize();
		return new Ray(new Point3D(p),D);//return the new reflected ray that include the original point and a new vector=D-2*(D*N)*N
	}
	
	//############

	private Ray constructRefractedRay(Vector normal, Point3D p, Ray inRay) throws Exception{//קרן השתברות
		//return a refracted ray from income ray,intersection
		//point and the normal of the geometry in this point
		Vector D=new Vector(inRay.getDirection());
		D.normalize();//the ray direction
		Vector epsVec= new Vector(normal);
		epsVec.scale(-2);
		epsVec.normalize();//eps
		Point3D p1=new Point3D(p);
		p1.add(epsVec);//p+eps
		return new Ray(p1,D);//return the new refracted ray that include the original point+eps and a new vector=D
	}
	
	//############

	private boolean occluded(Light light, Point3D point, Geometry geometry) throws Exception 
	//return true if the geometry occluded from the light in p-a specific point
	{

		Vector lightDirection = light.getL(point);//L
		lightDirection.normalize();
		//נכפיל במינוס 1 כי אנחנו רוצים את הווקטור מכיוון הגיאומטריה לכיוון האור
		lightDirection.scale(-1);//-L
		Point3D geometryPoint = new Point3D(point);
		Vector epsVector = new Vector(geometry.getNormal(point));//הנורמל בנקודה פוינט
		epsVector.normalize();
		epsVector.scale(0.1);//eps
		geometryPoint.add(epsVector);//point+eps
		Ray lightRay = new Ray(geometryPoint, lightDirection);//new ray- point+eps, -L
		Map<Geometry, List<Point3D>> intersectionPoints =getSceneRayIntersections(lightRay);//check intersection points
		// Flat geometry cannot self intersect
		if (geometry instanceof FlatGeometry)//FlatGeometry can not occluded itself
		{
			intersectionPoints.remove(geometry);
		} 

		for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())//check if the geometry occluded by other geometry
			if (entry.getKey().getMaterial().getKt() == 0&&entry.getKey().getMaterial().getKr() == 0)
				return true;
		return false;
	}

	//############

	private Map<Geometry,Point3D> getClosestPoint(Map<Geometry,List<Point3D>> intersectionPoints)
	//this function returns the closest point to the camera (P0) in the intersectionPoints list
	{
		double distance= Double.MAX_VALUE;
		Point3D P0 = scene.getCamera().getP0();
		Map<Geometry,Point3D> minDistancePoint = new HashMap<Geometry,Point3D>(); 

		for (Entry <Geometry,List<Point3D>> entry: intersectionPoints.entrySet())
		{
			for (Point3D point: entry.getValue())//scans the list of the intersections points 
				//and find the closest point by calculating the distance between p0(the camera)
				//to every point, when the distance is smaller than parameter distance, the minDistancePoint
				//will be changed in this point, and the distance parameter.
				if (P0.distance(point) < distance)
				{
					minDistancePoint.clear();
					minDistancePoint.put(entry.getKey(),new Point3D(point));
					distance = P0.distance(point);
				}
		}
		return minDistancePoint; 
	}

	//############

	private Map<Geometry,List<Point3D>> getSceneRayIntersections(Ray ray) throws Exception
	//this function returns list of all the intersection points between the ray to the geometries that
	//the ray hits in them (it checks all the geometries in the scene)
	{
		Iterator<Geometry> geometries = scene.getGeometriesIterator();//get iterator to the geometry list
		Map<Geometry,List<Point3D>> intersectionPoints = new HashMap<Geometry,List<Point3D>>();
		List<Point3D> geometryIntersectionPoints=new ArrayList<Point3D>();
		while (geometries.hasNext())//scans all the geometries in the scene by the iterator 
		{
			Geometry geometry =geometries.next();//the current geometry that it scans
			geometryIntersectionPoints =geometry.findIntersections(ray);//get the intersection points of the current geometry
			if(!geometryIntersectionPoints.isEmpty())
				intersectionPoints.put(geometry,geometryIntersectionPoints);//add geometryIntersectionPoints to intersectionPoints
		}
		return intersectionPoints; 
	}
	
	//############

	private Color calcDiffusiveComp(Double Kd,Vector geoNormal,Vector L,Color Intensity) throws Exception//this function return the color of the diffuse with light
	{
		Vector normal=new Vector(geoNormal);
		normal.normalize();
		Vector l=new Vector(L);
		l.normalize();
		double temp=Kd*normal.dotProduct(l);//temp=Kd*(N*L)
		if(temp<0)
			temp=-1*temp;
		return scaleColor(Intensity,temp);//Intensity*temp
	}
	
	//############

	private Color calcSpecularComp(Double Ks,Vector V,Vector geoNormal,Vector L,double n,Color Intensity) throws Exception//this function return the color of the specular with light
	{
		Vector N=new Vector(geoNormal);
		N.normalize();
		L.normalize();
		V.normalize();
		Vector R=new Vector(L);
		double help1=-2*(L.dotProduct(N));//help1=-2(V*N)*N
		if(help1<0)
			help1=0;
		N.scale(help1);
		R.add(N);//R=L-2(V*N)*N
		R.normalize();
		double help=V.dotProduct(R);
		if(help<0)
			help=-1*help;
		double temp1=Ks*Math.pow(help, n);//temp1=ks*((V*R)^n)
		return scaleColor(Intensity,temp1);//Intensity*temp1
	}
	
	//############

	private Color addColor(Color color1,Color color2)//this function returns the result of addition of 2 colors
	//if one of the RGB is bigger than 255, it puts in this field 255
	{
		int red=color1.getRed()+color2.getRed();
		if(red>255)
			red=255;
		int green=color1.getGreen()+color2.getGreen();
		if(green>255)
			green=255;
		int blue=color1.getBlue()+color2.getBlue();
		if(blue>255)
			blue=255;
		return new Color(red,green,blue);
	}
	
	//############

	private Color scaleColor(Color color, double n)//this function returns the result of scale*colors
	//if one of the RGB is bigger than 255, it puts in this field 255
	{
		double red=color.getRed()*n;
		if(red>255)
			red=255;
		double green=color.getGreen()*n;
		if(green>255)
			green=255;
		double blue=color.getBlue()*n;
		if(blue>255)
			blue=255;
		return new Color((int)red,(int)green,(int)blue);
	}
}
