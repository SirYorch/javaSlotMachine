package Win;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Slot extends JPanel{
    JLabel label;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    int pos1;
    int pos2;
    int pos3;
    int pos4;
    ImageIcon icono;
    ImageIcon icono1;
    ImageIcon icono2;
    ImageIcon icono3;
    
            
    public Slot(){
        this.setLayout(null);
        icono = new ImageIcon("src/Slot/Oso.jpg");
        icono1 = new ImageIcon("src/Slot/siete.jpg"); 
        icono2 = new ImageIcon("src/Slot/sandia.jpg");
        icono3 = new ImageIcon("src/Slot/casco.jpg"); 
        
        label = new JLabel(icono);
        label1 = new JLabel(icono1);
        label2 = new JLabel(icono2);
        label3 = new JLabel(icono3);
        
        pos1 = -50;
        pos2 = 52;
        pos3 = 154; 
        pos4 = 256;
        
        label.setBounds(0, pos1, icono.getIconWidth(), icono.getIconHeight());
        label1.setBounds(0, pos2, icono.getIconWidth(), icono.getIconHeight());
        label2.setBounds(0, pos3, icono.getIconWidth(), icono.getIconHeight());
        label3.setBounds(0, pos4, icono.getIconWidth(), icono.getIconHeight());
        
        this.add(label);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        label.setBounds(0, pos1, icono.getIconWidth(), icono.getIconHeight());
        label1.setBounds(0, pos2, icono.getIconWidth(), icono.getIconHeight());
        label2.setBounds(0, pos3, icono.getIconWidth(), icono.getIconHeight());
        label3.setBounds(0, pos4, icono.getIconWidth(), icono.getIconHeight());
    }
    
    
    public void repintar(){
        
    }
    public void rotar(){
        pos1+=2;
        pos2+=2;
        pos3+=2;
        pos4+=2;
        if(pos1>=258){
            pos1 = -150;
        } else if(pos2>=258){
            pos2 = -150;
        } else if(pos3>=258){
            pos3 = -150;
        } else if(pos4>=258){
            pos4 = -150;
        }
    }
}