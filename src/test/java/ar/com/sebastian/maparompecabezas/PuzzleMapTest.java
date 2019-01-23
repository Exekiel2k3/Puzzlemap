/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.sebastian.maparompecabezas;

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
    public void initialize(){
        pm1 = new PuzzleMap();
        pm2 = new PuzzleMap(30, 20);
        pm3 = new PuzzleMap(2, 3);
    }
    
    public PuzzleMapTest() {
    }
    
    @Test
    public void testPuzzleMapContructor1(){
        assertTrue((pm1.getColumns()==0) && (pm1.getRows()==0));
    }
    
    @Test
    public void testPuzzleMapContructor2(){
        assertTrue((pm2.getColumns()==20) && (pm2.getRows()==30));
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
    public void testCreateMap(){
        ArrayList<ArrayList<String>> map = pm3.create();
        assertTrue(map.size()==2);
        for (int i = 0; i < pm3.getRows(); i++) {
            assertTrue(map.get(i).size()==pm3.getColumns());
        }
    }
}