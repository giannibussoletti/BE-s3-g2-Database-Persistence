package giannibussoletti;

import giannibussoletti.DAO.StudentsDAO;
import giannibussoletti.entities.Student;
import giannibussoletti.enums.StudentType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    // Per connetersi al DB dobbiamo sfruttare la persistence unit descritta nel file persistence.xml
    // per sfruttarla dobbiamo creare un attributo statico di tipo EntityManageFactory, passandogli il nome
    // il nome della persistence unit
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4d12pu");

    public static void main(String[] args) {
        System.out.println("Hello World");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        StudentsDAO studentsDAO = new StudentsDAO(entityManager);

        Student aldo = new Student("Aldo", "Baglio", StudentType.PART_TIME);
        Student giovanni = new Student("Giovanni", "Storti", StudentType.FULL_TIME);
        Student giacomo = new Student("Giacomo", "Poretti", StudentType.PART_TIME);

//        studentsDAO.save(aldo);
//        studentsDAO.save(giovanni);
//        studentsDAO.save(giacomo);


//        try {
//            Student found = studentsDAO.findById(1);
//            System.out.println(found);
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            studentsDAO.findByIdAndDelete(2);
//        } catch (NotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        // Java Persistence API
        // JPA (Java Persistence API) è una specifica (uno standard) che
        // definisce come gestire la persistenza degli oggetti Java (chiamati
        // Entities) in un database relazionale

        // JDBC - Modalità manuale, si scrivono tutti i comandi SQL tramite stringa
        // JPA - Modalità automatica, l'approccio in questo caso è tramite classi e oggetti. JPA
        // genera il SQL necessario a runtime, gestendo la memoria tra programma e database

        // Per poter utilizzare la tecnologia JPA è necessario effettuare le seguenti operazioni:
        //      Installare le dipendenze necessarie nel progetto
        //      Configurare le impostazioni JPA (indirizzo del server, username, password...)
        //      Effettuare il mapping delle entities utilizzando le apposite annotations
        //      Effettuare le operazioni di interazione con il db impiegando gli strumenti JPA come l'EntityManager


        // Come si fa il mapping delle Entities(Classi)
        //Le annotazioni principali sono:
        // @Entity - indica che la classe deve essere gestita come entity
        // @Table(name = "...") - indica il nome della tabella DB corrispondente alla classe
        // @Column(name = "..." - mappa l'attributo su una specifica colonna
        // @Id - indica l'attributo che deve essere utilizzato come chiave primaria dell'elemento
        // @Enumerated - Indica come deve essere mappato un campo corrispondente ad una proprietà di tipo Enum

        // Entity Manager
//        Per passare l'entity manager allo StudentsDAO lo si passa tramite costruttore
    }
}
