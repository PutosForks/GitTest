package strings.StringMethods.Formating;

public class formattedTable {

    static void line() {
        System.out.println("-----------------------------------------------------------------------");
    }

    static void printHeader() {
        System.out.printf("%-15s \t %s \t %s \t %s \n", "Player", "Matches", "Goals", "Goals per match");
    }

    /*
     "%-15s"   => symbol "-" indicates left aligned. Number 15 specifies the 
                  length of the string
     "%5d"     => expects Integer taht will be dispalyed at minimum 5 digits
     "%.1f"    => expects Float at one precision digit
     */
    static void printRow(String player, int matches, int goals) {
        System.out.printf("%-15s \t %5d \t\t %d \t\t %.1f \n",
                player, matches, goals, ((float) goals / (float) matches));
    }

    public static void main(String[] str) {
        formattedTable.line();
        formattedTable.printHeader();
        formattedTable.line();
        formattedTable.printRow("Demando", 100, 122);
        formattedTable.printRow("Mushi", 80, 100);
        formattedTable.printRow("Peale", 150, 180);
        formattedTable.line();
    }
}
