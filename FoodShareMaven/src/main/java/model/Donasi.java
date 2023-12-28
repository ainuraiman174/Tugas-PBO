package model;

import java.util.Date;

public class Donasi {
    private Campaign namaJudul;
    private String jenisMakanan;
    private int jumlahDonasi;
    private Date deadline;
    private Donatur namaDonatur;
    private Date tanggal;

    public Donasi(Campaign namaJudul, String jenisMakanan, int jumlahDonasi, Date deadline, Donatur namaDonatur, Date tanggal) {
        this.namaJudul = namaJudul;
        this.jenisMakanan = jenisMakanan;
        this.jumlahDonasi = jumlahDonasi;
        this.deadline = deadline;
        this.namaDonatur = namaDonatur;
        this.tanggal = tanggal;
    }

    public Campaign getNamaJudul() {
        return namaJudul;
    }

    public void setNamaJudul(Campaign namaJudul) {
        this.namaJudul = namaJudul;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    public int getJumlahDonasi() {
        return jumlahDonasi;
    }

    public void setJumlahDonasi(int jumlahDonasi) {
        this.jumlahDonasi = jumlahDonasi;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Donatur getNamaDonatur() {
        return namaDonatur;
    }

    public void setNamaDonatur(Donatur namaDonatur) {
        this.namaDonatur = namaDonatur;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public Object getDonatur() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getjumlahDonasi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getCampaign() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
