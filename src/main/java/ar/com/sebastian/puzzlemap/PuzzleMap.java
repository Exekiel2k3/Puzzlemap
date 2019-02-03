/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ar.com.sebastian.puzzlemap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author sebas
 */
public class PuzzleMap {
    
    private Random random = new Random(System.currentTimeMillis());
    private HashSet<String> codes = new HashSet<String>(500, (float) 0.9);
    
    private int rows;
    private int columns;
    private int lengthCode;
    private ArrayList<ArrayList<String>> map;
    
    public PuzzleMap() {
        this.rows = 0;
        this.columns = 0;
        this.lengthCode = 0;
        this.map = null;
    }
    
    public PuzzleMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.lengthCode = 0;
        this.map = null;
    }
    
    public int getColumns() {
        return this.columns;
    }
    
    public int getRows() {
        return this.rows;
    }
    
    public int getLengthCode() {
        return this.lengthCode;
    }
    
    public ArrayList<ArrayList<String>> getMap() {
        return this.map;
    }
    
    public void setRows(int rows) {
        this.rows = rows;
    }
    
    public void setColumns(int columns) {
        this.columns = columns;
    }
    
    public void setLengthCode(int lengthCode) {
        this.lengthCode = lengthCode;
    }
    
    private String generateNewCode() {
        
        if (this.lengthCode == 0) {
            return "";
        }
        
        String code;
        do {
            code = "";
            for (int i = 0; i < this.lengthCode; i++) {
                int auxRand = random.nextInt(25);
                char aux[] = Character.toChars(65 + auxRand);
                code = code.concat(new String(aux));
            }
            
        } while (!codes.add(code));
        
        return code;
    }
    
    public void create() {
        ArrayList<ArrayList<String>> auxMap = new ArrayList<>();
        ArrayList<String> inner = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {//Rows
            for (int j = 0; j < columns; j++) {//Columns
                inner.add(j, generateNewCode());
            }
            auxMap.add(i, new ArrayList<>(inner));
            inner.clear();
        }
        map = auxMap;
    }
    
    @Override
    public String toString() {
        
        String auxMap = "";
        
        for (int i = 0; i < this.rows; i++) {//Rows
            for (int j = 0; j < this.columns; j++) {//Columns
                auxMap = auxMap.concat(map.get(i).get(j)).concat(" ");
            }
            auxMap = auxMap.concat("\n");
        }
        
        return "rows: " + rows + "\n"
                + "columns: " + columns + "\n"
                + "lengthCode: " + lengthCode + "\n"
                + "map: " + "\n" + auxMap;
    }  
}
