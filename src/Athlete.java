import java.util.*;

public class Athlete implements IAthlete {

    private String fullName;
    private int gamesTracked = 0;
    private Symptom[] symptomTracker;
    private SeverityScoreCalculator.RISK_CONDITION overallRating = SeverityScoreCalculator.RISK_CONDITION.NO_DIFFERENCE;

    public Athlete(String fullName) {
        this.fullName = fullName;
        this.symptomTracker = new Symptom[5];
    }


    @Override
    public void symptomEntry() {

        if(gamesTracked >=5) {
            System.arraycopy(symptomTracker, 1, symptomTracker, 0,symptomTracker.length - 1);
            gamesTracked = 4;
        }

        symptomTracker[gamesTracked] = new Symptom(gamesTracked);
        String[] questionList = symptomTracker[gamesTracked].getQuestions();
        Map<String, Integer> gameSymptomMap = symptomTracker[gamesTracked].getSymptoms();
        Scanner in = new Scanner(System.in);

        for (String s : questionList) {
            int a;
            do {
                System.out.printf("Please input your %s score (none(0), mild(1-2), moderate (3-4), & severe(5,6)): ", s);
                while (!in.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number between 0 and 6.");
                    in.nextLine(); // Clear the invalid input
                }
                a = in.nextInt();
                if (a < 0 || a > 6) {
                    System.out.println("Invalid input. Please enter a number between 0 and 6.");
                }
            } while (a < 0 || a > 6);
            if (a != 0) {
                gameSymptomMap.put(s, a);
            }
        }
        gamesTracked++;
    }

    @Override
    public void displaySymptomSummary() {
        int previousSymptomSize = 0;
        if (this.gamesTracked < 1) {
            System.out.println("Not enough games to compare. Considering adding symptoms for another game.");
            return;
        }
        for (int i = 0; i < this.gamesTracked; i++) {

            int symptomSeverityScore = 0;
            System.out.println("Summary for game #" + i);
            Map<String, Integer> gameSymptoms = symptomTracker[i].getSymptoms();

            for (Map.Entry<String, Integer> entry : gameSymptoms.entrySet()) {
                System.out.println("Symptom = " + entry.getKey() + ", Score = " + entry.getValue());
                symptomSeverityScore += entry.getValue();
            }

            System.out.printf("Symptom Severity Score is %s", symptomSeverityScore);
            if (i == 0) {
                System.out.println("First Game. Cannot compare with previous");
                continue;
            }

            System.out.println("Symptom Severity Score is: " + symptomSeverityScore);
            System.out.println("Overall rating compared to last game is: " + gameSymptoms.size());

            SeverityScoreCalculator riskCondition = new SeverityScoreCalculator();

            this.overallRating = riskCondition.getRating(Math.abs(previousSymptomSize - gameSymptoms.size()), symptomSeverityScore);
            previousSymptomSize = gameSymptoms.size();
        }
    }

    @Override
    public void riskyCondition() {
        SeverityScoreCalculator riskCondition = new SeverityScoreCalculator();
        riskCondition.getRating(this.overallRating);
    }

    public String getFullName() {
        return fullName;
    }
}
