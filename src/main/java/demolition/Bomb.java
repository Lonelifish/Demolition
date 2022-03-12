package demolition;

import processing.core.PImage;
import processing.core.PApplet; 

public class Bomb {
	private int x;
	private int y;

	private String[][] mapTable;
/**
* Bomb sprite
*/
	public PImage sprite;
	private PImage[] bombs;
	private int initial;
	private int tick;
/**
* Default width
*/
	public static final int WIDTH = 480;
/**
* Default height
*/
    public static final int HEIGHT = 480;
/**
* Construct a bomb object.
* @param mapTable 2D array for the map.
* @param x Column number of the bomb.
* @param y Row number of the bomb.
* @param bombs Array of sprites for bomb.
* @param initial Initial number used by tick() method, default value is zero.
*/	
	public Bomb(String[][] mapTable, int x, int y, PImage[] bombs, int initial){
		this.mapTable = mapTable;
		this.bombs = bombs;
		this.x = x;
		this.y = y;
		this.initial = initial;
		this.sprite = this.bombs[this.initial];
		this.tick = 1;
	}
/**
* Method to form bomb animation, loops through the bomb sprite array.
*/
	public void tick(){
		if (this.initial < this.bombs.length-1){
			this.initial += this.tick;
			this.sprite = this.bombs[this.initial];
		}
	}
/**
* Draw bomb object on map.
* @param app the main PApplet object.
*/
	public void draw(PApplet app) {
		app.image(this.sprite, this.y*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
   	}
}
