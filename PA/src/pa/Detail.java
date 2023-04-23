package pa;

public final class Detail implements Fail{ //implementation interface
    public final String certifiedDone = "Ada";
    public final String noCertified = "Tidak ada";

    public final void notifySuccessCreate(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" Data Berhasil Ditambahkan.");
        System.out.println("----------------------------------------------------------------");
    }
    
    public final void notifySuccessUpdate(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" Data Berhasil Diubah.");
        System.out.println("----------------------------------------------------------------");
    }
    
    public final void notifySuccessDelete(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" Data Berhasil Dihapus.");
        System.out.println("----------------------------------------------------------------");
    }

    @Override
    public void notifyFailCreate(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" Data Gagal Ditambahkan.");
        System.out.println("----------------------------------------------------------------");
    }

    @Override
    public void notifyFailUpdate(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" Data Gagal Diubah.");
        System.out.println("----------------------------------------------------------------");
    }

    @Override
    public void notifyFailDelete(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" Data Gagal Dihapus.");
        System.out.println("----------------------------------------------------------------");
    }
    
    @Override
    public void noData(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" Data Tidak Ada.");
        System.out.println("----------------------------------------------------------------");
    }

    @Override
    public void failChoose(){
        System.out.println("----------------------------------------------------------------");
        System.out.println(" Pilihan tidak ada.");
        System.out.println("----------------------------------------------------------------");
    }

}
