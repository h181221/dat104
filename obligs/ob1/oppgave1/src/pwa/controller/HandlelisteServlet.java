package pwa.controller;

import pwa.app.FlashUtil;
import pwa.dataaccess.HandlelisteEAO;
import pwa.model.Vare;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Peder on 12.09.2017.
 */
@WebServlet("/handleliste")
public class HandlelisteServlet extends HttpServlet {
    @EJB
    private HandlelisteEAO handlelisteEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("loggedInUser") != null){
            FlashUtil.Flash(request,"Success","Her er din handleliste");
            List<Vare> varer = handlelisteEAO.visAlleVarer();
            request.setAttribute("varer",varer);
            request.getRequestDispatcher("WEB-INF/handleliste.jsp").forward(request,response);
        }else {
            FlashUtil.duMaaVeareLoggetInn(request);
            response.sendRedirect("/login");
        }

    }
}
