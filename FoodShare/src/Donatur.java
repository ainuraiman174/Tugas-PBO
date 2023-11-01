import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
public class Donatur {
    private String nama;
    private String password;
    private String alamat;
    Map<String, Donasi> daftarDonasi;

    public Donatur(String nama, String password, String alamat) {
        this.nama = nama;
        this.password = password;
        this.alamat = alamat;
        this.daftarDonasi = new HashMap<>();
    }

    public void submitDonasi(Donasi donasi) {
        daftarDonasi.put(donasi.getNama(), donasi);
        System.out.println("Donasi berhasil disubmit!");
    }

    public String getPassword() {
        return password;
    }
}