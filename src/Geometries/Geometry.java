/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Geometries;

import java.awt.Color;
import java.util.List;

import Primitives.*;
public abstract class Geometry {
	
	protected Color emission;
	protected Material material;
	//***************** Constructors ********************** //
	public Geometry() {
		super();
		this.emission = Color.WHITE;
		this.material = new Material(1,1,1);
	}
	public Geometry(Color emission, Material material) {
		super();
		this.emission = emission;
		this.material = material;
	}
	public Geometry(Geometry g) {
		super();
		this.emission = g.getEmission();
		this.material = g.getMaterial();
	}
	//***************** Getters/Setters ********************** // 
	public Color getEmission() {
		return emission;
	}

	public void setEmission(Color emission) {
		this.emission = emission;
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	// ***************** Operations ******************** // 

	public abstract Vector getNormal(Point3D point) throws Exception;//this function return the normal of the geometry in specific point
	
	public abstract List<Point3D> findIntersections(Ray r) throws Exception;//this function return the intersection of the geometry with the ray r 
}
