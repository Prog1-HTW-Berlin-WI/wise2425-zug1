// Bibliothek fürs Sortieren
import java.util.Arrays;

/**
 * Klasse für Array Vorlesung
 * 
 * @author Reni Amalia Safitri
 */
public class MyArray {
    public static void main(String[] args) {
        // 1D Array vom Typ String mit der Länge 5 initialisieren
        // Länge 5 = 5 Elemente
        String[] plz = new String[5];
        // Element beginnend mit Index 0
        plz[0] = "13125";
        plz[1] = "12169";
        plz[2] = "12459";
        plz[3] = "12623";
        plz[4] = "10407";

        // danach kann man den Inhalt eines Elements ändern
        plz[4] = "10176";

        // 1D Array vom Typ String mit Elementen initialisieren
        String[] plz2 = { "13125", "12169", "12459", "12623", "10407" };

        // 2D Array vom Typ int mit Elementen initialisieren
        // Array mit Index 0 : 1,2,3
        // Array mit Index 1 : 4,6,9
        int[][] array2d = { { 1, 2, 3 }, { 4, 6, 9 } };

        // for each Schleife, für jedes Element im Array
        for (String item : plz2) {
            // bsp alles in der Konsole ausgeben
            System.out.println(item);
        }

        // In Arrays suchen

        // for Schleife mit Iterator i für Index des Elements im Array
        for (int i = 0; i < plz.length; i++) {
            // bsp nach Index vom 13125 suchen
            if (plz[i].equals("13125"))
                System.out.println(i); // gibt 0 aus
        }

        // verschachtelte for-Schleifen für 2D Arrays
        // große Schleife für Zeilen (Arrays)
        for(int i = 0; i < array2d.length; i++){
            // kleine Schleife für Elemente in den Arrays
            for(int j = 0; j < array2d[i].length; j++){
                // bsp nach Index vom Element 9 suchen
                if(array2d[i][j] == 9)
                    System.out.println("[" + i + "][" + j + "]");
            }
        }

        // Arrays sortieren
        Arrays.sort(plz2);

        // nach Index vom 13125 suchen nach der Sortierung des Arrays
        for (int i = 0; i < plz2.length; i++) {
            if (plz2[i].equals("13125"))
                System.out.println(i); // gibt 4 aus
        }

        // Inhalte löschen, bsp 1 Element löschen
        // neues Array erstellen mit der Länge des Ursprungs - Elemente, 
        // die gelöscht werden müssen
        String[] arrCopy = new String[plz2.length - 1];
        int idx = 0; // Hilfsvariable für die neue Index
        
        // Für jedes Element im Array
        for(String item : plz2){
            // wenn nicht das Element, was entfernt werden soll,
            // dann das Element in das neue Array kopieren
            // und Index erhöhen
            if(!item.equals("10407")){
                arrCopy[idx] = item;
                i++;
            }
        }

        // find unique element
        int uniqueNumber = findUniqueElement(new int[] { 2, 2, 3, 5, 5 }); // 3
    }

    /**
     * identifiziert das einzige Element, das nicht zweimal in einem Array
     * vorkommt und gibt es zurück
     * 
     * @see <a href="https://www.studytonight.com/java-examples/xor-operator-in-java">XOR Operator in Java</a>
     * 
     * @param inputArray das Array was durchsucht werden muss
     * @return das Element, was nur einmal vorkommt
     */
    public static int findUniqueElement(int[] inputArray){
        int uniqueElement = 0;

        // für jede Elemente im Array
        for (int i = 0; i < arr.length; i++) {
            // überprüfe ob den Wert im Element unique ist
            // wenn ja, zwischenspeichern in uniqueElement
            // uniqueElement XOR Element
            uniqueElement ^= arr[i];
        }
        return uniqueElement;
    }
}
