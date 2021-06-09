import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DB_utenti
{

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DB_utenti()
    {
	//autore: Codetta
    }



//=============================================================================



    public ArrayList<account> carica_account()
    {
	// autore: Codetta
	// metodo condiviso

        ArrayList<account> elenco;
	account a;
	Scanner sc;
	int i;

	// CARICA TUTTO IL FILE
	elenco=new ArrayList<account>();		
	try
	{
	    sc = new Scanner(new File("dati/accounts.txt"));
	    do
	    {
	        a = new account();
		a.username = sc.next();
		a.password = sc.next();
		a.attivo = sc.nextBoolean();
		a.tipo_utente = sc.next();
		elenco.add(a);
	    }
	    while ( (sc.hasNext()) );
	    sc.close();
	}
	catch (FileNotFoundException e) 
	{
            System.out.println("ERRORE apertura file accounts");
	}

	return elenco;
    }



    public void salva_account(ArrayList<account> elenco)
    {
	// autore: Codetta
	// metodo condiviso

	int i;
	account a;

	// SALVA TUTTO IL FILE
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/accounts.txt"), false);
		for (i=0; i<elenco.size(); i++)
		{
			a=(account)elenco.get(i);
			fw.write(a.username + "\t" + a.password + "\t" + a.attivo + "\t" + a.tipo_utente + "\n");
		}
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file accounts");
	}

    }



    public void aggiungi_account(account a) 
    {
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/accounts.txt"), true);
		fw.write(a.username + "\t" + a.password + "\t" + a.attivo + "\t" + a.tipo_utente + "\n");
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file accounts");
	}
    }



//=============================================================================



    public ArrayList<utente> carica_utenti()
    {
	// autore: Codetta
	// metodo condiviso

        ArrayList<utente> elenco;
	utente u;
	Scanner sc;
	int i;

	// CARICA TUTTO IL FILE
	elenco=new ArrayList<utente>();		
	try
	{
	    sc = new Scanner(new File("dati/utenti.txt"));
	    do
	    {
	        u = new utente();
		u.nome = sc.next();
		u.cognome = sc.next();
		u.email = sc.next();
		u.username = sc.next();
		u.credito = sc.nextInt();
		u.qualifica  = sc.next();
		u.residenza = new indirizzo();
		u.residenza.via = sc.next();
		u.residenza.numero = sc.nextInt();
		u.residenza.CAP = sc.nextInt();
		u.residenza.localita = sc.next();
		elenco.add(u);
	    }
	    while ( (sc.hasNext()) );
	    sc.close();
	}
	catch (FileNotFoundException e) 
	{
            System.out.println("ERRORE apertura file utenti");
	}

	return elenco;
    }



    public void salva_utenti(ArrayList<utente> elenco)
    {
	// autore: Codetta
	// metodo condiviso

	int i;
	utente u;

	// SALVA TUTTO IL FILE
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/utenti.txt"), false);
		for (i=0; i<elenco.size(); i++)
		{
			u=(utente)elenco.get(i);
			fw.write(u.nome + "\t" + u.cognome + "\t" + u.email + "\t" + u.username + "\t" + u.credito + "\t" + u.qualifica + "\t" + u.residenza.via + "\t" + u.residenza.numero + "\t" + u.residenza.CAP + "\t" + u.residenza.localita + "\n");
		}
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file utenti");


	}
    }



    public void aggiungi_utente(utente u) 
    {
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/utenti.txt"), true);
		fw.write(u.nome + "\t" + u.cognome + "\t" + u.email + "\t" + u.username + "\t" + u.credito + "\t" + u.qualifica + "\t" + u.residenza.via + "\t" + u.residenza.numero + "\t" + u.residenza.CAP + "\t" + u.residenza.localita + "\n");
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file utenti");
	}
    }



//=============================================================================


  
public ArrayList<ricarica> carica_ricariche()
    {
	// autore: Codetta
	// metodo condiviso

        ArrayList<ricarica> elenco;
	ricarica r;
	Scanner sc;
	int i;

	// CARICA TUTTO IL FILE
	elenco=new ArrayList<ricarica>();		
	try
	{
	    sc = new Scanner(new File("dati/ricariche.txt"));
	    do
	    {
	        r = new ricarica();
		r.username = sc.next();
		r.importo = sc.nextInt();
		r.data_ricarica = LocalDate.parse(sc.next(), formatter);
		elenco.add(r);
	    }
	    while ( (sc.hasNext()) );
	    sc.close();
	}
	catch (FileNotFoundException e) 
	{
            System.out.println("ERRORE apertura file ricariche");
	}

	return elenco;
    }



    public void salva_ricariche(ArrayList<ricarica> elenco)
    {
	// autore: Codetta
	// metodo condiviso

	int i;
	ricarica r;

	// SALVA TUTTO IL FILE
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/ricariche.txt"), false);
		for (i=0; i<elenco.size(); i++)
		{
			r=(ricarica)elenco.get(i);
			fw.write(r.username + "\t" + r.importo + "\t" + r.data_ricarica.format(formatter) + "\n");
		}
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file ricariche");
	}

    }



    public void aggiungi_ricarica(ricarica r) 
    {
	try
	{
		// false per modalita' write, true per modalita' append
		FileWriter fw = new FileWriter(new File("dati/ricariche.txt"), true);
		fw.write(r.username + "\t" + r.importo + "\t" + r.data_ricarica.format(formatter) + "\n");
		fw.close();
	}
	catch (IOException e) 
	{
            System.out.println("ERRORE apertura file ricariche");
	}
    }



//=============================================================================


   
    public account ricerca_account(String username, String password)
    {
	//RF00
	//autore: Codetta

        account acc, a;
        Scanner sc;

	acc=null;

	try
	{
            sc = new Scanner(new File("dati/accounts.txt"));
	    do
	    {
                a = new account();
		a.username = sc.next();
		a.password = sc.next();
		a.attivo = sc.nextBoolean();
		a.tipo_utente=sc.next();
		if (a.username.equals(username) && a.password.equals(password))
		    acc=a;
	    }
	    while (sc.hasNext() && acc == null);
	    sc.close();
	}
	catch (FileNotFoundException e)
	{
            System.out.println("ERRORE apertura file accounts");
	}

	return acc;
    }



}

