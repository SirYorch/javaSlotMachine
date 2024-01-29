package Win;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Frame extends JFrame{
    public SlotPane slots;
    public JPanel botones;
    public Main m;
    
    public JTextField col1;
    
    public JTextField col2;
    
    public JTextField col3;
    
    public Frame(Main m){
        //esto es solo para colocar los Paneles de Botones y el Panel de Slots para el moviimento de la maquina 
        this.m = m;
        JOptionPane.showInternalMessageDialog(null, "En este programa, Si no se coloca el tiempo, este sera el default, que esta probado con animaciones, \nen caso de colocar un numero por columna, este mientras mayor sea, sera más rapido, coloqué limites\npara que no pueda ser muy rapido. el numero en velocidad debe ser entre 1(lento) a 15(rapido)");
        Color background= new Color(210,210,210);
        
        this.setVisible(true);
        Insets i = this.getInsets();
        this.setLayout(null);
        this.setSize(450, 540+i.top);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel(){
            @Override
            public void paint(Graphics g){
                g.setColor(Color.red);
                g.drawRect(2, 83, 345, 103);
            }
        };
        p.setBounds(50,50,350,300);
        this.add(p);
        
        this.setTitle("Slot Machine"); 
        this.setResizable(false);
        
        JLabel tiempo = new JLabel("Tiempo:");
        tiempo.setBounds(1,25,100,20);
        this.add(tiempo);
        
        col1=new JTextField();
        col1.setBounds(55, 25, 100, 20);
        this.add(col1);
        
        col2=new JTextField();
        col2.setBounds(175, 25, 100, 20);
        this.add(col2);
        
        col3=new JTextField();
        col3.setBounds(295, 25, 100, 20);
        this.add(col3);
        
        
        slots = new SlotPane();
        slots.setBackground(background);
        slots.setBounds(50, 50, 350, 300);
        this.add(slots);
        
        botones = new Botones(this);
        botones.setBackground(background);
        botones.setBounds(50, 370, 350,120);
        this.add(botones);
        
        this.setLocationRelativeTo(null);
    }
    
}

class Botones extends JPanel implements ActionListener{
    
    public JButton parar1;
    public JButton parar2;
    public JButton parar3;
    
    public JButton iniciar1;
    public JButton iniciar2;
    public JButton iniciar3;
    
    public JTextField ingreso;
    public JButton inicio;
    public JButton fin;
    
    public Frame f;
    public Botones(Frame f){
        
        this.f=f;
        this.setLayout(null);
        
        
        iniciar1 = new JButton("Iniciar");
        iniciar1.setBounds(5, 10, 110, 25);
        iniciar1.addActionListener(this);
        this.add(iniciar1);
        
        iniciar2 = new JButton("Iniciar");
        iniciar2.setBounds(120, 10, 110, 25);
        iniciar2.addActionListener(this);
        this.add(iniciar2);
        
        iniciar3 = new JButton("Iniciar");
        iniciar3.setBounds(235, 10, 110, 25);
        iniciar3.addActionListener(this);
        this.add(iniciar3);
        
        parar1 = new JButton("Parar");
        parar1.setBounds(5, 45, 110, 25);
        parar1.addActionListener(this);
        this.add(parar1);
        
        parar2 = new JButton("Parar");
        parar2.setBounds(120, 45, 110, 25);
        parar2.addActionListener(this);
        this.add(parar2);
        
        parar3 = new JButton("Parar");
        parar3.setBounds(235, 45, 110, 25);
        parar3.addActionListener(this);
        this.add(parar3);
        
        ingreso = new JTextField();
        ingreso.setBounds(5, 80, 110, 30);
        this.add(ingreso);

        inicio = new JButton("<html><center>Iniciar<br>Todos</center></html>");
        inicio.setBounds(120, 80, 110, 30);
        inicio.addActionListener(this);
        this.add(inicio);

        fin = new JButton("<html><center>Parar<br>Todos</center></html>");
        fin.setBounds(235, 80, 110, 30);
        fin.addActionListener(this);
        this.add(fin);
        
    }
    
