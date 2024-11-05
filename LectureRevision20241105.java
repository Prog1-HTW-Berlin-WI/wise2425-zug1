public class LectureRevision20241105 {

    public static void main(String[] args) {
        System.out.println("# Beispiel 1: Bonusberechnung");
        System.out.println(bonusBerechnen(7, 3));
        System.out.println(bonusBerechnen(3, 0));
        System.out.println(bonusBerechnen(12, 3));

        System.out.println("\n# Beispiel 2: Tagesplan je nach Wochentag");
        printHtwTagesplan(2);
        printHtwTagesplan(3);
        printHtwTagesplan(8);

        System.out.println("\n# Beispiel 3.1: Plan für die gesamte Woche");
        printHtwWochenplan();

        System.out.println("\n# Beispiel 3.2: Plan für die gesamte Woche mit Feiertag am Mi");
        printHtwWochenplanMitFeiertag(3);

        System.out.println("\n# Beispiel 4: Bestellabwicklung");
        ordersProcessing();
    }

    // Kommentar zu Javadoc:
    // Erst: Freitextbeschreibung dessen, was die Methode macht (ohne das "Wie" dahinter zu erläutern).
    // Außerdem werden in Javadoc Tags (@irgendwas) genutzt, die als besondere Informationen interpretiert werden; hier:
    // @param <Name des Parameters> <Beschreibung> - beschreibt je genau einen Parameter, den die Methode entgegennimmt.
    // @return <Beschreibung> - beschreibt, was die Methode zurückgibt.

    /**
     * Berechnet Bonus in Abhängigkeit von Jahren im Unternehmen und der Anzahl an betreuten Abschlussarbeiten.
     *
     * @param jahreImUnternehmen Anzahl Jahre im Unternehmen
     * @param abschlussArbeiten  Anzahl betreuter Abschlussarbeiten
     * @return Finaler, errechneter Bonus.
     */
    public static int bonusBerechnen(int jahreImUnternehmen, int abschlussArbeiten) {
        final int basis = 500;
        int bonus = basis;

        if (jahreImUnternehmen >= 10) { // Diese Prüfung als erstes, da die untere auch für Personen mit 10+ Jahren Erfahrung true wäre
            bonus += 1000;
        } else if (jahreImUnternehmen >= 5) { // Wird nur geprüft, wenn bei oberem if false herauskommt
            bonus += 500;
        }

        bonus += abschlussArbeiten * 50; // 50,- pro Abschlussarbeit

        return bonus;
    }

    /**
     * Gibt (persönlichen) Plan an der HTW abhängig vom Wochentag auf der Konsole aus.
     *
     * @param tag Wochentag als Ganzzahl (1 = Mo bis 7 = So)
     */
    public static void printHtwTagesplan(int tag) {
        // ... Methodenname geht auf einen
        if (tag < 1 || tag > 7) {
            System.out.println("Fehler: Ungültiger Tag. Bitte geben Sie einen Wert zwischen 1 und 7 ein.");
        } else {
            switch (tag) {
                case 2 -> {
                    // Klammern sind bei nur einem Statement optional, bei mehreren allerdings verpflichtend
                    // (Hinweis: Ältere switch/case-Syntax arbeitet hingegen mit Einrückungen)
                    System.out.println("- Zwei Termine:\n   - 09:45 Uhr: Prog1 VL\n  - 12:00 Uhr: WebTech UE");
                }
                case 4 -> System.out.println("- Zwei Termine:\n   - 17:15 Uhr: WebTech VL\n  - 19:00 Uhr: WebTech UE");
                default -> System.out.println("- Keine Termine an der HTW");
            }

            // Alternativ: Ältere switch/case-Syntax

            //switch (tag) {
            //    case 2:
            //        System.out.println("Prog1/WebTech ...");
            //        break;
            //    case 4:
            //        System.out.println("WebTech x2 ...");
            //        break;
            //    default:
            //        System.out.println("Keine Termine");
            //}
        }
    }

    /**
     * Gibt (persönlichen) Plan an der HTW für eine Woche auf der Konsole aus.
     */
    public static void printHtwWochenplan() {
        for (int tag = 1; tag < 8; tag++) {
            printHtwTagesplan(tag);
        }
    }

    /**
     * Gibt (persönlichen) Plan an der HTW für eine Woche auf der Konsole aus und berücksichtigt dabei, dass
     * ein Tag ein Feiertag sein kann (etwas künstliches Beispiel, um continue/break zu nutzen).
     *
     * @param feiertag Tag, an dem ein Feiertag sein soll (1 = Mo bis 7 = So (andere Zahlen werden ignoriert))
     */
    public static void printHtwWochenplanMitFeiertag(int feiertag) {

        // Hinweis: break und continue haben ihren Stellenwert bei komplexeren Kontrollstrukturen,
        // wirken aber an dieser Stelle oft etwas konstruiert.
        // Man muss sich vorstellen, an einer Schleife mit etwas mehr Logik zu sitzen, die aufgrund mehrerer
        // vorhersehbarer Ursachen abgebrochen werden könnte. Hier wären zahlreiche Booleans die Alternative zu break
        // bzw. eine komplexere Verschachtlung Fällen die Alternative zu continue.
        // Beides macht den Code unleserlicher.
        //
        // Dieses Beispiel hätte auch nur mit if/else bzw. einer veränderten Schleifenbedingung umgesetzt werden können,
        // wurde hier aber bewusst mit break/continue implementiert, um es zu zeigen:
        // Wenn Feiertag: keinen Plan ausgeben, weiter mit der nächsten Iteration.
        // Wenn Tag > 5: Wochenende erreicht = Schleifenabbruch.

        for (int tag = 1; tag < 8; tag++) {
            if (tag == feiertag) {
                System.out.println("Tag " + feiertag + " ist ein Feiertag ");
                continue;
            } else if (tag > 5) {
                break;
            }
            printHtwTagesplan(tag); // Wird immer ausgeführt, wenn nicht continue/break davor aufgerufen wird
        }
    }

    /**
     * Simuliert das Abarbeiten ovn Bestellungen:
     * Bestellungen mit dem Status PRIORITY und NORMAL werden abgearbeitet.
     * Sofern eine Bestellung storniert wurde (CANCELLED), wird sie übersprungen und nicht weiter bearbeitet.
     * Sofern eine Bestellung priorisiert wurde (PRIORITY), werden keine Aufträge danach mehr berücksichtigt.
     */
    public static void ordersProcessing() {
        for (int i = 0; i < 5; i++) {
            String status = orderStatus(i);

            if (status.equals("CANCELLED")) {
                System.out.println("Order #" + i + " is cancelled, skipping.");
                continue;
            }

            System.out.println("Processing Order #" + i + " with status: " + status);

            if (status.equals("PRIORITY")) {
                System.out.println("Priority order processed. Stopping further processing.");
                break;
            }
        }
    }

    /**
     * Simuliert das Zuweisen von Bestellnummern zum Bestellstatus.
     *
     * @param orderNr Bestellnummer.
     * @return Simulierter Status.
     */
    public static String orderStatus(int orderNr) {
        return switch (orderNr) {
            case 3 -> "CANCELLED";
            case 4 -> "PRIORITY";
            default -> "NORMAL";
        };
    }
}