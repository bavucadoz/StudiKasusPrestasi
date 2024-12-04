import java.util.Scanner;

public class studiKasusPrestasi {
    static String[][] prestasiArray = new String[100][5]; // Array 2D dengan kapasitas maksimum 100 data (5 kolom)
    static int jmlPrestasi = 0; // Untuk melacak jumlah data yang tersimpan
    static Scanner scanner = new Scanner(System.in);

    public static void tambahPrestasi() {
        if (jmlPrestasi >= prestasiArray.length) {
            System.out.println("Data penuh. Tidak dapat menambahkan prestasi baru.");
            return;
        }

        System.out.println("\n=== TAMBAH DATA PRESTASI ===");
        System.out.print("Masukkan Nama Mahasiswa: ");
        prestasiArray[jmlPrestasi][0] = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        prestasiArray[jmlPrestasi][1] = scanner.nextLine();
        System.out.print("Masukkan Jenis Prestasi (misal: Juara 1, Juara Harapan, dll): ");
        prestasiArray[jmlPrestasi][2] = scanner.nextLine();

        System.out.print("Masukkan Tingkat Prestasi (Lokal, Nasional, Internasional): ");
        String tingkat = scanner.nextLine();
        
        // Nested if untuk validasi tingkat prestasi
        if (tingkat.equalsIgnoreCase("Lokal") || tingkat.equalsIgnoreCase("Nasional") || tingkat.equalsIgnoreCase("Internasional")) {
            prestasiArray[jmlPrestasi][3] = tingkat;

            System.out.print("Masukkan Tahun Prestasi (2010 - 2024): ");
            int tahun = scanner.nextInt();
            scanner.nextLine();  // Membersihkan buffer
            
            // Nested if dalam validasi tahun
            if (tahun >= 2010 && tahun <= 2024) {
                prestasiArray[jmlPrestasi][4] = String.valueOf(tahun);
                jmlPrestasi++;
                System.out.println("Prestasi berhasil ditambahkan!\n");
            } else {
                System.out.println("Tahun prestasi tidak valid. Harus antara 2010 dan 2024.");
            }
        } else {
            System.out.println("Tingkat prestasi tidak valid. Hanya menerima: Lokal, Nasional, atau Internasional.");
        }
    }

    public static void tampilkanPrestasi() {
        System.out.println("\n=== TAMPILKAN SEMUA PRESTASI ===");
        if (jmlPrestasi == 0) {
            System.out.println("Belum ada data prestasi.\n");
        } else {
            for (int i = 0; i < jmlPrestasi; i++) {
                System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %s\n",
                    prestasiArray[i][0], prestasiArray[i][1], prestasiArray[i][2], prestasiArray[i][3], prestasiArray[i][4]);
            }
            System.out.println();
        }
    }

    public static void analisisPrestasi() {
        System.out.println("\n=== ANALISIS PRESTASI ===");
        System.out.print("Masukkan Jenis Prestasi yang ingin dianalisis: ");
        String jenisCari = scanner.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < jmlPrestasi; i++) {
            if (prestasiArray[i][2].equalsIgnoreCase(jenisCari)) {
                System.out.printf("Nama: %s | NIM: %s | Jenis: %s | Tingkat: %s | Tahun: %s\n",
                    prestasiArray[i][0], prestasiArray[i][1], prestasiArray[i][2], prestasiArray[i][3], prestasiArray[i][4]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada prestasi dengan jenis '" + jenisCari + "'.\n");
        }
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

            // Nested if dalam kontrol menu
            if (pilihan >= 1 && pilihan <= 4) {
                if (pilihan == 1) {
                    tambahPrestasi();
                } else if (pilihan == 2) {
                    tampilkanPrestasi();
                } else if (pilihan == 3) {
                    analisisPrestasi();
                } else if (pilihan == 4) {
                    System.out.println("\nProgram selesai. Terima kasih!");
                    return;
                }
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.\n");
            }
        }
    }
}
