package com.company;

public class PixelVertex{

    /* Add a constructor here (if necessary) */
    PixelVertex[] neighbours;
    int x;
    int y;
    int degree;
    int visited;



    /* getX()
       Return the x-coordinate of the pixel corresponding to this vertex.
    */
    public int getX(){
        return x;
    }

    /* getY()
       Return the y-coordinate of the pixel corresponding to this vertex.
    */
    public int getY(){
        return y;
    }

    /* getNeighbours()
       Return an array containing references to all neighbours of this vertex.
    */
    public PixelVertex[] getNeighbours(){
        return neighbours;
    }

    /* addNeighbour(newNeighbour)
       Add the provided vertex as a neighbour of this vertex.
    */
    public void addNeighbour(PixelVertex newNeighbour){
        neighbours[degree] = newNeighbour;
        degree++;
    }

    /* removeNeighbour(neighbour)
       If the provided vertex object is a neighbour of this vertex,
       remove it from the list of neighbours.
    */
    public void removeNeighbour(PixelVertex neighbour){
        for(int i = 0; i < degree; i++){
            if(neighbours[i].equals(neighbour)){
                neighbours[i] = neighbours[degree-1];
                neighbours[degree-1] = null;
                break;
            }
        }
        degree--;
    }

    /* getDegree()
       Return the degree of this vertex.
    */
    public int getDegree(){
        return degree;
    }

    /* isNeighbour(otherVertex)
       Return true if the provided PixelVertex object is a neighbour of this
       vertex and false otherwise.
    */
    public boolean isNeighbour(PixelVertex otherVertex){
        for(int a = 0; a < degree; a++){
            if(neighbours[a].equals(otherVertex)){
                return true;
            }
        }
        return false;
    }

}