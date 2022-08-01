package bullscows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static bullscows.Main.numberOfPossibleCharacters;

public class utilities {

    public static String a = "";
    public static String set = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static String codeGeneratorNew(int length) {


        Random random = new Random();
        String a = "";
        set = set.substring(0, numberOfPossibleCharacters);
        for (int i = 0; i < length; i++) {
            int randomNumber = random.nextInt(set.length());
            String newNumber = "" + set.charAt(randomNumber);
            a += newNumber;
            set = set.replace(newNumber, "");


        }
        return a;
    }

    public static long codeGenerator(int length) {
        long pseudoRandomNumber = 0;
        Long pseudoRandomNumber1 = null;

        ArrayList<String> listNumber = new ArrayList<>();
        ArrayList<String> listNumberNewLength = new ArrayList<>();


        String setOfCharacters = "";
        String numbers = "";


        Random random = new Random();

        do {
            pseudoRandomNumber = Math.abs(random.nextLong());
            String a = String.valueOf(pseudoRandomNumber);
            String[] split = a.split("");
            listNumber.addAll(Arrays.asList(split));
        } while (listNumber.size() < length);

        listNumberNewLength.addAll(Arrays.asList(listNumber.get(0)));

        for (int i = 1; i < listNumber.size(); i++) {
            if (listNumberNewLength.size() == length) {
                break;
            }
            if (!(listNumberNewLength.contains(listNumber.get(i)))) {
                listNumberNewLength.addAll(Arrays.asList(listNumber.get(i)));
            } else {
                continue;

            }

        }

        pseudoRandomNumber1 = convertFromList_StringToLong(listNumberNewLength);
        return pseudoRandomNumber1;
    }

    public static Long convertFromList_StringToLong(List<String> first) {
        Long pseudoRandomNumber1;
        String newS = "";
        for (String s : first) {
            newS += s;
        }

        pseudoRandomNumber1 = Long.parseLong(newS);
        return pseudoRandomNumber1;
    }

    public static List<Long> convertFromLongtoListLong(Long first) {

        String stringFirst = first.toString();
        List<Long> arrs = new ArrayList<>();
        for (char c : stringFirst.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            Integer numericValue1 = (Integer) numericValue;
            long l = numericValue1.longValue();
            arrs.addAll(Arrays.asList(l));
        }
        return arrs;
    }

    public static boolean isUnique(Long pseudoRandomNumber) {

        boolean unique = false;
        String a = pseudoRandomNumber.toString();
        char[] a1 = a.toCharArray();


        for (int i = 0; i < a.length(); i++) {

            if (a.indexOf(a1[i]) == a.lastIndexOf(a1[i])) {
                unique = true;

            } else {

                unique = false;
                break;

            }
        }
        return unique;
    }

    public static boolean isUnique(String pseudoRandomNumber) {

        boolean unique = false;
        String a = pseudoRandomNumber.toString();
        char[] a1 = a.toCharArray();


        for (int i = 0; i < a.length(); i++) {

            if (a.indexOf(a1[i]) == a.lastIndexOf(a1[i])) {
                unique = true;

            } else {

                unique = false;
                break;

            }
        }
        return unique;
    }

    public static void ListPrint(List<Long> secretCode) {


        for (Long along : secretCode) {

            a += "" + along;
        }
        System.out.print(a);
        a = "";

    }

    public static List<String> convertStringToListString(String arg0) {
        String b = "";
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> a1 = new ArrayList<>();


        for (int i = 0; i < arg0.length(); i++) {
            b = "" + arg0.charAt(i);
            a1.add(b);

        }

        for (int i = 0; i < a1.size(); i++) {
            a.add(a1.get(i));
        }


        return a;
    }

    public static List<Long> convertStringToListLong(String arg0) {
        String b = "";
        ArrayList<Long> a = new ArrayList<>();
        ArrayList<String> a1 = new ArrayList<>();


        for (int i = 0; i < arg0.length(); i++) {
            b = "" + arg0.charAt(i);
            a1.add(b);

        }

        for (int i = 0; i < a1.size(); i++) {
            a.add(Long.parseLong(a1.get(i)));
        }


        return a;
    }

}
