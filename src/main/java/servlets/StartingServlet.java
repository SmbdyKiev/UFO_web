package servlets;

import GameService.Game;
import GameService.QA;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static GameService.Constants.UFO_WIN_MESSAGE;

@WebServlet("/start")
public class StartingServlet extends HttpServlet {
private static Logger LoggerFactory;
private static final Logger logger = LoggerFactory.getLogger(Game.class);
private String question, option1, option2, lossmessage;
private QA currentQA = new QA("","","","");
Game game = new Game();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("reached starting servlet, method Get");
        currentQA = game.receiveFirstQuestion();
        question = currentQA.getQuestion();
        option1 = currentQA.getOption1();
        option2 = currentQA.getOption2();
        req.setAttribute("message", question);
        req.setAttribute("option1", option1);
        req.setAttribute("option2", option2);
        RequestDispatcher dispatcher = req.getRequestDispatcher("play.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("reached starting servlet, method Post");
        String option = req.getParameter("option");
        logger.info("received option from web: "+option);
        if (option.equals("option1")) option = currentQA.getOption1();
        logger.info("converted option from web to : "+option);
        if (option != null) {
            question = game.checkAnswer(currentQA, option);
        }
        if (question.equals(UFO_WIN_MESSAGE)){
            req.setAttribute("message", question);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/win.jsp");
            dispatcher.forward(req, resp);
        } else
        if (question.equals(currentQA.getLossMessage())){
            req.setAttribute("message", question);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/loss.jsp");
            dispatcher.forward(req, resp);
        }
        else {
            currentQA=game.getNextQuestion(currentQA);
            question = currentQA.getQuestion();
            option1 = currentQA.getOption1();
            option2 = currentQA.getOption2();
            req.setAttribute("message", question);
            req.setAttribute("option1", option1);
            req.setAttribute("option2", option2);
            RequestDispatcher dispatcher = req.getRequestDispatcher("play.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
