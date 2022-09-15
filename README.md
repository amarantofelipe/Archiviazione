# Archiviazione
Questo microservizio permette, dato in input due date (con controllo di maggiore, minore o uguale), codice e l'elaborazione se è andato a buon fine. Inoltre in base alle date maggiori, minori o uguale stamperà in modo diverso i dati (stampando prima una data piuttosto che un'altra, sono presenti anche controlli sul corretto formato della data e sul codice.Successivamente salviamo i dati all'interno del database


Creiamo una classe model con relativi campi: id, codice, timestamp (@CreationTimestamp) ed elaborazione che rispecchia il formato della tabella nel db.

Creiamo una classe controller e con il solito RequestMapping diamo il base path, impostiamo l’endpoint a /archivia con il PostMapping e creiamo un metodo che ha abbia come parametri una stringa e come valore di ritorno un ResponseEntity<?> creiamo una formattazione per le date, grazie alla classe DataTimeFormatter.

Creiamo anche un oggetto di tipo  ObjectMapper e un tipo JsonNode

Inizializziamo anche delle variabili che ci servono per il corretto funzionamento del programma.

Ora andiamo ad inserire nell’oggetto JsonNode il parametro che ha inserito l’utente, nel caso in cui il json non sia scritto in maniera adeguata automaticamente tramite il catch ci restituirà l’errore 500 🙂.

Adesso andiamo a prendere tutte le variabili inserite dal utente: Tramite il metodo get(”Valore chiave”) e il metodo as.Int/text che ci ritornerà un tipo specifico, nel caso delle due date utilizziamo localdate.parse(data, formattazione della data).

Nel caso in cui la data sia in un formato errato il catch ci restituirà un errore 500.

Successivamente effettuiamo un controllo sulla lunghezza del codice trasformandolo prima in una stringa, nel caso in cui la stringa la lunghezza fosse diversa da 4 ci ritornerà un errore 500.

Prendiamo in due variabili gli anni delle date ed effettuiamo vari controllo tra cui l’uguaglianza, la maggioranza e la minoranza delle medesime, calcoliamo il 30% del codice e creiamo un oggetto di tipo model infine utilizziamo la nostra repo per l’inserimento al db e ritorniamo il codice di stato 200.
