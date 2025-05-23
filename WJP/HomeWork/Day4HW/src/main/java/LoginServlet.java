

import java.io.IOException;
import java.io.PrintWriter;

import com.voting.dao.CandidateDao;
import com.voting.dao.CandidateDaoImpl;
import com.voting.dao.UserDao;
import com.voting.dao.UserDaoImpl;
import com.voting.pojos.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
    private CandidateDao candidateDao;

    public void init() {
        try {
            userDao = new UserDaoImpl();
            candidateDao = new CandidateDaoImpl();
        } catch (Exception e) {
            throw new RuntimeException("Error in init: " + e);
        }
    }

    public void destroy() {
        try {
            userDao.cleanUp();
            candidateDao.cleanUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");

        try (PrintWriter pw = resp.getWriter()) {
            resp.setContentType("text/html");
            User user = userDao.authenticateUser(email, password);

            if (user == null) {
                pw.print("<h4 style='color:red;'>Invalid login, please <a href='index.html'>try again</a></h4>");
                return;
            }

            // Track session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            session.setAttribute("user_dao", userDao);
            session.setAttribute("candidate_dao", candidateDao);

            if (user.getRole().equals("voter")) {
                if (user.isVotingStatus())
                    pw.print("<h4>You have already voted. <a href='logout'>Logout</a></h4>");
                else
                    resp.sendRedirect("candidates");
            } else {
                resp.sendRedirect("admin");
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
