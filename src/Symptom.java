import java.util.*;

public class Symptom {

    private String[] questions = new String[]{"headache", "pressure in head", "neck pain", "nausea or vomiting", "dizziness",
            "blurred vision", "balance problems", "sensitivity to light", "sensitivity to noise",
            "feeling slowed down", "feeling like 'in a fog'", "don't feel right", "difficulty concentrating", "difficulty remembering", "fatigue or low energy",
            "confusion", "drowsiness", "trouble falling asleep", "more emotional", "irritability", "sadness", "nervous or anxious"};
    private Map<String, Integer> symptoms;
    private int gameNumber;

    public Symptom(int _gameNumber) {
        this.symptoms = new HashMap<>();
        this.gameNumber = _gameNumber;
    }

    public String[] getQuestions() {
        return questions;
    }

    public Map<String, Integer> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Map<String, Integer> _symptoms) {
        this.symptoms = _symptoms;
    }

    public int getGameNumber() {
        return gameNumber;
    }
}
