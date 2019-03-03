/* PixelGraph.java
   CSC 225 - Summer 2017
   Programming Assignment 3 - Pixel Graph Data Structure

   B. Bird - 07/03/2017
*/ 

import java.awt.Color;

public class PixelGraph{

	/* PixelGraph constructor
	   Given a 2d array of colour values (where element [x][y] is the colour 
	   of the pixel at position (x,y) in the image), initialize the data
	   structure to contain the pixel graph of the image. 
	*/

	int height;	
	int width;
	PixelVertex[][] graph;

	public PixelGraph(Color[][] imagePixels){
		height = imagePixels.length;
		width = imagePixels[0].length;
		graph = new PixelVertex[height][width];
		//System.out.println(height + " " + width);
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				graph[i][j] = new PixelVertex();
				graph[i][j].x = i;
				graph[i][j].y = j;
				graph[i][j].degree = 0;
				graph[i][j].neighbours = new PixelVertex[4];
				graph[i][j].visited = 0;
			}
		}

		for(int i = 0; i < height; i++){
			for(int j = 0; j < width-1; j++){
				if(imagePixels[i][j].equals(imagePixels[i][j+1])){
					graph[i][j].addNeighbour(graph[i][j+1]);
					graph[i][j+1].addNeighbour(graph[i][j]);
				}
			}
		}

		for(int i = 0; i < height-1; i++){
			for(int j = 0; j < width; j++){
				if(imagePixels[i][j].equals(imagePixels[i+1][j])){
					graph[i][j].addNeighbour(graph[i+1][j]);
					graph[i+1][j].addNeighbour(graph[i][j]);
				}
			}
		}

	}
	
	/* getPixelVertex(x,y)
	   Given an (x,y) coordinate pair, return the PixelVertex object 
	   corresponding to the pixel at the provided coordinates.
	   This method is not required to perform any error checking (and you may
	   assume that the provided (x,y) pair is always a valid point in the 
	   image).
	*/
	public PixelVertex getPixelVertex(int x, int y){
		return graph[x][y];
	}
	
	/* getWidth()
	   Return the width of the image corresponding to this PixelGraph 
	   object.
	*/
	public int getWidth(){
		return width;
	}
	
	/* getHeight()
	   Return the height of the image corresponding to this PixelGraph 
	   object.
	*/
	public int getHeight(){
		return height;
	}
	
}