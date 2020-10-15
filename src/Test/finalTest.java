/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;

//import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Elements.AmbientLight;
import Elements.DirectionalLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Squere;
import Geometries.Triangle;
import Primitives.Material;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class finalTest {

	@Test
	public void AngryBird() throws Exception
	{
		//********************scene settings**************************//
		Scene scene = new Scene();
		scene.setDistanceViewPlane(150);
		scene.setBackground(new Color(183,216,249));
		scene.setAmbientLight(new AmbientLight(0.1,Color.black));
		
		//******************creating the bird*************************//
		scene.addGeometry(new Sphere(15, new Point3D(50, 0, -140),Color.BLACK,new Material(1,1,20,0,0)));//right black sphere
    	scene.addGeometry(new Sphere(15, new Point3D(0, 0, -140),Color.BLACK,new Material(1,1,20,0,0)));//left black sphere

    	scene.addGeometry(new Sphere(12, new Point3D(47, 0, -130),Color.white,new Material(1,1,20,0,0)));//right white sphere
    	scene.addGeometry(new Sphere(12, new Point3D(0, 0, -130),Color.white,new Material(1,1,20,0,0)));//left white sphere
    	
    	scene.addGeometry(new Sphere(6, new Point3D(47, 0, -119),Color.BLACK,new Material(1,1,15,0.5,0)));//right black little sphere 
    	scene.addGeometry(new Sphere(6, new Point3D(3, 0, -119),Color.BLACK,new Material(1,1,15,0.5,0)));//left black little sphere 
    	
    	Triangle triangle0 = new Triangle(new Point3D( 155, -103, -150),new Point3D(  -155,-103, -150), new Point3D( 0, 155, -150),Color.BLACK,new Material(1,1,20,0,0));//big black
		Triangle triangle1 = new Triangle(new Point3D( 150, -100, -149),new Point3D(  -150,-100, -149), new Point3D( 0, 150, -149),Color.YELLOW,new Material(1,1,20,1,0));//yellow
		Triangle triangle2 = new Triangle(new Point3D( 20, 7, -115),new Point3D( -20, 12, -115), new Point3D( -10,17, -115),new Color(189,57,17),new Material(1,1,20,0,0));//left orange
		Triangle triangle3 = new Triangle(new Point3D( 22, 7, -115),new Point3D( 60, 12, -115), new Point3D(50,17, -115),new Color(189,57,17),new Material(1,1,20,0,0));//right orange
		Triangle triangle4 = new Triangle(new Point3D(-100, -20, -150),new Point3D(  -140,  -30, -150),new Point3D(-100, -5, -150),Color.BLACK,new Material(1,1,20,0,0));//tail lower black
		Triangle triangle5 = new Triangle(new Point3D(-100, -20, -150),new Point3D(  -150,  10, -150),new Point3D(-70, 0, -150),Color.BLACK,new Material(1,1,20,0,0));//tail middle black
		Triangle triangle6 = new Triangle(new Point3D(-100, -20, -150),new Point3D(  -110,  25, -150),new Point3D(-60, 0, -150),Color.BLACK,new Material(1,1,20,0,0));//tail upper black
		Triangle triangle7 = new Triangle(new Point3D(5, 140, -150),new Point3D(  -25,  200, -150),new Point3D(-15, 100, -150),Color.BLACK,new Material(1,1,20,0,0));//hair bigger black
		Triangle triangle8 = new Triangle(new Point3D(0, 140, -150),new Point3D(  20,  175, -150),new Point3D(-10, 160, -150),Color.BLACK,new Material(1,1,20,0,0));//hair right black
		Triangle triangle9 = new Triangle(new Point3D(0, 150, -150),new Point3D(  -50,  170, -150),new Point3D(0, 125, -150),Color.BLACK,new Material(1,1,20,0,0));//hair left black
		Triangle triangle10 = new Triangle(new Point3D(-10, 125, -150),new Point3D(-40,  125, -150),new Point3D(-10, 160, -150),Color.BLACK,new Material(1,1,20,0,0));//hair lefter black
		Triangle triangle11 = new Triangle(new Point3D(7, -32, -140),new Point3D(30,  -12, -140),new Point3D(63, -32, -140),Color.BLACK,new Material(1,1,20,0,0));// mouse upper black
		Triangle triangle12 = new Triangle(new Point3D(12, -30, -135),new Point3D(30,  -15, -135),new Point3D(58, -30, -135),new Color(255,137,0),new Material(1,1,9,0.5,0));// mouse upper orange
		Triangle triangle13 = new Triangle(new Point3D(7, -32, -140),new Point3D(30,  -43, -140),new Point3D(50, -32, -140),Color.BLACK,new Material(1,1,20,0,0));// mouse lower black
		Triangle triangle14 = new Triangle(new Point3D(10, -32, -135),new Point3D(30,  -40, -135),new Point3D(47, -32, -135),new Color(255,137,0),new Material(1,1,9,0.5,0));// mouse lower orange
		Triangle triangle15 = new Triangle(new Point3D(-260, -50, -155),new Point3D(-80,  0, -155),new Point3D(-260, -260, -155),new Color(8,175,69),new Material(1,1,20,0,0));// left green
		Triangle triangle16 = new Triangle(new Point3D(260, -50, -155),new Point3D(75,  0, -155),new Point3D(260, -260, -155),new Color(8,175,69),new Material(1,1,20,0,0));// right green
		Triangle triangle17 = new Triangle(new Point3D(-260, -260, -155),new Point3D(260, -260, -155), new Point3D( 0, 155, -155),new Color(8,175,69),new Material(1,1,20,0,0));//big green (middle triangle)

		scene.addGeometry(triangle0);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		scene.addGeometry(triangle5);
		scene.addGeometry(triangle6);
		scene.addGeometry(triangle7);
		scene.addGeometry(triangle8);
		scene.addGeometry(triangle9);
		scene.addGeometry(triangle10);
		scene.addGeometry(triangle11);
		scene.addGeometry(triangle12);
		scene.addGeometry(triangle13);
		scene.addGeometry(triangle14);
		scene.addGeometry(triangle15);
		scene.addGeometry(triangle16);
		scene.addGeometry(triangle17);

		//****************adding the lights*********************//
		scene.addLight(new SpotLight( new Point3D(0, 180, -25),0, 0.00001, 0.000005,new Vector(new Point3D(0, -1, 0)),new Color(255, 100, 100)));
		
		scene.addLight(new DirectionalLight(new Vector(new Point3D(-1,-1,0)),new Color(255, 100, 100)));

		//*********************imageWriter settings******************//
		ImageWriter imageWriter = new ImageWriter("finalImage", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();		
		
	}
	
	
	@Test
	public void FinalAngryBird() throws Exception
	{
		//********************scene settings**************************//
		Scene scene = new Scene();
		scene.setDistanceViewPlane(150);
		scene.setBackground(new Color(183,216,249));
		scene.setAmbientLight(new AmbientLight(0.1,Color.black));
		
		//******************creating the bird*************************//
		scene.addGeometry(new Sphere(15, new Point3D(50, 0, -140),Color.BLACK,new Material(1,1,20,0,0)));//right black sphere
    	scene.addGeometry(new Sphere(15, new Point3D(0, 0, -140),Color.BLACK,new Material(1,1,20,0,0)));//left black sphere

    	scene.addGeometry(new Sphere(12, new Point3D(47, 0, -130),Color.white,new Material(1,1,20,0,0)));//right white sphere
    	scene.addGeometry(new Sphere(12, new Point3D(0, 0, -130),Color.white,new Material(1,1,20,0,0)));//left white sphere
    	
    	scene.addGeometry(new Sphere(6, new Point3D(47, 0, -119),Color.BLACK,new Material(1,1,15,0.5,0)));//right black little sphere 
    	scene.addGeometry(new Sphere(6, new Point3D(3, 0, -119),Color.BLACK,new Material(1,1,15,0.5,0)));//left black little sphere 
    	
    	scene.addGeometry(new Sphere(20, new Point3D(-150, 150, -120),Color.PINK,new Material(1,1,20,0,0)));// sphere inside squere 
    	
    	Triangle triangle0 = new Triangle(new Point3D( 155, -103, -150),new Point3D(  -155,-103, -150), new Point3D( 0, 155, -150),Color.BLACK,new Material(1,1,20,0,0));//big black
		Triangle triangle1 = new Triangle(new Point3D( 150, -100, -149),new Point3D(  -150,-100, -149), new Point3D( 0, 150, -149),Color.YELLOW,new Material(1,1,20,1,0));//yellow
		Triangle triangle2 = new Triangle(new Point3D( 20, 7, -115),new Point3D( -20, 12, -115), new Point3D( -10,17, -115),new Color(189,57,17),new Material(1,1,20,0,0));//left orange
		Triangle triangle3 = new Triangle(new Point3D( 22, 7, -115),new Point3D( 60, 12, -115), new Point3D(50,17, -115),new Color(189,57,17),new Material(1,1,20,0,0));//right orange
		Triangle triangle4 = new Triangle(new Point3D(-100, -20, -150),new Point3D(  -140,  -30, -150),new Point3D(-100, -5, -150),Color.BLACK,new Material(1,1,20,0,0));//tail lower black
		Triangle triangle5 = new Triangle(new Point3D(-100, -20, -150),new Point3D(  -150,  10, -150),new Point3D(-70, 0, -150),Color.BLACK,new Material(1,1,20,0,0));//tail middle black
		Triangle triangle6 = new Triangle(new Point3D(-100, -20, -150),new Point3D(  -110,  25, -150),new Point3D(-60, 0, -150),Color.BLACK,new Material(1,1,20,0,0));//tail upper black
		Triangle triangle7 = new Triangle(new Point3D(5, 140, -150),new Point3D(  -25,  200, -150),new Point3D(-15, 100, -150),Color.BLACK,new Material(1,1,20,0,0));//hair bigger black
		Triangle triangle8 = new Triangle(new Point3D(0, 140, -150),new Point3D(  20,  175, -150),new Point3D(-10, 160, -150),Color.BLACK,new Material(1,1,20,0,0));//hair right black
		Triangle triangle9 = new Triangle(new Point3D(0, 150, -150),new Point3D(  -50,  170, -150),new Point3D(0, 125, -150),Color.BLACK,new Material(1,1,20,0,0));//hair left black
		Triangle triangle10 = new Triangle(new Point3D(-10, 125, -150),new Point3D(-40,  125, -150),new Point3D(-10, 160, -150),Color.BLACK,new Material(1,1,20,0,0));//hair lefter black
		Triangle triangle11 = new Triangle(new Point3D(7, -32, -140),new Point3D(30,  -12, -140),new Point3D(63, -32, -140),Color.BLACK,new Material(1,1,20,0,0));// mouse upper black
		Triangle triangle12 = new Triangle(new Point3D(12, -30, -135),new Point3D(30,  -15, -135),new Point3D(58, -30, -135),new Color(255,137,0),new Material(1,1,9,0.5,0));// mouse upper orange
		Triangle triangle13 = new Triangle(new Point3D(7, -32, -140),new Point3D(30,  -43, -140),new Point3D(50, -32, -140),Color.BLACK,new Material(1,1,20,0,0));// mouse lower black
		Triangle triangle14 = new Triangle(new Point3D(10, -32, -135),new Point3D(30,  -40, -135),new Point3D(47, -32, -135),new Color(255,137,0),new Material(1,1,9,0.5,0));// mouse lower orange
		Triangle triangle15 = new Triangle(new Point3D(-260, -50, -155),new Point3D(-80,  0, -155),new Point3D(-260, -260, -155),new Color(8,175,69),new Material(1,1,20,0,0));// left green
		Triangle triangle16 = new Triangle(new Point3D(260, -50, -155),new Point3D(75,  0, -155),new Point3D(260, -260, -155),new Color(8,175,69),new Material(1,1,20,0,0));// right green
		Triangle triangle17 = new Triangle(new Point3D(-260, -260, -155),new Point3D(260, -260, -155), new Point3D( 0, 155, -155),new Color(8,175,69),new Material(1,1,20,0,0));//big green (middle triangle)

		Triangle mirror1 = new Triangle(new Point3D(-200, -150, -170),new Point3D(200, -150, -170), new Point3D( 0, -150, 190),new Color(50,50,50),new Material(0.00001,1,20,0.99999,0.15));
		
		Squere squere = new Squere(new Point3D(-200, 200, -150),new Point3D(-100, 100, -150), Color.black,new Material(0.00001,1,20,0.99999,0.15));
		
		scene.addGeometry(triangle0);
		scene.addGeometry(triangle1);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		scene.addGeometry(triangle5);
		scene.addGeometry(triangle6);
		scene.addGeometry(triangle7);
		scene.addGeometry(triangle8);
		scene.addGeometry(triangle9);
		scene.addGeometry(triangle10);
		scene.addGeometry(triangle11);
		scene.addGeometry(triangle12);
		scene.addGeometry(triangle13);
		scene.addGeometry(triangle14);
		scene.addGeometry(triangle15);
		scene.addGeometry(triangle16);
		scene.addGeometry(triangle17);
		scene.addGeometry(squere);
		scene.addGeometry(mirror1);
		
		//****************adding the lights*********************//
		scene.addLight(new SpotLight( new Point3D(0, 180, -25),0, 0.00001, 0.000005,new Vector(new Point3D(0, -1, 0)),new Color(255, 100, 100)));
		
		scene.addLight(new DirectionalLight(new Vector(new Point3D(-1,-1,0)),new Color(255, 100, 100)));

		//*********************imageWriter settings******************//
		ImageWriter imageWriter = new ImageWriter("finalImageMirror", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		//render.printGrid(50);
		imageWriter.writeToimage();		
		
	}
}