/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.pesos;

import Utils.FunctionNumeric;
import Utils.FunctionString;

/**
 *
 * @author bonil
 */
public class convercionPesos {

    private Double entrada;

    private Double salida;

    public Double getEntrada() {
        return entrada;
    }

    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    public Double getSalida() {
        return salida;
    }

    public void setSalida(Double salida) {
        this.salida = salida;
    }

    

    //Objeto de la clase FunctionNumeric
    FunctionNumeric fn = new FunctionNumeric();

    //Objeto de la clase FunctionString
    FunctionString fs = new FunctionString();

    
      public void Pesos() {        
        this.setEntrada(fn.InputDoubleNumericScanner("Digite los pesos Colombianos : "));
        this.setSalida((this.getEntrada()*0.00024));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" pesos colombianos a Dolares es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()*733.51));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" pesos colombianos a Bolivares es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()*0.00088));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" pesos colombianos a Soles es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()*0.036784934));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" pesos colombianos a Pesetas es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()*0.00021));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" pesos colombianos a Francos es: "+this.getSalida()+"\n");
    }       
    
    public void Dolares(){
        this.setEntrada(fn.InputDoubleNumericScanner("Digite los Dolares : "));
        this.setSalida((this.getEntrada()* 4140.21));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Dolares a pesos Colombianos es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 3006640));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Dolares a Bolivares es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 3.66));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Dolares a Soles es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 151.155));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Dolares a Pesetas es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 0.87));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Dolares a Francos es: "+this.getSalida()+"\n");
    }
    
    public void Bolivares(){
        this.setEntrada(fn.InputDoubleNumericScanner("Digite los Bolivares : "));
        this.setSalida((this.getEntrada()* 0.00136318));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Bolivares a pesos Colombianos es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 0.00000033250885));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Bolivares a Dolares es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 0.00000122247));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Bolivares a Soles es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 0.0000000512566));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Bolivares a Pesetas es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 0.000000294833 ));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Bolivares a Francos es: "+this.getSalida()+"\n");
    }
    
     public void Soles(){
        this.setEntrada(fn.InputDoubleNumericScanner("Digite los Soles : "));
        this.setSalida((this.getEntrada()* 1130.86));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Soles a pesos Colombianos es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 0.27));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Soles a Dolares es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 8.2071284));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Soles a Bolivares es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 41.1686 ));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Soles a Pesetas es: "+this.getSalida()+"\n");
        this.setSalida((this.getEntrada()* 0.24 ));
        fs.ShowScanner("La conversión de "+this.getEntrada()+" Soles a Francos es: "+this.getSalida()+"\n");
    }
    

}
