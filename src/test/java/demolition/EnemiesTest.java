package demolition;
import processing.core.PImage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;
import java.io.*;
import org.junit.jupiter.api.Test;

public class EnemiesTest {

	private String[][] mapTable = new String[15][13];
    private String[] lines = new String[13];
    private PImage[] enemysprite = new PImage[6];
	private String filepath = "src/test/resources/enemytest/level1.txt";

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
	public void enemytest() throws IOException{
		putMapinTable();

		//check yellow enemy movement logic
		Yellow_Enemy yellow1 = new Yellow_Enemy(mapTable, 3, 7, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow1.move(yellow1.move_dir);
		assertEquals(4, yellow1.getX());
		assertEquals(7, yellow1.getY());
		yellow1.tick();
	
		Yellow_Enemy yellow2 = new Yellow_Enemy(mapTable, 11, 13, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow2.dir_check();
		assertEquals(11, yellow2.getX());
		assertEquals(12, yellow2.getY());
		yellow2.tick();
		yellow2.tick();
		yellow2.tick();
		yellow2.tick();
		yellow2.tick();

		Yellow_Enemy yellow3 = new Yellow_Enemy(mapTable, 11, 1, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow3.dir_check();
		assertEquals(11, yellow3.getX());
		assertEquals(2, yellow3.getY());

		Yellow_Enemy yellow4 = new Yellow_Enemy(mapTable, 5, 12, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow4.dir_check();
		assertEquals(5, yellow4.getX());
		assertEquals(13, yellow4.getY());
		yellow4.dir_check();
		assertEquals(6, yellow4.getX());
		assertEquals(13, yellow4.getY());
		yellow4.dir_check();
		yellow4.dir_check();
		yellow4.dir_check();
		assertEquals(7, yellow4.getX());
		assertEquals(13, yellow4.getY());

		Yellow_Enemy yellow5 = new Yellow_Enemy(mapTable, 3, 11, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow5.dir_check();
		yellow5.dir_check();
		assertEquals(3, yellow5.getX());
		assertEquals(11, yellow5.getY());

		Yellow_Enemy yellow6 = new Yellow_Enemy(mapTable, 11, 2, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow6.dir_check();
		yellow6.dir_check();
		assertEquals(10, yellow6.getX());
		assertEquals(1, yellow6.getY());

		Yellow_Enemy yellow7 = new Yellow_Enemy(mapTable, 9, 2, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow7.dir_check();
		yellow7.dir_check();
		assertEquals(9, yellow7.getX());
		assertEquals(2, yellow7.getY());

		Yellow_Enemy yellow8 = new Yellow_Enemy(mapTable, 2, 12, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow8.dir_check();
		yellow8.dir_check();
		assertEquals(1, yellow8.getX());
		assertEquals(13, yellow8.getY());

		Yellow_Enemy yellow9 = new Yellow_Enemy(mapTable, 2, 9, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow9.dir_check();
		yellow9.dir_check();
		assertEquals(2, yellow9.getX());
		assertEquals(9, yellow9.getY());

		Yellow_Enemy yellow10 = new Yellow_Enemy(mapTable, 11, 10, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		yellow10.dir_check();
		yellow10.dir_check();
		yellow10.dir_check();
		yellow10.dir_check();
		assertEquals(11, yellow10.getX());
		assertEquals(12, yellow10.getY());
		//check red enemy movement
		Red_Enemy red = new Red_Enemy(mapTable, 5, 5, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		red.tick();
		red.tick();
		red.tick();
		red.tick();
		red.tick();
		red.dir_check();
		red.dir_check();
		red.dir_check();
		red.dir_check();
		red.dir_check();
		red.dir_check();
		red.dir_check();
		red.dir_check();
		red.dir_check();
		red.dir_check();

		Red_Enemy red2 = new Red_Enemy(mapTable, 5, 1, enemysprite, enemysprite, enemysprite, enemysprite, 0);
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		red2.dir_check();
		
		

	}
}
