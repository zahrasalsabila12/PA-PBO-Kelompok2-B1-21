package pa;

public abstract class Kosmetik {
    protected String nama;
    protected String merk;
    protected int harga;
    protected int kuantitas;
    protected String certifiedBPOM; 

    Kosmetik(String namaKosmetik, String merkKosmetik, int hargaKosmetik, int kuantitasKosmetik, String sertiBPOM) {
        this.nama = namaKosmetik;
        this.merk = merkKosmetik;
        this.certifiedBPOM = sertiBPOM;
        this.harga = hargaKosmetik;
        this.kuantitas = kuantitasKosmetik;
    }

    //setter & getter nama
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    //setter & getter merk
    public String getMerk() {
        return merk;
    }
    public void setMerk(String merk) {
        this.merk = merk;
    }
    //setter & getter harga
    public int getHarga() {
        return harga;
    }
    public void setHarga(int harga) {
        this.harga = harga;
    }
    //setter & getter kuantitas
    public int getKuantitas() {
        return kuantitas;
    }
    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }
    //getter sertifikasiBPOM
    public String getCertifiedBPOM() {
        return certifiedBPOM;
    }

    //Override
    public void displayInfo(){
        System.out.println("================================================================");
        System.out.println(" Nama             : " + this.nama);
        System.out.println(" Merk             : " + this.merk);
        System.out.println(" Sertifikasi BPOM : " + this.certifiedBPOM);
        System.out.println(" Harga            : " + this.harga);
        System.out.println(" Kuantitas        : " + this.kuantitas);
        System.out.println("----------------------------------------------------------------");
    }

    public abstract void createDone(String nama);
}

