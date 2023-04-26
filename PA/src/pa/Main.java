package pa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                    }else if(pilih.equals("T") || pilih.equals("t")){
                        System.out.println(" Data Ke-" + (i+1));
                        data1.get(i).displayInfo(false);
                    }else{
                        info.failChoose();
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
                    }else if(pilih1.equals("T") || pilih1.equals("t")){
                        System.out.println(" Data Ke-" + (i+1));
                        data2.get(i).displayInfo(false);
                    }else{
                        info.failChoose();
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
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                        DATA SKIN CARE");
                    System.out.println("----------------------------------------------------------------");
                    System.out.print(" Ingin Melihat Data Secara Lengkap? [y/t] : ");
                    String pilih = baca.readLine();
                    System.out.println("----------------------------------------------------------------");
                    for(int index = 0; index < data1.size(); index++){
                        if (pilih.equals("Y") || pilih.equals("y")){
                            System.out.println(" Data Ke-" + (index+1));
                            data1.get(index).displayInfo();
                        }else{
                            System.out.println(" Data Ke-" + (index+1));
                            data1.get(index).displayInfo(false);
                        }
                    }
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
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                         DATA MAKE UP");
                    System.out.println("----------------------------------------------------------------");
                    System.out.print(" Ingin Melihat Data Secara Lengkap? [y/t] : ");
                    String pilih1 = baca.readLine();
                    System.out.println("----------------------------------------------------------------");
                    for(int index = 0; index < data2.size(); index++){
                        if (pilih1.equals("Y") || pilih1.equals("y")){
                            System.out.println(" Data Ke-" + (index+1));
                            data2.get(index).displayInfo();
                        }else{
                            System.out.println(" Data Ke-" + (index+1));
                            data2.get(index).displayInfo(false);
                        }
                    }
                }
            }
        }else{
            info.failChoose();
        }
    }

    //Menambahkan kosmetik ke dalam keranjang pembelian
    static void createDataKeranjang() throws IOException{
        Detail info = new Detail();
        int lihat = 0;
        do {
            
            System.out.println("""
            ================================================================
                                   Keranjang Pembelian
            ================================================================
             1. Tambah Skin Care
             2. Tambah Make Up
             3. Kembali
            ================================================================""");
            System.out.print("Pilihan Anda [1/2] : ");
            lihat = Integer.parseInt(baca.readLine());
            if(lihat == 1){
                if(data1.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data Skin Care");
                }else{ //lihat data skincare
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                        DATA SKIN CARE");
                    System.out.println("----------------------------------------------------------------");
                    for(int i = 0; i < data1.size(); i++){
                            System.out.println(" Data Ke-" + (i+1));
                            data1.get(i).displayInfo();
                    }
                    System.out.print("Pilih ID Barang: ");
                    String idBarangSC = baca.readLine();
                    System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
                    int jumlahBarangSC = Integer.parseInt(baca.readLine());
                    for(Skincare dataSkincare : data1){
                        if(dataSkincare.getIdSkincare().equals(idBarangSC)){
                            String idSC = dataSkincare.getIdSkincare();
                            String namaSC = dataSkincare.getNama();
                            String merkSC = dataSkincare.getMerk();
                            String tipeSC = dataSkincare.getTipe();
                            String jenkulSC = dataSkincare.getJenisKulit();
                            String sertifikasiSC = dataSkincare.getCertifiedBPOM();
                            int kuantitasSC = jumlahBarangSC;
                            int hargaSC = dataSkincare.getHarga() * jumlahBarangSC;
                            KeranjangSC newKeranjangSC = new KeranjangSC(idSC, tipeSC, jenkulSC, namaSC, merkSC, hargaSC, kuantitasSC, sertifikasiSC);
                            keranjangSC.add(newKeranjangSC);
                            info.notifySuccessCreate();
                            break;
                        }
                    }
                }
            }else if(lihat == 2){
                if(data2.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data Make Up");
                    break;
                }else{ //lihat data make up
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                         DATA MAKE UP");
                    System.out.println("----------------------------------------------------------------");
                    for(int i = 0; i < data2.size(); i++){
                            System.out.println(" Data Ke-" + (i+1));
                            data2.get(i).displayInfo();
                    }
                    System.out.print("Pilih ID Barang: ");
                    String idBarangMU = baca.readLine();
                    System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
                    int jumlahBarangMU = Integer.parseInt(baca.readLine());
                    for(Makeup dataMakeup : data2){
                        if(dataMakeup.getIdMakeup().equals(idBarangMU)){
                            String idMU = dataMakeup.getIdMakeup();
                            String namaMU = dataMakeup.getNama();
                            String merkMU = dataMakeup.getMerk();
                            String jenisMU = dataMakeup.getJenis();
                            String shadeMU = dataMakeup.getShade();
                            String sertifikasiMU = dataMakeup.getCertifiedBPOM();
                            int kuantitasMU = jumlahBarangMU;
                            int hargaMU = dataMakeup.getHarga() * jumlahBarangMU;
                            KeranjangMU newKeranjangMU = new KeranjangMU(idMU, jenisMU, shadeMU, namaMU, merkMU, hargaMU, kuantitasMU, sertifikasiMU);
                            keranjangMU.add(newKeranjangMU);
                            info.notifySuccessCreate();
                            break;
                        }
                    }
                }
            }else if (lihat == 3){
                break;
            }else{
                info.failChoose();
            }
        } while (lihat != 3);
    }
    
    //Pembelian Kosmetik
    static void readDataKeranjang() throws IOException {
        Detail info = new Detail();
        int jumlah = 0;
        do {
            System.out.println("""
            ================================================================
                                   Pembelian Kosmetik
            ================================================================
             1. Skin Care
             2. Make Up
             3. Kembali
             ================================================================""");
            System.out.print("Pilihan Anda [1/2] : ");
            jumlah = Integer.parseInt(baca.readLine());
            if (jumlah == 1){
                if(keranjangSC.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data. Mohon Tambahkan Keranjang Terlebih Dahulu");
                }else{ //lihat data skincare
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                        DATA BARANG");
                    System.out.println("----------------------------------------------------------------");
                    int totalHarga = 0;
                    for(int i = 0; i < keranjangSC.size(); i++){
                        System.out.println(" Data Ke-" + (i+1));
                        keranjangSC.get(i).displayInfo();
                        totalHarga += keranjangSC.get(i).getHarga();
                    }
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("TOTAL HARGA = Rp." + totalHarga);
                    System.out.print("\nApakah anda yakin ingin melakukan pembelian? [y/t]: ");
                    String konfirmasi = baca.readLine();
                    if (konfirmasi == "y" || konfirmasi == "Y") {
                        System.out.println("***TRANSAKSI BERHASIL***");
                    }else if(konfirmasi.equals("t") || konfirmasi.equals("T")){
                        System.out.println("***TRANSAKSI BATAL***");
                    }
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
                    int totalHarga = 0;
                    for(int i = 0; i < keranjangMU.size(); i++){
                        System.out.println(" Data Ke-" + (i+1));
                        keranjangMU.get(i).displayInfo();
                        totalHarga += keranjangSC.get(i).getHarga();
                    }
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("TOTAL HARGA = Rp." + totalHarga);
                    System.out.print("\nApakah anda ingin membeli kosmetik tersebut [y/t]: ");
                    String konfirmasi = baca.readLine();
                    if (konfirmasi == "y" || konfirmasi == "Y") {
                        System.out.println("***TRANSAKSI BERHASIL***");
                    }else if(konfirmasi.equals("t") || konfirmasi.equals("T")){
                        System.out.println("***TRANSAKSI BATAL***");
                    }
                }
            }else if(jumlah == 3){
                break;
            }else{
                info.failChoose();
            }
        } while (jumlah != 3);
    }
    
    //Ubah data jumlah pembelian
    static void  updateDataKeranjang() throws IOException {
        Detail info = new Detail();
        int update = 0;
        do {
            System.out.println("""
            ================================================================
                               Update Data Jumlah Pembelian 
            ================================================================
             1. Skin Care
             2. Make Up
             3. Kembali
            ================================================================""");
            System.out.print("Pilihan Anda [1/2] : ");
            update = Integer.parseInt(baca.readLine());
    
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
                        System.out.print("ID Skin Care yang Ingin Diubah : ");
                        String idSC = baca.readLine();
                        if(dataSkincare.getIdSkincare().equals(idSC)){
                            System.out.println("----------------------------------------------------------------");
                            System.out.print(" Kuantitas Pembelian Skin Care Terbaru : "); dataSkincare.setKuantitas(Integer.parseInt(baca.readLine()));
                            info.notifySuccessUpdate();
                            break;
                        }else{
                            info.notifyFailUpdate();
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
                            System.out.print(" Kuantitas Pembelian Make Up Terbaru : "); dataMakeup.setKuantitas(Integer.parseInt(baca.readLine()));
                            System.out.println("----------------------------------------------------------------");
                            info.notifySuccessUpdate();
                            break;
                        }else{
                            info.notifyFailUpdate();
                        }
                    }
                }
            }else if (update == 3){
                break;
            }else{
                info.failChoose();
            }
        } while (update != 3);
    }

    //Hapus data kosmetik di keranjang
    static void deleteDataKeranjang() throws IOException{
        Detail info = new Detail();
        int delete = 0;
        do {
            System.out.println("""
            ================================================================
                              Menghapus Data Keranjang
            ================================================================
             1. Skin Care
             2. Make Up
             3. Kembali
            ================================================================""");
            System.out.print("Pilihan Anda [1/2] : ");
            delete = Integer.parseInt(baca.readLine());
            if (delete == 1){
                while (true) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                        DATA BARANG");
                    System.out.println("----------------------------------------------------------------");
                    for(int i  = 0; i < keranjangSC.size(); i++) {
                        System.out.println(" Data Ke-" + (i+1));
                        keranjangSC.get(i).displayInfo();
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(" Masukkan ID Skin Care yang Ingin Anda Hapus : ");
                        String idSC = baca.readLine();
                        if(keranjangSC.get(i).getIdSkincare().equals(idSC)){
                            info.notifySuccessDelete();
                            keranjangSC.remove(i);
                            break;
                        }else{
                            info.notifyFailDelete();
                        }
                    }
                }
            }else if  (delete == 2){
                while (true) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                        DATA BARANG");
                    System.out.println("----------------------------------------------------------------");
                    for(int i  = 0; i < keranjangMU.size(); i++) {
                        System.out.println(" Data Ke-" + (i+1));
                        keranjangMU.get(i).displayInfo();
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(" Masukkan ID Make Up yang Ingin Anda Hapus : "); 
                        String idMU = baca.readLine();
                        if(keranjangMU.get(i).getIdMakeup().equals(idMU)){
                            info.notifySuccessDelete();
                            keranjangMU.remove(i);
                            break;
                        }else{
                            info.notifyFailDelete();
                        }
                    }
                }
            }else if (delete == 3){
                break;
            }else{
                info.failChoose();
            }
        } while (delete != 3);
    }
    
     static void loginFormAdmin() throws IOException{
        Scanner input = new Scanner(System.in);
        String username, password;
        System.out.println("""
        \n****************************************************************
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
                    \n****************************************************************
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
        } else {
                System.out.println("================================================================");
                System.out.println("                USERNAME ATAU PASSWORD SALAH!                   ");
                System.out.println("    >>> SILAHKAN MASUKAN PASSWORD DAN USERNAME YANG BENAR <<< ");
        }
    }

        public static void loginFormUser() throws IOException{
            Scanner input = new Scanner(System.in);
            String username, password;
            File path = new File("PA/src/pa/akun.csv");
            Scanner myreader = new Scanner(path);
            Boolean _found = false;
            while (myreader.hasNextLine()){
                System.out.println("""
                \n****************************************************************
                                           Beauty Shop
                ****************************************************************
                                        Welcome Login Page 
                ================================================================""");
                System.out.print("Masukkan username: ");
                username = input.nextLine();
                System.out.println("================================================================");
                System.out.print("Masukkan password: ");
                password = input.nextLine();
                String data = myreader.next();
                String[] file = data.split(",");
                if (file[0].equals(username) && file[1].equals(password)){
                    _found = true;
                }
                if (_found == true){
                    myreader.hasNext();
                    System.out.println("================================================================");
                    System.out.println("              ANDA BERHASIL LOGIN SEBAGAI USER");
                    int pilihan = 0;
                    do {
                        System.out.println("""
                        \n****************************************************************
                                                 Beauty Shop
                        ****************************************************************
                                               Main Menu User
                        ================================================================
                        1. Keranjang Pembelian
                        2. Atur Keranjang
                        3. Lakukan Pembelian
                        4. Keluar
                        ================================================================""");
                        System.out.print(" Pilihan Anda [1-4]: ");
                        pilihan = Integer.parseInt(baca.readLine());

                        switch (pilihan) {
                            case 1:
                                //Tambah Keranjang
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
                                    3. Kembali
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
                                readDataKeranjang();
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
                }else {
                    System.out.println("================================================================");
                    System.out.println("                USERNAME ATAU PASSWORD SALAH!                   ");
                    System.out.println("      >>> SILAHKAN MASUKAN PASSWORD DAN USERNMAE YANG BENAR <<< ");
                    break;
                }
                myreader.close();
                break;
                
            }
    }
    
    
    static void Registrasi()throws IOException{
        Scanner input = new Scanner(System.in);
        String username, password;
        System.out.println("""
        \n****************************************************************
                                   Beauty Shop
        ****************************************************************
                                 Registrasi Akun 
        ================================================================""");
        System.out.print("Masukkan username: ");
        username = input.nextLine();
        System.out.println("================================================================");
        System.out.print("Masukkan password: ");
        password = input.nextLine();
        List <List<String>> dataDummy = Arrays.asList(
        Arrays.asList(username,password)
        );
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/pa/akun.csv"));
            for (List<String> data : dataDummy ) {
                writer.write(String.join(",", data));
                writer.newLine();
            }
            writer.close();
    }

    public static void main(String[] args) throws IOException {
        // // TAMBAH DATA AWAL
        Skincare newDataSC = new Skincare("1", "UV Moisture Gel", "Skin Aqua", 47000, 500, "Ada", "Sun Protection", "Berminyak");
        data1.add(newDataSC);
        // Skincare newDataSC2 = new Skincare("2", "Azarine Night Cream Moisturizer", "Azarine", 47000, 1200, "Tidak Ada", "Moisturizer", "Sensitif");
        // data1.add(newDataSC2);
        Makeup newDataMU = new Makeup("1", "Creamatte Lip Cream", "Emina", 47500, 200, "Ada", "Lipstick", "Fuzzy Muzzy");
        data2.add(newDataMU);
        // Makeup newDataMU2 = new Makeup("2", "IMPLORA Urban Lip Cream Matte", "Implora", 16000, 550, "Tidak Ada", "Lip Cream", "Allure");
        // data2.add(newDataMU2);
        
        Scanner input = new Scanner(System.in);
        String username, password;

        while(true){
            int pilihan = 0;
            System.out.println("""
            \n****************************************************************
                                     Beauty Shop
            ****************************************************************
                                      Main Menu 
            ================================================================
            1. Registrasi
            2. Login Sebagai Admin
            3. Login Sebagai User
            4. Keluar
            ================================================================""");
            System.out.print(" Pilihan Anda [1-4]: ");
            pilihan = Integer.parseInt(baca.readLine());
            switch(pilihan){
                
                case 1:
                    //registrasi
                    Registrasi();
                    break;
                case 2:
                    loginFormAdmin();
                    break;
                case 3:
                    loginFormUser();
                    break;
                case 4:
                    System.out.println("KELUAR DARI PROGRAM");
                    System.exit(0);
                default:
                    System.out.println("================================================================");
                    System.out.println(" Inputan tidak ditemukan, mohon coba kembali!");
                    break;
            }
        }
    }
}
