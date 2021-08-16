package web;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "myController",urlPatterns = "*.do")
public class ControllerServlet extends HttpServlet {
    private IProduitDao metier;

    @Override
    public void init() throws ServletException {
        metier = new ProduitDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/chercher.do")){
            req.getRequestDispatcher("produit.jsp").forward(req,resp);
        }
        else if (path.equals("/chercher.do")){
            String motCle = req.getParameter("motCle");
            ProduitModel model = new ProduitModel();
            model.setMotCle(motCle);
            try {
                List<Produit> produits = metier.produitsParMC("%" +motCle+ "%");
                model.setProduits(produits);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("model",model);
            req.getRequestDispatcher("produit.jsp").forward(req,resp);
        }
        else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
