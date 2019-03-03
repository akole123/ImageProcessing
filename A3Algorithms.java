/* A5Algorithms.java
   CSC 225 - Summer 2017
   Programming Assignment 3 - Image Algorithms


   B. Bird - 07/03/2017
*/ 

import java.util.*;
import java.awt.Color;

public class A3Algorithms{
	static Queue<PixelVertex> q = new LinkedList<PixelVertex>();
	/* FloodFillDFS(v, viewer, fillColour)
	   Traverse the component the vertex v using DFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void FloodFillDFS(PixelVertex v, ImageViewer225 viewer, Color fillColour){
		if(v.visited == 1){
			return;
		}
		v.visited = 1;
		viewer.setPixel(v.getX(), v.getY(), fillColour);
		if(v.getDegree() == 1){
			return;
		}else{
			PixelVertex[] neighbour = new PixelVertex[v.getDegree()];
			neighbour = v.getNeighbours();
			for(int i = 0; i < v.getDegree(); i++){
				FloodFillDFS(neighbour[i], viewer, fillColour);
			}
		}
	}
	
	/* FloodFillBFS(v, viewer, fillColour)
	   Traverse the component the vertex v using BFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void FloodFillBFS(PixelVertex v, ImageViewer225 viewer, Color fillColour){
		if(v.visited == 1){
			return;
		}
		v.visited = 1;
		viewer.setPixel(v.getX(), v.getY(), fillColour);

		if(v.getDegree() == 1){
			return;
		}else{
			PixelVertex[] neighbour = new PixelVertex[v.getDegree()];
			neighbour = v.getNeighbours();
			for(int i = 0; i < v.getDegree(); i++){
				if(neighbour[i].visited == 0){
					q.add(neighbour[i]);
				}		
			}
		}
		while(q.peek() != null){
			FloodFillBFS(q.remove(), viewer, fillColour);
		}
	}
	
	/* OutlineRegionDFS(v, viewer, outlineColour)
	   Traverse the component the vertex v using DFS and set the colour 
	   of the pixels corresponding to all vertices with degree less than 4
	   encountered during the traversal to outlineColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void OutlineRegionDFS(PixelVertex v, ImageViewer225 viewer, Color outlineColour){
	
		if(v.visited == 1){
			return;
		}
		v.visited = 1;
		
		if(v.getDegree() != 4){
		
			viewer.setPixel(v.getX(), v.getY(), outlineColour);
		
		}

		if(v.getDegree() == 1){
			return;
		}else{
			PixelVertex[] neighbour = new PixelVertex[v.getDegree()];
			neighbour = v.getNeighbours();
			for(int i = 0; i < v.getDegree(); i++){
				OutlineRegionDFS(neighbour[i], viewer, outlineColour);
			}
		}
	}
	
	/* OutlineRegionBFS(v, viewer, outlineColour)
	   Traverse the component the vertex v using BFS and set the colour 
	   of the pixels corresponding to all vertices with degree less than 4
	   encountered during the traversal to outlineColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void OutlineRegionBFS(PixelVertex v, ImageViewer225 viewer, Color outlineColour){

		if(v.visited == 1){
			return;
		}
		v.visited = 1;


		if(v.getDegree() != 4){
			//System.out.println(v.getDegree());
			viewer.setPixel(v.getX(), v.getY(), outlineColour);
	
		}

		if(v.getDegree() == 1){
			return;
		}else{
			PixelVertex[] neighbour = new PixelVertex[v.getDegree()];
			neighbour = v.getNeighbours();
			for(int i = 0; i < v.getDegree(); i++){
				if(neighbour[i].visited == 0){
					q.add(neighbour[i]);
				}		
			}
		}
		while(q.peek() != null){
			OutlineRegionBFS(q.remove(), viewer, outlineColour);
		}
	}

	/* CountComponents(G)
	   Count the number of connected components in the provided PixelGraph 
	   object.
	*/
	public static int CountComponents(PixelGraph G){
		//int count = 0;
		//int[][] visitgraph = new int[G.getHeight()][G.getWidth()];
		//PixelVertex[][] vertices = G.graph;
		return 0;
	}
}