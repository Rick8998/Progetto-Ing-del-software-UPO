class gestore_accessi
{
    DB_utenti db_ut;

    public gestore_accessi(DB_utenti d1)
    {
      //autore: Codetta
      db_ut=d1;
    }



    public String controlla_credenziali(String username, String password)
    {
	//RF00
	//autore: Codetta

        int L1, L2;
        String tipo_utente;
        account acc;

        L1=username.length();
        if (L1==0)
            tipo_utente="error1";
        else
        {
            L2=password.length();
	    if (L2==0)
	        tipo_utente="error1";
    	    else
	    {
                acc=db_ut.ricerca_account(username, password);
		if (acc==null)
		    tipo_utente="error2";
		else
		    if (acc.attivo==false)
		        tipo_utente="error3";
		    else
			tipo_utente=acc.tipo_utente;
	    }
	}

	return tipo_utente;
    }



}

