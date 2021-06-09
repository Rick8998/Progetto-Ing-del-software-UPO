class gestore_ricerche
{
    DB_utenti db_ut;
    DB_libri db_lib;
    DB_prestiti db_pres;

    public gestore_ricerche(DB_utenti d1, DB_libri d2, DB_prestiti d3)
    {
      //autore: Codetta
      db_ut=d1;
      db_lib=d2;
      db_pres=d3;
    }
}

