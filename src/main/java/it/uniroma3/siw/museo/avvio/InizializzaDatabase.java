package it.uniroma3.siw.museo.avvio;

import it.uniroma3.siw.museo.model.Utente;
import it.uniroma3.siw.museo.service.ArtistaService;
import it.uniroma3.siw.museo.service.CollezioneService;
import it.uniroma3.siw.museo.service.CredentialsService;
import it.uniroma3.siw.museo.service.CuratoreService;
import it.uniroma3.siw.museo.service.OperaService;
import it.uniroma3.siw.museo.service.UtenteService;

import java.time.LocalDate;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.model.Curatore;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.model.Credentials;


public class InizializzaDatabase {
	UtenteService us=new UtenteService();
	CredentialsService cs= new CredentialsService();
	ArtistaService as= new ArtistaService();
	CollezioneService cos= new CollezioneService();
	OperaService os= new OperaService();
	CuratoreService cus= new CuratoreService();
	
	Utente u1=new Utente(1L,"Gavriel","Di Nepi");
	Credentials c1= new Credentials(1L,"admin123","admin123","ADMIN",u1);
	Utente u2=new Utente(2L,"Gavriel","Di Nepi");
	Credentials c2= new Credentials(2L,"user123","user123","DEFAULT",u2);
	Curatore cu1= new Curatore(1L, "Antonio", "Cecchetto",LocalDate.of(1980,12,11),"Roma", "antonio@gmail.com", 5432543, 3402533); 
	Collezione co1= new Collezione(1L, "Astrattismo", "Inizio 900", "L'Astrattismo è un movimento artistico che nasce nei primi anni del XX secolo, in zone della Germania abbastanza lontane tra loro, dove si sviluppò senza intenti comuni. "
			+ "Il termine indica quelle opere pittoriche e plastiche che esulano dalla rappresentazione di oggetti reali. "
			+ "L'astrattismo usa un linguaggio visuale di forme, colori e linee con lo scopo di creare una composizione che possa esistere con un grado di indipendenza dalle referenze visuali nel mondo.\r\n"
			+ "L'arte occidentale è stata, dal Rinascimento fino al XIX secolo, segnata dalla logica della prospettiva e dal tentativo di riprodurre un'illusione della realtà visibile. "
			+ "Ma l'accessibilità alle arti delle culture altre rispetto a quelle europee mostrano modi alternativi di descrivere l'esperienza visiva agli artisti. Dalla fine del XIX secolo molti artisti sentirono il bisogno di creare un nuovo tipo di arte che includesse i cambiamenti fondamentali che stavano avvenendo nella tecnologia, nelle scienze e nella filosofia. "
			+ "Le fonti da cui gli artisti estraevano i loro argomenti teorici erano diverse, e riflettevano le ansie sociali e intellettuali in tutte le culture occidentali del tempo",
			cu1);
	Artista a1= new Artista(1L,"Vasilij Vasil'evič","Kandinskij",LocalDate.of(1866, 12, 16),"Mosca",LocalDate.of(1944, 12, 13),"Neuilly-sur-Seine","Russia");
	Opera o1= new Opera(1L,"Primo acquarello astratto","Primo acquerello astratto è un dipinto a matita, acquarello e china su carta (49,6×61,8 cm) realizzato nel 1910 dal pittore Vasilij Kandinskij. È conservato nel Centre Pompidou di Parigi.\r\n"
			+ "\r\n"+ "La critica fa iniziare l'astrattismo da questo quadro.\r\n"
			+ "\r\n"+ "Fu lo stesso Kandinskij a rilevare in una sua dichiarazione la nascita dell'arte astratta. L'acquerello si presenta come uno schizzo informe ricongiungibile a uno scarabocchio infantile, in questo acquerello si è "
			+ "proposto di sperimentare il primo contatto dell'essere umano con il mondo, con una realtà di cui non si sa nulla. "
			+ "L'immagine è caratterizzata da diverse macchie colorate: alcune grosse velature espanse e trasparenti, situate in particolare nella parte alta del foglio, sembrano introdurre nella superficie bianca un senso di profondità fluttuante.",
			1910,co1,a1,"PrimoAcquarello.jpg");
	
	public InizializzaDatabase() {
		us.saveUtente(u1);
		us.saveUtente(u2);
		cs.saveCredentials(c1);
		cs.saveCredentials(c2);
		cus.inserisci(cu1);
		cos.inserisci(co1);
		as.inserisci(a1);
		os.inserisci(o1);
		
		
		
	}

}
