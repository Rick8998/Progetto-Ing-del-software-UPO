import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DB_prestiti
{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DB_prestiti()
    {
	//autore: Codetta
    }

    

    public ArrayList<prenotazione> carica_prenotazioni()
    {
	// autore: Codetta
	// metodo condiviso

        ArrayList<prenotazione> elenco;
	prenotazione p;
	Scanner sc;
	int i;

        // CARICA TUTTO IL FILE
	elenco=new ArrayList<prenotazione>();		
	try
	{
	    sc = new Scanner(new File("dati/prenotazioni.txt"));
	    do
	    {
	        p = new prenotazione();
		p.data_prenotazione = LocalDate.parse(sc.next(), formatter);
		p.codice_libro = sc.nextInt();
		p.username = sc.next();
		
		elenco.add(p);
	    }
	    while ( (sc.hasNext()) );
	    sc.close();
	}
	catch (FileNotFoundException e) 
	{
            System.out.println("ERRORE apertura file prenotazioni");
	}

	return elenco;
    }



    public void salva_prenotazioni(ArrayList<prenotazione> elenco)
    {
	// autore: Codetta
	// metodo condiviso

	int i;
	prenotazione p;

	// SALVA TUTTO IL FILE
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/prenotazioni.txt"), false);
		for (i=0; i<elenco.size(); i++)
		{
			p=(prenotazione)elenco.get(i);
			fw.write(p.data_prenotazione.format(formatter) + "\t" + p.codice_libro + "\t" + p.username + "\n");
		}
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file prenotazioni");
	}

    }



    public void aggiungi_prenotazione(prenotazione p) 
    {
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/prenotazioni.txt"), true);
		fw.write(p.data_prenotazione.format(formatter) + "\t" + p.codice_libro + "\t" + p.username + "\n");
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file prenotazioni");
	}
    }

    

    //=============================================================================


    public ArrayList<prestito> carica_prestiti()
    {
	// autore: Codetta
	// metodo condiviso

        ArrayList<prestito> elenco;
	prestito p;
	Scanner sc;
	int i;

	// CARICA TUTTO IL FILE
	elenco=new ArrayList<prestito>();		
	try
	{
	    sc = new Scanner(new File("dati/prestiti.txt"));
	    do
	    {
	        p = new prestito();
		p.data_prestito = LocalDate.parse(sc.next(), formatter);
		p.codice_libro = sc.nextInt();
		p.username = sc.next();
		p.scadenza = LocalDate.parse(sc.next(), formatter);
		p.data_restituzione = LocalDate.parse(sc.next(), formatter);
		
		elenco.add(p);
	    }
	    while ( (sc.hasNext()) );
	    sc.close();
	}
	catch (FileNotFoundException e) 
	{
            System.out.println("ERRORE apertura file prestiti");
	}

	return elenco;
    }



    public void salva_prestiti(ArrayList<prestito> elenco)
    {
	// autore: Codetta
	// metodo condiviso

	int i;
	prestito p;

	// SALVA TUTTO IL FILE
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/prestiti.txt"), false);
		for (i=0; i<elenco.size(); i++)
		{
			p=(prestito)elenco.get(i);
			fw.write(p.data_prestito.format(formatter) + "\t" + p.codice_libro + "\t" + p.username + "\t" + p.scadenza.format(formatter) + "\t" + p.data_restituzione.format(formatter) + "\n");
		}
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file prestiti");
	}

    }



    public void aggiungi_prestito(prestito p) 
    {
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/prestiti.txt"), true);
		fw.write(p.data_prestito.format(formatter) + "\t" + p.codice_libro + "\t" + p.username + "\t" + p.scadenza.format(formatter) + "\t" + p.data_restituzione.format(formatter) + "\n");
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file prestiti");
	}
    }



//=============================================================================



}
