public class SeverityScoreCalculator {
    public enum RISK_CONDITION {
        NO_DIFFERENCE,
        UNSURE,
        VERY_DIFFERENT
    }

    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";
    String YELLOW = "\u001B[33m";
    String RESET = "\u001B[0m";

    public RISK_CONDITION getRating(int difference, int severityScore) {
        if (difference >= 3 || severityScore >= 15) {
            System.out.println(getRED() + "Very Different" + getRESET());
            return RISK_CONDITION.VERY_DIFFERENT;
        } else if (severityScore >= 10) {
            System.out.println(getYELLOW() + "Unsure" + getRESET());
            return RISK_CONDITION.UNSURE;
        } else {
            System.out.println(getGREEN() + "No Difference" + getRESET());
            return RISK_CONDITION.NO_DIFFERENCE;
        }
    }

    public void getRating(RISK_CONDITION riskCondition) {
        if (riskCondition == RISK_CONDITION.VERY_DIFFERENT) {
            System.out.println(getRED() + "Very Different" + getRESET());
        } else if (riskCondition == RISK_CONDITION.UNSURE) {
            System.out.println(getYELLOW() + "Unsure" + getRESET());
        } else {
            System.out.println(getGREEN() + "No Difference" + getRESET());
        }
    }

    public String getGREEN() {
        return this.GREEN;
    }

    public String getRED() {
        return this.RED;
    }

    public String getYELLOW() {
        return this.YELLOW;
    }

    public String getRESET() {
        return this.RESET;
    }
}
