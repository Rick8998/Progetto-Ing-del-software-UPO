class gestore_prestito
{
    DB_libri db_lib;
    DB_prestiti db_pres;

    public gestore_prestito(DB_libri d1, DB_prestiti d2)
    {
      //autore: Codetta
      db_lib=d1;
      db_pres=d2;
    }
}
