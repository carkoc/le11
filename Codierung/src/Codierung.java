import java.util.Random;

/**
 * Klasse zur Verschlüsselung von Texten in einer 2dim-Matrix, deren Größe das Geheimnis ist
 * @author  Carsten Kocherscheidt (mailto:carsten.kocherscheidt@gmx.de)
 * @version 01.00
 * getestet mit Java-Version 1.8 (Windows), 1.7 (Linux)
 */


public class Codierung  
{
	
	private int zeilen;
	private int spalten;
	
	/**
	 * default Konstruktur
	 * @param zeilen	maximale Anzahl von Zeilen
	 * @param spalten	maximale Anzahl von Spalten
	 */
	public Codierung  (int zeilen, int spalten)
	{
		this.zeilen  = zeilen;
		this.spalten = spalten;
	}
	
	/**
	 * Methode zum Verschlüsseln des eines Textes
	 * @param klarText	zu verschlüsselnder Text in einem String
	 * @return verschlüsselter Text als String
	 */
	public String verschluessleText (String klarText)
	{
		String codedText = "";
		//Leerzeichen entfernen
		String cleanText = "";
		for (char zeichen : klarText.toCharArray())
		{   
			if (' ' != zeichen) cleanText += zeichen;
		}
		//System.out.println(cleanText); //Debug
		klarText=cleanText;
		
		//zuerst Größenprüfung
		if (klarText.length() >  (zeilen*spalten))
		{
			throw new IllegalArgumentException("Die Matrix " + zeilen + " x " + spalten 
					+ " ist zu klein für den zu verschlüsselnden Text der Länge " 
					+ klarText.length() + " Byte!");
		}
		
		//Text in Array speichern
		char[][] cube = new char [zeilen][spalten];
		
		int z=0, s=0;
		for (int i=0;i < klarText.length();i++)
		{
			//System.out.println(z + " " + s + ": " + klarText.charAt(i) ); //DEBUG
			cube[z][s] = klarText.charAt(i);
			if (s < (spalten-1) ) s++;
			else 
			{	s=0; 
				if (z < (zeilen-1) ) z++;
				else
					z = 0;
				//end else
			}//end else
		}//end for
		
		//zusätzliche Zellen mit Random-Zeichen auffüllen
		//Anzahl: zeilen*spalten - Text-Länge
		for (int i=0;i < (zeilen*spalten - klarText.length() );i++)
		{
			Random rnd = new Random();
			//System.out.println(z + " " + s); //Debug
			
			cube[z][s] = (char) rnd.nextInt(255);
			//cube[z][s] = '*'; //TEST
			if (s < (spalten-1) ) s++;
			else 
			{	s=0; 
				if (z < (zeilen-1) ) z++;
				else
					z = 0;
				//end else
			}//end else
		}//end for
		
		//"Verschlüsseln": Zuerst die Spalten variieren, dann die Zeilen!!!
		for (int n=0;n<spalten;n++)	{
			for (int m=0;m<zeilen;m++) {
				codedText += cube[m][n];
				//System.out.print(cube[m][n]); //Debug 
			}
			System.out.println();
		}//end for
		
		System.out.println("Die codierte Matrix ist:");
		for (int m=0;m<zeilen;m++) {
			for (int n=0;n<spalten;n++)	{
				System.out.print(cube[m][n]); 
			}
			System.out.println();
		}//end for

		//System.out.println(codedText); //Debug
		return codedText;
	}// end verschluessleText

}//end Codierung
