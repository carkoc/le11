import java.util.Random;


public class Codierung_gen2 {
	
	private int zeilen;
	private int spalten;
	
	/**
	 * default Konstruktur
	 * @param zeilen	maximale Anzahl von Zeilen
	 * @param spalten	maximale Anzahl von Spalten
	 */
	public Codierung_gen2   (int zeilen, int spalten)
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
		for (int i=0;i < (zeilen*spalten);i++)
		{
			Random rnd = new Random();
			if (i < klarText.length() )
				cube[z][s] = klarText.charAt(i);
			else
				cube[z][s] = (char) rnd.nextInt(255);
			//end else
			//System.out.println(z + " " + s + ": " + klarText.charAt(i) ); //DEBUG
			
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

}
