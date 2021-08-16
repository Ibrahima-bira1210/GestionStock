import dao.ProduitDaoImpl;
import metier.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public class TestDao {
    public static void main(String[] args) throws SQLException {
        ProduitDaoImpl dao = new ProduitDaoImpl();
        //Produit p1 = dao.saveProduit(new Produit("HpEliteBook",900,45));
        //Produit p2 = dao.saveProduit(new Produit("Machine a laver",1900,4));
        //Produit p3 = dao.saveProduit(new Produit("Micro-Onde",1200,44));
        //System.out.println(p1.toString());
        //System.out.println(p2.toString());
        //System.out.println(p3.toString());
        System.out.println("Chercher produit");
        List<Produit> prods = dao.produitsParMC("machine%");
        for (Produit p : prods) {
            System.out.println(p.toString());
        }
    }

}
