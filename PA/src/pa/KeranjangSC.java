/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa;

/**
 *
 * @author Mohammad Fhadil
 */
public class KeranjangSC extends Kosmetik{
    private String idSkincare;
    private String tipe;
    private String jenisKulit;

    public KeranjangSC(String idSkincare, String tipe, String jenisKulit, String namaKosmetik, String merkKosmetik, int hargaKosmetik, int kuantitasKosmetik, String sertiBPOM) {
        super(namaKosmetik, merkKosmetik, hargaKosmetik, kuantitasKosmetik, sertiBPOM);
        this.idSkincare = idSkincare;
        this.tipe = tipe;
        this.jenisKulit = jenisKulit;
    }



    public String getIdSkincare() {
        return idSkincare;
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
        System.out.println(" Data Skincare "+ nama + " Ditambahkan");
       }
}
