
package com.example.discoapp.Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class DAODiscoteca {

    private Connection con = null;

    public static DAODiscoteca instance = null;

    public DAODiscoteca() throws SQLException, ClassNotFoundException {
        con = DBConnection.getConnection();
    }

    public static DAODiscoteca getInstance() throws SQLException, ClassNotFoundException {
        if (instance == null)
            instance = new DAODiscoteca();
        return instance;
    }

    public void insert(Discoteca n) throws SQLException {
        PreparedStatement ps = con
                .prepareStatement("INSERT INTO Discoteca (nombre, pid, descripcion, categoria, estado, fechaIni, fechaFin, importancia)" + "VALUES" + "(?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, n.getNombre());
        ps.setInt(2, n.getPid());
        ps.setString(3, n.getDescripcion());
        ps.setInt(4, n.getCategoria());
        ps.setInt(5, n.getEstado());
        ps.setString(6, n.getFechaIni().toString());
        ps.setString(7, n.getFechaFin().toString());
        ps.setInt(8, n.getImportancia());
        ps.executeUpdate();
        ps.close();
    }

    public void update(Discoteca n) throws SQLException {
        String sql="";
        sql="UPDATE Discoteca ";
        PreparedStatement ps = con
                .prepareStatement("UPDATE Discoteca SET nombre= ?, pid= ?, descripcion= ?, categoria=?, estado=?, fechaIni=?, fechaFin=?, importancia=? WHERE id=?");
        ps.setString(1, n.getNombre());
        ps.setInt(2, n.getPid());
        ps.setString(3, n.getDescripcion());
        ps.setInt(4, n.getCategoria());
        ps.setInt(5, n.getEstado());
        ps.setString(6, n.getFechaIni().toString());
        ps.setString(7, n.getFechaFin().toString());
        ps.setInt(8, n.getImportancia());
        ps.setInt(9, n.getId());
        ps.executeUpdate();
        ps.close();
    }

    public ArrayList<Discoteca> listaDiscotecas() throws SQLException {
        PreparedStatement psa = con.prepareStatement("SELECT * FROM Discoteca");
        ResultSet rs = psa.executeQuery();

        ArrayList<Discoteca> result = new ArrayList<Discoteca>();

        while (rs.next()) {
            Discoteca t = new Discoteca(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                    rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getInt(9));
            result.add(t);
        }
        rs.close();
        psa.close();
        return result;
    }

    public void delete(int id) throws SQLException{
        PreparedStatement psa = con.prepareStatement("DELETE FROM Discoteca WHERE id=?");
        psa.setInt(1, id);
        psa.executeUpdate();
        psa.close();
    }
}
