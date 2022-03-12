package demolition;
import processing.core.PImage;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.*;
import java.io.*;
import org.junit.jupiter.api.Test;

public class ExplodesTest{

    private String[][] mapTable = new String[15][13];
    private String[] lines = new String[13];
    private PImage[] explodes = new PImage[6];
    private ArrayList<String> testarray = new ArrayList<String>();
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
	public void explodetest() throws IOException {

        //Check different explosion positions
        putMapinTable();
        Explode exp = new Explode(mapTable,1,1,explodes,0);
        exp.checkExplodeSpace();
        testarray.add("C");
        testarray.add("D1");
        testarray.add("D2");
        assertTrue(exp.explodespace.equals(testarray));
        exp.getExplodeCoord();
        exp.getXlist();
        exp.getYlist();

        testarray.clear();
        Explode exp2 = new Explode(mapTable,4,6,explodes,0);
        exp2.checkExplodeSpace();
        testarray.add("C");
        testarray.add("L1");
        testarray.add("R1");
        testarray.add("R2");
        testarray.add("U1");
        testarray.add("D1");
        testarray.add("D2");
        assertTrue(exp2.explodespace.equals(testarray));
        exp2.getExplodeCoord();

        testarray.clear();
        Explode exp3 = new Explode(mapTable,6,9,explodes,0);
        exp3.checkExplodeSpace();
        testarray.add("C");
        testarray.add("L1");
        testarray.add("L2");
        testarray.add("U1");
        testarray.add("U2");
        testarray.add("D1");
        assertTrue(exp3.explodespace.equals(testarray));
        exp3.getExplodeCoord();

        testarray.clear();
        Explode exp4 = new Explode(mapTable,4,2,explodes,0);
        exp4.checkExplodeSpace();
        testarray.add("C");
        testarray.add("L1");
        testarray.add("R1");
        testarray.add("U1");
        testarray.add("D1");
        assertTrue(exp4.explodespace.equals(testarray));
        exp4.getExplodeCoord();

        testarray.clear();
        Explode exp5 = new Explode(mapTable,2,4,explodes,0);
        exp5.checkExplodeSpace();
        testarray.add("C");
        testarray.add("L1");
        testarray.add("R1");
        testarray.add("U1");
        testarray.add("D1");
        assertTrue(exp5.explodespace.equals(testarray));
        exp5.getExplodeCoord();

   	}
}
