
import dao.DonaturDAO;
import model.Donatur;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author user
 */
public class FoodShareMaven {

    public static void main(String[] args) {
        Donatur donatur1 = new Donatur("udin", "34567");
        DonaturDAO.registerDonatur(donatur1);
    }
}
