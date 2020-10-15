/*
 Efrar Chitrit 207955287
 Esty Namirovsky 314815507
*/

package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;

public class ImageWriterTest {

	@Test
	public void test1() 
	{
		try{
		ImageWriter image=new ImageWriter("grid",500,500,500,500);
		//divides the screen to grid by interval and put white color in the lines of the grid
		for(int i=0;i<image.getHeight();i++)
		{
			for(int j=0;j<image.getWidth();j++)
			{
				if(i%50==0||j%50==0||j==499||i==499)
				{
					image.writePixel(i,j,255,255,255);
				}
				else
					image.writePixel(i,j,0,0,0);
			}
		}
		image.writeToimage();
		assertTrue(true);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@Test
	public void LinesTest() 
	{
		try {
		ImageWriter image2 = new ImageWriter("lines",500,500,500,500);
		for (int i  = 0; i<500;i++)
			for (int j=0; j<500;j++)
				if (i%50==0||j%50==0)
					image2.writePixel(i, j, 255, 255, 255); //white
				else
					image2.writePixel(i, j, 0, 0, 0); ///black
		
		for (int i  = 200; i<500;i++) //red rectangle
			for (int j  = 0; j<50;j++)
				image2.writePixel(j, i, 240,33,19);
		for (int i  = 300; i<500;i++) //orange rectangle
			for (int j  = 50; j<100;j++)
				image2.writePixel(j, i, 240,100,19);
		for (int i  = 350; i<500;i++) //yellow rectangle
			for (int j  = 100; j<150;j++)
				image2.writePixel(j, i, 240,240,19);
		for (int i  = 250; i<500;i++) //light green rectangle
			for (int j  = 150; j<200;j++)
				image2.writePixel(j, i, 166,240,19);
		for (int i  = 150; i<500;i++) //green rectangle
			for (int j  = 200; j<250;j++)
				image2.writePixel(j, i, 26,240,19);
		for (int i  = 200; i<500;i++) //light blue rectangle
			for (int j  = 250; j<300;j++)
				image2.writePixel(j, i, 19,240,218);
		for (int i  = 300; i<500;i++) //blue rectangle
			for (int j  = 300; j<350;j++)
				image2.writePixel(j, i, 19,137,240);
		for (int i  = 400; i<500;i++) //purple rectangle
			for (int j  = 350; j<400;j++)
				image2.writePixel(j, i, 189,19,240);
		for (int i  = 250; i<500;i++) //light pink rectangle
			for (int j  = 400; j<450;j++)
				image2.writePixel(j, i, 240,19,181);
		for (int i  = 100; i<500;i++) //pink rectangle
			for (int j  = 450; j<500;j++)
				image2.writePixel(j, i, 240,19,85);
		
		for (int i  = 0; i<500;i++)
			for (int j=0; j<500;j++)
				if (i%50==0||j%50==0)
					image2.writePixel(i, j, 255, 255, 255); //white
		image2.writeToimage();
		
		assertTrue(true);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	@Test
	public void TetrisTest() 
	{
		try {
		ImageWriter image = new ImageWriter("tetris",500,500,500,500);

		for (int i  = 0; i<500;i++)
			for (int j=0; j<500;j++)
				if (i%50==0||j%50==0)
					image.writePixel(i, j, 255, 255, 255);
				else
					image.writePixel(i, j, 0, 0, 0);
		
		for (int i  = 250; i<500;i++) //red rectangle
			for (int j  = 0; j<50;j++)
				image.writePixel(j, i, 240, 24, 24);
		
		for (int i  = 400; i<500;i++) //yellow rectangle
			for (int j  = 50; j<100;j++)
				image.writePixel(j, i, 247, 240, 11);
		for (int i  = 400; i<500;i++) //yellow rectangle
			for (int j  = 50; j<100;j++)
				image.writePixel(j, i, 247, 240, 11);
		for (int i  = 350; i<400;i++) //blue rectangle
			for (int j  = 50; j<150;j++)
				image.writePixel(j, i, 11, 27, 247);
		for (int i  = 450; i<500;i++) //yellow rectangle
			for (int j  = 100; j<250;j++)
				image.writePixel(j, i, 247, 240, 11);
		for (int i  = 400; i<450;i++) //blue rectangle
			for (int j  = 100; j<200;j++)
				image.writePixel(j, i,  11, 27, 247);
		for (int i  = 400; i<500;i++) //light blue rectangle
			for (int j  = 250; j<350;j++)
				image.writePixel(j, i, 11,224,247);
		for (int i  = 300; i<500;i++) //pink rectangle
			for (int j  = 350; j<400;j++)
				image.writePixel(j, i, 247,11,216);
		for (int i  = 450; i<500;i++) //pink rectangle
			for (int j  = 400; j<450;j++)
				image.writePixel(j, i, 247,11,216);
		for (int i  = 350; i<450;i++) //light pink rectangle
			for (int j  = 400; j<450;j++)
				image.writePixel(j, i, 245,189,209);
		for (int i  = 400; i<500;i++) //light pink rectangle
			for (int j  = 450; j<500;j++)
				image.writePixel(j, i, 245,189,209);
		for (int i  = 250; i<300;i++) //green rectangle
			for (int j  = 150; j<300;j++)
				image.writePixel(j, i, 59,205,49);
		for (int i  = 300; i<350;i++) //green rectangle
			for (int j  = 200; j<250;j++)
				image.writePixel(j, i, 59,205,49);
		

		for (int i  = 0; i<500;i++)
			for (int j=0; j<500;j++)
				if (i%50==0||j%50==0)
					image.writePixel(i, j, 255, 255, 255);
		image.writeToimage();
		
		assertTrue(true);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	}
