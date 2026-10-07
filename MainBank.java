public class MainBank {
    public static void main(String[] args) {
        System.out.println("--- SISTEM REKENING BANK ---");

        // Membuat 2 objek rekening
        RekeningBank akun1 = new RekeningBank("R001", "Budi", 1500000);
        RekeningBank akun2 = new RekeningBank("R002", "Siti", 300000);

        // Menampilkan info awal
        System.out.println("\n[Kondisi Awal]");
        akun1.tampilkanInfo();
        akun2.tampilkanInfo();

        // Melakukan transfer dari rekening 1 ke rekening 2 (Berhasil)
        System.out.println("\n[Skenario 1: Transfer Normal]");
        akun1.transfer(500000, akun2);

        // Mencoba transfer melebihi saldo (Validasi error enkapsulasi)
        System.out.println("\n[Skenario 2: Transfer Melebihi Saldo]");
        akun2.transfer(5000000, akun1); // Siti mencoba transfer 5 juta padahal saldo tidak cukup

        // Mencetak saldo akhir kedua rekening
        System.out.println("\n[Saldo Akhir]");
        akun1.tampilkanInfo();
        akun2.tampilkanInfo();

        // Mengakses Static Variable totalRekening
        System.out.println("\nTotal Rekening Terdaftar di Bank: " + RekeningBank.totalRekening);
    }
}