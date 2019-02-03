/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.sebastian.puzzlemaptest;

import ar.com.sebastian.puzzlemap.PuzzleMap;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author sebas
 */
public class PuzzleMapTest {

    private PuzzleMap pm1, pm2, pm3;

    @Before
    public void initialize() {
        pm1 = new PuzzleMap();
        pm2 = new PuzzleMap(30, 20);
        pm3 = new PuzzleMap(2, 3);
        pm3.setLengthCode(2);
    }

    public PuzzleMapTest() {
    }

    @Test
    public void testPuzzleMapContructor1() {
        assertTrue((pm1.getColumns() == 0)
                && (pm1.getRows() == 0)
                && (pm1.getLengthCode() == 0)
                && (pm1.getMap() == null));
    }

    @Test
    public void testPuzzleMapContructor2() {
        assertTrue((pm2.getColumns() == 20)
                && (pm2.getRows() == 30)
                && (pm2.getLengthCode() == 0)
                && (pm2.getMap() == null));
    }

    @Test
    public void testSetRows() {
        pm1.setRows(13);
        assertEquals(null, 13, pm1.getRows());
    }

    @Test
    public void testSetColumns() {
        pm1.setColumns(33);
        assertEquals(null, 33, pm1.getColumns());
    }

    @Test
    public void testGetRows() {
        assertEquals(null, 30, pm2.getRows());
    }

    @Test
    public void testGetColumns() {
        assertEquals(null, 20, pm2.getColumns());
    }

    @Test
    public void testSetLengthCode() {
        pm1.setLengthCode(2);
        assertEquals(null, 2, pm1.getLengthCode());
    }

    @Test
    public void testGetLengthCode() {
        assertEquals(null, 0, pm2.getLengthCode());
    }

    @Test
    public void testGetMap() {
        pm3.create();
        ArrayList<ArrayList<String>> map = pm3.getMap();
        assertTrue(map.size() == 2);
        for (int i = 0; i < pm3.getRows(); i++) {
            assertTrue(map.get(i).size() == pm3.getColumns());
        }
    }

    @Test
    public void testUniqueValue() {
        ArrayList<ArrayList<String>> map;
        pm3.create();
        map = pm3.getMap();
        int count;
        
        for (int i = 0; i < pm3.getRows(); i++) {//Rows
            for (int j = 0; j < pm3.getColumns(); j++) {//Columns
                String code = map.get(i).get(j);
                count = 0;
                for (int k = 0; k < pm3.getRows(); k++) {//Rows
                    for (int l = 0; l < pm3.getColumns(); l++) {//Columns
                        if(code==map.get(k).get(l)){
                            count++;
                        }
                    }
                }
                
                assertTrue(count==1);
            }
        }
    }
    
    @Test
    public void testToString(){
        pm3.create();
        System.out.println(pm3.toString());;
        assertTrue(true);
    }
}
