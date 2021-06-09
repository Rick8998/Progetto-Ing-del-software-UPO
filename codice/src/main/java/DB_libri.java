import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DB_libri
{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DB_libri()
    {
	//autore: Codetta
    }



    public ArrayList<libro> carica_libri()
    {
	// autore: Codetta
	// metodo condiviso

        ArrayList<libro> elenco;
	libro l;
	Scanner sc;
	int i;

	// CARICA TUTTO IL FILE
	elenco=new ArrayList<libro>();		
	try
	{
	    sc = new Scanner(new File("dati/libri.txt"));
	    do
	    {
	        l = new libro();
		l.titolo = sc.next();
		l.autore = sc.next();
		l.codice = sc.nextInt();
		l.copie_disponibili = sc.nextInt();
		l.in_catologo = sc.nextBoolean();
		elenco.add(l);
	    }
	    while ( (sc.hasNext()) );
	    sc.close();
	}
	catch (FileNotFoundException e) 
	{
            System.out.println("ERRORE apertura file libri");
	}

	return elenco;
    }



    public void salva_libri(ArrayList<libro> elenco)
    {
	// autore: Codetta
	// metodo condiviso

	int i;
	libro l;

	// SALVA TUTTO IL FILE
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/libri.txt"), false);
		for (i=0; i<elenco.size(); i++)
		{
			l=(libro)elenco.get(i);
			fw.write(l.titolo + "\t" + l.autore + "\t" + l.codice + "\t" + l.copie_disponibili + "\t" + l.in_catologo + "\n");
		}
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file libri");
	}

    }



    public void aggiungi_libro(libro l) 
    {
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/libri.txt"), true);
		fw.write(l.titolo + "\t" + l.autore + "\t" + l.codice + "\t" + l.copie_disponibili + "\t" + l.in_catologo + "\n");
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file libri");
	}
    }



//=============================================================================



    public ArrayList<fornitura> carica_forniture()
    {
	// autore: Codetta
	// metodo condiviso

        ArrayList<fornitura> elenco;
	fornitura f;
	Scanner sc;
	int i;

        // CARICA TUTTO IL FILE
	elenco=new ArrayList<fornitura>();		
	try
	{
	    sc = new Scanner(new File("dati/forniture.txt"));
	    do
	    {
	        f = new fornitura();
		f.data_fornitura = LocalDate.parse(sc.next(), formatter);
		f.quantita = sc.nextInt();
		f.codice_libro = sc.nextInt();
		elenco.add(f);
	    }
	    while ( (sc.hasNext()) );
	    sc.close();
	}
	catch (FileNotFoundException e) 
	{
            System.out.println("ERRORE apertura file forniture");
	}

	return elenco;
    }


    public void salva_forniture(ArrayList<fornitura> elenco)
    {
	// autore: Codetta
	// metodo condiviso

	int i;
	fornitura f;

	// SALVA TUTTO IL FILE
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/forniture.txt"), false);
		for (i=0; i<elenco.size(); i++)
		{
			f=(fornitura)elenco.get(i);
			fw.write(f.data_fornitura.format(formatter) + "\t" + f.quantita + "\t" + f.codice_libro + "\n");
		}
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file forniture");
	}

    }



    public void aggiungi_fornitura(fornitura f) 
    {
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/forniture.txt"), true);
		fw.write(f.data_fornitura.format(formatter) + "\t" + f.quantita + "\t" + f.codice_libro + "\n");
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file forniture");
	}
    }



    //=============================================================================



}
