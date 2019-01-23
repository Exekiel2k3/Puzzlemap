/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.sebastian.puzzlemap;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sebas
 */
public class PuzzleMap {

    private String[] alf = {"AAAAA", "B", "C", "D", "E", "F", "G", "H", "I", 
                            "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", 
                            "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
    private Random random = new Random(System.currentTimeMillis());
    private ArrayList<String> codes = new ArrayList<String>();
    
    private int rows;
    private int columns;

    public PuzzleMap() {
        this.rows = 0;
        this.columns = 0;
    }
    
    public PuzzleMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
        
    private String generateNewCode(){
                
        String code;
        do {            
        String letra = alf[random.nextInt(27)]; 
        String number = String.format("%02d",(int) random.nextInt(50));
        code = "";
        int order = (int) random.nextInt(3);
        
        switch (order){
            case 0: code = letra + number;
                break;
            case 1: code = "0" + letra + letra;
                break;                
            case 2: code = number + letra;
                break;                        
        }  

        } while (codes.contains(code));
        codes.add(code);
            return code;
    }
    
    public ArrayList<ArrayList<String>> create(){
        
        ArrayList<ArrayList<String>> outer = new ArrayList<>();
        ArrayList<String> inner = new ArrayList<>();
        
        for(int i=0; i<rows; i++){//Rows
            for(int j=0; j<columns; j++){//Columns
                inner.add(j, generateNewCode());
            }
            outer.add(i, new ArrayList<>(inner));
            inner.clear();
        }
        
        return outer;        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        PuzzleMap puzzleMap = new PuzzleMap(28,36);
//        
//        for(int i=0; i<puzzleMap.rows; i++){//Rows
//            for(int j=0; j<puzzleMap.columns; j++){//Columns
//
//                System.out.print( puzzleMap.generateNewCode() + "|");
//            }
//            System.out.println();
//        }
    }

        
}