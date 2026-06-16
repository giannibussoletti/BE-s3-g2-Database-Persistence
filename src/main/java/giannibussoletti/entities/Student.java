package giannibussoletti.entities;

import giannibussoletti.enums.StudentType;
import jakarta.persistence.*;

@Entity // Annotazione Obbligatori per tutte le entities
// Crea una mappatura tra questa classe e la tabella corrispondente nel DB.
// Gli attributi di questa classe verranno mappati a colonne della tabella anche se non utilizziamo l'annotazione @Column

// N.B. Bisogna sempre ricordarsi di aggiornare il persistence.xml con il percorso della classe <class>giannibussoletti.entities.Student</class>

@Table(name = "students") // Annotazione opzionale, ma utile per customizzare il nome della tabella
public class Student {
    @Id // Serve per stabilire che questo campo sarà la chiave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Chiede a postgres di generare un Id automaticamente ad ogni inserimento
    // Con strategy identity gli chiediamo insoltre di rendere quel campo long invece che un biginteger un
    // bigserial, quindi un intero auto incrementante
    @Column(name = "student_id")
    private long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String name;
    @Column(name = "surname", nullable = false, length = 50)
    private String surname;
    @Column(name = "student_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StudentType studentType; // Di default gli enum vengono trattati come SMALLINT(numeri)
    // Per risolvere questo problema si risolve con l'annotazione @Enumarated(EnumType.STRING

    public Student() {
        // Il costruttore vuoto è obbligatorio con le entities se hanno un costruttore che degli attributi
    }

    public Student(String name, String surname, StudentType studentType) {
        this.name = name;
        this.surname = surname;
        this.studentType = studentType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;

    }

    public StudentType getStudentType() {
        return studentType;
    }
}
