/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa;

/**
 *
 * @author Mohammad Fhadil
 */
public class KeranjangMU extends Kosmetik{
        private String idMakeup;
    private String jenis;
    private String shade;

    public KeranjangMU(String idMakeup, String jenis, String shade, String namaKosmetik, String merkKosmetik, int hargaKosmetik, int kuantitasKosmetik, String sertiBPOM) {
        super(namaKosmetik, merkKosmetik, hargaKosmetik, kuantitasKosmetik, sertiBPOM);
        this.idMakeup = idMakeup;
        this.jenis = jenis;
        this.shade = shade;
    }

    

    public String getIdMakeup() {
        return idMakeup + "XMXU";
    }

    public void setIdMakeup(String idMakeup) {
        this.idMakeup = idMakeup;
    }

    public String getJenis() {
        return jenis;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getShade() {
        return shade;
    }

    public void setShade(String shade) {
        this.shade = shade;
    }

    @Override
    public void displayInfo(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" ID               : " + this.idMakeup);
        super.displayInfo();
        System.out.println(" Jenis Make Up    : " + this.jenis);
        System.out.println(" Shade            : " + this.shade);
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
        System.out.println(" Data Make Up "+ nama + " Ditambahkan");
       }
}
