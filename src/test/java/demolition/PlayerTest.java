package demolition;
import processing.core.PImage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;
import java.io.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	private String[][] mapTable = new String[15][13];
    private String[] lines = new String[13];
    private PImage[] playersprite = new PImage[6];
    private String filepath = "src/test/resources/playertest/level1.txt";
    
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
	public void playertest() throws IOException{
		putMapinTable();
		Player player = new Player(mapTable, 1, 1, playersprite, playersprite, playersprite, playersprite, 0);
		for (int i = 0; i < 10; i++){
			player.tick();
		}
		assertTrue(player.movedown());
		assertTrue(!player.moveleft());
		assertTrue(!player.moveright());
		assertTrue(player.moveup());
		assertTrue(!player.moveup());
		assertTrue(player.moveright());
		assertTrue(player.moveleft());
		assertTrue(player.moveright());
		assertTrue(!player.movedown());

		Player player2 = new Player(mapTable, 3, 11, playersprite, playersprite, playersprite, playersprite, 0);
		assertTrue(!player2.movedown());
		assertTrue(!player2.moveleft());
		assertTrue(!player2.moveright());
		assertTrue(!player2.moveup());
		assertTrue(!player2.findgoal());

		Player player3 = new Player(mapTable, 11, 12, playersprite, playersprite, playersprite, playersprite, 0);
		player3.moveright();
		assertTrue(player3.findgoal());


		
	}
	// @Test 
    // public void playertest() {
    //     // Create an instance of your application
    //     App app = new App();
    //     // Set the program to not loop automatically
    //     app.noLoop();
    //     // Tell PApplet to create the worker threads for the program
    //     PApplet.runSketch(new String[] {"App"}, app);
	// 	// Set the path of the config file to use
	// 	app.setConfig("src/test/resources/playertest/config.json");
	// 	// Call App.setup() to load in sprites
    //     app.setup();
    //     // Set a 1 second delay to ensure all resources are loaded
    //     app.delay(1000);
	// 	// check player tick
	// 	app.player.tick();
	// 	app.player.tick();
	// 	app.player.tick();
	// 	app.player.tick();
	// 	app.player.tick();
	// 	// check player directions
	// 	app.player.dir_check();
	// 	app.player.movedown();
	// 	app.player.moveup();
	// 	app.player.moveleft();
	// 	app.player.moveright();
	// 	// Call keyPressed() 
	// 	app.player.y = 13;
	// 	app.player.x = 12;
	// 	app.player.moveleft();
	// 	app.draw();
	// 	app.player.y = 13;
	// 	app.player.x = 12;
	// 	app.player.moveright();
	// 	app.draw();
	// 	//check find goal - next level
	// 	app.player.findgoal = true;
	// 	app.draw();
	// 	//check find goal - win
	// 	app.player.findgoal = true;
	// 	app.whichlevel = app.levels;
	// 	app.draw();
	// 	//check losing all lives - game over
	// 	app.lifecount = 0;
	// 	app.draw();
    //     // Verify the new state of the program with assertions
    // }
}
