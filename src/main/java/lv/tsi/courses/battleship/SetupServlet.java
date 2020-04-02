package lv.tsi.courses.battleship;

import lv.tsi.courses.battleship.model.CellState;
import lv.tsi.courses.battleship.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "SetupServlet", urlPatterns = "/setup")
public class SetupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selected = request.getParameterValues("cells");

        var player = (Player) request.getSession().getAttribute("player");

        player.getOwnField().clear();

        if (selected != null) {
            System.out.println(Arrays.toString(selected));
            for (String addr : selected) {
                player.getOwnField().setState(addr, CellState.SHIP);
            }
        }

        if (player.getOwnField().isValid()) {
            response.sendRedirect("/waitSetup");
        } else {
            request.setAttribute("message", "wrong placement!");
            request.getRequestDispatcher("/WEB-INF/setupShips.jsp").include(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO insert logic to check state, whether everything is ready to setup ships.
        request.getRequestDispatcher("/WEB-INF/setupShips.jsp").include(request, response);
    }

}
