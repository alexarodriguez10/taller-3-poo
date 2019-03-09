package tragamonedas;

import java.util.ArrayList;
import java.util.Objects;

public class Premio {
    private final ArrayList <Fruta> combinacionGanadora;
    private final double cantidadDinero;
    
    public Premio(double cantidadDinero, Fruta... frutas) {
        this.cantidadDinero = cantidadDinero;
        combinacionGanadora = new ArrayList<>();
        for(Fruta ft : frutas) {
            this.combinacionGanadora.add(ft);
        }
    }
    
    
    public ArrayList<Fruta> getCombinacionGanadora() { return combinacionGanadora; }
    public double getCantidadDinero() { return cantidadDinero; }
}
    
 