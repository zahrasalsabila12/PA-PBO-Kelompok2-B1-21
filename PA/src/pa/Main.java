package pa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static ArrayList<Skincare> data1 = new ArrayList<>();
    static ArrayList<Makeup> data2 = new ArrayList<>();
    static ArrayList<KeranjangSC> keranjangSC = new ArrayList<>();
    static ArrayList<KeranjangMU> keranjangMU = new ArrayList<>();

    static BufferedReader baca = new BufferedReader(new InputStreamReader(System.in));
    

    //menambahkan data
    static void createData() throws IOException{
        Detail info = new Detail();
        System.out.println("""
================================================================
                         Tambah Data
================================================================
 1. Skin Care
 2. Make Up
================================================================""");
        System.out.print("Pilihan Anda [1/2] : ");
        int tambah = Integer.parseInt(baca.readLine());
        
        if (tambah == 1){ //tambah data skincare
            System.out.println("----------------------------------------------------------------");
            System.out.println("| DATA SKIN CARE                                               |");
            System.out.println("----------------------------------------------------------------");
            System.out.print(" ID                : "); String idSC = baca.readLine();
            System.out.print(" Nama              : "); String namaSC = baca.readLine();
            System.out.print(" Merk              : "); String merkSC = baca.readLine();
            System.out.print(" Tipe              : "); String tipeSC = baca.readLine();
            System.out.print(" Untuk Jenis Kulit : "); String jenkulSC = baca.readLine();
            System.out.print(" Harga             : "); int hargaSC = Integer.parseInt(baca.readLine());
            System.out.print(" Kuantitas         : "); int kuantitasSC = Integer.parseInt(baca.readLine());
            System.out.println("----------------------------------------------------------------");
            System.out.print("Telah tersertifikasi BPOM? [y/t] : "); String serti = baca.readLine();
            if (serti.equals("Y") || serti.equals("y")){
                String sertifikasiSC = info.certifiedDone;
                for(int i = 0; i < data1.size(); i++){
                    data1.get(i).createDone(namaSC);
                }
                info.notifySuccessCreate();
                Skincare newDataSC = new Skincare(idSC, namaSC, merkSC, hargaSC, kuantitasSC, sertifikasiSC, tipeSC, jenkulSC);
                data1.add(newDataSC);
            }else if (serti.equals("T")||serti.equals("t")){
                String sertifikasiSC = info.noCertified;
                for(int i = 0; i < data1.size(); i++){
                    data1.get(i).createDone(namaSC);
                }
                info.notifySuccessCreate();
                Skincare newDataSC = new Skincare(idSC, namaSC, merkSC, hargaSC, kuantitasSC, sertifikasiSC, tipeSC, jenkulSC);
                data1.add(newDataSC);
            }else{
                info.failChoose();
            }
        }else if (tambah == 2) { //tambah data make up
            System.out.println("----------------------------------------------------------------");
            System.out.println("| DATA MAKE UP                                                 |");
            System.out.println("----------------------------------------------------------------");
            System.out.print(" ID        : "); String idMU = baca.readLine();
            System.out.print(" Nama      : "); String namaMU = baca.readLine();
            System.out.print(" Merk      : "); String merkMU = baca.readLine();
            System.out.print(" Jenis     : "); String jenisMU = baca.readLine();
            System.out.print(" Shade     : "); String shadeMU = baca.readLine();
            System.out.print(" Harga     : "); int hargaMU = Integer.parseInt(baca.readLine());
            System.out.print(" Kuantitas : "); int kuantitasMU = Integer.parseInt(baca.readLine());
            System.out.println("----------------------------------------------------------------");
            System.out.print("Telah tersertifikasi BPOM? [y/t] : "); String serti = baca.readLine();
            if (serti.equals("Y") || serti.equals("y")){
                for(int i = 0; i < data2.size(); i++){
                    data2.get(i).createDone(namaMU);
                }
                info.notifySuccessCreate();
                String sertifikasiMU = info.certifiedDone;
                Makeup newDataMU = new Makeup(idMU, namaMU, merkMU, hargaMU, kuantitasMU, sertifikasiMU,jenisMU, shadeMU);
                data2.add(newDataMU);
            }else if (serti.equals("T")||serti.equals("t")){
                String sertifikasiMU = info.noCertified;
                for(int i = 0; i < data2.size(); i++){
                    data2.get(i).createDone(namaMU);
                }
                info.notifySuccessCreate();
                Makeup newDataMU = new Makeup(idMU, namaMU, merkMU, hargaMU, kuantitasMU, sertifikasiMU,jenisMU, shadeMU);
                data2.add(newDataMU);
            }else{
                info.failChoose();
            } 
        }else{
            info.notifyFailCreate();
        }
    }

    //Read Data
    static void readData() throws IOException{
        Detail info = new Detail();
        System.out.println("""
================================================================
                         Lihat Data
================================================================
 1. Skin Care
 2. Make Up
================================================================""");
        System.out.print("Pilihan Anda [1/2] : ");
        int lihat = Integer.parseInt(baca.readLine());

        if(lihat == 1){
            if(data1.isEmpty()){
                System.out.println("----------------------------------------------------------------");
                System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Terlebih Dahulu");
            }else{ //lihat data skincare
                System.out.println("----------------------------------------------------------------");
                System.out.println("                        DATA SKIN CARE");
                System.out.println("----------------------------------------------------------------");
                System.out.print(" Ingin Melihat Data Secara Lengkap? [y/t] : ");
                String pilih = baca.readLine();
                System.out.println("----------------------------------------------------------------");
                for(int i = 0; i < data1.size(); i++){
                    if (pilih.equals("Y") || pilih.equals("y")){
                        System.out.println(" Data Ke-" + (i+1));
                        data1.get(i).displayInfo();
                    }else{
                        System.out.println(" Data Ke-" + (i+1));
                        data1.get(i).displayInfo(false);
                    }
                }
            }
        }else if(lihat == 2){
            if(data2.isEmpty()){
                System.out.println("----------------------------------------------------------------");
                System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Terlebih Dahulu");
            }else{ //lihat data make up
                System.out.println("----------------------------------------------------------------");
                System.out.println("                         DATA MAKE UP");
                System.out.println("----------------------------------------------------------------");
                System.out.print(" Ingin Melihat Data Secara Lengkap? [y/t] : ");
                String pilih1 = baca.readLine();
                System.out.println("----------------------------------------------------------------");
                for(int i = 0; i < data2.size(); i++){
                    if (pilih1.equals("Y") || pilih1.equals("y")){
                        System.out.println(" Data Ke-" + (i+1));
                        data2.get(i).displayInfo();
                    }else{
                        System.out.println(" Data Ke-" + (i+1));
                        data2.get(i).displayInfo(false);
                    }
                }
            }
        }else{
            info.failChoose();
        }
    }

    //mengubah data
    static void  updateData() throws IOException {
        Detail info = new Detail();
        System.out.println("""
================================================================
                        Update Data 
================================================================
 1. Skin Care
 2. Make Up
================================================================""");
        System.out.print("Pilihan Anda [1/2] : ");
        int update = Integer.parseInt(baca.readLine());

        if (update == 1) {
            for(Skincare dataSkincare : data1){
                while(true){
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("Nama Skin Care yang Ingin Diubah : ");
                    String namaSC = baca.readLine();
                    if(dataSkincare.getNama().equals(namaSC)){
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(" Nama Skin Care Terbaru       : "); dataSkincare.setNama(baca.readLine());
                        System.out.print(" Merk Skin Care Terbaru       : "); dataSkincare.setMerk(baca.readLine());
                        System.out.print(" Tipe Skin Care Terbaru       : "); dataSkincare.setTipe(baca.readLine());
                        System.out.print(" Untuk Jenis Kulit Terbaru    : "); dataSkincare.setJenisKulit(baca.readLine());
                        System.out.print(" Harga Skin Care Terbaru      : "); dataSkincare.setHarga(Integer.parseInt(baca.readLine()));
                        System.out.print(" Kuantitas Skin Care  Terbaru : "); dataSkincare.setKuantitas(Integer.parseInt(baca.readLine()));
                        info.notifySuccessUpdate();
                        break;
                    }else{
                        info.notifyFailUpdate();
                        System.out.println("Silahkan melihat data yang ingin diubah terlebih dahulu");
                        readData();
                        break;
                    }
                }
            }
        }else if (update == 2) {
            for(Makeup dataMakeup : data2){
                while(true){
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("Nama Make Up yang Ingin Diubah : ");
                    String namaMU = baca.readLine();
                    if(dataMakeup.getNama().equals(namaMU)){
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(" Nama Make Up Terbaru      : "); dataMakeup.setNama(baca.readLine());;
                        System.out.print(" Merk Make Up Terbaru      : "); dataMakeup.setMerk(baca.readLine()); 
                        System.out.print(" Jenis Make Up Terbaru     : "); dataMakeup.setJenis(baca.readLine());
                        System.out.print(" Shade Make Up Terbaru     : "); dataMakeup.setShade(baca.readLine());
                        System.out.print(" Harga Make Up Terbaru     : "); dataMakeup.setHarga(Integer.parseInt(baca.readLine()));
                        System.out.print(" Kuantitas Make Up Terbaru : "); dataMakeup.setKuantitas(Integer.parseInt(baca.readLine()));
                        System.out.println("----------------------------------------------------------------");
                        info.notifySuccessUpdate();    
                        break;
                    }else{
                        info.notifyFailUpdate();
                        System.out.println("Silahkan melihat data yang ingin diubah terlebih dahulu");
                        readData();
                        break;
                    }
                }
            }
        }else{
            info.failChoose();
        }

    }

    //menghapus data
    static void deleteData() throws IOException{
        Detail info = new Detail();
        System.out.println("""
================================================================
                       Menghapus Data
================================================================
 1. Skin Care
 2. Make Up
 ================================================================""");
        System.out.print("Pilihan Anda [1/2] : ");
        int delete = Integer.parseInt(baca.readLine());
        if (delete == 1){
            System.out.println("----------------------------------------------------------------");
            System.out.print(" Masukkan Nama Skin Care yang Ingin Anda Hapus : ");
            String nmSC = baca.readLine();
            for(int i  = 0; i < data1.size(); i++) {
                if(data1.get(i).getNama().equals(nmSC)){
                    info.notifySuccessDelete();
                    data1.remove(i);
                }else{
                    info.notifyFailDelete();
                    System.out.println(" Silahkan melihat data yang ingin dihapus terlebih dahulu");
                    readData();
                    break;
                }
            }
        }else if  (delete == 2){
            System.out.println("----------------------------------------------------------------");
            System.out.print(" Masukkan Nama Make Up yang Ingin Anda Hapus : "); 
            String nmMU = baca.readLine();
            for(int i  = 0; i < data2.size(); i++) {
                if(data2.get(i).getNama().equals(nmMU)){
                    info.notifySuccessDelete();
                    data2.remove(i);
                }else{
                    info.notifyFailDelete();
                    System.out.println(" Silahkan melihat data yang ingin dihapus terlebih dahulu");
                    readData();
                    break;
                }
            }
        }else{
            info.failChoose();
        }
    }
        static void createDataKeranjang() throws IOException{
    }
    
    static void readDataKeranjang() throws IOException {
        Detail info = new Detail();
        System.out.println("""
        ================================================================
                               Ubah Jumlah Barang
        ================================================================
         1. Skin Care
         2. Make Up
         ================================================================""");
        System.out.print("Pilihan Anda [1/2] : ");
        int jumlah = Integer.parseInt(baca.readLine());
        if (jumlah == 1){
            if(keranjangSC.isEmpty()){
                System.out.println("----------------------------------------------------------------");
                System.out.println(" Tidak Ada Data. Mohon Tambahkan Keranjang Terlebih Dahulu");
            }else{ //lihat data skincare
                System.out.println("----------------------------------------------------------------");
                System.out.println("                        DATA BARANG");
                System.out.println("----------------------------------------------------------------");
                for(int i = 0; i < keranjangSC.size(); i++){
                    System.out.println(" Data Ke-" + (i+1));
                    keranjangSC.get(i).displayInfo();
                }
                System.out.println("----------------------------------------------------------------");

            }
        }
        else if (jumlah == 2){
            if(keranjangMU.isEmpty()){
                System.out.println("----------------------------------------------------------------");
                System.out.println(" Tidak Ada Data. Mohon Tambahkan Keranjang Terlebih Dahulu");
            }else{ //lihat data skincare
                System.out.println("----------------------------------------------------------------");
                System.out.println("                        DATA BARANG");
                System.out.println("----------------------------------------------------------------");
                for(int i = 0; i < keranjangMU.size(); i++){
                    System.out.println(" Data Ke-" + (i+1));
                    keranjangMU.get(i).displayInfo();
                }
                System.out.println("----------------------------------------------------------------");
            }
        }else{
            info.failChoose();
        }
    }
    
        static void  updateDataKeranjang() throws IOException {
        Detail info = new Detail();
        System.out.println("""
        ================================================================
                                Update Data 
        ================================================================
         1. Skin Care
         2. Make Up
        ================================================================""");
        System.out.print("Pilihan Anda [1/2] : ");
        int update = Integer.parseInt(baca.readLine());

        if (update == 1) {
            for(KeranjangSC dataSkincare : keranjangSC){
                while(true){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                        DATA BARANG");
                    System.out.println("----------------------------------------------------------------");
                    for(int i = 0; i < keranjangSC.size(); i++){
                        System.out.println(" Data Ke-" + (i+1));
                        keranjangSC.get(i).displayInfo();
                    }
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("Nama Skin Care yang Ingin Diubah : ");
                    String namaSC = baca.readLine();
                    if(dataSkincare.getNama().equals(namaSC)){
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(" Nama Skin Care        : "); dataSkincare.getNama();
                        System.out.print(" Merk Skin Care        : "); dataSkincare.getMerk();
                        System.out.print(" Tipe Skin Care        : "); dataSkincare.getTipe();
                        System.out.print(" Untuk Jenis Kulit     : "); dataSkincare.getJenisKulit();
                        System.out.print(" Harga Skin Care       : "); dataSkincare.getHarga();
                        System.out.print(" Kuantitas Skin Care  Terbaru : "); dataSkincare.setKuantitas(Integer.parseInt(baca.readLine()));
                        info.notifySuccessUpdate();
                        break;
                    }else{
                        info.notifyFailUpdate();
                        System.out.println("Silahkan melihat data yang ingin diubah terlebih dahulu");
                        readDataKeranjang();
                        break;
                    }
                }
            }
        }else if (update == 2) {
            for(KeranjangMU dataMakeup : keranjangMU){
                while(true){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                        DATA BARANG");
                    System.out.println("----------------------------------------------------------------");
                    for(int i = 0; i < keranjangMU.size(); i++){
                        System.out.println(" Data Ke-" + (i+1));
                        keranjangMU.get(i).displayInfo();
                    }
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("Nama Make Up yang Ingin Diubah : ");
                    String namaMU = baca.readLine();
                    if(dataMakeup.getNama().equals(namaMU)){
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(" Nama Make Up Terbaru      : "); dataMakeup.getNama();
                        System.out.print(" Merk Make Up Terbaru      : "); dataMakeup.getMerk(); 
                        System.out.print(" Jenis Make Up Terbaru     : "); dataMakeup.getJenis();
                        System.out.print(" Shade Make Up Terbaru     : "); dataMakeup.getShade();
                        System.out.print(" Harga Make Up Terbaru     : "); dataMakeup.getHarga();
                        System.out.print(" Kuantitas Make Up Terbaru : "); dataMakeup.setKuantitas(Integer.parseInt(baca.readLine()));
                        System.out.println("----------------------------------------------------------------");
                        info.notifySuccessUpdate();    
                        break;
                    }else{
                        info.notifyFailUpdate();
                        System.out.println("Silahkan melihat data yang ingin diubah terlebih dahulu");
                        readDataKeranjang();
                        break;
                    }
                }
            }
        }else{
            info.failChoose();
        }

    }
    
    static void deleteDataKeranjang() throws IOException{
        Detail info = new Detail();
        System.out.println("""
================================================================
                  Menghapus Data Keranjang
================================================================
 1. Skin Care
 2. Make Up
 ================================================================""");
        System.out.print("Pilihan Anda [1/2] : ");
        int delete = Integer.parseInt(baca.readLine());
        if (delete == 1){
            System.out.println("----------------------------------------------------------------");
            System.out.print(" Masukkan Nama Skin Care yang Ingin Anda Hapus : ");
            String nmSC = baca.readLine();
            for(int i  = 0; i < keranjangSC.size(); i++) {
                if(keranjangSC.get(i).getNama().equals(nmSC)){
                    info.notifySuccessDelete();
                    keranjangSC.remove(i);
                }else{
                    info.notifyFailDelete();
                    System.out.println(" Silahkan melihat data yang ingin dihapus terlebih dahulu");
                    readDataKeranjang();
                    break;
                }
            }
        }else if  (delete == 2){
            System.out.println("----------------------------------------------------------------");
            System.out.print(" Masukkan Nama Make Up yang Ingin Anda Hapus : "); 
            String nmMU = baca.readLine();
            for(int i  = 0; i < keranjangMU.size(); i++) {
                if(keranjangMU.get(i).getNama().equals(nmMU)){
                    info.notifySuccessDelete();
                    keranjangMU.remove(i);
                }else{
                    info.notifyFailDelete();
                    System.out.println(" Silahkan melihat data yang ingin dihapus terlebih dahulu");
                    readDataKeranjang();
                    break;
                }
            }
        }else{
            info.failChoose();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String username, password;

    while(true){
        System.out.println("""
****************************************************************
                           Beauty Shop
****************************************************************
                        Welcome Login Page 
================================================================""");
    System.out.print("Masukkan username: ");
    username = input.nextLine();
    System.out.println("================================================================");
    System.out.print("Masukkan password: ");
    password = input.nextLine();
        
    if (username.equals("admin") && password.equals("admin123")) {
        System.out.println("================================================================");
        System.out.println("              ANDA BERHASIL LOGIN SEBAGAI ADMIN");

        int pilihan = 0;
        do {
            System.out.println("""
****************************************************************
                         Beauty Shop
****************************************************************
                       Main Menu Admin
================================================================
1. Tambah Data Kosmetik
2. Lihat Data Kosmetik    
3. Ubah Data Kosmetik
4. Hapus Data Kosmetik
5. Keluar
================================================================""");
            System.out.print(" Pilihan Anda [1-5]: ");
            pilihan = Integer.parseInt(baca.readLine());

            switch (pilihan) {
                case 1:
                    //Tambah data
                    createData();
                    break;
                case 2:
                    //Lihat data
                    readData();
                    break;
                case 3:
                    //Ubah data
                    updateData();
                    break;
                case 4:
                    //hapus data
                    deleteData();
                    break;
                case 5:
                    //keluar
                    System.out.println("================================================================");
                    System.out.println("                       Terima Kasih");
                    System.out.println("================================================================");
                    break;
                default:
                System.out.println("================================================================");
                System.out.println(" Inputan tidak ditemukan, mohon coba kembali!");
                    break;
            }
        } while (pilihan != 5);
    } else if 
        (username.equals("user") && password.equals("user123")) {
            System.out.println("================================================================");
            System.out.println("              ANDA BERHASIL LOGIN SEBAGAI USER");
            int pilihan = 0;
            do {
                System.out.println("""
                ****************************************************************
                                         Beauty Shop
                ****************************************************************
                                       Main Menu User
                ================================================================
                1. Lihat Data Kosmetik
                2. Keranjang
                3. Pemesanan
                4. Keluar
                ================================================================""");
                System.out.print(" Pilihan Anda [1-4]: ");
                pilihan = Integer.parseInt(baca.readLine());

                switch (pilihan) {
                    case 1:
                        //Lihat Data
                        readData();
                        createDataKeranjang();
                        break;
                    case 2:
                        //Cek Keranjang
                        do {
                            System.out.println("""
                            ****************************************************************
                                                     Beauty Shop
                            ****************************************************************
                                                      Keranjang
                            ================================================================
                            1. Ubah Jumlah Barang
                            2. Hapus Barang
                            3. Keluar
                            ================================================================""");
                            System.out.print(" Pilihan Anda [1-3]: ");
                            pilihan = Integer.parseInt(baca.readLine());
                            switch(pilihan){
                                case 1 :
                                    //ubah jumlah barang
                                    updateDataKeranjang();
                                    break;
                                case 2 :
                                    //hapus barang
                                    deleteDataKeranjang();
                                    break;
                                case 3 :
                                    break;
                            }
                        } while(pilihan!= 3);
                    case 3:
                        //Pemesanan
                        break;
                    case 4:
                        //keluar
                        System.out.println("================================================================");
                        System.out.println("                       Terima Kasih");
                        System.out.println("================================================================");
                        break;
                    default:
                    System.out.println("================================================================");
                    System.out.println(" Inputan tidak ditemukan, mohon coba kembali!");
                        break;
                }
            } while (pilihan != 4);
        }
    else {
        System.out.println("================================================================");
        System.out.println("                USERNAME ATAU PASSWORD SALAH!                   ");
        System.out.println("      >>> SILAHKAN MASUKAN PASSWORD DAN USERNMAE YANG BENAR <<< ");
        }
    } 
}
}
