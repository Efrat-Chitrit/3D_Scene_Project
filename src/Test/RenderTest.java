/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Elements.AmbientLight;
import Elements.PointLight;
import Elements.SpotLight;
import Geometries.*;
import Primitives.*;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class RenderTest {
	@Test
	public void basicRendering() throws Exception{//4 triangles and sphere - black and white
		//try{
		Scene scene = new Scene();
	
		Sphere s=new Sphere(50, new Point3D(new Coordinate(0.0), new Coordinate(0.0),new Coordinate( -150)));
		s.setEmission(Color.WHITE);
		scene.addGeometry(s);
		Triangle triangle = new Triangle(new Point3D( new Coordinate(100),new Coordinate(0),new Coordinate(-149)),
				 						 new Point3D( new Coordinate(0),new Coordinate (100),new Coordinate(-149)),
				 						 new Point3D(new Coordinate (100),new Coordinate (100),new Coordinate( -149)));
		
		Triangle triangle2 = new Triangle(new Point3D( new Coordinate(100),new Coordinate( 0),new Coordinate( -149)),
				 			 			  new Point3D( new Coordinate(0),new Coordinate(-100),new Coordinate (-149)),
				 			 			  new Point3D( new Coordinate(100),new Coordinate(-100),new Coordinate( -149)));
		
		Triangle triangle3 = new Triangle(new Point3D(new Coordinate(-100),new Coordinate( 0),new Coordinate(-149)),
				 						  new Point3D(new Coordinate( 0),new Coordinate( 100),new Coordinate( -149)),
				 						  new Point3D(new Coordinate(-100),new Coordinate( 100),new Coordinate( -149)));
		
		Triangle triangle4 = new Triangle(new Point3D(new Coordinate(-100),new Coordinate( 0),new Coordinate( -149)),
				 			 			  new Point3D( new Coordinate( 0),new Coordinate(-100),new Coordinate( -149)),
				 			 			  new Point3D(new Coordinate(-100),new Coordinate( -100),new Coordinate( -149)));
		
		triangle.setEmission(Color.WHITE);
		triangle2.setEmission(Color.WHITE);
		triangle3.setEmission(Color.WHITE);
		triangle4.setEmission(Color.WHITE);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);

	
		ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
		Render render = new Render(scene,imageWriter);
		
		render.renderImage();
		render.printGrid(50);
		render.getImageWriter().writeToimage();
		assertTrue(true);
		//}
		//catch(Exception e)
		//{
		//System.out.println(e);
		//}
	}
	
	
		@Test
		public void basicRendering3() throws Exception{//4 triangle and sphere-emmision check - the color set by the "set" functions
			Scene scene = new Scene();
			
			Sphere s=new Sphere(50, new Point3D(new Coordinate(0.0), new Coordinate(0.0),new Coordinate( -150)));
			s.setEmission(Color.GRAY);
			scene.addGeometry(s);
			Triangle triangle = new Triangle(new Point3D( new Coordinate(100),new Coordinate(0),new Coordinate(-149)),
					 						 new Point3D( new Coordinate(0),new Coordinate (100),new Coordinate(-149)),
					 						 new Point3D(new Coordinate (100),new Coordinate (100),new Coordinate( -149)));
			
			Triangle triangle2 = new Triangle(new Point3D( new Coordinate(100),new Coordinate( 0),new Coordinate( -149)),
					 			 			  new Point3D( new Coordinate(0),new Coordinate(-100),new Coordinate (-149)),
					 			 			  new Point3D( new Coordinate(100),new Coordinate(-100),new Coordinate( -149)));
			
			Triangle triangle3 = new Triangle(new Point3D(new Coordinate(-100),new Coordinate( 0),new Coordinate(-149)),
					 						  new Point3D(new Coordinate( 0),new Coordinate( 100),new Coordinate( -149)),
					 						  new Point3D(new Coordinate(-100),new Coordinate( 100),new Coordinate( -149)));
			
			Triangle triangle4 = new Triangle(new Point3D(new Coordinate(-100),new Coordinate( 0),new Coordinate( -149)),
					 			 			  new Point3D( new Coordinate( 0),new Coordinate(-100),new Coordinate( -149)),
					 			 			  new Point3D(new Coordinate(-100),new Coordinate( -100),new Coordinate( -149)));
			triangle.setEmission(Color.GRAY);
			triangle2.setEmission(Color.BLUE);
			triangle3.setEmission(Color.GREEN);
			triangle4.setEmission(Color.RED);
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			scene.addGeometry(triangle3);
			scene.addGeometry(triangle4);

		
			ImageWriter imageWriter = new ImageWriter("Render test3", 500, 500, 500, 500);
			Render render = new Render(scene,imageWriter);
			
			render.renderImage();
			render.printGrid(50);
			render.getImageWriter().writeToimage();
			assertTrue(true);
		
		}
		
		
		@Test 
		public void emmissionTest() throws Exception{//another emmission test - the color send as a parameter to the constractor
			
			Scene scene = new Scene();
			
			scene.addGeometry(new Sphere(50, new Point3D(new Coordinate(0.0),new Coordinate( 0.0), new Coordinate(-149)), new Color(255,0,0),new Material(1,1,1)));
			
			Triangle triangle = new Triangle(new Point3D( new Coordinate(100),new Coordinate( 0),new Coordinate( -149)),
					 						 new Point3D( new Coordinate( 0),new Coordinate( 100),new Coordinate(-149)),
					 						 new Point3D( new Coordinate(100),new Coordinate( 100),new Coordinate(-149)),
					 						 new Color(0,255,0),
					 						new Material(1,1,1)
					 						 );
			
			Triangle triangle2 = new Triangle(new Point3D( new Coordinate(100),new Coordinate( 0),new Coordinate( -149)),
					 			 			  new Point3D(  new Coordinate(0), new Coordinate(-100),new Coordinate( -149)),
					 			 			  new Point3D( new Coordinate(100),new Coordinate(-100),new Coordinate( -149)),
						 						 new Color(0,0,255),
						 						new Material(1,1,1));
			
			Triangle triangle3 = new Triangle(new Point3D(new Coordinate(-100),new Coordinate( 0),new Coordinate( -149)),
					 						  new Point3D( new Coordinate( 0), new Coordinate(100), new Coordinate(-149)),
					 						  new Point3D(new Coordinate(-100),new Coordinate( 100),new Coordinate( -149)),
					 						  new Color(255,255,0),
					 						 new Material(1,1,1));
			
			Triangle triangle4 = new Triangle(new Point3D(new Coordinate(-100),new Coordinate( 0),new Coordinate( -149)),
					 			 			  new Point3D( new Coordinate( 0), new Coordinate( -100),new Coordinate( -149)),
					 			 			  new Point3D(new Coordinate(-100), new Coordinate(-100),new Coordinate( -149)),
						 						 new Color(255,0,255),
						 						new Material(1,1,1));
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			scene.addGeometry(triangle3);
			scene.addGeometry(triangle4);
			
			ImageWriter imageWriter = new ImageWriter("Emmition test", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();
			render.printGrid(50);
			imageWriter.writeToimage();
		}
		
		
		@Test
		public void spotLightTest2() throws Exception{//sphere with triangle and light-check shadow
			
			Scene scene = new Scene();
			//scene.setBackground(Color.pink);
			scene.setDistanceViewPlane(200);
			Material m=new Material(1,1,1);
			m.setN(20);
			Sphere sphere = new Sphere(500, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(0, 0, 100),new Material(1,1,1));
			sphere.setMaterial(m);
			scene.addGeometry(sphere);
			
			
			Triangle triangle = new Triangle(new Point3D(new Coordinate(-125), new Coordinate(-225),new Coordinate( -260)),
											 new Point3D(new Coordinate(-225),new Coordinate( -125), new Coordinate(-260)),
											 new Point3D(new Coordinate(-225),new Coordinate( -225),new Coordinate( -270)),
											 new Color (0, 0, 100),new Material(1,1,1));
			Material m1=new Material(1,1,1);
			m1.setN(4);
			triangle.setMaterial(m);
			scene.addGeometry(triangle);
			
			scene.addLight(new SpotLight( new Point3D(new Coordinate(-200),new Coordinate( -200),new Coordinate( -150)),0.1, 0.00001, 0.000005, 
						   new Vector(new Point3D(new Coordinate(2),new Coordinate( 2),new Coordinate( -3))),new Color(255, 100, 100)));
		
			ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
		
		@Test
		public void spotLightTest() throws Exception{//a sphere with spot light
			
			Scene scene = new Scene();
			//scene.setBackground(Color.pink);
			Sphere sphere = new Sphere(800, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(0, 0, 100),new Material(1,1,1));
			Material m=new Material(1,1,1);
			m.setN(20);
			sphere.setMaterial(m);
			scene.addGeometry(sphere);
			scene.addLight(new SpotLight( new Point3D(new Coordinate(-200),new Coordinate( -200),new Coordinate( -100)), 0, 0.00001, 0.000005, 
						   new Vector(new Point3D(new Coordinate(2),new Coordinate( 2),new Coordinate( -3))),new Color(255, 100, 100)));
		
			ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}

		 
		@Test
		public void pointLightTest() throws Exception{//a sphere with point light
			
			Scene scene = new Scene();
			Sphere sphere = new Sphere (800, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(0, 0, 100),new Material(1,1,1));
			Material m=new Material(1,1,1);
			m.setN(20);
			sphere.setMaterial(m);
			scene.addGeometry(sphere);
			scene.addLight(new PointLight( new Point3D(new Coordinate(-200),new Coordinate( -200),new Coordinate( -100)), 
						   0, 0.00001, 0.000005,new Color(255,100,100)));
		
			ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
			
		}
		
		@Test
		public void spotLightTest3() throws Exception{//2 triangles with spot light
			
			Scene scene = new Scene();
			Triangle triangle = new Triangle(new Point3D(new Coordinate(  3500),new Coordinate(  3500), new Coordinate(-2000)),
					 						 new Point3D(new Coordinate( -3500),new Coordinate( -3500),new Coordinate( -1000)),
					 						 new Point3D(  new Coordinate(3500),new Coordinate( -3500),new Coordinate( -2000)),
					 						 new Color(0,0,0),
					 						 new Material(1,1,1));

			Triangle triangle2 = new Triangle(new Point3D( new Coordinate( 3500),new Coordinate(  3500),new Coordinate( -2000)),
					  						  new Point3D(new Coordinate( -3500),new Coordinate(  3500), new Coordinate(-1000)),
					  						  new Point3D( new Coordinate(-3500), new Coordinate(-3500), new Coordinate(-1000)),
						 						 new Color(0,0,0),
						 						 new Material(1,1,1));
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			
			scene.addLight(new SpotLight( new Point3D(new Coordinate(200),new Coordinate( 200),new Coordinate( -100)), 0, 0.000001, 0.0000005, 
						   new Vector(new Point3D(new Coordinate(-2),new Coordinate( -2),new Coordinate( -3))),new Color(255, 100, 100)));
		
			
			ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
		
		@Test
		public void pointLightTest2() throws Exception{//2 triangles with point light
			
			Scene scene = new Scene();
			
			Triangle triangle = new Triangle(new Point3D(  new Coordinate(3500),  new Coordinate(3500), new Coordinate(-2000)),
					 						 new Point3D( new Coordinate(-3500), new Coordinate(-3500), new Coordinate(-1000)),
					 						 new Point3D(  new Coordinate(3500),new Coordinate( -3500), new Coordinate(-2000)),
					 						 new Color(0,0,0),
					 						 new Material(1,1,1));

			Triangle triangle2 = new Triangle(new Point3D( new Coordinate( 3500),  new Coordinate(3500), new Coordinate(-2000)),
					  						  new Point3D( new Coordinate(-3500), new Coordinate( 3500), new Coordinate(-1000)),
					  						  new Point3D( new Coordinate(-3500), new Coordinate(-3500), new Coordinate(-1000)),
						 						 new Color(0,0,0),
						 						 new Material(1,1,1));
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			scene.addLight(new PointLight( new Point3D(new Coordinate(200),new Coordinate( 200), new Coordinate(-100)), 
						   0, 0.000001, 0.0000005,new Color(255, 100, 100)));
			
			ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
		
		@Test
		public void spotShadowTest2() throws Exception{//sphere, triangle and spot light with shadow
			
			Scene scene = new Scene();
			scene.setDistanceViewPlane(200);
			Material m=new Material(1,1,1);
			m.setN(20);
			Sphere sphere = new Sphere(500, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(0, 0, 100),new Material(1,1,1));
			sphere.setMaterial(m);
			scene.addGeometry(sphere);
			
			
			Triangle triangle = new Triangle(new Point3D(new Coordinate(0), new Coordinate(-500),new Coordinate( -1000)),
											 new Point3D(new Coordinate(-500),new Coordinate( -200), new Coordinate(-1000)),
											 new Point3D(new Coordinate(-200),new Coordinate( -100),new Coordinate( -270)),
											 new Color (0, 0, 100),new Material(1,1,1));
			Material m1=new Material(1,1,1);
			m1.setN(4);
			triangle.setMaterial(m);
			scene.addGeometry(triangle);
			
			scene.addLight(new SpotLight( new Point3D(new Coordinate(-200),new Coordinate( -200),new Coordinate( -150)),0.1, 0.00001, 0.000005, 
						   new Vector(new Point3D(new Coordinate(2),new Coordinate( 2),new Coordinate( -3))),new Color(255, 100, 100)));
		
			ImageWriter imageWriter = new ImageWriter("SpotShadow test 2", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
		@Test
		public void spotLightShadow() throws Exception{//sphere, triangle and spot light with shadow
			
			Scene scene = new Scene();
			scene.setDistanceViewPlane(200);
			Material m=new Material(1,1,1);
			m.setN(20);
			Sphere sphere = new Sphere(500, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(0, 0, 100),new Material(1,1,1));
			sphere.setMaterial(m);
			scene.addGeometry(sphere);
			
			
			Triangle triangle = new Triangle(new Point3D(new Coordinate(-125), new Coordinate(-225),new Coordinate( -260)),
											 new Point3D(new Coordinate(-225),new Coordinate( -125), new Coordinate(-260)),
											 new Point3D(new Coordinate(-225),new Coordinate( -225),new Coordinate( -270)),
											 new Color (0, 0, 100),new Material(1,1,1));
			Material m1=new Material(1,1,1);
			m1.setN(4);
			triangle.setMaterial(m);
			scene.addGeometry(triangle);
			
			scene.addLight(new SpotLight( new Point3D(new Coordinate(-200),new Coordinate( -150),new Coordinate( -150)),0.1, 0.00001, 0.000005, 
						   new Vector(new Point3D(new Coordinate(2),new Coordinate( 2),new Coordinate( -3))),new Color(255, 100, 100)));
		
			ImageWriter imageWriter = new ImageWriter("Shadow 2", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
		@Test
		public void spotLightShadow1() throws Exception{//sphere, triangle and spot light with shadow
			
			Scene scene = new Scene();
			scene.setDistanceViewPlane(200);
			Material m=new Material(1,1,1);
			m.setN(20);
			Sphere sphere = new Sphere(500, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(0, 0, 100),new Material(1,1,1));
			sphere.setMaterial(m);
			scene.addGeometry(sphere);
			
			
			Triangle triangle = new Triangle(new Point3D(new Coordinate(-125), new Coordinate(-225),new Coordinate( -260)),
											 new Point3D(new Coordinate(-225),new Coordinate( -125), new Coordinate(-260)),
											 new Point3D(new Coordinate(-225),new Coordinate( -225),new Coordinate( -270)),
											 new Color (0, 0, 100),new Material(1,1,1));
			Material m1=new Material(1,1,1);
			m1.setN(4);
			triangle.setMaterial(m);
			scene.addGeometry(triangle);
			
			scene.addLight(new SpotLight( new Point3D(new Coordinate(-180),new Coordinate( -180),new Coordinate( 0)),0.1, 0.00001, 0.000005, 
						   new Vector(new Point3D(new Coordinate(2),new Coordinate( 2),new Coordinate( -3))),new Color(255, 100, 100)));
		
			ImageWriter imageWriter = new ImageWriter("Shadow 3", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
		@Test
		public void spotLightShadow2() throws Exception{//sphere, triangle and spot light check shadow
			
			Scene scene = new Scene();
			scene.setDistanceViewPlane(200);
			Material m=new Material(1,1,1);
			m.setN(20);
			Sphere sphere = new Sphere(500, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(0, 0, 100),new Material(1,1,1));
			sphere.setMaterial(m);
			scene.addGeometry(sphere);
			
			
			Triangle triangle = new Triangle(new Point3D(new Coordinate(-125), new Coordinate(-225),new Coordinate( -260)),
											 new Point3D(new Coordinate(-225),new Coordinate( -125), new Coordinate(-260)),
											 new Point3D(new Coordinate(-225),new Coordinate( -225),new Coordinate( -270)),
											 new Color (0, 0, 100),new Material(1,1,1));
			Material m1=new Material(1,1,1);
			m1.setN(4);
			triangle.setMaterial(m);
			scene.addGeometry(triangle);
			
			scene.addLight(new SpotLight( new Point3D(new Coordinate(-100),new Coordinate( -100),new Coordinate( 0)),0.1, 0.00001, 0.000005, 
						   new Vector(new Point3D(new Coordinate(2),new Coordinate( 2),new Coordinate( -3))),new Color(255, 100, 100)));
		
			ImageWriter imageWriter = new ImageWriter("Shadow 4", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
		
		@Test
		public void pointLightTest3() throws Exception{//2 triangle, sphere and point light with shadow
			
			Scene scene = new Scene();
			Material m=new Material(1,1,1);
			m.setN(20);
			Sphere sphere = new Sphere(100, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -200)),new Color(0, 0, 100),new Material(1,1,1));
			sphere.setMaterial(m);
			
			
			Triangle triangle = new Triangle(new Point3D(  new Coordinate(3500),  new Coordinate(3500), new Coordinate(-2000)),
					 						 new Point3D( new Coordinate(-3500), new Coordinate(-3500), new Coordinate(-1000)),
					 						 new Point3D(  new Coordinate(-3500),new Coordinate(3500), new Coordinate(-2000)),
					 						 new Color(0,0,0),
					 						 new Material(1,1,1));

			Triangle triangle2 = new Triangle(new Point3D( new Coordinate( 3500),  new Coordinate(3500), new Coordinate(-2000)),
					  						  new Point3D( new Coordinate(3500), new Coordinate( -3500), new Coordinate(-1000)),
					  						  new Point3D( new Coordinate(-3500), new Coordinate(-3500), new Coordinate(-1000)),
						 						 new Color(0,0,0),
						 						 new Material(1,1,1));
			scene.addGeometry(sphere);
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			
			scene.addLight(new PointLight( new Point3D(new Coordinate(200),new Coordinate(200), new Coordinate(-100)), 
						   0, 0.000001, 0.0000005,new Color(255, 100, 100)));
			
			ImageWriter imageWriter = new ImageWriter("PointShadowTest", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
	@Test
		public void spotLightTest4() throws Exception{//2 triangle, sphere and spot light with shadow
			
			Scene scene = new Scene();
			scene.setDistanceViewPlane(100);
			Material m=new Material(1,1,1);
			m.setN(20);
			Sphere sphere = new Sphere(100, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -200)),new Color(0, 0, 100),new Material(1,1,1));
			sphere.setMaterial(m);
			scene.addGeometry(sphere);
			Triangle triangle = new Triangle(new Point3D(new Coordinate(  3500),new Coordinate(  3500), new Coordinate(-2000)),
					 						 new Point3D(new Coordinate( -3500),new Coordinate( -3500),new Coordinate( -1000)),
					 						 new Point3D(  new Coordinate(-3500),new Coordinate( 3500),new Coordinate( -2000)),
					 						 new Color(0,0,0),
					 						 new Material(1,1,1));

			Triangle triangle2 = new Triangle(new Point3D( new Coordinate( 3500),new Coordinate(  3500),new Coordinate( -2000)),
					  						  new Point3D(new Coordinate( 3500),new Coordinate(  -3500), new Coordinate(-1000)),
					  						  new Point3D( new Coordinate(-3500), new Coordinate(-3500), new Coordinate(-1000)),
						 						 new Color(0,0,0),
						 						 new Material(1,1,1));
			
			scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			
			scene.addLight(new SpotLight( new Point3D(new Coordinate(-200),new Coordinate(-200),new Coordinate( -100)), 0, 0.000001, 0.0000005, 
						   new Vector(new Point3D(new Coordinate(-2),new Coordinate( -2),new Coordinate( -3))),new Color(255, 100, 100)));
		
			
			ImageWriter imageWriter = new ImageWriter("SpotShadowTest", 500, 500, 500, 500);
			
			Render render = new Render(scene, imageWriter);
			
			render.renderImage();

			imageWriter.writeToimage();
			
		}
@Test
public void testRefractionRays() throws Exception{//refract big sphere, inside smaller sphere and spot light.check refraction
	
	Scene scene = new Scene();
	scene.setAmbientLight(new AmbientLight(0,new Color(0,0,0)));
	scene.addGeometry(new Sphere(800, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(0, 0, 100),new Material(1,1,20,0,0.4)));
	scene.addGeometry(new Sphere(500, new Point3D(new Coordinate(0.0),new Coordinate( 0.0),new Coordinate( -1000)),new Color(100, 0, 0),new Material(1,1,20,0,0)));
	
	scene.addLight(new SpotLight( new Point3D(new Coordinate(-200),new Coordinate(-200),new Coordinate( -100)), 0, 0.000001, 0.000005, 
			   new Vector(new Point3D(new Coordinate(2),new Coordinate( 2),new Coordinate( -3))),new Color(255, 100, 100)));
	
	ImageWriter imageWriter = new ImageWriter("SpotSRayTest", 500, 500, 500, 500);
	
	Render render = new Render(scene, imageWriter);
	
	render.renderImage();

	imageWriter.writeToimage();
	
}
@Test
public void testRefractionRays1() throws Exception//refract big sphere, inside smaller sphere and spot light.check refraction
{
	Scene scene = new Scene();
	scene.setDistanceViewPlane(200);
	Sphere c= new Sphere (500, new Point3D(0.0, 0.0, -1000),new Color(0, 0, 100),new Material(1,1,20,0,0.5));
	Sphere  c2= new Sphere (250, new Point3D(0.0, 0.0, -1000),new Color(100, 0, 0),new Material(1,1,20,0,0));
	scene.addGeometry(c);
	scene.addGeometry(c2);		

	scene.addLight(new SpotLight(new Point3D(-200, -200, -150), 0.1, 0.00001, 0.000005,
			new Vector(new Point3D(2, 2, -3)),new Color(255, 100, 100)));
	ImageWriter imageWriter = new ImageWriter("SpotSRayTest1", 500, 500, 500, 500);

	Render render = new Render(scene,imageWriter);

	render.renderImage();
	imageWriter.writeToimage();
}

@Test
public void testReflectionAndRefraction2() throws Exception //spot light, circle, mirrors triangles
{
	Scene scene = new Scene();
	scene.setDistanceViewPlane(300);
	Sphere c= new Sphere(300, new Point3D(-550, -500, -1000),new Color(0, 0, 100),new Material(1,1,20,0,0.5));
	scene.addGeometry(c);
	Sphere c2= new Sphere(150, new Point3D(-550, -500, -1000),new Color(100, 20, 20),new Material(1,1,20,0,0));
	scene.addGeometry(c2);

	Triangle triangle = new Triangle(new Point3D(1500, -1500, -1500),
			new Point3D(-1500, 1500, -1500),
			new Point3D( 200,  200, -375),new Color (20, 20, 20),new Material(1,1,20,1,0));	
	scene.addGeometry(triangle);
	
	Triangle triangle1 = new Triangle(new Point3D(1500, -1500, -1500),
			new Point3D(-1500, 1500, -1500),
			new Point3D(-1500, -1500, -1500),new Color (20, 20, 20),new Material(1,1,20,0.5,0));
	scene.addGeometry(triangle1);
	
	
	
	scene.addLight(new SpotLight( new Point3D(200, 200, -150),0, 0.00001, 0.000005,
			new Vector(new Point3D(-2, -2, -3)),new Color(255, 100, 100)));
	
	ImageWriter imageWriter = new ImageWriter("test Reflection Refraction 2", 500, 500, 500, 500);
	Render render = new Render(scene,imageWriter);

	render.renderImage();
	imageWriter.writeToimage();
}
@Test
public void testSquere() throws Exception
{
	Scene scene = new Scene();
	scene.setDistanceViewPlane(150);
	Point3D p1=new Point3D(-50,50,-140);
	Point3D p4=new Point3D(50,-50,-140);
	Squere s=new Squere(p1,p4,Color.RED,new Material(1,1,19,1,1));
	scene.addGeometry(s);
	
	scene.addLight(new SpotLight( new Point3D(200, 200, -150),0, 0.00001, 0.000005,
			new Vector(new Point3D(-2, -2, -3)),new Color(255, 100, 100)));
	
	ImageWriter imageWriter = new ImageWriter("squere test", 500, 500, 500, 500);
	Render render = new Render(scene,imageWriter);
	
	render.renderImage();
	imageWriter.writeToimage();
}
}

