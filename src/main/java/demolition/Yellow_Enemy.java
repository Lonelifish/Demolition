package demolition;

import processing.core.PImage;
import java.util.ArrayList;

public class Yellow_Enemy extends GameObject{

/**
* Construct the Yellow_Enemy object.
* @param mapTable 2D array for the map.
* @param x Column number of the Yellow_Enemy.
* @param y Row number of the Yellow_Enemy.
* @param downsprite Array of images for down facing Yellow_Enemy.
* @param upsprite Array of images for up facing Yellow_Enemy.
* @param leftsprite Array of images for left facing Yellow_Enemy.
* @param rightsprite Array of images for right facing Yellow_Enemy.
* @param initial Initial number used by tick() method, default value is zero.
*/
	public Yellow_Enemy(String[][] mapTable, int x, int y, PImage[] downsprite,PImage[] upsprite, PImage[] rightsprite, PImage[] leftsprite, int initial){
		super(mapTable,x,y,downsprite,upsprite,rightsprite,leftsprite,initial);
		this.helpersprite = this.downsprite;
		this.sprite = this.helpersprite[this.initial];
		this.move_dir = "Down";
	}
	
	public void tick() {
		//handles logic
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
* Yellow enemy direction check method.
* The Yellow Enemy moves in a straight line, but on collision with a wall will attempt to move clockwise
*/
	public void dir_check() {
		//put available directions in a list
		ArrayList<String> directions = new ArrayList<String>();
		
		if (directions.size() == 0){
			if (!this.mapTable[this.y][this.x+1].equals("W") && !this.mapTable[this.y][this.x+1].equals("B")){
				directions.add("Down");
			}
			if (!this.mapTable[this.y][this.x-1].equals("W") && !this.mapTable[this.y][this.x-1].equals("B")){
				directions.add("Up");
			}
			if (!this.mapTable[this.y-1][this.x].equals("W") && !this.mapTable[this.y-1][this.x].equals("B") ){
				directions.add("Left");
			}
			if (!this.mapTable[this.y+1][this.x].equals("W") && !this.mapTable[this.y+1][this.x].equals("B") ){
				directions.add("Right");
			}
			
		}
		//logic for clockwise movement
		if (directions.contains(this.move_dir)){
			move(this.move_dir);
			directions.clear();
		}
		else if (!directions.contains(this.move_dir)  && this.move_dir == "Left"  && directions.size() != 0){
			if (directions.contains("Up")){
				this.move_dir = "Up";
				move(this.move_dir);
				directions.clear();
			}
			else {
				this.move_dir = "Right";
				move(this.move_dir);
				directions.clear();
			}

		}
		else if (!directions.contains(this.move_dir) && this.move_dir == "Down" && directions.size() != 0){
			if (directions.contains("Left")){
				this.move_dir = "Left";
				move(this.move_dir);
				directions.clear();
			}
			else if (directions.contains("Right")){
				this.move_dir = "Right";
				move(this.move_dir);
				directions.clear();
			}
			else {
				this.move_dir = "Up";
				move(this.move_dir);
				directions.clear();
			}

		}
		else if (!directions.contains(this.move_dir) && this.move_dir == "Up"  && directions.size() != 0){
			if (directions.contains("Right")){
				this.move_dir = "Right";
				move(this.move_dir);
				directions.clear();
			}
			else {
				this.move_dir = "Down";
				move(this.move_dir);
				directions.clear();
			}

		}
		else if (!directions.contains(this.move_dir) && this.move_dir == "Right"  && directions.size() != 0){
			if (directions.contains("Down")){
				this.move_dir = "Down";
				move(this.move_dir);
				directions.clear();
			}
			else {
				this.move_dir = "Left";
				move(this.move_dir);
				directions.clear();
			}
		}
		else if (directions.size()==0){
			stuck();
		}	
	}
}
