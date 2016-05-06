import java.util.Scanner;
import java.io.*;
import java.nio.*;

public class MainIo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String myReponse = "";

		System.out.println("Chemin d'origine :");
		String myString = new String(sc.nextLine());
		File mydir = new File(myString);

		if ((!(mydir.exists()) || (!mydir.isDirectory()))) {
			mydir.mkdir();
		}

		System.out.println("Voulez-vous une arborescence à 2 niveaux ? (O/N) :");
		do {
			myReponse = new String(sc.next());
		} while (!myReponse.equals("N") && !myReponse.equals("O"));

		if (myReponse.equals("O")) {
			mydir = new File(myString + "/sub1");
			if ((!(mydir.exists()) || (!mydir.isDirectory()))) {
				mydir.mkdir();
			}
			mydir = new File(myString + "/sub1/sub2");
			if ((!(mydir.exists()) || (!mydir.isDirectory()))) {
				mydir.mkdir();
			}
			// Directory
			writeDirFile(myString + "/sub1");
			writeDirFile(myString + "/sub1/sub2");
		}
		writeDirFile(myString);
		

		 System.out.println("Chemin du fichier texte à copier :");
		 String otherString = new String(sc.nextLine());
		 mydir = new File(otherString);
		 try {
			  String pathname = otherString.substring(otherString.lastIndexOf("/"));
			FileOutputStream myDirFile = new FileOutputStream(new File(myString + "/"+pathname));
			try {
				myDirFile.write(myString.getBytes());
				myDirFile.write("\n\r".getBytes());
				
				myDirFile.write(date);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void writeDirFile(String dirpathname) {
		File mydir = new File(dirpathname);
		try {
			FileOutputStream myDirFile = new FileOutputStream(new File(dirpathname + "/.directory"));

			for (String stFileName : mydir.list()) {
				try {
					myDirFile.write(stFileName.getBytes());
					myDirFile.write("\n\r".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				myDirFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
