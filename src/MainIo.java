import java.util.Scanner;
import java.io.*;
import java.nio.*;

public class MainIo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Chemin d'origine :");
		String 	myString = new String(sc.nextLine());
		File mydir = new File(myString);
		
		if ((!(mydir.exists()) || (!mydir.isDirectory()))) {
			mydir.mkdir();
		}
	}
	
}
