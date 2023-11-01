/**
 *
 * @author user
 */
public class PenerimaDonasi {
    private String nama;
    private String password;
    private String alamat;

    public PenerimaDonasi(String nama, String password, String alamat) {
        this.nama = nama;
        this.password = password;
        this.alamat = alamat;
    }

    public String getPassword() {
        return password;
    }

    void terimaDonasi(Donasi donasi) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}