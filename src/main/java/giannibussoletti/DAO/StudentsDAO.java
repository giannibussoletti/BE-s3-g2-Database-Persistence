package giannibussoletti.DAO;

import giannibussoletti.entities.Student;
import giannibussoletti.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentsDAO {
    //DAO = Data Access Object
    // È un astrazione, cioè, siccome le interazione con il DB richiedono un po' di righe di codice
    // non particolarmente semplici, creiamo queste classe che fornirà dei metodi
    // semplice da usare nel main, nascondendo queste complessità
    private final EntityManager entityManager;

    // Tutti i metodi di questo DAO avranno bisogno di utilizzare l'entity manager, poiché è l'oggetto che mi consente di
    // salvare, cancellare, leggere ecc. sincronizzandomi con il DB.
    // Siccome l'oggetto EntityManager viene creato nel main è comodo passarlo al costruttore del DAO come parametro.
    // Avendolo già a disposizione in tutti i suoi metodi.

    public StudentsDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Student newStudent) {
        // Come si fa un save?
        // Entity manager quando facciamo modifiche esige una Transazione
        // 1.  Creiamo una transazione
        EntityTransaction transaction = this.entityManager.getTransaction();

        // 2. Facciamo partire la transazione
        transaction.begin();

        // 3. Siccome newStudent non è un MANAGEDm per aggiungerlo all'elenco
        // degli oggetti monitorati (PersistenceContext) dobbiamo effettuare una operazione di PERSIST
        // L'oggetto MANAGED però non fa ancora parte del DB
        this.entityManager.persist(newStudent);

        // 4. L'operazione di COMMIT sincronizza il PersistenceContext con il DB
        // Siccome in questo caso c'è un nuovo oggetto  nel PC, creerà una nuova riga nella tabella Students
        transaction.commit();

        //5. Facciamo un log per sapere che tutto è andato a buon fine
    }


    public Student findById(long id) {
        Student fromDB = this.entityManager.find(Student.class, id);
        if (fromDB != null) return fromDB;
        else throw new NotFoundException(id);
    }

    public void findByIdAndDelete(long id) {

        //1. Cerchiamo lo studente
        Student fromDB = this.findById(id);

        //2.Creiamo una transizione
        EntityTransaction transaction = this.entityManager.getTransaction();

        // 3. Facciamo partire la transazione
        transaction.begin();

        //4. Informiamo l'EM che lo studente è da cancellare dal DB, lo facciamo tramite metodo .remove()
        this.entityManager.remove(fromDB);

        // 5. L'operazione di COMMIT sincronizza il PersistenceContext con il DB
        transaction.commit();
        // Siccome in questo caso c'è un oggetto segnato da rimuovere, il DB cancellerà la riga corrispondente
        System.out.println("Lo studente " + fromDB + " è stato cancellato con successo!");
    }
}
