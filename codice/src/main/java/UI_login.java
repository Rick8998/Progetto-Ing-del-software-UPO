import java.util.Scanner;

public class UI_login
{   
    gestore_accessi g_acc;
    gestore_ricerche g_ric;

    int scelta;
    String tipo_utente;
    String username;
    String password;

    public UI_login(gestore_accessi g1, gestore_ricerche g2)
    {	
	//autore: Codetta

        g_acc=g1;
        g_ric=g2;
    }



    public void avvio_login()
    {
	//RF00
	//autore: Codetta
	
	do
	{   
	    this.form_login();

	    // per arrestare il prototipo
	    if (username.equals("0") && password.equals("0"))
		break;

	    tipo_utente=g_acc.controlla_credenziali(username, password);
	    if (tipo_utente.equals("error1") || tipo_utente.equals("error2") || tipo_utente.equals("error3"))
		this.mostra_errore(tipo_utente);
	    else
	    {
		// da sostituire con la chiamata del metodo di AVVIO
		System.out.println("\nAVVIO visualizza notifiche");

		do
		{	    
		    this.mostra_menu(tipo_utente);
		    if (scelta==1)
	 	        // da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO imposta password");

		    if (scelta==2 && (tipo_utente.equals("cliente") || tipo_utente.equals("staff")))
			// da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO ricerca libro");

		    if (scelta==3 && (tipo_utente.equals("cliente") || tipo_utente.equals("staff")))
			// da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO elenco prenotazioni");

	            if (scelta==4 && (tipo_utente.equals("cliente") || tipo_utente.equals("staff")))
			// da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO elenco prestiti");
			    
	            if (scelta==5 && tipo_utente.equals("staff") || scelta==2 && tipo_utente.equals("admin"))
			// da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO ricerca utente"); 

		    if (scelta==3 && tipo_utente.equals("admin"))
			// da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO elenco prestiti");
	
		    if (scelta==6 && tipo_utente.equals("staff"))
			// da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO inserisci nuovo libro");

		    if (scelta==7 && tipo_utente.equals("staff"))
			// da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO elenco forniture");

		    if (scelta==8 && tipo_utente.equals("staff"))
			 // da sostituire con la chiamata del metodo di AVVIO
		        System.out.println("\nAVVIO visualizza libri in esaurimento");
		}
		while (scelta != 0);
            }	
	}
	while ( scelta==0 || tipo_utente.equals("error1") || tipo_utente.equals("error2") || tipo_utente.equals("error3") );
    }



    public void form_login()
    {
	//RF00
	//autore: Codetta

        Scanner sc = new Scanner(System.in);

	System.out.print("\ninserisci username: ");
	username = sc.nextLine();
        System.out.print("inserisci password: ");
        password = sc.nextLine();
    }	



    public void mostra_errore(String tipo_utente)
    {
	//RF00
	//autore: Codetta

        String conferma;
        Scanner sc = new Scanner(System.in);

   	if (tipo_utente.equals("error1"))
	    System.out.println("\nERRORE: username o password vuota");
	if (tipo_utente.equals("error2"))
	    System.out.println("\nERRORE: credenziali errate");
	if (tipo_utente.equals("error3"))
	    System.out.println("\nERRORE: account bloccato");	
			
	System.out.print("premi INVIO per confermare");
	conferma = sc.nextLine();
    }



    public void mostra_menu(String tipo_utente)
    {
	//RF00
	//autore: Codetta

	Scanner sc = new Scanner(System.in);

	System.out.println("\ntipo utente: " + tipo_utente);
        System.out.println("MENU:\n0. logout\n1. imposta password");

	if (tipo_utente.equals("admin") )
	    System.out.println("2. ricerca utente\n3. crea utente");
	if (tipo_utente.equals("cliente"))
	    System.out.println("2. ricerca libro\n3. elenco prenotazioni\n4. elenco prestiti");
	if (tipo_utente.equals("staff") )
	    System.out.println("2. ricerca libro\n3. elenco prenotazioni\n4. elenco prestiti\n5. ricerca utente\n6. inserisci nuovo libro\n7. elenco forniture\n8. visualizza libri in esaurimento");
	
	System.out.print("\ninserire scelta: ");
	scelta=sc.nextInt();

	if (tipo_utente.equals("admin") && scelta > 3 || tipo_utente.equals("cliente") && scelta > 4 || tipo_utente.equals("staff") && scelta > 8)
		System.out.println("\nERRORE: scelta errata");
   }



}

