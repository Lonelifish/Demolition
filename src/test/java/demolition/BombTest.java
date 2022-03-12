package demolition;

import processing.core.PImage;
import java.util.*;
import java.io.*;
import org.junit.jupiter.api.Test;

public class BombTest {
	private String[][] mapTable = new String[15][13];
    private String[] lines = new String[13];
    private PImage[] bombsprite = new PImage[6];
	private String filepath = "src/test/resources/explodetest/level1.txt";

	public void putMapinTable() throws IOException{

        BufferedReader in = new BufferedReader(new FileReader(filepath));
        String str;
        List<String> list = new ArrayList<String>();
        while( (str = in.readLine())!= null ){
            list.add(str);
        }
        lines = list.toArray(new String[0]);
        in.close();
        
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
	@Test 
   public void bombtest() throws IOException {
		putMapinTable();
		Bomb bomb1 = new Bomb(mapTable,1,1,bombsprite,0);
		bomb1.tick();
		bomb1.tick();
		bomb1.tick();
		bomb1.tick();
		bomb1.tick();
      
      
   	}
}
