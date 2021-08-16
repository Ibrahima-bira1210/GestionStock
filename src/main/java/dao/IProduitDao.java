package dao;

import metier.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface IProduitDao {
    public Produit saveProduit(Produit p) throws SQLException;
    public List<Produit> produitsParMC(String mc) throws SQLException;
    public Produit getProduit(Long id);
    public Produit updateProduit(Produit p);
    public void deleteProduit(Long id);
}
