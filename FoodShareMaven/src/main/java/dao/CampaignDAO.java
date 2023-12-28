/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Campaign;
import model.Organisasi;

/**
 *
 * @author Administrator
 */
public class CampaignDAO extends BaseDAO {
    private static PreparedStatement st;
    private static Connection con;
    
    public static void saveCampaign(Campaign campaign){
        try {
            con = getCon();
            String query = "insert into campaign (namaJudul, jenisMakanan,jumlahDonasi, dealine, namaDonatur, tanggal, id_organisasi)"
                    + " values ('%s', '%s', %d, ?, '%s', ?, %d)";
           query = String.format(query,
        campaign.getnamaJudul(),
        campaign.getjenisMakanan(),
        campaign.getjumlahDonasi(),
        campaign.getDeadline(),
        campaign.getnamaDonatur(),
        campaign.gettanggal(),
        campaign.getid_Campaign());
            st = con.prepareStatement(query);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }
    public static void updateCampaign(Campaign campaign) {
        String query = "UPDATE donasi SET namaJudul=?, jenisMakanan=?, jumlahDonasi=?, deadline=?, namaDonatur=?, tanggal=?, id_organisasi=?, WHERE id=?";
        try {
            con = getCon();
            st = con.prepareStatement(query);
            st.setString(1, campaign.getNamaJudul());
            st.setString(2, campaign.getJenisMakanan());
            st.setInt(3, campaign.getJumlahDonasi());
            st.setDate(4, new java.sql.Date(donasi.getDeadline().getTime()));
            st.setString(5, camapign.getNamaDonatur());
            st.setDate(6, new java.sql.Date(donasi.getTanggal().getTime()));
            st.setInt(7, organiasi.getOrganisasi().getId());
            st.setInt(8, campaign.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM campaign WHERE id=?";
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

    public static List<Campaign> getAllCampaign() {
        List<Campaign> campaignList = new ArrayList<>();
        String query = "SELECT * FROM campaign";
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

                Campaign campaign = new Campaign(id, namaJudul, jenisMakanan, jumlahDonasi, deadline, namaDonatur, tanggal);
                campaignList.add(campaign);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeCon(con);
        }

        return campaignList;
    }
    
}