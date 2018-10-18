/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartas;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import loquendo.tts.engine.TTSException;
import loquendo.tts.engine.TTSReader;
import loquendo.tts.engine.TTSSession;


/**
 *
 * @author abel
 */
public class Carta {
      
 JPanel mesa;   
 ArrayList cartas;
 String grupo;
 int numero;
 int x=10;int fx=1;
 int y=10;int fy=-1;
 Random random=new Random();
 JLabel label;
 
 public Carta(JPanel mesa,ArrayList cartas,String grupo,int numero){
super();
derecha=true;
this.mesa=mesa;
this.cartas=cartas;
this.grupo=grupo;
this.numero=numero;
label=new JLabel();
x=10+(int)(random.nextFloat()*(mesa.getWidth()-20));
y=10+(int)(random.nextFloat()*(mesa.getHeight()-20));
label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/"+grupo+"/"+numero+".jpg"))); 
 mesa.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(x,y,-1,-1));
 cartas.add(this); 
 label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {try{Clip clip;
     TTSSession hSession = null; 
        
        TTSReader hReader = null;
		try {
			/* Creation of a new session by using default configuration */
			hSession = new TTSSession();
                        if (null != hSession) {
				try { 
					/* Creation of a new reader instance */
					hReader = new TTSReader(hSession);
					/* Set the sound blaster as audio destination, stereo, linear and 32kHz samples rate */
					hReader.setAudio("LTTS7AudioBoard", null, 32000, "linear", 2);
					/* Load of Ludoviko voice with his default language */
					//hReader.setLanguage(new TTSLanguage("SpanishEs","SpanishEs"));
                                        hReader.loadPersona("Carmen",null,null);
					
                                        /* Read the Ludoviko demo sentence */
	                                 
                                        hReader.read(significado(), false, false);
                                                                              
				} catch (TTSException e) {
					e.printStackTrace();
				}
				hSession.delete();
			}
		} catch (TTSException e) {
			e.printStackTrace();
		}





     //  AudioInputStream audio2= AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/"+grupo+"/"+numero+".wav"));
    //clip = AudioSystem.getClip();
    //clip.open(audio2);
    //clip.start();
    
    
    
    }catch(Exception ex){ex.printStackTrace();}}});
 
 }

public boolean derecha;
public String significa=""; 
public boolean derecha(){return derecha;}
public void setDerecha(boolean derecha){this.derecha=derecha;}
public String significado() {return significa;}
public void setSignificado(String significa){this.significa=significa;}
public void voltea(){
if (!derecha())
label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/"+grupo+"/"+numero+".jpg")));
else label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/"+grupo+"/"+numero+"R.jpg")));
}

}