    //////todo el codigo aqui es para que solo se pueda iniciar con los botones de iniciar,
    ////y que solo se pueda detener con los botones de detener
    
    
    boolean detenido1=true;
    boolean detenido2=true;
    boolean detenido3=true;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==iniciar1){
            ///boton para iniciar el slot 1;
            if(detenido1){
                f.m.setSpeed();
                f.m.iniciarHilo(1);
                detenido1=false;
                
            }
        } else
        if(e.getSource()==iniciar2){
            ///boton para iniciar el slot 2;
            if(detenido2){
                f.m.setSpeed();
                f.m.iniciarHilo(2);
                detenido2=false;
                
            }
        }else
        if(e.getSource()==iniciar3){
            ///boton para iniciar el slot 3;
            if(detenido3){
                f.m.setSpeed();
                f.m.iniciarHilo(3);
                detenido3=false;
            }
        }else
        if(e.getSource()==parar1){
            ///boton para detener el slot 1;
            if(!detenido1){
                iniciar1.removeActionListener(this);
                f.m.detenerHilo(1);
                detenido1=true;
            }
            if(detenido1&&detenido2&&detenido3){
            comprobarWin();
            }
        }else
        if(e.getSource()==parar2){
            ///boton para detener el slot 2;
            if(!detenido2){
                iniciar2.removeActionListener(this);
                f.m.detenerHilo(2);
                detenido2=true;
            }
            if(detenido1&&detenido2&&detenido3){
            comprobarWin();
            }
        }else
        if(e.getSource()==parar3){
            
            ///boton para detener el slot 3;
            if(!detenido3){
                iniciar3.removeActionListener(this);
                f.m.detenerHilo(3);
                detenido3=true;
            }
            if(detenido1&&detenido2&&detenido3){
            comprobarWin();
            }
        }else if(e.getSource()==inicio){
            ///boton para iniciar todos los slots;
            if((ingreso.getText().equals(""))){
                f.m.setSpeed(0);
            }else {
                f.m.setSpeed(Integer.parseInt(ingreso.getText() ));
            }
            if(detenido1){
                f.m.iniciarHilo(1);
                detenido1=false;
            }
            if(detenido2){
                f.m.iniciarHilo(2);
                detenido2=false;
            }
            if(detenido3){
                f.m.iniciarHilo(3);
                detenido3=false;
            }
            
            
            
        }else
        if(e.getSource()==fin){
            ///boton para finalizar todos los slots;
            if(!detenido1){
                iniciar1.removeActionListener(this);
                inicio.removeActionListener(this);
                f.m.detenerHilo(1);
                detenido1=true;
            }
            if(!detenido2){
                
                iniciar2.removeActionListener(this);
                f.m.detenerHilo(2);
                detenido2=true;
            }
            if(!detenido3){
                
                iniciar3.removeActionListener(this);
                f.m.detenerHilo(3);
                detenido3=true;
            }
            if(detenido1&&detenido2&&detenido3){
                comprobarWin();
            }
            
        }
        
    }
    
    
    public void comprobarWin() {
        Thread d = new Thread(){

            //aqui saco un nuevo hilo, porque si hago el sleep en el thread del gui, se detiene el frame y no se ve la animacion
            @Override
            public void run(){
                
                while(!(((f.slots.cubo1.pos1==52)||(f.slots.cubo1.pos2==52)||(f.slots.cubo1.pos3==52)||(f.slots.cubo1.pos4==52))&&((f.slots.cubo2.pos1==52)||(f.slots.cubo2.pos2==52)||(f.slots.cubo2.pos3==52)||(f.slots.cubo2.pos4==52))&&((f.slots.cubo3.pos1==52)||(f.slots.cubo3.pos2==52)||(f.slots.cubo3.pos3==52)||(f.slots.cubo3.pos4==52)))){
                    try {
                        sleep(100);
                    } catch (InterruptedException ex) {
                        
                    }
                }
                
                if((f.slots.cubo1.pos1 == f.slots.cubo2.pos1&& f.slots.cubo1.pos1==f.slots.cubo3.pos1)||(f.slots.cubo1.pos2 == f.slots.cubo2.pos2&& f.slots.cubo1.pos2==f.slots.cubo3.pos2)||(f.slots.cubo1.pos1 == f.slots.cubo2.pos3&& f.slots.cubo1.pos3==f.slots.cubo3.pos3)){

                    JOptionPane.showMessageDialog(null, "Ganaste", "Win_Screen", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Vuelva a intentar", "Loose_Screen", JOptionPane.INFORMATION_MESSAGE);
                }
                
                iniciar1.addActionListener(Botones.this);
                iniciar2.addActionListener(Botones.this);
                iniciar3.addActionListener(Botones.this);
                inicio.addActionListener(Botones.this);
            }

        };
        d.start();
    }
    
    
    
}

class SlotPane extends JPanel{
    
    Slot cubo1;
    Slot cubo2;
    Slot cubo3;
    
    public SlotPane(){
        this.setLayout(null);
        Color b = new Color(100,100,100);
        cubo1 = new Slot();
        cubo1.setBounds(5, 33, 100, 225);
        cubo1.setBackground(b);
        this.add(cubo1);
        
        cubo2 = new Slot();
        cubo2.setBounds(125, 33, 100, 225);
        cubo2.setBackground(b);
        this.add(cubo2);
        
        cubo3 = new Slot();
        cubo3.setBounds(245, 33, 100, 225);
        cubo3.setBackground(b);
        this.add(cubo3);
        
        
    }
    
    
}
