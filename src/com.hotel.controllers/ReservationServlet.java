import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.ReservationService;
import com.example.entity.Reservation;

@WebServlet("/reservations")
public class ReservationServlet extends HttpServlet {
    @Inject
    private ReservationService reservationService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Reservation> reservations = reservationService.getAllReservations();
        request.setAttribute("reservations", reservations);
        request.getRequestDispatcher("reservations.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int chambreId = Integer.parseInt(request.getParameter("chambre_id"));
        String dateDebut = request.getParameter("date_debut");
        String dateFin = request.getParameter("date_fin");
        
        reservationService.createReservation(userId, chambreId, dateDebut, dateFin);
        response.sendRedirect("/reservations");
    }
}
