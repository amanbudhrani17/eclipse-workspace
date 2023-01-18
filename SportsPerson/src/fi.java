import java.util.Scanner;

class SportsPerson {
    protected String name;
    protected String address;

    void inputSportsPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Address: ");
        this.address = sc.nextLine();
    }

    void displaySportsPerson() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
    }
}

class Cricketer extends SportsPerson {
    static String type = "Cricketer";
    protected int matchesPlayed;
    protected int catches;

    void inputCricketer() {
        inputSportsPerson();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Matches Played: ");
        matchesPlayed = sc.nextInt();
        System.out.print("Enter Catches: ");
        catches = sc.nextInt();
    }

    void displayCricketer() {
        displaySportsPerson();
        System.out.println("Type: " + type);
        System.out.println("Matches Played: " + this.matchesPlayed);
        System.out.println("Catches Taken: " + this.catches);
    }
}

class Footballer extends SportsPerson {
    static String type = "Footballer";
    protected int matchesPlayed;
    protected int goals;
    protected int tackles;

    void inputFootballer() {
        inputSportsPerson();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Matches Played: ");
        this.matchesPlayed = sc.nextInt();
        System.out.print("Enter Total Goals: ");
        this.goals = sc.nextInt();
        System.out.print("Enter Total Tackles: ");
        this.tackles = sc.nextInt();
    }

    void displayFootballer() {
        displaySportsPerson();
        System.out.println("Type: " + type);
        System.out.println("Matchesplayed: " + this.matchesPlayed);
        System.out.println("Total Goals: " + this.goals);
        System.out.println("Total Tackles: " + this.tackles);
    }
}

class Batsman extends Cricketer {
    protected int runs;
    protected double highest;

    void inputBatsman() {
        inputCricketer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Runs: ");
        this.runs = sc.nextInt();
        System.out.print("Enter Highest Runs: ");
        this.highest = sc.nextDouble();
    }

    void displayBatsman() {
        displayCricketer();
        System.out.println("Runs: " + this.runs);
        System.out.println("Highest Runs: " + this.highest);
    }
}

class Bowler extends Cricketer {
    protected int wickets;
    protected double strikeRate;

    void inputBowler() {
        inputCricketer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Wickets: ");
        this.wickets = sc.nextInt();
        System.out.print("Enter Strike Rate: ");
        this.strikeRate = sc.nextDouble();
    }

    void displayBowler() {
        displayCricketer();
        System.out.println("Total Wickets: " + this.wickets);
        System.out.println("Strike Rates: " + this.strikeRate);
    }
}

class Striker extends Footballer {
    protected int bestScore;
    protected int assist;

    void inputStriker() {
        inputFootballer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Total Goals Scored: ");
        this.bestScore = sc.nextInt();
        System.out.print("Enter Assists: ");
        this.assist = sc.nextInt();
    }

    void displayStriker() {
        displayFootballer();
        System.out.println("Total Goals Scored: " + this.bestScore);
        System.out.println("Assists: " + this.assist);

    }
}

class Defender extends Footballer {
    protected int penalty;
    protected int headers;

    void inputDefender() {
        inputFootballer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Total Tackles: ");
        this.penalty = sc.nextInt();
        System.out.print("Enter Total headers: ");
        this.headers = sc.nextInt();
    }

    void displayDefender() {
        displayFootballer();
        System.out.println("Total tackles: " + this.penalty);
        System.out.println("Total headers: " + this.headers);
    }
}

class WicketKeeper extends Batsman {
    protected int stumpings;

    void inputWK() {
        inputBatsman();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Stumpings: ");
        this.stumpings = sc.nextInt();
    }

    void displayWK() {
        displayBatsman();
        System.out.println("Stumpings: " + this.stumpings);
    }
}

class GoalKeeper extends Defender {
    protected int saves;
    protected int cleanSheets;

    void inputGK() {
        inputDefender();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Total Saves: ");
        this.saves = sc.nextInt();
        System.out.print("Enter Total Clean Sheets: ");
        this.cleanSheets = sc.nextInt();
    }

    void displayGK() {
        displayDefender();
        System.out.println("Total Saves: " + this.saves);
        System.out.println("Total Clean Sheets: " + this.cleanSheets);
    }
}

public class scratch{
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        int alpha = 1;
        while (alpha == 1) {
            System.out.println(
                    "1. SportsPerson\n2. Cricketer \n3. Batsman\n4. Bowler\n5. Footballer\n6. Striker\n7. Defender\n8. WicketKeeper\n9. GoalKeeper\nEnter the type of object you want to create: ");
            int a = sc.nextInt();

            switch (a) {
                case 1:
                    SportsPerson ob1 = new SportsPerson();
                    ob1.inputSportsPerson();
                    System.out.println();
                    ob1.displaySportsPerson();
                    break;
                case 2:
                    Cricketer ob2 = new Cricketer();
                    ob2.inputCricketer();
                    System.out.println();
                    ob2.displayCricketer();
                    break;
                case 3:
                    Batsman ob3 = new Batsman();
                    ob3.inputBatsman();
                    System.out.println();
                    ob3.displayBatsman();
                    break;
                case 4:
                    Bowler ob4 = new Bowler();
                    ob4.inputBowler();
                    System.out.println();
                    ob4.displayBowler();
                    break;
                case 5:
                    Footballer ob5 = new Footballer();
                    ob5.inputFootballer();
                    System.out.println();
                    ob5.displayFootballer();
                    break;
                case 6:
                    Striker ob6 = new Striker();
                    ob6.inputStriker();
                    System.out.println();
                    ob6.displayStriker();
                    break;
                case 7:
                    Defender ob7 = new Defender();
                    ob7.inputDefender();
                    System.out.println();
                    ob7.displayDefender();
                    break;
                case 8:
                    WicketKeeper ob8 = new WicketKeeper();
                    ob8.inputWK();
                    System.out.println();
                    ob8.displayWK();
                    break;
                case 9:
                    GoalKeeper ob9 = new GoalKeeper();
                    ob9.inputGK();
                    System.out.println();
                    ob9.displayGK();
                    break;
            }
            System.out.println("\nDo you want to create more objects(0/1): ");
            alpha = sc.nextInt();
        }
        sc.close();
    }
}