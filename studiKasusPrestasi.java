import java.util.Scanner;

class Prestasi {
    String namaMHS;
    int nimMHS;
    String jenisPrestasiMHS;
    String tingkatPrestasiMHS;
    int tahunPrestasiMHS;

    public Prestasi(String nama, int nim, String jenis, String tingkat, int tahun) {
        namaMHS = nama;
        nimMHS = nim;
        jenisPrestasiMHS = jenis;
        tingkatPrestasiMHS = tingkat;
        tahunPrestasiMHS = tahun;
    }

    public void display() {
        System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %d\n",
                namaMHS, nimMHS, jenisPrestasiMHS, tingkatPrestasiMHS, tahunPrestasiMHS);
    }
}

public class studiKasusPrestasi {
    static Prestasi[] prestasiArray = new Prestasi[100]; // Kapasitas maksimum 100 data
    static int jmlPrestasi = 0; // Untuk melacak jumlah data yang tersimpan
    static Scanner scanner = new Scanner(System.in);

    public static void tambahPrestasi() {
        if (jmlPrestasi >= prestasiArray.length) {
            System.out.println("Data penuh. Tidak dapat menambahkan prestasi baru.");
            return;
        }

        System.out.println("\n=== TAMBAH DATA PRESTASI ===");
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        int nim = scanner.nextInt();
        scanner.nextLine();  // Membersihkan buffer
        System.out.print("Masukkan Jenis Prestasi (misal: Juara 1, Juara Harapan, dll): ");
        String jenis = scanner.nextLine();
        
        System.out.print("Masukkan Tingkat Prestasi (Lokal, Nasional, Internasional): ");
        String tingkat = scanner.nextLine();

        if (tingkat.equalsIgnoreCase("Lokal") || 
            tingkat.equalsIgnoreCase("Nasional") || 
            tingkat.equalsIgnoreCase("Internasional")) {
            // Input valid
        } else {
            System.out.println("Tingkat prestasi tidak valid. Hanya menerima: Lokal, Nasional, atau Internasional.");
            return;
        }

        System.out.print("Masukkan Tahun Prestasi (2010 - 2024): ");
        int tahun = scanner.nextInt();
        scanner.nextLine();  // Membersihkan buffer
        if (tahun < 2010 || tahun > 2024) {
            System.out.println("Tahun prestasi tidak valid. Harus antara 2010 dan 2024.");
            return; //kembali ke menu
        }

        // Tambahkan data ke array
        prestasiArray[jmlPrestasi] = new Prestasi(nama, nim, jenis, tingkat, tahun);
        jmlPrestasi++;
        System.out.println("Prestasi berhasil ditambahkan!\n");
    }

    public static void tampilkanPrestasi() {
        System.out.println("\n=== TAMPILKAN SEMUA PRESTASI ===");
        if (jmlPrestasi == 0) {
            System.out.println("Belum ada data prestasi.\n");
            return;
        }

        for (int i = 0; i < jmlPrestasi; i++) {
            prestasiArray[i].display();
        }
        System.out.println();
    }

    public static void analisisPrestasi() {
        System.out.println("\n=== ANALISIS PRESTASI ===");
        System.out.print("Masukkan Jenis Prestasi yang ingin dianalisis: ");
        String jenisCari = scanner.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < jmlPrestasi; i++) {
            if (prestasiArray[i].jenisPrestasiMHS.equalsIgnoreCase(jenisCari)) {
                prestasiArray[i].display();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada prestasi dengan jenis '" + jenisCari + "'.\n");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
            System.out.println("1. Tambah Data Prestasi");
            System.out.println("2. Tampilkan Semua Prestasi");
            System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahPrestasi();
                    break;
                case 2:
                    tampilkanPrestasi();
                    break;
                case 3:
                    analisisPrestasi();
                    break;
                case 4:
                    System.out.println("\nProgram selesai. Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.\n");
            }
        }
    }
}
