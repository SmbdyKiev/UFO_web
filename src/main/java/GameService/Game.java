package GameService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import static GameService.Constants.*;

public class Game {
    private static Logger LoggerFactory;
    private static final Logger logger = LoggerFactory.getLogger(Game.class);
    private ArrayList<QA> qaList = UFO_CORRECT_ANSWERS;
    private String winMessage = UFO_WIN_MESSAGE;



    public QA receiveFirstQuestion(){
        logger.info("Getting first qestion");
        return qaList.get(0);
    }
    public String checkAnswer (QA qa, String option){
        int index;
        logger.debug("Checking if correct answer for qa: "+qa.getQuestion());
        if(qaList.contains(qa) && qa.getOption1().equals(option)){
            index = qaList.indexOf(qa);
            if ( index < qaList.size()-1) return qaList.get(index+1).getQuestion();
                    else return winMessage;
        }
        else return qa.getLossMessage();
    }

    public QA getNextQuestion (QA question){
        if (qaList.contains(question) && (qaList.indexOf(question) < qaList.size()-1))
            return qaList.get(qaList.indexOf(question)+1);
        else return qaList.get(0);
    }
}
