import java.util.Scanner;

/*
 * Klasse zum Testen der Klasse Codierung
 * @author  Carsten Kocherscheidt (mailto:carsten.kocherscheidt@gmx.de)
 * @version 01.00
 * getestet mit Java-Version 1.8 (Windows), 1.7 (Linux)
 */


public class CodierungTest {
	
	
	public static void main (String args[])
	{
		//Text �ber Console eingeben
		Scanner in = new Scanner(System.in); //CK

		//Codierung �ber Console eingeben = Matrix-Gr��e mxn
		String Klartext="";
		System.out.println("Geben Sie den zu verschl�sselnden Text ein:");
		Klartext = in.nextLine();

		int zeilen, spalten;
		System.out.print("Schl�ssel 1 (Zeilen):  ");
		zeilen = in.nextInt();
		System.out.print("Schl�ssel 2 (Spalten): ");
		spalten = in.nextInt();
		
		Codierung myVerschuesselung = new Codierung (zeilen, spalten);
		String verschusselt = myVerschuesselung.verschluessleText(Klartext);
		System.out.println("Ihr eingegebener Text in verschl�sselter Form:");
		System.out.println(Klartext);
		System.out.println(verschusselt);
		
		Codierung_gen2 myVerschuesselung2 = new Codierung_gen2 (zeilen, spalten);
		String verschusselt2 = myVerschuesselung2.verschluessleText(Klartext);
		System.out.println("Ihr eingegebener Text in verschl�sselter Form:");
		System.out.println(Klartext);
		System.out.println(verschusselt2);
		
		
		//Testfall 1
		String botschaft = "L�sung Einsendeaufgabe ZKT-E2";
		Codierung myCoding = new Codierung (7,5);
		String coded = myCoding.verschluessleText(botschaft);
		System.out.println("Ihr eingegebener Text in verschl�sselter Form:");
		System.out.println(coded);
		//Testfall 2
		String botschaft2 = "L�sung Einsendeaufgabe ZKT-E2";
		Codierung myCoding2 = new Codierung (7,4);
		coded = myCoding2.verschluessleText(botschaft2);
		System.out.println("Ihr eingegebener Text in verschl�sselter Form:");
		System.out.println(coded);

		
		in.close();
		System.out.println("TEST ENDE reached without exception.");
	}

}
