package GameService;


public class QA {
    private String question;
    private String lossMessage, option1, option2;

    public String getQuestion() {
        return question;
    }
    public String getLossMessage() {
        return lossMessage;
    }
    public String getOption1() {
        return option1;
    }
    public String getOption2() {
        return option2;
    }

    public QA(String question, String option1, String option2, String lossMessage) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.lossMessage = lossMessage;
    }
}
