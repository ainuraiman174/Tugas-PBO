
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author administrator
 */
public class FoodShare {
    /**
     * @param args the command line arguments
     */
    private static Map<String, Donatur> donaturDatabase = new HashMap<>();
    private static Map<String, PenerimaDonasi> penerimaDonasiDatabase = new HashMap<>();
    private static Map<String, Organisasi> organisasiDatabase = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String args[]) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Food Share - Selamat datang!");
            System.out.println("1. Registrasi Donatur");
            System.out.println("2. Registrasi Penerima Donasi");
            System.out.println("3. Login Donatur");
            System.out.println("4. Login Penerima Donasi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    registerDonatur();
                    break;
                case 2:
                    registerPenerimaDonasi();
                    break;
                case 3:
                    loginDonatur();
                    break;
                case 4:
                    loginPenerimaDonasi();
                    break;
                case 5:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan Food Share. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        } 
    }
    
    
    private static void registerPenerimaDonasi() {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();

        PenerimaDonasi penerimaDonasi = new PenerimaDonasi(nama, password, alamat);
        penerimaDonasiDatabase.put(nama, penerimaDonasi);

        System.out.println("Registrasi Penerima Donasi berhasil!");
    }
     
    private static void loginDonatur() {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        Donatur donatur = donaturDatabase.get(nama);
        if (donatur != null && donatur.getPassword().equals(password)) {            
            System.out.println("Login Donatur berhasil!");
            menuDonatur(donatur);
            // Implementasi menu Donatur di sini
        } else {
            System.out.println("Login gagal. Nama atau password salah.");
        }
    }
    
    private static void loginPenerimaDonasi() {
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        PenerimaDonasi penerimaDonasi = penerimaDonasiDatabase.get(nama);
        if (penerimaDonasi != null && penerimaDonasi.getPassword().equals(password)) {
            System.out.println("Login Penerima Donasi berhasil!");
            // Implementasi menu Penerima Donasi di sini
        } else {
            System.out.println("Login gagal. Nama atau password salah.");
        }
    }
    
    private static String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine().trim();
    }
    
    private static void registerDonatur() {
        System.out.print("\n");
        String nama = getInput("Masukkan nama");
        String password = getInput("Masukkan password");
        String alamat = getInput("Masukkan alamat");

        if (nama.isEmpty() || password.isEmpty() || alamat.isEmpty()) {
            System.out.println("Error: Nama, password, dan alamat tidak boleh kosong.");
            return;
        }

        if (donaturDatabase.containsKey(nama)) {
            System.out.println("Error: Nama sudah digunakan. Silakan pilih nama lain.");
        } else {
            Donatur donatur = new Donatur(nama, password, alamat);
            donaturDatabase.put(nama, donatur);
            System.out.println("Registrasi Donatur berhasil!\n");
            
        }
    }
    
    private static void menuDonatur(Donatur donatur) {
        boolean isDonaturLoggedIn = true;
        while (isDonaturLoggedIn) {
            System.out.println("\nMenu Donatur");
            System.out.println("1. Submit Donasi");
            System.out.println("2. Lihat Donasi Saya");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    submitDonasi(donatur);
                    break;
                case 2:
                    lihatDonasi(donatur);
                    break;
                case 3:
                    isDonaturLoggedIn = false;
                    System.out.println("Logout berhasil!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        }
    }
    
    private static void submitDonasi(Donatur donatur) {
        System.out.print("Masukkan nama donasi: ");
        String namaDonasi = scanner.nextLine();
        System.out.print("Masukkan tanggal donasi: ");
        String tanggalDonasi = scanner.nextLine();
        System.out.print("Masukkan target donasi: ");
        int targetDonasi = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Donasi donasi = new Donasi(namaDonasi, donatur, tanggalDonasi, targetDonasi);
        donatur.submitDonasi(donasi);
    }
    
    private static void lihatDonasi(Donatur donatur) {
        System.out.println("\nDaftar Donasi Saya:");
        for (Donasi donasi : donatur.daftarDonasi.values()) {
            System.out.println("Nama Donasi: " + donasi.getNama());
            System.out.println("Tanggal: " + donasi.getTanggal());
            System.out.println("Target: " + donasi.getTarget());
            System.out.println("-------------------------");
        }
    }
}