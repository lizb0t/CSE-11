/* Project breakdown
 * read input data for programming assignment scores, a midterm score, and a final score 
 * validate the input to ensure scores are within the valid range (0 to 100)
 * calculate the averafe score for programming assignments
 * compute the overall score using given weights 
 * determine the letter grade based on the overall score
 * outpit the overall score and the letter grade g
 */
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) { // main method
        Scanner scanner = new Scanner(System.in); // create a scanner object to read input from the user

        String paScoresLine = scanner.nextLine(); // read the input for programming assignment scores
        String examScoresLine = scanner.nextLine(); // read the input for exam scores

        String[] paScores = paScoresLine.split(" "); // split the input into an array of strings
        int numPA = Integer.parseInt(paScores[0]); // get the number of programming assignments

        if (numPA == 0) {
            System.out.println("invalid input");
            return; // exit the program
        }

        double totalPAScore = 0; // initialize the total score for programming assignments
        boolean validInput = true; // initialize a boolean variable to check if the input is valid

        for (int i = 1; i <= numPA; i++) { // iterate over the programming assignment scores
            int score = Integer.parseInt(paScores[i]); // get the score for each programming assignment
            if (score < 0 || score > 100) { // check if the score is within the valid range
                validInput = false; // set the validInput flag to false
                break; // exit the loop
            }
            totalPAScore += score; // add the score to the total score
        }

        if (!validInput) {
            System.out.println("invalid input");
            return;
        }

        double avgPAScore = totalPAScore / numPA;

        String[] examScores = examScoresLine.split(" ");
        int midtermScore = Integer.parseInt(examScores[0]);
        int finalScore = Integer.parseInt(examScores[1]);

        if (midtermScore < 0 || midtermScore > 100 || finalScore < 0 || finalScore > 100) {
            System.out.println("invalid input");
            return;
        }

        double overallScore = (avgPAScore * 0.5) + (midtermScore * 0.125) + (finalScore * 0.375);

        char letterGrade;

        if (overallScore >= 90) {
            letterGrade = 'A';
        } else if (overallScore >= 80) {
            letterGrade = 'B';
        } else if (overallScore >= 70) {
            letterGrade = 'C';
        } else if (overallScore >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        System.out.println(overallScore);
        System.out.println(letterGrade);
    }
}

