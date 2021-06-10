package it.uniroma3.siw.museo.avvio;

import it.uniroma3.siw.museo.service.UtenteService;
import it.uniroma3.siw.museo.service.ArtistaService;
import it.uniroma3.siw.museo.service.CollezioneService;
import it.uniroma3.siw.museo.service.CredentialsService;
import it.uniroma3.siw.museo.service.CuratoreService;
import it.uniroma3.siw.museo.service.OperaService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.model.Curatore;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.model.Utente;
import it.uniroma3.siw.museo.model.Credentials;

@Component
public class InizializzaDatabase implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private UtenteService us;
	
	@Autowired
	private CredentialsService cs;
	
	@Autowired
	private ArtistaService as;
	
	@Autowired
	private CollezioneService cos;
	
	@Autowired
	private OperaService os;
	
	@Autowired
	private CuratoreService cus;
	
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Utente u1 = new Utente();
		u1.setNome("nome1");
		u1.setCognome("cognome1");
		us.saveUtente(u1);

		Credentials c1= new Credentials();
		c1.setUsername("admin");
		c1.setRole("ADMIN");
		c1.setPassword("admin");
		c1.setUtente(u1);
		cs.saveCredentials(c1);
		
		Utente u2=new Utente();
		u2.setNome("nome2");
		u2.setCognome("cognome2");
		us.saveUtente(u2);
		
		Credentials c2= new Credentials();
		c2.setUsername("user");
		c2.setRole("DEFAULT");
		c2.setPassword("user");
		c2.setUtente(u2);
		cs.saveCredentials(c2);
		
		Curatore cu1= new Curatore();
		cu1.setNome("Antonio");
		cu1.setCognome("Cecchetto");
		cu1.setDataNascita(LocalDate.of(1980,12,11));
		cu1.setLuogoNascita("Roma");
		cu1.setEmail("antonio@gmail.com");
		cu1.setTelefono(333333333);
		cu1.setMatricola(123);
		cus.inserisci(cu1);
		
		Collezione co1= new Collezione();
		co1.setCuratore(cu1);
		co1.setNome("Astrattismo");
		co1.setDescrizione("Inizio 900");
		co1.setDescrizioneCorrente("L'Astrattismo è un movimento artistico che nasce nei primi anni del XX secolo, in zone della Germania abbastanza lontane tra loro, dove si sviluppò senza intenti comuni. "
				+ "Il termine indica quelle opere pittoriche e plastiche che esulano dalla rappresentazione di oggetti reali. "
				+ "L'astrattismo usa un linguaggio visuale di forme, colori e linee con lo scopo di creare una composizione che possa esistere con un grado di indipendenza dalle referenze visuali nel mondo.\r\n"
				+ "L'arte occidentale è stata, dal Rinascimento fino al XIX secolo, segnata dalla logica della prospettiva e dal tentativo di riprodurre un'illusione della realtà visibile. "
				+ "Ma l'accessibilità alle arti delle culture altre rispetto a quelle europee mostrano modi alternativi di descrivere l'esperienza visiva agli artisti. Dalla fine del XIX secolo molti artisti sentirono il bisogno di creare un nuovo tipo di arte che includesse i cambiamenti fondamentali che stavano avvenendo nella tecnologia, nelle scienze e nella filosofia. "
				+ "Le fonti da cui gli artisti estraevano i loro argomenti teorici erano diverse, e riflettevano le ansie sociali e intellettuali in tutte le culture occidentali del tempo");
		cos.inserisci(co1);
		
		Artista a1= new Artista();
		a1.setNome("Vasilij Vasil'evič");
		a1.setCognome("Kandinskij");
		a1.setDataNascita(LocalDate.of(1866, 12, 16));
		a1.setLuogoNascita("Mosca");
		a1.setDataMorte(LocalDate.of(1944, 12, 13));
		a1.setLuogoMorte("Neuilly-sur-Seine");
		a1.setNazione("Russia");
		a1.setLinkFoto("Vassily-Kandinsky.jpeg");
		as.inserisci(a1);
		
		Opera o1= new Opera();
		o1.setArtista(a1);
		o1.setTitolo("Primo acquarello astratto");
		o1.setCollezione(co1);
		o1.setAnno(1910);
		o1.setDescrizione("Primo acquerello astratto è un dipinto a matita, acquarello e china su carta (49,6×61,8 cm) realizzato nel 1910 dal pittore Vasilij Kandinskij. È conservato nel Centre Pompidou di Parigi.\r\n"
				+ "\r\n"+ "La critica fa iniziare l'astrattismo da questo quadro.\r\n"
				+ "\r\n"+ "Fu lo stesso Kandinskij a rilevare in una sua dichiarazione la nascita dell'arte astratta. L'acquerello si presenta come uno schizzo informe ricongiungibile a uno scarabocchio infantile, in questo acquerello si è "
				+ "proposto di sperimentare il primo contatto dell'essere umano con il mondo, con una realtà di cui non si sa nulla. "
				+ "L'immagine è caratterizzata da diverse macchie colorate: alcune grosse velature espanse e trasparenti, situate in particolare nella parte alta del foglio, sembrano introdurre nella superficie bianca un senso di profondità fluttuante.");
		o1.setLinkFoto("PrimoAcquarello.jpg");
		os.inserisci(o1);
		
		Opera o2=new Opera();
		o2.setArtista(a1);
		o2.setTitolo("Composizione VIII");
		o2.setCollezione(co1);
		o2.setAnno(1923);
		o2.setDescrizione("L'opera rappresenta forme geometriche elementari (cerchi, triangoli, quadrati, linee...), "
				+ "disposte in maniera apparentemente casuale. Cerchi e linee rette sono le forme dominanti della composizione "
				+ "e contribuiscono a creare una struttura geometrica rigida, rafforzata anche da colori opachi utilizzati per lo sfondo. All'interno del "
				+ "quadro è possibile riconoscere anche trapezi, cunei e linee curve. Particolare rilievo è dato al cerchio viola, nero e rosso in alto a sinistra e al grande cuneo che taglia verticalmente il centro del dipinto.");
		o2.setLinkFoto("Composizione VIII.jpg");
		os.inserisci(o2);
		
		Artista a2=new Artista();
		a2.setNome("Piet");
		a2.setCognome("Mondrian");
		a2.setDataNascita(LocalDate.of(1872,3,7));
		a2.setLuogoNascita("Amersfoort");
		a2.setDataMorte(LocalDate.of(1944, 2, 1));
		a2.setLuogoMorte("New York");
		a2.setNazione("Olanda");
		a2.setLinkFoto("PietMondrian.jpg");
		as.inserisci(a2);
		
		Opera o3=new Opera();
		o3.setArtista(a2);
		o3.setTitolo("Albero Rosso");
		o3.setCollezione(co1);
		o3.setAnno(1909);
		o3.setDescrizione("Red Tree (L'albero rosso) è un quadro dipinto nel 1908/1909 da Piet Mondrian. "
				+ "È una rappresentazione artistica di un albero (un melo) in cui l'artista non si preoccupa del tronco o dei "
				+ "rami, bensì della loro forma e dei loro rapporti. Un segno deciso e di vario spessore evidenzia la struttura e cerca di impregnare nella composizione i rapporti che scaturiscono dai rami. I colori, prevalentemente rosso e blu, favoriscono tale semplificazione.\r\n"
				+ "\r\n"+ "Attualmente è conservato nel museo municipale dell'Aia.\r\n"+ "\r\n"
				+ "Nell'opera il tronco nodoso e ruvido è chiazzato da striature rosse che, sui rami nudi, "
				+ "paiono fiammelle guizzanti. L'albero pare prima adagiarsi dolcemente a destra, assecondando linee a onde correnti; poi protende le punte di nuovo verso l'alto; a sinistra, invece, i rami sembrano accelerare la loro caduta, quasi pronti a immergersi nella terra.");
		o3.setLinkFoto("AlberoRosso.jpg");
		os.inserisci(o3);
		
		Opera o4=new Opera();
		o4.setArtista(a2);
		o4.setTitolo("Broadway Boogie-Woogie");
		o4.setCollezione(co1);
		o4.setAnno(1942);
		o4.setDescrizione("Il quadro è composto da una quantità di quadrati di colore luminoso e brillante, che sembrano "
				+ "quasi luccicare come un mosaico, attirando l'attenzione del fruitore.\r\n"+ "\r\n"+ "In questo quadro "
				+ "spariscono i rigidi reticoli neri, gli stessi rettangoli dipinti nei quadri precedenti, non sono più "
				+ "bordati da una linea nera: ora sono accostati uno all'altro. Tutto ciò ha lo scopo di riprodurre il frenetico ritmo del ballo del Boogie-Woogie. Quest'opera trasmette un effetto di vitalità, suggerendo l'atmosfera della città di Broadway, riprendendo il reticolato delle sue strade e lo sfrecciare in esse dei taxi gialli.\r\n"
				+ "\r\n"+ "In queste opere finali, le forme hanno usurpato il ruolo delle linee, aprendo una nuova porta per lo sviluppo di Mondrian come astrattista. I quadri della serie \"Boogie-Woogie\" rappresentano il più radicale sviluppo dal momento del suo abbandono dell'arte rappresentativa avvenuto nel 1913. Mentre le opere degli anni '20 e '30 tendevano ad avere un'austerità quasi scientifica in esse, "
				+ "queste sono quadri luminosi, vivaci e riflettono la musica ottimista e allegra che li ispirò e la città nella quale vennero prodotti.");
		o4.setLinkFoto("Broadway_Boogie_Woogie.jpg");
		os.inserisci(o4);
		
		
	}

}
