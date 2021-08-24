package web;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;
import org.springframework.context.ApplicationContext;

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
        //ApplicationContext springContext = WebApplicationContextUtils.getApplicationContext(this.getServletContext());
        //metier= (IProduitDao)springContext.getBean("dao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/index.do")){
            req.getRequestDispatcher("produit.jsp").forward(req,resp);
        }
        else if (path.equals("/chercher.do")){
            String motCle = req.getParameter("motCle");
            ProduitModel model = new ProduitModel();
            model.setMotCle(motCle);
            try {
                List<Produit> produits = metier.produitsParMC("%" +motCle+ "%");
                model.setProduits(produits);
                req.setAttribute("model",model);
                req.getRequestDispatcher("produit.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if (path.equals("/saisie.do")){
            req.getRequestDispatcher("saisi.jsp").forward(req,resp);
        }
        else if(path.equals("/save.do") &&(req.getMethod().equals("POST"))){
            String des = req.getParameter("designation");
            double prix = Double.parseDouble(req.getParameter("prix"));
            int quantite = Integer.parseInt(req.getParameter("quantite"));
            try {
                Produit p = metier.saveProduit(new Produit(des, prix, quantite));
                req.setAttribute("produit",p);
                req.getRequestDispatcher("confirm.jsp").forward(req,resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else if(path.equals("/suprimer.do")){
            long id = Long.parseLong(req.getParameter("id"));
            metier.deleteProduit(id);
            //req.getRequestDispatcher("produit.jsp").forward(req,resp);
            resp.sendRedirect("chercher.do?motCle=");
        }
        else if(path.equals("/edit.do")){
            long id = Long.parseLong(req.getParameter("id"));
            Produit p = metier.getProduit(id);
            req.setAttribute("produit",p);
            req.getRequestDispatcher("edit.jsp").forward(req, resp);
        }
        else if(path.equals("/update.do") &&(req.getMethod().equals("POST"))){
            Long id = Long.parseLong(req.getParameter("id"));
            String des = req.getParameter("designation");
            double prix = Double.parseDouble(req.getParameter("prix"));
            int quantite = Integer.parseInt(req.getParameter("quantite"));
            Produit p = new Produit(des, prix, quantite);
            p.setId(id);
            metier.updateProduit(p);
            req.setAttribute("produit",p);
            req.getRequestDispatcher("confirm.jsp").forward(req,resp);

        }
        else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
