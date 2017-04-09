package cs560Hex;
import java.util.*;
import java.io.*;

public class ShortestPath {
	
	public static Hex[][] hexArray = new Hex[31][15];
	
	public static void main(String[] args) {
		//first, load up an array with the hex data from the text file:
		loadArray();
		//try printing the array (we should remove this after everybody has looked at it):
		for (int i = 0; i < hexArray.length; i++) {
            for (int j = 0; j < hexArray[i].length; j++) {
            	try{
            		System.out.print(hexArray[i][j].index + " ");
            	}
            	catch(Exception e){
            		System.out.print(hexArray[i][j] + " ");
            	}
            }
            System.out.println();
        }
	}
	
	public static void loadArray(){
		//load up the text file:
		try{
			File textfile = new File("weights.txt");
			Scanner scanner = new Scanner(textfile);
			
			//textfile is loaded, now load the hexArray with the data from textfile:
			int currentRow = 1;
			while(scanner.hasNextLine()){
				int currentColumn = 1;
				//handle odd rows (first row is row 1):
				if((currentRow % 2) != 0){
					while(currentColumn <= 15){
						//only add elements in odd columns(first column is column 1):
						if((currentColumn % 2) != 0){
							//make a new Hex and put it in the current position
							Hex hex = new Hex(scanner.nextInt(), scanner.nextInt());
							hexArray[currentRow-1][currentColumn-1] = hex;
						}
						else{
							hexArray[currentRow-1][currentColumn-1] = null;
						}
						currentColumn++;
					}
				}
				//handle even rows:
				else if((currentRow % 2) == 0){
					while(currentColumn <= 15){
						//only add elements in odd columns(first column is column 1):
						if((currentColumn % 2) != 0){
							hexArray[currentRow-1][currentColumn-1] = null;
						}
						else{
							//make a new Hex and put it in the current position
							Hex hex = new Hex(scanner.nextInt(), scanner.nextInt());
							hexArray[currentRow-1][currentColumn-1] = hex;
						}
						currentColumn++;
					}
				}
				currentRow++;
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

