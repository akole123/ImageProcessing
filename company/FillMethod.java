package com.company;


import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class FillMethod{
    static Queue<PixelVertex> q = new LinkedList<PixelVertex>();

    public static void FloodFillDFS(PixelVertex v, Main viewer, Color fillColour){
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

    public static void FloodFillBFS(PixelVertex v, Main viewer, Color fillColour){
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

    public static void OutlineRegionDFS(PixelVertex v, Main viewer, Color outlineColour){

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

    public static void OutlineRegionBFS(PixelVertex v, Main viewer, Color outlineColour){

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
                if(neighbour[i].visited == 0){
                    q.add(neighbour[i]);
                }
            }
        }
        while(q.peek() != null){
            OutlineRegionBFS(q.remove(), viewer, outlineColour);
        }
    }


    public static int CountComponents(PixelGraph G){
        return 0;
    }
}