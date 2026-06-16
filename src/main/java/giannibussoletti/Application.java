package giannibussoletti;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    // Per connetersi al DB dobbiamo sfruttare la persistence unit descritta nel file persistence.xml
    // per sfruttarla dobbiamo creare un attributo statico di tipo EntityManageFactory, passandogli il nome
    // il nome della persistence unit
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4d12pu");

    public static void main(String[] args) {
        System.out.println("Hello World");
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


    }
}
