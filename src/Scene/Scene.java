/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Scene;
import Geometries.*;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import Elements.*;

public class Scene {
	protected String sceneName;
	protected Color background;
	protected List<Geometry> geometries;
	protected Camera camera;
	protected double distanceViewPlane;
	protected AmbientLight ambientLight;
	protected List<Light> lights;
	// ***************** Constructors ********************** //
	public Scene() {//default constructor
		this.sceneName = "";
		this.background = Color.BLACK;
		this.geometries = new ArrayList<Geometry>();
		this.camera = new Camera();//default camera - x,y,z צירים
		this.distanceViewPlane =100;
		this.ambientLight=new AmbientLight();
		this.lights = new ArrayList<Light>();
	}
	
	public Scene(String sceneName1, Color background1, List<Geometry> geometries1, Camera camera1,
			double distanceViewPlane1,AmbientLight a,List<Light> lights1) {//parameter constructor
		this.sceneName = sceneName1;
		this.background = background1;
		this.geometries = geometries1;
		this.camera = camera1;
		this.distanceViewPlane = distanceViewPlane1;
		this.ambientLight=a;
		this.lights=lights1;
	}
	
	public Scene(Scene s) {//copy constructor
		this.sceneName = s.getSceneName();
		this.background = s.getBackground();
		this.geometries = s.getGeometries();
		this.camera = s.getCamera();
		this.distanceViewPlane = s.getDistanceViewPlane();
		this.ambientLight=new AmbientLight(s.getAmbientLight());
		this.lights = s.getLights();
	}
	
// ***************** Getters/Setters ********************** //
	public String getSceneName() {
		return sceneName;
	}

	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}

	public Color getBackground() {
		return background;
	}

	public void setBackground(Color background) {
		this.background = background;
	}

	public List<Geometry> getGeometries() {
		return geometries;
	}

	public void setGeometries(List<Geometry> geometries) {
		this.geometries = geometries;
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public double getDistanceViewPlane() {
		return distanceViewPlane;
	}

	public void setDistanceViewPlane(double distanceViewPlane) {
		this.distanceViewPlane = distanceViewPlane;
	}
	public AmbientLight getAmbientLight() {
		return ambientLight;
	}

	public void setAmbientLight(AmbientLight a) {
		this.ambientLight = a;
	}
	public List<Light> getLights() {
		return lights;
	}

	public void setLights(List<Light> l) {
		this.lights = l;
	}
	
	// ***************** Administration  ******************** //
	
	
	@Override
	public String toString() {
		return "Scene: sceneName=" + sceneName + ", background=" + background + ", geometries=" + geometries
				+ ", camera=" + camera + ", distanceViewPlane=" + distanceViewPlane + ", ambientLight=" + ambientLight;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scene other = (Scene) obj;
		if (ambientLight == null) {
			if (other.ambientLight != null)
				return false;
		} else if (!ambientLight.equals(other.ambientLight))
			return false;
		if (background == null) {
			if (other.background != null)
				return false;
		} else if (!background.equals(other.background))
			return false;
		if (camera == null) {
			if (other.camera != null)
				return false;
		} else if (!camera.equals(other.camera))
			return false;
		if (Double.doubleToLongBits(distanceViewPlane) != Double.doubleToLongBits(other.distanceViewPlane))
			return false;
		if (geometries == null) {
			if (other.geometries != null)
				return false;
		} else if (!geometries.equals(other.geometries))
			return false;
		if (sceneName == null) {
			if (other.sceneName != null)
				return false;
		} else if (!sceneName.equals(other.sceneName))
			return false;
		return true;
	}

	// ***************** Operations ******************** // 

	public void addGeometry(Geometry g)//add a geometry to the list of geometry that in the scene
	{
		geometries.add(g);
	}
	
	public Iterator<Geometry>getGeometriesIterator()//get iterator to the geometry list
	{
		return geometries.iterator();

	}
	
	public void addLight(Light l)//add a light to the list of light that in the scene
	{
		lights.add(l);
	}
	
	public Iterator<Light>getLightsIterator()//get iterator to the light list
	{
		return lights.iterator();

	}
	
}
