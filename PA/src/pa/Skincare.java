package pa;

public class Skincare extends Kosmetik{
    private String idSkincare;
    private String tipe;
    private String jenisKulit;

    public Skincare(String id, String nama, String merk, int harga, int kuantitas, String sertifikasi,String tipe, String jenisKulit) {
        super(nama, merk, harga, kuantitas, sertifikasi);
        this.idSkincare = id;
        this.tipe = tipe;
        this.jenisKulit = jenisKulit;
    }
    
    public String getIdSkincare() {
        return idSkincare + "XSXC";
    }

    public void setIdSkincare(String idSkincare) {
        this.idSkincare = idSkincare;
    }
    
    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getJenisKulit() {
        return jenisKulit;
    }

    public void setJenisKulit(String jenisKulit) {
        this.jenisKulit = jenisKulit;
    }

   //override
   @Override
   public void displayInfo(){
       System.out.println("----------------------------------------------------------------");
       System.out.println(" ID               : " + this.idSkincare);
       super.displayInfo();
       System.out.println(" Tipe Skincare    : " + this.tipe);
       System.out.println(" Jenis Kulit      : " + this.jenisKulit);
       System.out.println("----------------------------------------------------------------");
   }

   //overload
   public void displayInfo(boolean lihat){
       if(lihat) displayInfo();
       else super.displayInfo();
   }

   @Override
   public void createDone(String nama){
    System.out.println("----------------------------------------------------------------");
    System.out.println(" Data Skin Care "+ nama + " Ditambahkan");
   }
}
