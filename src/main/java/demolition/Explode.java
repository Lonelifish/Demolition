package demolition;

import processing.core.PImage;

import java.util.ArrayList;


import processing.core.PApplet; 

public class Explode {
	private int x;
	private int y;

	private String[][] mapTable;
/**
* Explode sprite
*/
	public PImage sprite;
	private PImage[] explodes;
	private PImage[] helpersprite;
	private int initial;

	ArrayList<String> explodespace; 

	private ArrayList<Integer> listX;
	private ArrayList<Integer> listY;
/**
* Default width
*/
	public static final int WIDTH = 480;
/**
* Default height
*/
    public static final int HEIGHT = 480;
/**
* Construct an Explode object.
* @param mapTable 2D array for the map.
* @param x Column number of the explosion.
* @param y Row number of the explosion.
* @param explodes Array of sprites for explosion.
* @param initial Initial number used by tick() method, default value is zero.
*/		
	public Explode(String[][] mapTable, int x, int y, PImage[] explodes, int initial) {
		this.mapTable = mapTable;
		this.explodes = explodes;
		this.initial = initial;
		this.x = x;
		this.y = y;
		this.helpersprite = this.explodes;
		this.sprite = this.helpersprite[this.initial];
		this.explodespace = new ArrayList<String>();
		this.listX = new ArrayList<Integer>();
		this.listY = new ArrayList<Integer>();

	}
/**
* Checks the explosion area by reading through the 2D Array of map.
*/
	public void checkExplodeSpace() {
		//center
		explodespace.add("C");
		//left
		if (this.mapTable[this.y-1][this.x].equals("B")){
			explodespace.add("L1");
		}
		else if (!this.mapTable[this.y-1][this.x].equals("B") && !this.mapTable[this.y-1][this.x].equals("W") && !this.mapTable[this.y-2][this.x].equals("W")){
			explodespace.add("L1");
			explodespace.add("L2");
		} 
		else if (!this.mapTable[this.y-1][this.x].equals("B") && !this.mapTable[this.y-1][this.x].equals("W") && this.mapTable[this.y-2][this.x].equals("W")){
			explodespace.add("L1");
		}
		//right
		if (this.mapTable[this.y+1][this.x].equals("B")){
			explodespace.add("R1");
		}
		else if (!this.mapTable[this.y+1][this.x].equals("B") && !this.mapTable[this.y+1][this.x].equals("W") && !this.mapTable[this.y+2][this.x].equals("W")){
			explodespace.add("R1");
			explodespace.add("R2");
		} 
		else if (!this.mapTable[this.y+1][this.x].equals("B") && !this.mapTable[this.y+1][this.x].equals("W") && this.mapTable[this.y+2][this.x].equals("W")){
			explodespace.add("R1");
		} 
		//up
		if (this.mapTable[this.y][this.x-1].equals("B")){
			explodespace.add("U1");
		}
		else if (!this.mapTable[this.y][this.x-1].equals("B") && !this.mapTable[this.y][this.x-1].equals("W") && !this.mapTable[this.y][this.x-2].equals("W")){
			explodespace.add("U1");
			explodespace.add("U2");
		} 
		else if (!this.mapTable[this.y][this.x-1].equals("B") && !this.mapTable[this.y][this.x-1].equals("W") && this.mapTable[this.y][this.x-2].equals("W")){
			explodespace.add("U1");
		}
		//down
		if (this.mapTable[this.y][this.x+1].equals("B")){
			explodespace.add("D1");
		}
		else if (!this.mapTable[this.y][this.x+1].equals("B") && !this.mapTable[this.y][this.x+1].equals("W") && !this.mapTable[this.y][this.x+2].equals("W")){
			explodespace.add("D1");
			explodespace.add("D2");
		} 
		else if (!this.mapTable[this.y][this.x+1].equals("B") && !this.mapTable[this.y][this.x+1].equals("W") && this.mapTable[this.y][this.x+2].equals("W")){
			explodespace.add("D1");
		} 
	}
/**
* Draws the explosion on map.
* @param app the main PApplet object.
*/
	public void draw(PApplet app) {
		app.image(this.explodes[0], this.y*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
		//left 1
		for (String e : this.explodespace){
			if (e.equals("C")){
				app.image(this.explodes[0], this.y*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
			}
			if (e.equals("L1")){
				app.image(this.explodes[5], (this.y-1)*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
				if (!this.mapTable[this.y-1][this.x].equals("G")){
					this.mapTable[this.y-1][this.x] = " ";
				}
			}
			if (e.equals("L2")){
				app.image(this.explodes[2], (this.y-2)*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
				if (!this.mapTable[this.y-2][this.x].equals("G")){
					this.mapTable[this.y-2][this.x] = " ";
				}
			}
			if (e.equals("R1")){
				app.image(this.explodes[5], (this.y+1)*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
				if (!this.mapTable[this.y+1][this.x].equals("G")){
					this.mapTable[this.y+1][this.x] = " ";
				}
			}
			if (e.equals("R2")){
				app.image(this.explodes[3], (this.y+2)*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
				if (!this.mapTable[this.y+2][this.x].equals("G")){
					this.mapTable[this.y+2][this.x] = " ";
				}
			}
			if (e.equals("U1")){
				app.image(this.explodes[6], this.y*(WIDTH/mapTable.length),(64+(this.x-1) *((HEIGHT-64)/mapTable[this.x].length)));
				if (!this.mapTable[this.y][this.x-1].equals("G")){
					this.mapTable[this.y][this.x-1] = " ";
				}
			}
			if (e.equals("U2")){
				app.image(this.explodes[4], this.y*(WIDTH/mapTable.length),(64+(this.x-2) *((HEIGHT-64)/mapTable[this.x].length)));
				if (!this.mapTable[this.y][this.x-2].equals("G")){
					this.mapTable[this.y][this.x-2] = " ";
				}
			}
			if (e.equals("D1")){
				app.image(this.explodes[6], this.y*(WIDTH/mapTable.length),(64+(this.x+1) *((HEIGHT-64)/mapTable[this.x].length)));
				if (!this.mapTable[this.y][this.x+1].equals("G")){
					this.mapTable[this.y][this.x+1] = " ";
				}
			}
			if (e.equals("D2")){
				app.image(this.explodes[1], this.y*(WIDTH/mapTable.length),(64+(this.x+2) *((HEIGHT-64)/mapTable[this.x].length)));
				if (!this.mapTable[this.y][this.x+2].equals("G")){
					this.mapTable[this.y][this.x+2] = " ";
				}
			}
		}
   	}
/**
* Puts the explosion covered coordinates in two separate Arrays, one for y(row) and one for x(column).
*/	
	public void getExplodeCoord(){

		for (String e : this.explodespace){
			if (e.equals("L1")){
				this.listY.add(y-1);
				this.listX.add(x);
			}
			if (e.equals("L2")){
				this.listY.add(y-2);
				this.listX.add(x);
			}
			if (e.equals("R1")){
				this.listY.add(y+1);
				this.listX.add(x);
			}
			if (e.equals("R2")){
				this.listY.add(y+2);
				this.listX.add(x);
			}
			if (e.equals("U1")){
				this.listY.add(y);
				this.listX.add(x-1);
			}
			if (e.equals("U2")){
				this.listY.add(y);
				this.listX.add(x-2);
			}
			if (e.equals("D1")){
				this.listY.add(y);
				this.listX.add(x+1);
			}
			if (e.equals("D2")){
				this.listY.add(y);
				this.listX.add(x+2);
			}
			if (e.equals("C")){
				this.listY.add(y);
				this.listX.add(x);
			}
		}
	}
/**
* Gets the explosion Array of row numbers
*@return returns an Array of Integers for explosion row
*/
	public ArrayList<Integer> getXlist(){
		return this.listX;
	}
/**
* Gets the explosion Array of column numbers
*@return returns an Array of Integers for explosion column
*/
	public ArrayList<Integer> getYlist(){
		return this.listY;
	}
}
