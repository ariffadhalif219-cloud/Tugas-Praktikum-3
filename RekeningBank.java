public class RekeningBank {
    // 01 Atribut wajib private
    private String noRekening;
    private String namaPemilik;
    private double saldo;

    // 02 Static Variable untuk menghitung total rekening
    public static int totalRekening = 0;

    // 03 Constructor + Validasi Saldo Minimal Rp 50.000
    public RekeningBank(String noRekening, String namaPemilik, double saldoAwal) {
        this.noRekening = noRekening;
        this.namaPemilik = namaPemilik;
        
        // Validasi saldo awal minimal 50.000
        if (saldoAwal >= 50000) {
            this.saldo = saldoAwal;
        } else {
            System.out.println("ERROR: Saldo awal untuk " + namaPemilik + " minimal Rp 50.000! Diset ke 0.");
            this.saldo = 0;
        }
        
        // Setiap objek berhasil/dibuat, total rekening bertambah
        totalRekening++;
    }

    // 04 Getter & Setter
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldoBaru) {
        if (saldoBaru >= 0) {
            this.saldo = saldoBaru;
        } else {
            System.out.println("ERROR: Saldo tidak boleh negatif!");
        }
    }

    public String getNamaPemilik() {
        return this.namaPemilik;
    }

    // Method Bisnis: Setor Tunai
    public void setor(double nominal) {
        if (nominal > 0) {
            this.saldo += nominal;
            System.out.println(this.namaPemilik + " berhasil setor Rp " + nominal);
        }
    }

    // Method Bisnis: Tarik Tunai
    public void tarik(double nominal) {
        if (nominal > 0 && nominal <= this.saldo) {
            this.saldo -= nominal;
            System.out.println(this.namaPemilik + " berhasil tarik Rp " + nominal);
        } else {
            System.out.println("ERROR: Penarikan gagal (saldo tidak cukup atau nominal salah).");
        }
    }

    // Method Bisnis: Transfer antar rekening
    public void transfer(double nominal, RekeningBank rekeningTujuan) {
        if (nominal > 0 && nominal <= this.saldo) {
            this.saldo -= nominal; // Saldo pengirim berkurang
            rekeningTujuan.saldo += nominal; // Saldo penerima bertambah
            System.out.println("Transfer Rp " + nominal + " dari " + this.namaPemilik + " ke " + rekeningTujuan.getNamaPemilik() + " BERHASIL.");
        } else {
            System.out.println("ERROR: Transfer gagal! Saldo " + this.namaPemilik + " tidak mencukupi untuk transfer Rp " + nominal);
        }
    }

    // Method untuk menampilkan info rekening
    public void tampilkanInfo() {
        System.out.println("No Rek: " + this.noRekening + " | Pemilik: " + this.namaPemilik + " | Saldo: Rp " + this.saldo);
    }
}