package demolition;

import processing.core.PApplet;
import processing.core.PImage;

public class Map {
	private int x;
	private int y;
	private PImage[] mapsprite;
	private String[][] mapTable;
	private String[] lines;
/**
* Default width.
*/
	public static final int WIDTH = 480;
/**
* Default height.
*/
    public static final int HEIGHT = 480;

/**
* Construct a map object.
* @param mapsprite Array of PImage for map sprites - solid wall, broken, empty and goal.
* @param lines String Array for lines read from the current level.
*/
	public Map(PImage[] mapsprite, String[] lines ){
		this.mapsprite = mapsprite;
		this.lines = lines;
		this.mapTable = new String[15][13];
	}
	
/**
* Put the lines in a 2D Array represeting a map table.
*/
	public void putTextinTable(){
		for (int h = 0; h < lines.length; h ++) {
            for (int w =0; w < lines[h].length(); w ++){
                if (lines[h].charAt(w)=='W'){
                    this.mapTable[w][h] = "W";
                }
                else if (lines[h].charAt(w)=='G'){
                    this.mapTable[w][h] = "G";
                }
                else if (lines[h].charAt(w)=='B'){
                    this.mapTable[w][h] = "B";
                }
                else if (lines[h].charAt(w)=='R'){
                    this.mapTable[w][h] = "R";
                }
                else if (lines[h].charAt(w)=='P'){
                    this.mapTable[w][h] = "P";
                }
                else if (lines[h].charAt(w)=='Y'){
                    this.mapTable[w][h] = "Y";
                }
                else if (lines[h].charAt(w)==' '){
                    this.mapTable[w][h] = " ";
                }
               
            }
        }
	}
/**
* Draw the map.
* @param app The main PApplet object.
*/
	public void draw(PApplet app) {
		//handles graphics, should be a few lines
		for (this.y = 0; this.y < mapTable.length; this.y++){
			for (this.x = 0; x <mapTable[this.y].length; this.x++){
				if (mapTable[this.y][this.x].equals("W")){
					app.image(this.mapsprite[0], this.y*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
				}
				else if (mapTable[this.y][this.x].equals("B")) {
					app.image(this.mapsprite[1], this.y*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
				}
				else if (mapTable[this.y][this.x].equals("G")) {
					app.image(this.mapsprite[2], this.y*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
				}
				else{
					app.image(this.mapsprite[3], this.y*(WIDTH/mapTable.length),(64+this.x *((HEIGHT-64)/mapTable[this.x].length)));
				}
				
			}
		}
   	}
/**
* Returns a 2D String Array as the map table used in the main game function.
* @return Returns a 2D String Array
*/
	public String[][] getMapTable() {
		return this.mapTable;
	}
}
