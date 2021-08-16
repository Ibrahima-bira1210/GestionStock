package dao;

import metier.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDaoImpl implements IProduitDao {
    @Override
    public Produit saveProduit(Produit p) throws SQLException {
        Connection connection = SingletonConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO produit (designation,prix,quantite) VALUES (?,?,?)"
            );
            ps.setString(1, p.getDesignation());
            ps.setDouble(2,p.getPrix());
            ps.setInt(3,p.getQuantite());
            ps.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(
                    "SELECT MAX(id) AS MAX_id FROM produit"
            );
            ResultSet rs = ps2.executeQuery();
            if(rs.next()) {
                p.setId(rs.getLong("MAX_id"));
            }
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return p;
    }

    @Override
    public List<Produit> produitsParMC(String mc) throws SQLException {
        List<Produit> produits = new ArrayList<Produit>();
        Connection connection = SingletonConnection.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM produit WHERE designation LIKE ?"
            );
            ps.setString(1,mc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Produit p = new Produit();
                p.setId(rs.getLong("id"));
                p.setDesignation(rs.getString("designation"));
                p.setPrix(rs.getDouble("prix"));
                p.setQuantite(rs.getInt("quantite"));
                produits.add(p);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit getProduit(Long id) {
        return null;
    }

    @Override
    public Produit updateProduit(Produit p) {
        return null;
    }

    @Override
    public void deleteProduit(Long id) {

    }


}
