package lt.bit.vidinesKlases;

public class Masina {

    
    public Ratas prk = new Ratas("R20");
    public Ratas prd = new Ratas("R20");
    public Ratas gk = new Ratas("R22");
    public Ratas gd = new Ratas("R22");
    public Ratas atsarginis;
    
    public static class Ratas {
        private String parametrai;

        public Ratas(String p) {
            this.parametrai = p;
        }
    }
    
    public static class Vairas {
        
    }
}
