public class Lecture20241105 {

    public static void main(String[] args) {
        System.out.println("# Beispiel 1: Bonusberechnung");
        System.out.println(bonusBerechnen(7, 3));
        System.out.println(bonusBerechnen(3, 0));
        System.out.println(bonusBerechnen(12, 3));

        System.out.println("\n# Beispiel 2: Tagesplan je nach Wochentag");
        printEntspanntenTagesplan(2);
        printEntspanntenTagesplan(3);
        printEntspanntenTagesplan(8);

        System.out.println("\n# Beispiel 3: Plan für die gesamte Woche");
        printEntspanntenWochenplan();
    }

    /**
     * Berechnet Bonus in Abhängigkeit von Boni.
     *
     * @param jahreImUnternehmen Anzahl Jahre im Unternehmen
     * @param abschlussArbeiten  Anzahl betreuter Abschlussarbeiten
     * @return Finaler, errechneter Bonus.
     */
    public static int bonusBerechnen(int jahreImUnternehmen, int abschlussArbeiten) {
        final int basis = 500;
        int bonus = basis;

        if (jahreImUnternehmen >= 10) {
            bonus += 1000;
        } else if (jahreImUnternehmen >= 5) {
            bonus += 500;
        }

        // for (int i = 0; i < abschlussArbeiten; i++) {
        //     bonus += 50;
        // }

        bonus += abschlussArbeiten * 50;

        return bonus;
    }

    public static void printEntspanntenTagesplan(int tag) {
        if (tag < 1 || tag > 7) {
            System.out.println("Fehler: Ungültiger Tag. Bitte geben Sie einen Wert zwischen 1 und 7 ein.");
        } else {
            // switch / case
            switch (tag) {
                case 2 -> {
                    System.out.println("- Zwei Termine:\n   - 09:45 Uhr: Prog1 VL\n   - 12:00 Uhr: WebTech UE");
                }
                case 4 -> System.out.println("- Zwei Termine:\n   - 17:15 Uhr: WebTech VL\n   - 19:00 Uhr: WebTech UE");
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

    public static void printEntspanntenWochenplan() {
        final int feiertag = 3; // Feiertag am Mittwoch

        for (int tag = 1; tag < 8; tag++) {
            if (tag == feiertag) {
                System.out.println("Tag " + feiertag + " ist ein Feiertag ");
                continue;
            } else if (tag > 5) {
                break;
            }
            printEntspanntenTagesplan(tag);
        }
    }
}