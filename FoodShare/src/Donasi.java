/**
 *
 * @author user
 */
public class Donasi {
    private String nama;
    private Donatur pembuatCampaign;
    private String tanggal;
    private int target;

    public Donasi(String nama, Donatur pembuatCampaign, String tanggal, int target) {
        this.nama = nama;
        this.pembuatCampaign = pembuatCampaign;
        this.tanggal = tanggal;
        this.target = target;
    }
    
    public String getNama() {
        return nama;
    }

        public int getTarget() {
        return target;
    }

    public String getTanggal() {
        return tanggal;
    }

    public Donatur getPembuatCampaign() {
        return pembuatCampaign;
    }
}