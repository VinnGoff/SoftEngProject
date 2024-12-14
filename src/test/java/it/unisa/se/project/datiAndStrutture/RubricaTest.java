package it.unisa.se.project.datiAndStrutture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

class RubricaTest {
    private Rubrica rubrica;
    private Contatto contatto1;
    private Contatto contatto2;
    private final String TEST_FILE = "test_rubrica.csv";

    @BeforeEach
    void setUp() {
        rubrica = new Rubrica();
        
        // Creazione contatti di test
        contatto1 = new Contatto(
            "Mario", 
            "Rossi",
            new NumeroTel("1234567890"),
            new NumeroTel("0987654321"),
            new NumeroTel("1122334455"),
            new Email("mario.rossi@email.com"),
            new Email("mario.work@email.com"),
            new Email("mario.personal@email.com")
        );
        
        contatto2 = new Contatto(
            "Luigi", 
            "Verdi",
            new NumeroTel("2233445566"),
            new NumeroTel(""),
            new NumeroTel(""),
            new Email("luigi.verdi@email.com"),
            new Email(""),
            new Email("")
        );
    }

    @Test
    @DisplayName("Aggiunta di un contatto valido")
    void testAggiungiContatto() {
        rubrica.aggiungiContatto(contatto1);
        List<Contatto> contatti = rubrica.getContatti();
        
        assertEquals(1, contatti.size());
        assertEquals(contatto1, contatti.get(0));
    }

    @Test
    @DisplayName("Aggiunta di un contatto null deve lanciare IllegalArgumentException")
    void testAggiungiContattoNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            rubrica.aggiungiContatto(null);
        });
    }

    @Test
    @DisplayName("Rimozione di un contatto esistente")
    void testRimuoviContatto() {
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);
        
        rubrica.rimuoviContatto(contatto1);
        List<Contatto> contatti = rubrica.getContatti();
        
        assertEquals(1, contatti.size());
        assertEquals(contatto2, contatti.get(0));
    }

    @Test
    @DisplayName("Ricerca contatti con vari criteri")
    void testCercaContatto() {
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);

        // Test ricerca per nome
        List<Contatto> risultatiNome = rubrica.cercaContatto("Mario");
        assertEquals(1, risultatiNome.size());
        assertEquals(contatto1, risultatiNome.get(0));

        // Test ricerca per cognome
        List<Contatto> risultatiCognome = rubrica.cercaContatto("Verdi");
        assertEquals(1, risultatiCognome.size());
        assertEquals(contatto2, risultatiCognome.get(0));

        // Test ricerca per numero di telefono
        List<Contatto> risultatiTelefono = rubrica.cercaContatto("1234567890");
        assertEquals(1, risultatiTelefono.size());
        assertEquals(contatto1, risultatiTelefono.get(0));

        // Test ricerca per email
        List<Contatto> risultatiEmail = rubrica.cercaContatto("luigi.verdi@email.com");
        assertEquals(1, risultatiEmail.size());
        assertEquals(contatto2, risultatiEmail.get(0));
    }

    @Test
    @DisplayName("Ricerca con stringa vuota o null deve restituire tutti i contatti")
    void testCercaContattoEdgeCases() {
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);

        assertAll(
            () -> assertEquals(2, rubrica.cercaContatto("").size(), "Ricerca con stringa vuota"),
            () -> assertEquals(2, rubrica.cercaContatto(null).size(), "Ricerca con null")
        );
    }

    @Test
    @DisplayName("Salvataggio e caricamento da file")
    void testSalvaECaricaFile() throws IOException {
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);

        // Test salvataggio
        rubrica.salvaFile(TEST_FILE);
        assertTrue(new File(TEST_FILE).exists());

        // Creiamo una nuova rubrica e carichiamo il file
        Rubrica nuovaRubrica = new Rubrica();
        nuovaRubrica.caricaFile(TEST_FILE);

        List<Contatto> contattiOriginali = rubrica.getContatti();
        List<Contatto> contattiCaricati = nuovaRubrica.getContatti();

        assertEquals(contattiOriginali.size(), contattiCaricati.size());
        
        // Verifichiamo che i contatti siano stati caricati correttamente
        for (int i = 0; i < contattiOriginali.size(); i++) {
            Contatto originale = contattiOriginali.get(i);
            Contatto caricato = contattiCaricati.get(i);
            
            assertAll(
                () -> assertEquals(originale.getNome(), caricato.getNome(), "Nome deve corrispondere"),
                () -> assertEquals(originale.getCognome(), caricato.getCognome(), "Cognome deve corrispondere"),
                () -> assertEquals(originale.getNumeriTel().toString(), caricato.getNumeriTel().toString(), "Numeri di telefono devono corrispondere"),
                () -> assertEquals(originale.getIndirizziEmail().toString(), caricato.getIndirizziEmail().toString(), "Email devono corrispondere")
            );
        }
    }

    @Test
    @DisplayName("Caricamento di un file inesistente deve lanciare IOException")
    void testCaricaFileInesistente() {
        assertThrows(IOException.class, () -> {
            rubrica.caricaFile("file_non_esistente.csv");
        });
    }

    @AfterEach
    void tearDown() {
        // Pulizia del file di test se esiste
        File testFile = new File(TEST_FILE);
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}