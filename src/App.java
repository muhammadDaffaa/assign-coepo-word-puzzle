import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class App {

    static int totalScoreLevel1 = 0, totalScoreLevel2 = 0, totalScoreLevel3 = 0,
            rightAnswer = 0, rightAnswer2 = 0,
            rightAnswer3 = 0, numberChance = 1, numberChance2 = 1, numberChance3 = 1;

    static String answer, validasi, tempValidasi = "", readEnterPressed = "";

    static boolean statusLevel1 = false, statusLevel2 = false, statusLevel3 = false;
    static Scanner input = new Scanner(System.in);

    static ArrayList<String> tempAnswers = new ArrayList<String>();

    public static void main(String[] args) {

        String[] wordLevel1 = { "die", "led", "lei", "let", "lid", "lie", "lit", "tie", "deli", "diet", "\n",
                "edit", "idle", "lied", "tide", "tied", "tile", "tilt", "tilde", "tiled", "title", "\n", "tilted",
                "titled" };
        String[] wordLevel2 = { "ace", "can", "sac", "sea", "sec", "see", "aces",
                "acne", "cane", "cans",
                "\n", "case", "ease", "sane", "scan", "seen", "acnes", "canes", "cease",
                "cense", "scene", "\n", "encase", "seance" };

        String[] wordLevel3 = { "", "eon", "hen", "her", "hoe", "hon", "ken", "nor",
                "one", "ore", "rho",
                "roe", "hero", "hoer", "hone", "honk", "horn", "kern", "oner", "heron",
                "honer", "\n",
                "honker", };

        // Call Method
        showRules();

        do {
            level1(wordLevel1);
            level2(wordLevel2);
            level3(wordLevel3);

            if (statusLevel1 == true && statusLevel2 == true && statusLevel3 == true) {

                showResult(totalScoreLevel1 + totalScoreLevel2 + totalScoreLevel3);
            }

            if (totalScoreLevel1 < 70 || totalScoreLevel2 < 70 || totalScoreLevel2 < 70) {
                System.out.print("You Lose!! Try Again ...");
                System.out.print("Do you want to retry [y/t] ? ");
                validasi = input.nextLine();
                tempValidasi = validasi.toLowerCase();
                while (!tempValidasi.equals("y") && !tempValidasi.equals("t")) {
                    System.out.print("You Lose!! Try Again ...");
                    System.out.print("Do you want to retry [y/t] ? ");
                    validasi = input.next();
                    tempValidasi = validasi.toLowerCase();
                }
                if (tempValidasi.equals("y")) {
                    numberChance = 1;
                    numberChance2 = 1;
                    numberChance3 = 1;
                }
            }

        } while (tempValidasi.equals("y"));

    }

    public static void showRules() {
        System.out.println("Coeppoe Word Puzzle");
        System.out.println("===================");
        System.out.println();
        System.out.println("Rules : ");
        System.out.println("1. Create a word using given characters, min 3 characters & max 6 characters");
        System.out.println("2. Each level, You have 10 chances to answer correctly");
        System.out.println("3. To get through to next level, you have to score 70 points each level");
        System.out.println();
    }

    public static void showResult(int result) {
        System.out.println("Overall Score : " + result);
        System.out.println("You Win !!");
        System.out.println("Press ENTER to Exit ...");
        readEnterPressed = input.nextLine();
        if (input.hasNextLine()) {

            return;
        }
    }

    public static void level1(String[] arrData) {

        System.out.println("Level 1");
        System.out.println("-------");
        System.out.println("Rules : ");

        System.out.println("\td\te\tt\tt\tl\ti");
        while (numberChance <= 10) {
            System.out.print(numberChance + " > Your Answer: ");

            answer = input.nextLine();
            while (answer.length() < 3 || answer.length() > 6) {

                System.out.print(numberChance + " > Your Answer: ");
                answer = input.nextLine();
            }

            if (Arrays.stream(arrData).anyMatch(answer::contains)) {
                if (tempAnswers.contains(answer)) {
                    System.out.println("You had already type this word before!");
                    continue;
                }
                totalScoreLevel1 += 10;
                tempAnswers.add(answer);
                rightAnswer += 1;
                System.out.println("#Right. Score: " + totalScoreLevel1);
                numberChance++;
            } else {
                System.out.println("#Wrong. Score : " + totalScoreLevel1);
                numberChance++;
            }

        }
        if (totalScoreLevel1 >= 70 || totalScoreLevel1 <= 70) {
            System.out.println("You had answered 10 times with " + rightAnswer + " right answer ...");
            System.out.println("Correct Answer : ");
            System.out.println();

        }

        if (totalScoreLevel1 >= 70) {
            statusLevel1 = true;
        }
    }

    public static void level2(String[] arrData) {
        // showRules();
        System.out.println("Level 2");
        System.out.println("-------");
        System.out.println("Rules : ");

        System.out.println("\ts\te\tc\ta\te\tn\t");
        while (totalScoreLevel1 >= 70 && numberChance2 <= 10) {

            while (numberChance2 <= 10) {
                System.out.print(numberChance2 + " > Your Answer: ");
                answer = input.nextLine();
                while (answer.length() < 3 || answer.length() > 6) {
                    System.out.print(numberChance2 + " > Your Answer: ");
                    answer = input.nextLine();
                }

                // answer = input.nextLine();
                if (Arrays.stream(arrData).anyMatch(answer::contains)) {
                    if (tempAnswers.contains(answer)) {
                        System.out.println("You had already type this word before!");
                        continue;
                    }
                    totalScoreLevel2 += 10;
                    tempAnswers.add(answer);
                    rightAnswer2 += 1;
                    System.out.println("#Right. Score: " + totalScoreLevel2);
                    numberChance2++;
                } else {
                    System.out.println("#Wrong. Score : " + totalScoreLevel2);
                    numberChance2++;
                }
            }

        }

        if (totalScoreLevel2 >= 70 && totalScoreLevel1 >= 70) {
            System.out.println("You had answered 10 times with " + rightAnswer2 + " right answer ...");
            System.out.println("Correct Answer : ");
            System.out.println();
        }
        if (totalScoreLevel2 >= 70) {
            statusLevel2 = true;
        }

    }

    public static void level3(String[] arrData) {
        while (totalScoreLevel2 >= 70 && numberChance3 <= 10) {
            // showRules();
            System.out.println("Level 3");
            System.out.println("-------");
            System.out.println("Rules : ");

            System.out.println("\th\tk\tr\tn\te\to\t");
            while (numberChance3 <= 10) {
                System.out.print(numberChance3 + " > Your Answer: ");

                answer = input.nextLine();
                System.out.print(numberChance3 + " > Your Answer: ");
                while (answer.length() < 3 || answer.length() > 6) {
                    answer = input.nextLine();
                }

                // answer = input.nextLine();
                if (Arrays.stream(arrData).anyMatch(answer::contains)) {
                    if (tempAnswers.contains(answer)) {
                        System.out.println("You had already type this word before!");
                        continue;
                    }
                    totalScoreLevel3 += 10;
                    tempAnswers.add(answer);
                    rightAnswer3 += 1;
                    System.out.println("#Right. Score: " + totalScoreLevel3);
                    numberChance3++;
                } else {
                    System.out.println("#Wrong. Score : " + totalScoreLevel3);
                    numberChance3++;
                }
            }
        }

        if (totalScoreLevel3 >= 70 && totalScoreLevel2 >= 70) {
            System.out.println("You had answered 10 times with " + rightAnswer3 + " right   answer ...");
            System.out.println("Correct Answer : ");
            System.out.println();
        }

        if (totalScoreLevel3 >= 70) {
            statusLevel3 = true;
        }

    }

}