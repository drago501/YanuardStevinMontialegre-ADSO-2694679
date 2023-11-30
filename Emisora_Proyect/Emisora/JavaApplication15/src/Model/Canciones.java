package Model;

public class Canciones {
    private String nombreC1;
    private String nombreC2;
    private String nombreC3;

    public void setNombreC1(String nombreC1) {
        this.nombreC1 = nombreC1;
    }

    public void setNombreC2(String nombreC2) {
        this.nombreC2 = nombreC2;
    }

    public void setNombreC3(String nombreC3) {
        this.nombreC3 = nombreC3;
    }

   

    public Canciones() {
         this.nombreC1 = nombreC1;
         this.nombreC2 = nombreC2;
          this.nombreC3 = nombreC3;
    }

    public String getNombreC1() {
        return nombreC1;
    }

    public String getNombreC2() {
        return nombreC2;
    }

    public String getNombreC3() {
        return nombreC3;
    }

   
}
