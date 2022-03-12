package demolition;

import processing.core.PImage;
import java.util.Random;
import java.util.ArrayList;

public class Red_Enemy extends GameObject {
/**
* Construct the Red_Enemy object.
* @param mapTable 2D array for the map.
* @param x Column number of the Red_Enemy.
* @param y Row number of the Red_Enemy.
* @param downsprite Array of images for down facing Red_Enemy.
* @param upsprite Array of images for up facing Red_Enemy.
* @param leftsprite Array of images for left facing Red_Enemy.
* @param rightsprite Array of images for right facing Red_Enemy.
* @param initial Initial number used by tick() method, default value is zero.
*/
	public Red_Enemy(String[][] mapTable,int x, int y, PImage[] downsprite,PImage[] upsprite, PImage[] rightsprite, PImage[] leftsprite, int initial){
		super(mapTable,x,y,downsprite,upsprite,rightsprite,leftsprite,initial);
		this.helpersprite = this.downsprite;
		this.sprite = this.helpersprite[this.initial];
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
* Red enemy direction check method.
* The Red Enemy moves in a straight line and turns to a random decision every time its path is blocked by a solid/broken wall.
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
		if (directions.contains(this.move_dir)){
			move(this.move_dir);
			directions.clear();
		}
		else if (directions.contains(this.move_dir) == false){
			Random rand = new Random();
			int upperbound = directions.size();
			int int_random = rand.nextInt(upperbound);
			this.move_dir = directions.get(int_random);
			move(this.move_dir);
			directions.clear();
		}	
	}
}
