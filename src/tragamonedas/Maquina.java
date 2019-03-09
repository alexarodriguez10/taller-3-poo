package tragamonedas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Maquina {
    private final int numeroCasillas;
    private double precioJugada;
    private double credito;
    private final HashSet <Premio> premios = new HashSet<>();
    
    public Maquina(int numeroCasillas, double precio, Premio... premios) {
        this.numeroCasillas = numeroCasillas;
        this.precioJugada = precio;
        for(Premio pt : premios) {
            this.premios.add(pt);
        }
         
        
    }

    
    public int getNumeroCasillas() { return numeroCasillas; }
    public double getPrecioJugada() { return precioJugada; }
    public double getCredito() { return credito; }
    
    
    public void setPrecioJugada(double precioJugada) { this.precioJugada = precioJugada; }
    
  
    public void incrementarCredito(double credito) {
        this.credito += credito;
    }
    
    private ArrayList<Fruta> generarCombinacion() {
        ArrayList<Fruta> combinacion = new ArrayList<>(this.numeroCasillas);
        Random random = new Random();
        Fruta[] frutas = Fruta.values();
        for(int i = 0; i < this.numeroCasillas; i++) {
            Fruta fruta = frutas[random.nextInt(frutas.length)];
            combinacion.add(fruta);
        }
        
        return combinacion;
    }
    
    public ArrayList<Fruta> jugar() {
        if(this.credito >= this.precioJugada) {
            this.credito -= this.precioJugada;
            ArrayList <Fruta> combinacionActual, combPremio;
            combinacionActual = this.generarCombinacion();
            for(Premio pt : this.premios) {
                combPremio = pt.getCombinacionGanadora();
                if(combinacionActual.equals(combPremio)) {
                    this.credito += pt.getCantidadDinero();
                }
            }
            return combinacionActual;
        }
        
            return null;
    }
    
    
}
