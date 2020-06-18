package training.web.application.filters;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Filter subclass that validates fields data while registering any User.
 * @author Ihor Savchenko
 */
public class ValidateRegistrationFilter extends BaseFilter {
    public void doFilter(HttpServletRequest req, HttpServletResponse resp,
                         FilterChain filterChain) throws IOException, ServletException {

        Boolean incorrectFieldFound = false;

        Pattern loginPattern = Pattern.compile("^[A-Za-z_]([A-Za-z\\d_]{2,19})$");
        Pattern passwordPattern = Pattern.compile("^[\\w]{5,20}$");
        Pattern namePattern = Pattern.compile("^[A-ZА-Я]([a-zа-я]{1,19})$");
        Pattern lastnamePattern = Pattern.compile("^[A-ZА-Я]([a-zа-я]{1,19})$");
        Pattern emailPattern = Pattern.compile("^[\\w]([\\w-]{1,19})@([a-z]{3,8})\\.([a-z]{2,3})$");

        Matcher loginMatcher = loginPattern.matcher(req.getParameter("login"));
        Matcher passwordMatcher = passwordPattern.matcher(req.getParameter("password"));
        Matcher nameMatcher = namePattern.matcher(req.getParameter("name"));
        Matcher lastnameMatcher = lastnamePattern.matcher(req.getParameter("lastname"));
        Matcher emailMatcher = emailPattern.matcher(req.getParameter("email"));

        if(!loginMatcher.matches()){
            incorrectFieldFound = true;
        }
        else if(!passwordMatcher.matches()){
            incorrectFieldFound = true;
        }
        else if(!nameMatcher.matches()){
            incorrectFieldFound = true;
        }
        else if(!lastnameMatcher.matches() && !req.getParameter("lastname").equals("")){
            incorrectFieldFound = true;
        }
        else if(!emailMatcher.matches()){
            incorrectFieldFound = true;
        }

        if(incorrectFieldFound){
            req.setAttribute("incorrectRegistration", true);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/registration.jsp");
            dispatcher.forward(req, resp);
        }
        else filterChain.doFilter(req, resp);
    }
}
