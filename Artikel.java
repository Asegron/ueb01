
/**
 * Klasse "Artikel" für den Zweck der einfachen Bestandsführung
 *
 * @author Daniel Stelz, Mert Kiran
 * @version 0.2
 */
public class Artikel {
    /**
     * Attribute des Programmes
     */
    private int artikelnr; 
    private String bezeichnung;
    private int bestand;
    
    /**
     *Erster Konstruktor  mit 3 Parametern
     *
     *Die .trim() - Methode entfernt die Whitespace-Zeichen vom eingegebenen String am Anfang und Emde, aber nicht in der Mitte.
     *
     *Die .isEmpty() - Methode prüft, ob der eingebene String leer ist.
     *
     *@param artikelnr ; darf nicht < 1000 || > 9999 sein
     *@param bezeichnung ; darf nicht leer sein
     *@param bestand ; muss >= 0 sein
     */
    public Artikel(int artikelnr, String bezeichnung, int bestand) {
        if((artikelnr < 1000) || (artikelnr > 9999)) {
            throw new IllegalArgumentException(
                "Artikelnummer ist ungültig, da die Eingabe nicht 4-stellig und/oder negativ ist!");
        }       
        
        if((bezeichnung == null) || (bezeichnung.trim().isEmpty())) {
            throw new IllegalArgumentException(
                "Bezeichnung ist ungültig, da die Eingabe leer ist!");
        }
        
        if(bestand < 0) {
            throw new IllegalArgumentException(
                "Bestand ist ungültig, da Eingabe < 0!");
        }
        
        this.artikelnr = artikelnr;
        this.bezeichnung = bezeichnung;
        this.bestand = bestand;
    }
    
    /**
     * Zweiter Konstruktor mit 2 Parametern
     * 
     * @param artikelnr ; darf nicht < 1000 || <9999 sein
     * @param bezeichnung ; darf nicht leer sein
     */
    public Artikel(int artikelnr, String bezeichnung) {
        this(artikelnr, bezeichnung, 0);
    }
    
    public void bucheZugang(int menge) {
        if(menge <= 0) {
            throw new IllegalArgumentException("Die Eingabe ist ungültig, da < 0!");
        }
        
        bestand = bestand + menge;
    }
    
    public void bucheAbgang(int menge) {
        if(menge <= 0) {
            throw new IllegalArgumentException("Die Eingabe ist ungültig, da < 0!");
        }
        
        if( bestand - menge < 0) {
            throw new IllegalArgumentException("Abgang ist größer als die Größe des Bestandes!");
        }
        bestand = bestand - menge;
    }
    
    /**
     * toString-Methode, um ein Artikel-Objekt als Zeichenkette aufbereiten zu können
     */
    public String toString() {
        return("Artikelnummer: " + artikelnr +
        ", Artikelbezeichnung: " + bezeichnung +
        ", aktueller Artikelbestand in Stück: " + bestand);
    }
    
    /**
     * Gibt die Artikelnummer zurück
     * 
     * @return Artikelnummer
     */
    public int getArtikelnr() {
        return artikelnr;
    }
    
    /**
     * Gibt die Artikelbezeichnung zurück
     * 
     * @return Artikelnummer
     */
    public String getBezeichnung() {
        return bezeichnung;
    }
    
    /**
     * Gibt den Artikelbestand zurück
     * 
     * @return Artikelbestand
     */
    public int getBestand() {
        return bestand;
    }   
    
    /**
     * Legt die Artikelbezeichnung fest
     * 
     * Die .trim() - Methode entfernt die Whitespace-Zeichen vom eingegebenen String am Anfang und Emde, aber nicht in der Mitte.
     *
     * Die .isEmpty() - Methode prüft, ob der eingebene String leer ist.
     * 
     * @param bezeichnung
     */
    public void setBezeichnung(String bezeichnung) {
        if((bezeichnung == null) || (bezeichnung.trim().isEmpty())) {
            throw new IllegalArgumentException("Bezeichnung ist ungültig, da die Eingabe leer ist!");
        }
    }
}
