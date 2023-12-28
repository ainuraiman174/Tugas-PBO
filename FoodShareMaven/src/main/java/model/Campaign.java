package model;


import java.util.Date;

public class Campaign {
    private String nama;
    private String JenisMakanan;
    private Date deadline;
    private Organisasi pemilik; // Foreign key dari class Organisasi
    private int id_campaign;

    public int getId_campaign() {
        return id_campaign;
    }

    public void setId_campaign(int id_campaign) {
        this.id_campaign = id_campaign;
    }
    

    // Constructor
    public Campaign(String nama, String JenisMakanan, Date deadline, Organisasi pemilik) {
        this.nama = nama;
        this.JenisMakanan = JenisMakanan;
        this.deadline = deadline;
        this.pemilik = pemilik;
    }

    // Getter

    public String getNama() {
        return nama;
    }

    public String getJenisMakanan() {
    return JenisMakanan;
    }
    public Date getDeadline() {
        return deadline;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisMakanan(String jenisMakanan) {
    this.JenisMakanan = jenisMakanan;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Organisasi getPemilik() {
        return pemilik;
    }

    public void setPemilik(Organisasi pemilik) {
        this.pemilik = pemilik;
    }    
}