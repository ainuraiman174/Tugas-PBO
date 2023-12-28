/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Donasi;

public class DonasiDAO extends BaseDAO {

    public void saveDonasi(Donasi donasi) { 
        
        try (Connection con = getCon();
             PreparedStatement st = con.prepareStatement(
                     "INSERT INTO donasi (namaJudul, jenisMakanan, jumlahDonasi, deadline, namaDonatur, tanggal, id_donasi, id_donatur, id_campaign) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            st.setString(1, donasi.getnamaJudul());
            st.setString(2, donasi.getjenisMakanan());
            st.setInt(3, donasi.getjumlahDonasi());
            st.setDate(4, new java.sql.Date(donasi.getDeadline().getTime()));
            st.setString(5, donasi.getnamaDonatur());
            st.setDate(6, new java.sql.Date(donasi.getTanggal().getTime()));
            st.setInt(7, donasi.getDonaturgetId()); 
            st.setInt(8, donasi.getCampaign().getId()); 
            st.executeUpdate();
        } catch (SQLException e) {
      
        }
    }

    public static void updateDonasi(Donasi donasi) {
        String query = "UPDATE donasi SET namaJudul=?, jenisMakanan=?, jumlahDonasi=?, deadline=?, namaDonatur=?, tanggal=?, id_donatur=?, id_campaign=? WHERE id=?";
        try {
            con = getCon();
            st = con.prepareStatement(query);
            st.setString(1, donasi.getNamaJudul());
            st.setString(2, donasi.getJenisMakanan());
            st.setInt(3, donasi.getJumlahDonasi());
            st.setDate(4, new java.sql.Date(donasi.getDeadline().getTime()));
            st.setString(5, donasi.getNamaDonatur());
            st.setDate(6, new java.sql.Date(donasi.getTanggal().getTime()));
            st.setInt(7, donasi.getDonatur().getId());
            st.setInt(8, donasi.getCampaign().getId());
            st.setInt(9, donasi.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM donasi WHERE id=?";
        try {
            con = getCon();
            st = con.prepareStatement(query);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }

    public static List<Donasi> getAllDonasi() {
        List<Donasi> donasiList = new ArrayList<>();
        String query = "SELECT * FROM donasi";
        try {
            con = getCon();
            st = con.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namaJudul = resultSet.getString("namaJudul");
                String jenisMakanan = resultSet.getString("jenisMakanan");
                int jumlahDonasi = resultSet.getInt("jumlahDonasi");
                java.sql.Date deadline = resultSet.getDate("deadline");
                String namaDonatur = resultSet.getString("namaDonatur");
                java.sql.Date tanggal = resultSet.getDate("tanggal");

                Donasi donasi = new Donasi(id, namaJudul, jenisMakanan, jumlahDonasi, deadline, namaDonatur, tanggal);
                donasiList.add(donasi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }

        return donasiList;
    }
}
