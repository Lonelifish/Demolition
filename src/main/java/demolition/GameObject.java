package demolition;

import processing.core.PImage;
import processing.core.PApplet;

public abstract class GameObject {
/**
* Row number for the object.
*/
	protected int x;
	/**
* Column number for the object.
*/
	protected int y;
	/**
* 2D Array for the map, storing location information for game object except for clock and time.
*/
	protected String[][] mapTable;
	/**
* PImage Array for game objects facing up.
*/
	protected PImage[] upsprite;
	/**
* PImage Array for game objects facing down.
*/
	protected PImage[] downsprite;
	/**
* PImage Array for game objects facing left.
*/
	protected PImage[] leftsprite;
	/**
* PImage Array for game objects facing right;
*/
	protected PImage[] rightsprite;
/**
* Initial number used by tick() method, default value is zero.
*/
	protected int initial;
/**
* Direction indicator for movable objects, can only be Up, Down, Right or Left.
*/
	protected String move_dir;
/**
* Helper PImage Array used to switch image sets when movable objects change direction.
*/
	protected PImage[] helpersprite;
/**
* PImage used in draw method.
*/
	protected PImage sprite;
/**
* Default width.
*/
	public static final int WIDTH = 480;
/**
* Default height.
*/
    public static final int HEIGHT = 480;

/**
* Construct a game object.
* @param mapTable 2D array for the map
* @param x Column number for the object
* @param y Row number for the object
* @param downsprite Array of images for down facing movable game objects
* @param upsprite Array of images for up facing movable game objects
* @param leftsprite Array of images for left facing movable game objects
* @param rightsprite Array of images for right facing movable game objects
* @param initial Initial number used by tick() method, default value is zero.
*/
	public GameObject(String[][] mapTable, int x, int y, PImage[] downsprite,PImage[] upsprite, PImage[] rightsprite, PImage[] leftsprite, int initial){
		this.downsprite = downsprite;
		this.upsprite = upsprite;
		this.rightsprite = rightsprite;
		this.leftsprite = leftsprite;
		this.mapTable = mapTable;
		this.x = x;
		this.y = y;
		this.helpersprite = this.downsprite;
		this.sprite = this.helpersprite[this.initial];
	}
/**
* Method to form animation.
*/
	public abstract void tick();
/**
* Check movable object directions.
*/
	public abstract void dir_check(); 
/**
* Method to move object across the map.
* @param move_dir can only be Up, Down, Right or Left.
*/
	public void move(String move_dir){
		
		if (move_dir == "Down"){
			movedown();
		}
		else if (move_dir == "Up"){
			moveup();
		}
		else if (move_dir == "Left"){
			moveleft();
		}
		else if (move_dir == "Right"){
			moveright();
		}
	}
	
/**
* draw movable objects on map.
* @param app the main PApplet object.
*/
	public void draw(PApplet app){
		app.image(this.sprite, this.y*(WIDTH/mapTable.length),(48+(this.x) *((HEIGHT-64)/mapTable[this.x].length)));
	}
/**
* Move the object down by one row.
* @return if move success return true, else do nothing.
*/
	public boolean movedown() {
		this.helpersprite = this.downsprite;
		this.x = this.x + 1;
		return true;
	}
/**
* Move the object up by one row.
* @return if move success return true, else do nothing.
*/	
	public boolean moveup() {
		this.helpersprite = this.upsprite;
		this.x = this.x - 1;
		return true;
		
	}
/**
* Move the object left by one column.
* @return if move success return true, else do nothing.
*/	
	public boolean moveleft() {
		this.helpersprite = this.leftsprite;
		this.y = this.y - 1;
		return true;
	}
/**
* Move the object right by one row.
* @return if move success return true, else do nothing.
*/	
	public boolean moveright() {
		this.helpersprite = this.rightsprite;
		this.y = this.y + 1;
		return true;
	}
/**
* Stay stationary
* @return if stuck use down sprite and return true, else do nothing.
*/	
public boolean stuck() {
	this.helpersprite = this.downsprite;
	return true;
}
/**
* @return returns the column number of the object.
*/	
	public int getX(){
		return this.x;
	}
/**
* @return returns the row number of the object.
*/	
	public int getY(){
		return this.y;
	}
}