package Win;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MovementThread extends Thread{
    Slot s;
    Frame f;
    Main m;
    int velocidad;
    public MovementThread(Slot s,Frame f,Main m){
        this.f = f;
        this.s=s;
        this.m=m;
        velocidad = 5;
    }
    @Override
    public void run() 
    {
        while (true) 
        {   
            s.rotar();
            s.repaint();
            
            try {
                sleep(velocidad);
            } catch (InterruptedException ex) {
                
                ///este es un metodo para que el slot se detenga en un dato especifico
                //y de forma mas lenta()
                
                interrumpir();
                
                while(true){
                    try {
                        sleep(2000);                       
                        
                    } catch (InterruptedException ex1) {
                        
                        break;
                        
                    }
                }
            }
            
        }
    }
    public void setVelocidad(int velocidad){
        if(velocidad>=1 && velocidad <=15){
            this.velocidad=16 - velocidad;
        } else {
            this.velocidad=5;
        }
    }
    
    public void interrumpir(){
        int dato = velocidad;
        while(s.pos1!=52&&s.pos2 !=52&&s.pos3!=52&&s.pos4!=52){
            s.rotar();
            s.repaint();
            try {
                sleep(dato);
            } catch (InterruptedException ex) {
                Logger.getLogger(MovementThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(dato>5){
                dato+=4;
            }else{
                dato*=2.5;
            }
        }
    }
}
