package am.basic.jdbcStart.controller;

import am.basic.jdbcStart.model.exceptions.InternalServerException;
import am.basic.jdbcStart.model.exceptions.NotFoundException;
import am.basic.jdbcStart.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static am.basic.jdbcStart.util.constants.Pages.HOME_PAGE;
import static am.basic.jdbcStart.util.constants.ParameterKeys.*;

public class NoteServlet extends HttpServlet {
    private UserService userService = new UserService();

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter(USERNAME_PARAM_KEY);
        String note = request.getParameter(NOTE_PARAM_KEY);

        try {
           userService.saveNoteInBase(username, note);
            HttpSession session = request.getSession();
            session.setAttribute(USERNAME_PARAM_KEY, username);
            response.sendRedirect(HOME_PAGE);

            /*if (rememberMe != null && rememberMe.equalsIgnoreCase("on")) {
                Cookie cookie = new Cookie(REMEMBER_TOKEN_COOKIE_KEY);
                cookie.setMaxAge(360000);
                response.addCookie(cookie);*/
        } catch (InternalServerException | NotFoundException e) {
            e.printStackTrace();
            request.setAttribute(MESSAGE_ATTRIBUTE_KEY, e.getMessage());
            request.getRequestDispatcher(HOME_PAGE).forward(request, response);
        }

    }
}