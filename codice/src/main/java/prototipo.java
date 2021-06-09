public class prototipo
{
    public static void main(String[] args) 
    {
        DB_utenti db_ut = new DB_utenti();
	DB_libri db_lib = new DB_libri();
	DB_prestiti db_pres = new DB_prestiti();
		
	gestore_accessi g_acc = new gestore_accessi(db_ut);
	gestore_utente g_ut = new gestore_utente(db_ut);
	gestore_ricerche g_ric = new gestore_ricerche(db_ut, db_lib, db_pres);
	gestore_libro g_lib = new gestore_libro(db_lib);
	gestore_prestito g_pres = new gestore_prestito(db_lib, db_pres);
	
	UI_login ui_log = new UI_login(g_acc, g_ric);
	UI_account ui_acc = new UI_account(g_acc);	
	UI_utente ui_ut = new UI_utente(g_ut);
	UI_ricerca ui_ric = new UI_ricerca(g_ric);
        UI_elenco ui_ele = new UI_elenco(g_ric);
	UI_libro ui_lib = new UI_libro(g_lib);
	UI_prestito ui_pres = new UI_prestito(g_ut, g_pres);

	ui_log.avvio_login();	
    }
}
