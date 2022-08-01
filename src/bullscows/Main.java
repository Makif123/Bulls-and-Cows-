package bullscows;

import java.util.*;


public class Main extends utilities {


    int count = 1;
    public static int length = 0;
    public static int numberOfPossibleCharacters = 36;


    public static void main(String[] args) {
        int count = 1;
        Long first;
        String stars = "";
        int length = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        String length1 = scanner.nextLine();

        try {
            length = Integer.parseInt(length1);

        } catch (NumberFormatException e) {


            System.out.println("Error: "+"\t" + length1 + "\t" + "isn't a valid number");
            System.exit(0);

        }
        if (length < 1) {
            System.out.println("Error");
            System.exit(0);
        }

        for (int i = 0; i < length; i++) {
            stars += "" + "*";
        }
        System.out.println("Input the number of possible symbols in the code:");

        numberOfPossibleCharacters = scanner.nextInt();


        if (numberOfPossibleCharacters < length) {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + numberOfPossibleCharacters + " unique symbols.");
            System.exit(0);

        }


        if (numberOfPossibleCharacters > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
            System.exit(0);
        }


        String l1 = "" + set.charAt(10) + "-" + set.charAt(numberOfPossibleCharacters - 1);
        System.out.println("The secret is prepared: " + stars + " (0-9, " + l1 + ").");


        Long pseudoRandomNumber1 = null;
        String secretCode = codeGeneratorNew(length);


        System.out.println(secretCode);
        List<Character> guessDigitList;
        int cows = 0;
        int bulls = 0;
        String digit = "";
        String guessNumberAndCharacters;
        System.out.println("Okay, let's start a game!");
        do {


            System.out.println("Turn " + count + ":");
            Scanner scanner1 = new Scanner(System.in);
            guessNumberAndCharacters = scanner1.nextLine();

            List<String> arrs = new ArrayList<>();
            List<String> arrString = new ArrayList<>();
            arrs = convertStringToListString(guessNumberAndCharacters);
            List<String> guessDigitList1 = new ArrayList<>();

            for (int i = 0; i < secretCode.length(); i++) {

                digit = "" + guessNumberAndCharacters.charAt(i);
                guessDigitList1.add(digit);
                if (secretCode.contains(digit)) {
                    if (guessDigitList1.indexOf(digit) == guessDigitList1.lastIndexOf(digit)) {
                        if (guessDigitList1.indexOf(digit) != secretCode.indexOf(digit)) {
                            cows++;
                        }
                    } else {
                        if (i >= 1) {
                            if (guessDigitList1.get(i - 1).equals(guessDigitList1.get(i))) {
                                if (guessDigitList1.lastIndexOf(digit) != secretCode.lastIndexOf(digit)) {
                                    cows++;
                                }
                            }
                        }
                    }

                    if (guessDigitList1.lastIndexOf(digit) == secretCode.indexOf(digit)) {
                        bulls++;
                    }
                }

            }
            if (bulls > 0 && cows == 0) {
                System.out.println("Grade: " + bulls + " bull(s)..");
            }
            if (cows > 0 && bulls == 0) {
                System.out.println("Grade: " + cows + " cow(s)..");
            }

            if (cows > 0 && bulls > 0) {
                System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)..");
            }
            if (cows == 0 && bulls == 0) {
                System.out.println("Grade: None..");
            }
            count++;

            cows = 0;
            bulls = 0;
        } while (!(secretCode.equals(guessNumberAndCharacters)));
        System.out.println("Congratulations! You guessed the secret code.");
    }


}

