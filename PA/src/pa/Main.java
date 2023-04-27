package pa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.BreakIterator;
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
        String idSC = null, idMU = null;
        int hargaSC = 0, kuantitasSC = 0, hargaMU = 0, kuantitasMU = 0;
        Detail info = new Detail();
        int tambah = 0;
        do {
            System.out.println("""
            ================================================================
                                     Tambah Data
            ================================================================
             1. Skin Care
             2. Make Up
             3. Kembali
            ================================================================""");
            System.out.print("Pilihan Anda [1/2] : ");
            tambah = Integer.parseInt(baca.readLine());
            
            if (tambah == 1){ //tambah data skincare
                System.out.println("----------------------------------------------------------------");
                System.out.println("| DATA SKIN CARE                                               |");
                System.out.println("----------------------------------------------------------------");
                while (true) {
                    int cek = 0;
                    System.out.print(" ID                : "); idSC = baca.readLine();
                    for(Skincare dataSkincare : data1){
                        if (dataSkincare.getIdSkincare().equals(idSC)) {
                            System.out.println("ID Skin care sudah ada, mohon coba kembali!");
                            cek = 1;
                            break;
                        }
                    }
                    if (cek == 0) {
                        break;
                    }
                }
                System.out.print(" Nama              : "); String namaSC = baca.readLine();
                System.out.print(" Merk              : "); String merkSC = baca.readLine();
                System.out.print(" Tipe              : "); String tipeSC = baca.readLine();
                System.out.print(" Untuk Jenis Kulit : "); String jenkulSC = baca.readLine();
                while (true) {
                    try {
                        System.out.print(" Harga             : "); hargaSC = Integer.parseInt(baca.readLine());
                        if (hargaSC > 0){
                            break;
                        } else if (hargaSC < 0) {
                            System.out.println(" Harga Skin Care harus bernilai positif, mohon coba kembali!");
                        } else if (hargaSC == 0) {
                            System.out.println(" Harga Skin Care tidak boleh 0, mohon coba kembali!");
                        }
                    }catch (NumberFormatException e) {
                        System.out.println(" Harga Skin Care tidak valid, mohon coba kembali!");
                    }
                }
                while (true) {
                    try {
                        System.out.print(" Kuantitas         : "); kuantitasSC = Integer.parseInt(baca.readLine());
                        if (kuantitasSC > 0){
                            break;
                        } else if (kuantitasSC < 0) {
                            System.out.println(" Kuantitas Skin Care harus bernilai positif, mohon coba kembali!");
                        } else if (kuantitasSC == 0) {
                            System.out.println(" Kuantitas Skin Care tidak boleh 0, mohon coba kembali!");
                        }
                    }catch (NumberFormatException e) {
                        System.out.println(" Kuantitas Skin Care tidak valid, mohon coba kembali!");
                    }
                }
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
                    break;
                }else if (serti.equals("T")||serti.equals("t")){
                    String sertifikasiSC = info.noCertified;
                    for(int i = 0; i < data1.size(); i++){
                        data1.get(i).createDone(namaSC);
                    }
                    info.notifySuccessCreate();
                    Skincare newDataSC = new Skincare(idSC, namaSC, merkSC, hargaSC, kuantitasSC, sertifikasiSC, tipeSC, jenkulSC);
                    data1.add(newDataSC);
                    break;
                }else{
                    info.failChoose();
                }
            }else if (tambah == 2) { //tambah data make up
                System.out.println("----------------------------------------------------------------");
                System.out.println("| DATA MAKE UP                                                 |");
                System.out.println("----------------------------------------------------------------");
                while (true) {
                    int cek = 0;
                    System.out.print(" ID        : "); idMU = baca.readLine();
                    for(Makeup dataMakeup : data2){
                        if (dataMakeup.getIdMakeup().equals(idMU)) {
                            System.out.println("ID Make Up sudah ada, mohon coba kembali!");
                            cek = 1;
                            break;
                        }
                    }
                    if (cek == 0) {
                        break;
                    }
                }
                System.out.print(" Nama      : "); String namaMU = baca.readLine();
                System.out.print(" Merk      : "); String merkMU = baca.readLine();
                System.out.print(" Jenis     : "); String jenisMU = baca.readLine();
                System.out.print(" Shade     : "); String shadeMU = baca.readLine();
                while (true) {
                    try {
                        System.out.print(" Harga     : "); hargaMU = Integer.parseInt(baca.readLine());
                        if (hargaMU > 0){
                            break;
                        } else if (hargaMU < 0) {
                            System.out.println(" Harga Make Up harus bernilai positif, mohon coba kembali!");
                        } else if (hargaMU == 0) {
                            System.out.println(" Harga Make Up tidak boleh 0, mohon coba kembali!");
                        }
                    }catch (NumberFormatException e) {
                        System.out.println(" Harga Make Up tidak valid, mohon coba kembali!");
                    }
                }
                while (true) {
                    try {
                        System.out.print(" Kuantitas : "); kuantitasMU = Integer.parseInt(baca.readLine());
                        if (kuantitasMU > 0){
                            break;
                        } else if (kuantitasMU < 0) {
                            System.out.println(" Kuantitas Make Up harus bernilai positif, mohon coba kembali!");
                        } else if (kuantitasMU == 0) {
                            System.out.println(" Kuantitas Make Up tidak boleh 0, mohon coba kembali!");
                        }
                    }catch (NumberFormatException e) {
                        System.out.println(" Kuantitas Make Up tidak valid, mohon coba kembali!");
                    }
                }
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
                    break;
                }else if (serti.equals("T")||serti.equals("t")){
                    String sertifikasiMU = info.noCertified;
                    for(int i = 0; i < data2.size(); i++){
                        data2.get(i).createDone(namaMU);
                    }
                    info.notifySuccessCreate();
                    Makeup newDataMU = new Makeup(idMU, namaMU, merkMU, hargaMU, kuantitasMU, sertifikasiMU,jenisMU, shadeMU);
                    data2.add(newDataMU);
                    break;
                }else{
                    info.failChoose();
                } 
            }else if(tambah == 3){
                break;
            }else{
                info.notifyFailCreate();
            }
            
        } while (tambah != 3);
    }

    //Read Data
    static void readData() throws IOException{
        Detail info = new Detail();
        int lihat = 0;
        do {
            System.out.println("""
            ================================================================
                                     Lihat Data
            ================================================================
             1. Skin Care
             2. Make Up
             3. Kembali
            ================================================================""");
            System.out.print("Pilihan Anda [1/2] : ");
            lihat = Integer.parseInt(baca.readLine());
    
            if(lihat == 1){
                if(data1.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Terlebih Dahulu");
                    break;
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
                    break;
                }
            }else if(lihat == 2){
                if(data2.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Terlebih Dahulu");
                    break;
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
                    break;
                }
            }else if(lihat == 3){
                break;
            }else{
                info.failChoose();
            }
        } while (lihat != 3);
    }

    //mengubah data
    static void  updateData() throws IOException {
        Detail info = new Detail();
        int notif = 0;
        int update = 0;
        do {
            System.out.println("""
            ================================================================
                                    Update Data 
            ================================================================
             1. Skin Care
             2. Make Up
             3. Kembali
            ================================================================""");
            System.out.print("Pilihan Anda [1/2] : ");
            update = Integer.parseInt(baca.readLine());
            
            if (update == 1) {
                if(data1.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Terlebih Dahulu");
                    break;
                }else{ //lihat data skincare
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                        DATA SKIN CARE");
                    System.out.println("----------------------------------------------------------------");
                    for(int i = 0; i < data1.size(); i++){
                            System.out.println(" Data Ke-" + (i+1));
                            data1.get(i).displayInfo();
                    }
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("ID Skin Care yang Ingin Diubah : ");
                    String idSC = baca.readLine();
                    notif = 0;
                    for(Skincare dataSkincare : data1){
                        if(dataSkincare.getIdSkincare().equals(idSC)){
                            System.out.println("----------------------------------------------------------------");
                            System.out.print(" Nama Skin Care Terbaru       : "); dataSkincare.setNama(baca.readLine());
                            System.out.print(" Merk Skin Care Terbaru       : "); dataSkincare.setMerk(baca.readLine());
                            System.out.print(" Tipe Skin Care Terbaru       : "); dataSkincare.setTipe(baca.readLine());
                            System.out.print(" Untuk Jenis Kulit Terbaru    : "); dataSkincare.setJenisKulit(baca.readLine());
                            while (true) {
                                try {
                                    System.out.print(" Harga Skin Care Terbaru      : "); dataSkincare.setHarga(Integer.parseInt(baca.readLine()));
                                    if (dataSkincare.getHarga() > 0){
                                        break;
                                    } else if (dataSkincare.getHarga() < 0) {
                                        System.out.println(" Harga Skin Care harus bernilai positif, mohon coba kembali!");
                                    } else if (dataSkincare.getHarga() == 0) {
                                        System.out.println(" Harga Skin Care tidak boleh 0, mohon coba kembali!");
                                    }
                                }catch (NumberFormatException e) {
                                    System.out.println(" Harga Skin Care tidak valid, mohon coba kembali!");
                                }
                            }
                            while (true) {
                                try {
                                    System.out.print(" Kuantitas Skin Care  Terbaru : "); dataSkincare.setKuantitas(Integer.parseInt(baca.readLine()));
                                    if (dataSkincare.getKuantitas() > 0){
                                        break;
                                    } else if (dataSkincare.getKuantitas() < 0) {
                                        System.out.println(" Kuantitas Skin Care harus bernilai positif, mohon coba kembali!");
                                    } else if (dataSkincare.getKuantitas() == 0) {
                                        System.out.println(" Kuantitas Skin Care tidak boleh 0, mohon coba kembali!");
                                    }
                                }catch (NumberFormatException e) {
                                    System.out.println(" Kuantitas Skin Care tidak valid, mohon coba kembali!");
                                }
                            }
                            System.out.println("----------------------------------------------------------------");
                            info.notifySuccessUpdate();
                            notif = 1;
                            break;
                        }
                    }
                    if (notif == 0){
                        info.notifyFailUpdate();
                    }
                }
            }else if (update == 2) {
                if(data2.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Terlebih Dahulu");
                    break;
                }else{ //lihat data make up
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("                         DATA MAKE UP");
                    System.out.println("----------------------------------------------------------------");
                    for(int i = 0; i < data2.size(); i++){
                        System.out.println(" Data Ke-" + (i+1));
                        data2.get(i).displayInfo();
                    }
                    System.out.println("----------------------------------------------------------------");
                    System.out.print("ID Make Up yang Ingin Diubah : ");
                    String idMU = baca.readLine();
                    notif = 0;
                    for(Makeup dataMakeup : data2){
                        if(dataMakeup.getIdMakeup().equals(idMU)){
                            System.out.println("----------------------------------------------------------------");
                            System.out.print(" Nama Make Up Terbaru      : "); dataMakeup.setNama(baca.readLine());;
                            System.out.print(" Merk Make Up Terbaru      : "); dataMakeup.setMerk(baca.readLine()); 
                            System.out.print(" Jenis Make Up Terbaru     : "); dataMakeup.setJenis(baca.readLine());
                            System.out.print(" Shade Make Up Terbaru     : "); dataMakeup.setShade(baca.readLine());
                            while (true) {
                                try {
                                    System.out.print(" Harga Make Up Terbaru     : "); dataMakeup.setHarga(Integer.parseInt(baca.readLine()));
                                    if (dataMakeup.getHarga() > 0){
                                        break;
                                    } else if (dataMakeup.getHarga() < 0) {
                                        System.out.println(" Harga Make Up harus bernilai positif, mohon coba kembali!");
                                    } else if (dataMakeup.getHarga() == 0) {
                                    System.out.println(" Harga Make Up tidak boleh 0, mohon coba kembali!");
                                    }
                                }catch (NumberFormatException e) {
                                    System.out.println(" Harga Skin Care tidak valid, mohon coba kembali!");
                                }
                            }
                            while (true) {
                                try {
                                    System.out.print(" Kuantitas Make Up Terbaru : "); dataMakeup.setKuantitas(Integer.parseInt(baca.readLine()));
                                    if (dataMakeup.getKuantitas() > 0){
                                        break;
                                    } else if (dataMakeup.getKuantitas() < 0) {
                                        System.out.println(" Kuantitas Make Up harus bernilai positif, mohon coba kembali!");
                                    } else if (dataMakeup.getKuantitas() == 0) {
                                    System.out.println(" Kuantitas Make Up tidak boleh 0, mohon coba kembali!");
                                    }
                                }catch (NumberFormatException e) {
                                    System.out.println(" Kuantitas Make Up tidak valid, mohon coba kembali!");
                                }
                            }
                            System.out.println("----------------------------------------------------------------");
                            info.notifySuccessUpdate();  
                            notif = 1;
                            break;
                        }
                    }if (notif == 0){
                        info.notifyFailUpdate();
                    }
                }
            }else if(update == 3){
                break;
            }else{
                info.failChoose();
            }
        } while (update != 3);
    }

    //menghapus data
    static void deleteData() throws IOException{
        Detail info = new Detail();
        int delete = 0;
        do {
            System.out.println("""
            ================================================================
                                   Menghapus Data
            ================================================================
             1. Skin Care
             2. Make Up
             3. Kembali
            ================================================================""");
            System.out.print("Pilihan Anda [1/2] : ");
            delete = Integer.parseInt(baca.readLine());
            if (delete == 1){
                if(data1.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Terlebih Dahulu");
                    break;
                }else{ //lihat data skincare
                    while(true){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("                        DATA SKIN CARE");
                        System.out.println("----------------------------------------------------------------");
                        for(int i = 0; i < data1.size(); i++){
                                System.out.println(" Data Ke-" + (i+1));
                                data1.get(i).displayInfo();
                        }
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(" Masukkan ID Skin Care yang Ingin Anda Hapus : ");
                        String idSC = baca.readLine();
                        for(int i  = 0; i < data1.size(); i++) {
                            if(data1.get(i).getIdSkincare().equals(idSC)){
                                info.notifySuccessDelete();
                                data1.remove(i);
                                break;
                            }else{
                                info.notifyFailDelete();
                            }
                        }
                    }
                }
            }else if  (delete == 2){
                if(data2.isEmpty()){
                    System.out.println("----------------------------------------------------------------");
                    System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Terlebih Dahulu");
                    break;
                }else{ //lihat data make up
                    while(true){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println("                         DATA MAKE UP");
                        System.out.println("----------------------------------------------------------------");
                        for(int i = 0; i < data2.size(); i++){
                            System.out.println(" Data Ke-" + (i+1));
                            data2.get(i).displayInfo();
                        }
                        System.out.println("----------------------------------------------------------------");
                        System.out.print(" Masukkan ID Make Up yang Ingin Anda Hapus : "); 
                        String nmMU = baca.readLine();
                        for(int i  = 0; i < data2.size(); i++) {
                            if(data2.get(i).getIdMakeup().equals(nmMU)){
                                info.notifySuccessDelete();
                                data2.remove(i);
                                break;
                            }else{
                                info.notifyFailDelete();
                            }
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

    //Menambahkan kosmetik ke dalam keranjang pembelian
    static void createDataKeranjang() throws IOException{
        int jumlahBarangSC = 0, jumlahBarangMU = 0, notif = 0;
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
            try{
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
                        System.out.print("Pilih ID Skin Care: "); String idBarangSC = baca.readLine();
                        notif = 0;
                        for(Skincare dataSkincare : data1){
                            if(dataSkincare.getIdSkincare().equals(idBarangSC)){
                                while (true) {
                                    try {
                                        System.out.print("Masukkan jumlah barang yang ingin dibeli: "); 
                                        jumlahBarangSC = Integer.parseInt(baca.readLine());
                                        if (jumlahBarangSC > 0){
                                            break;
                                        } else if (jumlahBarangSC < 0) {
                                            System.out.println(" Jumlah barang harus bernilai positif, mohon coba kembali!");
                                        }
                                    }catch (NumberFormatException e) {
                                        System.out.println(" Jumlah barang tidak valid, mohon coba kembali!");
                                    }
                                }
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
                                notif = 1;
                                break;
                            }
                        } if (notif == 0){
                            System.out.println("Maaf, ID Skin Care tidak tersedia. mohon coba kembali!");
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
                        notif = 0;
                        for(Makeup dataMakeup : data2){
                            if(dataMakeup.getIdMakeup().equals(idBarangMU)){
                                while (true) {
                                    try {
                                        System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
                                        jumlahBarangMU = Integer.parseInt(baca.readLine());
                                        if (jumlahBarangMU > 0){
                                            break;
                                        } else if (jumlahBarangMU < 0) {
                                            System.out.println(" Jumlah barang harus bernilai positif, mohon coba kembali!");
                                        }
                                    }catch (NumberFormatException e) {
                                        System.out.println(" Jumlah barang tidak valid, mohon coba kembali!");
                                    }
                                }
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
                                notif = 1;
                                break;
                            }
                        }if (notif == 0){
                            System.out.println("Maaf, ID Make Up tidak tersedia. mohon coba kembali!");
                        }
                    }
                }else if (lihat == 3){
                    break;
                }else{
                    info.failChoose();
                }
            }catch (NumberFormatException e){
                System.out.println(" Inputan harus di isi dengan angka, mohon coba kembali!");
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
            try {
                jumlah = Integer.parseInt(baca.readLine());
                if (jumlah == 1){
                    if(keranjangSC.isEmpty()){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Keranjang Terlebih Dahulu");
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
                        System.out.println("================================================================");
                        System.out.println("TOTAL HARGA = Rp." + totalHarga);
                        System.out.print("\nApakah anda yakin ingin melakukan pembelian? [y/t]: ");
                        String konfirmasi = baca.readLine();
                        if (konfirmasi.equals("y") || konfirmasi.equals("Y")) {
                            for(KeranjangSC dataSkincare : keranjangSC){
                                String namaSC = dataSkincare.getNama();
                                int jumlahBeli = dataSkincare.getKuantitas();
                                for(Skincare dataSC : data1){
                                    if(dataSC.getNama().equals(namaSC)){
                                        int newStok = dataSC.getKuantitas() - jumlahBeli;
                                        dataSC.setKuantitas(newStok);
                                    }
                                }
                            }
                            System.out.println("\n ***TRANSAKSI BERHASIL*** ");
                        }else if(konfirmasi.equals("t") || konfirmasi.equals("T")){
                            System.out.println("\n ***TRANSAKSI BATAL*** ");
                        }
                    }
                }
                else if (jumlah == 2){
                    if(keranjangMU.isEmpty()){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Keranjang Terlebih Dahulu");
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
                        System.out.println("================================================================");
                        System.out.println("TOTAL HARGA = Rp." + totalHarga);
                        System.out.print("\nApakah anda ingin membeli kosmetik tersebut [y/t]: ");
                        String konfirmasi = baca.readLine();
                        if (konfirmasi.equals("y") || konfirmasi.equals("Y")) {
                            for(KeranjangMU dataMakeup : keranjangMU){
                                String namaMU = dataMakeup.getNama();
                                int jumlahBeli = dataMakeup.getKuantitas();
                                for(Makeup dataMU : data2){
                                    if(dataMU.getNama().equals(namaMU)){
                                        int newStok = dataMU.getKuantitas() - jumlahBeli;
                                        dataMU.setKuantitas(newStok);
                                    }
                                }
                            }
                            System.out.println("\n*** TRANSAKSI BERHASIL ***");
                        }else if(konfirmasi.equals("t") || konfirmasi.equals("T")){
                            System.out.println("\n*** TRANSAKSI BATAL ***");
                        }
                    }
                }else if(jumlah == 3){
                    break;
                }else{
                    info.failChoose();
                }
            }catch (NumberFormatException e){
                System.out.println(" Inputan harus di isi dengan angka, mohon coba kembali!");
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
            try{
                update = Integer.parseInt(baca.readLine());
                if (update == 1) {
                    if(keranjangSC.isEmpty()){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Keranjang Terlebih Dahulu");
                    }else{
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
                                System.out.print("ID keranjang Skin Care yang Ingin Diubah : ");
                                String idSC = baca.readLine();
                                if(dataSkincare.getIdSkincare().equals(idSC)){
                                    System.out.println("----------------------------------------------------------------");
                                    while (true) {
                                        try {
                                            System.out.print(" Kuantitas Pembelian Skin Care Terbaru : "); dataSkincare.setKuantitas(Integer.parseInt(baca.readLine()));
                                            if (dataSkincare.getKuantitas() > 0){
                                                break;
                                            } else if (dataSkincare.getKuantitas() < 0) {
                                                System.out.println(" Kuantitas barang harus bernilai positif, mohon coba kembali!");
                                            }
                                        }catch (NumberFormatException e) {
                                            System.out.println(" Kuantitas barang tidak valid, mohon coba kembali!");
                                        }
                                    }
                                    System.out.println("----------------------------------------------------------------");
                                    info.notifySuccessUpdate();
                                    break;
                                }else{
                                    info.notifyFailUpdate();
                                }
                            }
                        }
                    }
                }else if (update == 2) {
                    if(keranjangMU.isEmpty()){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Keranjang Terlebih Dahulu");
                    }else{
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
                                System.out.print("ID keranjang Make Up yang Ingin Diubah : ");
                                String idMU = baca.readLine();
                                if(dataMakeup.getIdMakeup().equals(idMU)){
                                    System.out.println("----------------------------------------------------------------");
                                    while (true) {
                                        try {
                                            System.out.print(" Kuantitas Pembelian Make Up Terbaru : "); dataMakeup.setKuantitas(Integer.parseInt(baca.readLine()));
                                            if (dataMakeup.getKuantitas() > 0){
                                                break;
                                            } else if (dataMakeup.getKuantitas() < 0) {
                                                System.out.println(" Kuantitas barang harus bernilai positif, mohon coba kembali!");
                                            }
                                        }catch (NumberFormatException e) {
                                            System.out.println(" Kuantitas barang tidak valid, mohon coba kembali!");
                                        }
                                    }
                                    System.out.println("----------------------------------------------------------------");
                                    info.notifySuccessUpdate();
                                    break;
                                }else{
                                    info.notifyFailUpdate();
                                }
                            }
                        }
                    }
                }else if (update == 3){
                    break;
                }else{
                    info.failChoose();
                }
            }catch (NumberFormatException e){
                System.out.println(" Inputan harus di isi dengan angka, mohon coba kembali!");
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
            try{
                delete = Integer.parseInt(baca.readLine());
                if (delete == 1){
                    if(keranjangSC.isEmpty()){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Keranjang Terlebih Dahulu");
                    }else{
                        while (true) {
                            System.out.println("----------------------------------------------------------------");
                            System.out.println("                        DATA BARANG");
                            System.out.println("----------------------------------------------------------------");
                            for(int i  = 0; i < keranjangSC.size(); i++) {
                                System.out.println(" Data Ke-" + (i+1));
                                keranjangSC.get(i).displayInfo();
                            }
                            System.out.println("----------------------------------------------------------------");
                            System.out.print(" Masukkan ID Skin Care yang Ingin Anda Hapus : ");
                            String idSC = baca.readLine();
                            for(int x  = 0; x < keranjangSC.size(); x++) {
                                if(keranjangSC.get(x).getIdSkincare().equals(idSC)){
                                    info.notifySuccessDelete();
                                    keranjangSC.remove(x);
                                    break;
                                }else{
                                    info.notifyFailDelete();
                                }
                            }
                            break;
                        }
                    }
                }else if  (delete == 2){
                    if(keranjangMU.isEmpty()){
                        System.out.println("----------------------------------------------------------------");
                        System.out.println(" Tidak Ada Data. Mohon Tambahkan Data Keranjang Terlebih Dahulu");
                    }else{
                        while (true) {
                            System.out.println("----------------------------------------------------------------");
                            System.out.println("                        DATA BARANG");
                            System.out.println("----------------------------------------------------------------");
                            for(int i  = 0; i < keranjangMU.size(); i++) {
                                System.out.println(" Data Ke-" + (i+1));
                                keranjangMU.get(i).displayInfo();
                            }
                                System.out.println("----------------------------------------------------------------");
                                System.out.print(" Masukkan ID Make Up yang Ingin Anda Hapus : "); 
                                String idMU = baca.readLine();
                                for(int x  = 0; x < keranjangMU.size(); x++) {
                                    if(keranjangMU.get(x).getIdMakeup().equals(idMU)){
                                        info.notifySuccessDelete();
                                        keranjangMU.remove(x);
                                        break;
                                }else{
                                    info.notifyFailDelete();
                                }
                            }
                            break;
                        }
                    }
                }else if (delete == 3){
                    break;
                }else{
                    info.failChoose();
                }
            }catch (NumberFormatException e){
                System.out.println(" Inputan harus di isi dengan angka, mohon coba kembali!");
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
                try {
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
                }catch (NumberFormatException e) {
                    System.out.println(" Inputan harus di isi dengan angka, mohon coba kembali!");
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
            Boolean _found = false;
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
            Scanner scanner = new Scanner(Files.newBufferedReader(Paths.get("src/pa/akun.csv")));
            scanner.useDelimiter(",");

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String fileUsername = parts[0];
                String filePassword = parts[1];
                if (username.equals(fileUsername) && password.equals(filePassword)){
                    _found = true;
                    break;
                }
            }
                 scanner.close();
                if (_found == true){
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
                        1. Pesan Data Kosmetik
                        2. Atur Keranjang
                        3. Lakukan Pemesanan
                        4. Keluar
                        ================================================================""");
                        System.out.print(" Pilihan Anda [1-4]: ");
                    try{
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
                                    3. Keluar
                                    ================================================================""");
                                    System.out.print(" Pilihan Anda [1-3]: ");
                                    try{
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
                                    }catch (NumberFormatException e){
                                        System.out.println(" Inputan harus di isi dengan angka, mohon coba kembali!");
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
                        }catch (NumberFormatException e) {
                            System.out.println(" Inputan harus di isi dengan angka, mohon coba kembali!");
                        }
                    } while (pilihan != 4);
                }else {
                    System.out.println("================================================================");
                    System.out.println("                USERNAME ATAU PASSWORD SALAH!                   ");
                    System.out.println("      >>> SILAHKAN MASUKAN PASSWORD DAN USERNMAE YANG BENAR <<< ");
                }
    }
    
    
    static void Registrasi()throws IOException{
        Scanner input = new Scanner(System.in);
        String username, password;
        // Membaca file CSV dan menyimpannya ke dalam StringBuilder
        Path path = Paths.get("src/pa/akun.csv");
        StringBuilder builder = new StringBuilder();
        try {
            String content = new String(Files.readAllBytes(path));
            builder.append(content);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
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
            String newAccount = username + "," + password + "\n";
             // Memeriksa apakah akun sudah terdaftar
            boolean isRegistered = builder.indexOf(username) != -1;
            if (isRegistered) {
                System.out.println("Username sudah terdaftar");
            } else {
                // Menambahkan string data akun baru ke dalam StringBuilder
                builder.append(newAccount);
                System.out.println("Registrasi berhasil");
            }
                FileWriter writer = new FileWriter("src/pa/akun.csv");
                writer.write(builder.toString());
                writer.close();
    }

    public static void main(String[] args) throws IOException {
         
         Skincare newDataSC = new Skincare("1", "UV Moisture Gel", "Skin Aqua", 47000, 500, "Ada", "Sun Protection", "Berminyak");
         data1.add(newDataSC);
         Skincare newDataSC2 = new Skincare("2", "Azarine Night Cream Moisturizer", "Azarine", 47000, 1200, "Tidak Ada", "Moisturizer", "Sensitif");
         data1.add(newDataSC2);
         Makeup newDataMU = new Makeup("1", "Creamatte Lip Cream", "Emina", 47500, 200, "Ada", "Lipstick", "Fuzzy Muzzy");
         data2.add(newDataMU);
         Makeup newDataMU2 = new Makeup("2", "IMPLORA Urban Lip Cream Matte", "Implora", 16000, 550, "Tidak Ada", "Lip Cream", "Allure");
         data2.add(newDataMU2);
        
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
            try {
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
                        System.out.println("================================================================");
                        System.out.println("                       Terima Kasih");
                        System.out.println("================================================================");
                        System.exit(0);
                    default:
                        System.out.println("================================================================");
                        System.out.println(" Inputan tidak ditemukan, mohon coba kembali!");
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println(" Inputan harus di isi dengan angka, mohon coba kembali!");
            }
        }
    }
}
