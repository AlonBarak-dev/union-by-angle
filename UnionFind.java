package ex4;

import java.awt.Point;

import java.awt.Point;

public class UnionFind {
	//Add class properties
	Point[] elements;
	double angle;
	int[] id;
	int size;
	
	public UnionFind(int size, double angle) {
		
		this.id = new int[size];
		this.elements = new Point[size];
		this.angle = angle;
		this.size  = size;
		this.elements = Ex4Utils.generateRandomArray(size);	//creating a random array of points in length of the given size
		doisJoin();
		Point p = new Point(50,50);
		UnionByAngularDist(p);		
	
	}
	/**
	 * return the group number of a given point
	 * @param p -> an index that represent a point
	 * @return its group number
	 */
	public int Find(int p) {

		if(id[p] == p)
			return p;
		else
			return Find(id[p]);
	
	}
	
	
	
	public void doisJoin() {
		for(int i = 0; i< size; i++) {
			id[i] = i;		//creating an array of groups for each element
		}	}
	
	/**
	 * merge between two groups of points.
	 * merge group ind1 to ind2
	 * @param ind1 -> first group
	 * @param ind2 -> second group
	 */
	public void Union(int ind1, int ind2) {
		
		for(int i = 0; i < id.length;i++) {
			if(id[i] == id[ind1])
				id[i] = id[ind2];
		}
		
	}

	public void increaseAngle(int d) {
		this.angle += d;		//increasing the angle by d
		Point p = new Point(50,50);		//center point
		UnionByAngularDist(p);				//union by the new angle
	
	}
	
	
	/**
	 * Divides the points into groups according to the size of their 
	 * angle relative to the Point p.
	 * @param p
	 */
	public void UnionByAngularDist(Point p) {
		
		int groupsNumber = (int) (360/angle);	//he number of groups needed base on the current angle
		
		if(360 % angle != 0)	//in case the 360 isnt divided by the angle
			groupsNumber++;
		
		int[] groups = new int[groupsNumber];		//creating an array of groups {0,1,2...n}
		
		for (int i = 0; i < groups.length; i++) {
		
			groups[i] = Integer.MIN_VALUE;		
		}
		
		for (int j = 0; j < elements.length; j++) {
			
			int d = (int)((Ex4Utils.angleFrom(p,elements[j]))/(angle));		//finding a new group to elements[j] base on its angle
		
			if(groups[d]== Integer.MIN_VALUE) {
				groups[d]=j;	
			}
			else 
				Union(j,groups[d]);		//union the groups 
			
			if(this.id[j]==j)
				groups[d]=j;			
	}	
   }
	
	

	
	
	
	

}























