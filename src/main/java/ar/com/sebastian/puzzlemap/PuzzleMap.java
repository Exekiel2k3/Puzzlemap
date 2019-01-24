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

    private Random random = new Random(System.currentTimeMillis());
    private ArrayList<String> codes = new ArrayList<String>();
    
    private int rows;
    private int columns;
    private int lengthCode;

    public PuzzleMap() {
        this.rows = 0;
        this.columns = 0;
	this.lengthCode = 0;
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
	
    public int getLengthCode() {
        return lengthCode;
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
       
    private String generateNewCode(){

        if(this.lengthCode==0){
            return "";
        }
        
        String code;
        do {
            code = "";
            for(int i=0; i<this.lengthCode; i++){
                int auxRand = random.nextInt(25);
                char aux[] = Character.toChars( 65 + auxRand);
                code = code.concat(new String(aux));
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
	
//	@Override
//	public String toString(){
//		
//		String map = "";
//		
//		for(int i=0; i<rows; i++){//Rows
//            for(int j=0; j<columns; j++){//Columns
//				inner.add(j, generateNewCode2());
//            }
//            outer.add(i, new ArrayList<>(inner));
//            inner.clear();
//        }
//		
//		return 	"rows: " + rows + "\n" +
//				"columns: " + columns "\n" +
//				"lengthCode: " + lengthCode + "\n" +
//				
//	
//	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
               
//        PuzzleMap puzzleMap = new PuzzleMap(28,36);
//        puzzleMap.setLengthCode(2);
//        
//        for(int i=0; i<puzzleMap.rows; i++){//Rows
//            for(int j=0; j<puzzleMap.columns; j++){//Columns
//
//                System.out.print( puzzleMap.generateNewCode2() + "|");
//            }
//            System.out.println();
//        }
    }

        
}