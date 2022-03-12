package demolition;

import processing.core.PImage;

public class Player extends GameObject {
/**
* Check if player has found Goal.
*/
	boolean findgoal;
/**
* Construct the Player object.
* @param mapTable 2D array for the map.
* @param x Column number of the player.
* @param y Row number of the player.
* @param downsprite Array of images for down facing player.
* @param upsprite Array of images for up facing player.
* @param leftsprite Array of images for left facing player.
* @param rightsprite Array of images for right facing player.
* @param initial Initial number used by tick() method, default value is zero.
*/
	public Player(String[][] mapTable, int x, int y,  PImage[] downsprite,PImage[] upsprite, PImage[] rightsprite, PImage[] leftsprite, int initial){
		super(mapTable,x,y,downsprite,upsprite,rightsprite,leftsprite,initial);
		this.helpersprite = this.downsprite;
		this.sprite = this.helpersprite[this.initial];
		this.findgoal = false;
		
	}
	public void tick() {
		if (this.initial < this.helpersprite.length-1){
			this.initial += 1;
			this.sprite = this.helpersprite[this.initial];
			if (this.initial == 4) {
				this.initial = 0;
				this.sprite = this.helpersprite[this.initial];
			}
		}
	}
	/**
* Move down by one row to a non-wall, non-broken space.
*/
	public boolean movedown() {
		this.helpersprite = this.downsprite;
		if (!this.mapTable[this.y][this.x+1].equals("W") && !this.mapTable[this.y][this.x+1].equals("B")){
			this.x = this.x +1;
			return true;
		}
		else {
			return false;
		}
	}
	/**
* Move up by one row, to a non-wall, non-broken space.
*/
	public boolean moveup() {
		this.helpersprite = this.upsprite;
		if (!this.mapTable[this.y][this.x-1].equals("W") && !this.mapTable[this.y][this.x-1].equals("B")){
			this.x = this.x -1;
			return true;
		}
		else {
			return false;
		}
	}
	/**
* Move left by one row, to a non-wall, non-broken space.
*/
	public boolean moveleft() {
		this.helpersprite = this.leftsprite;
		if (!this.mapTable[this.y-1][this.x].equals("W") && !this.mapTable[this.y-1][this.x].equals("B")){
			this.y = this.y -1;
			return true;
		}
		else {
			return false;
		}
	}
	/**
* Move right by one row, to a non-wall, non-broken space.
*/
	public boolean moveright() {
		this.helpersprite = this.rightsprite;
		if (!this.mapTable[this.y+1][this.x].equals("W") && !this.mapTable[this.y+1][this.x].equals("B")){
			this.y = this.y +1 ;
			return true;
		}
		else {
			return false;
		}
	}

	public void dir_check() {
	}
	/**
* Check if player has found goal.
* @return If player reaches Goal, return true; else return false.
*/
	public boolean findgoal() {
		if (this.mapTable[this.y][this.x].equals("G")){
			findgoal = true;
			return findgoal;
		}
		else {
			return findgoal;
		}
	}
}
