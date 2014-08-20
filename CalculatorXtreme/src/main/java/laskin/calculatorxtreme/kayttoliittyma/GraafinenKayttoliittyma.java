package laskin.calculatorxtreme.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;

public class GraafinenKayttoliittyma implements Runnable {
    
     private JFrame frame;
     private ToimintoKirjasto kirjasto;

    public GraafinenKayttoliittyma(ToimintoKirjasto kirjasto) {
        this.kirjasto = kirjasto;
    }

    @Override
    public void run() {
        frame = new JFrame("CalculatorXtreme");
        frame.setPreferredSize(new Dimension(300, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridBagLayout asettelu = new GridBagLayout();
        container.setLayout(asettelu);
        
        JTextField tulostekentta = new JTextField();
        GridBagConstraints saadot1 = new GridBagConstraints();
        saadot1.weightx = 1.0;
        saadot1.weighty = 0.5;
        saadot1.fill = GridBagConstraints.HORIZONTAL;
        saadot1.insets = new Insets(10,10,10,10);
        saadot1.gridx = 0;
        saadot1.gridy = 0;
        container.add(tulostekentta, saadot1);
        
        JTextField syotekentta = new JTextField();
        GridBagConstraints saadot2 = new GridBagConstraints();
        saadot2.weightx = 1.0;
        saadot2.weighty = 0.5;
        saadot2.fill = GridBagConstraints.HORIZONTAL;
        saadot2.insets = new Insets(10,10,10,10);
        saadot2.gridx = 0;
        saadot2.gridy = 1;
        container.add(syotekentta, saadot2);
        
        JPanel kenttienNappaimisto = luoKenttienNappaimisto(syotekentta, tulostekentta);
        GridBagConstraints saadot5 = new GridBagConstraints();
        saadot5.weightx = 1.0;
        saadot5.weighty = 1.0;
        saadot5.fill = GridBagConstraints.BOTH;
        saadot5.gridheight = 2;
        saadot5.insets = new Insets(10,10,10,10);
        saadot5.gridx = 1;
        saadot5.gridy = 0;
        container.add(kenttienNappaimisto, saadot5);
        
        JPanel numeroNappaimisto = luoNumeroNappaimisto(syotekentta);
        GridBagConstraints saadot3 = new GridBagConstraints();
        saadot3.weightx = 1.0;
        saadot3.weighty = 1.0;
        saadot3.fill = GridBagConstraints.BOTH;
        saadot3.insets = new Insets(10,10,10,10);
        saadot3.gridx = 0;
        saadot3.gridy = 2;
        container.add(numeroNappaimisto, saadot3);
        
        JPanel laskutoimitusNappaimisto = luoLaskutoimitusNappaimisto(syotekentta);
        GridBagConstraints saadot4 = new GridBagConstraints();
        saadot4.weightx = 1.0;
        saadot4.weighty = 1.0;
        saadot4.fill = GridBagConstraints.BOTH;
        saadot4.insets = new Insets(10,10,10,10);
        saadot4.gridx = 1;
        saadot4.gridy = 2;
        container.add(laskutoimitusNappaimisto, saadot4);
        
        JPanel funktioNappaimisto = luoFunktioNappaimisto(syotekentta);
        GridBagConstraints saadot6 = new GridBagConstraints();
        saadot6.weightx = 1.0;
        saadot6.weighty = 1.0;
        saadot6.fill = GridBagConstraints.BOTH;
        saadot6.gridwidth = 2;
        saadot6.insets = new Insets(10,10,10,10);
        saadot6.gridx = 0;
        saadot6.gridy = 3;
        container.add(funktioNappaimisto, saadot6);
    }
    
    private JPanel luoNumeroNappaimisto(JTextField syotekentta) {
        JPanel nappaimisto = new JPanel(new GridLayout(3,4));
        
        JButton nappain1 = new JButton("1");
        nappain1.addActionListener(new NappaimenKirjoittaja("1", syotekentta));
        nappaimisto.add(nappain1);
        
        JButton nappain2 = new JButton("2");
        nappain2.addActionListener(new NappaimenKirjoittaja("2", syotekentta));
        nappaimisto.add(nappain2);
        
        JButton nappain3 = new JButton("3");
        nappain3.addActionListener(new NappaimenKirjoittaja("3", syotekentta));
        nappaimisto.add(nappain3);
        
        JButton nappain4 = new JButton("4");
        nappain4.addActionListener(new NappaimenKirjoittaja("4", syotekentta));
        nappaimisto.add(nappain4);
        
        JButton nappain5 = new JButton("5");
        nappain5.addActionListener(new NappaimenKirjoittaja("5", syotekentta));
        nappaimisto.add(nappain5);
        
        JButton nappain6 = new JButton("6");
        nappain6.addActionListener(new NappaimenKirjoittaja("6", syotekentta));
        nappaimisto.add(nappain6);
        
        JButton nappain7 = new JButton("7");
        nappain7.addActionListener(new NappaimenKirjoittaja("7", syotekentta));
        nappaimisto.add(nappain7);
        
        JButton nappain8 = new JButton("8");
        nappain8.addActionListener(new NappaimenKirjoittaja("8", syotekentta));
        nappaimisto.add(nappain8);
        
        JButton nappain9 = new JButton("9");
        nappain9.addActionListener(new NappaimenKirjoittaja("9", syotekentta));
        nappaimisto.add(nappain9);
        
        JButton nappain0 = new JButton("0");
        nappain0.addActionListener(new NappaimenKirjoittaja("0", syotekentta));
        nappaimisto.add(nappain0);
        
        JButton nappainSulkuAuki = new JButton("(");
        nappainSulkuAuki.addActionListener(new NappaimenKirjoittaja("(", syotekentta));
        nappaimisto.add(nappainSulkuAuki);
        
        JButton nappainSulkuKiinni = new JButton(")");
        nappainSulkuKiinni.addActionListener(new NappaimenKirjoittaja(")", syotekentta));
        nappaimisto.add(nappainSulkuKiinni);
        
        return nappaimisto;
    }
    
    private JPanel luoLaskutoimitusNappaimisto(JTextField syotekentta) {
        JPanel nappaimisto = new JPanel(new GridLayout(5,1));
        
        JButton nappainPlus = new JButton("+");
        nappainPlus.addActionListener(new NappaimenKirjoittaja("+", syotekentta));
        nappaimisto.add(nappainPlus);
        
        JButton nappainMiinus = new JButton("-");
        nappainMiinus.addActionListener(new NappaimenKirjoittaja("-", syotekentta));
        nappaimisto.add(nappainMiinus);
        
        JButton nappainKerto = new JButton("*");
        nappainKerto.addActionListener(new NappaimenKirjoittaja("*", syotekentta));
        nappaimisto.add(nappainKerto);
        
        JButton nappainJako = new JButton("/");
        nappainJako.addActionListener(new NappaimenKirjoittaja("/", syotekentta));
        nappaimisto.add(nappainJako);
        
        JButton nappainPotenssi = new JButton("'");
        nappainPotenssi.addActionListener(new NappaimenKirjoittaja("'", syotekentta));
        nappaimisto.add(nappainPotenssi);
        
        return nappaimisto;
    }
    
    private JPanel luoKenttienNappaimisto(JTextField syotekentta, 
            JTextField tulostekentta) {
        JPanel nappaimisto = new JPanel(new GridLayout(3,1));
        
        JButton nappainDel = new JButton("DEL");
        nappainDel.addActionListener(new ViimeisenMerkinPoistaja(syotekentta));
        nappaimisto.add(nappainDel);
        
        JButton nappainC = new JButton("C");
        nappainC.addActionListener(new KenttienTyhjaaja(syotekentta, 
                tulostekentta));
        nappaimisto.add(nappainC);
        
        JButton nappainEnter = new JButton("Enter");
        nappainEnter.addActionListener(new LausekkeenLaskija(syotekentta, 
                tulostekentta, kirjasto));
        nappaimisto.add(nappainEnter);
        
        return nappaimisto;
    }
    
    private JPanel luoFunktioNappaimisto(JTextField syotekentta) {
        JPanel nappaimisto = new JPanel(new GridLayout(0,4));
        
        JButton nappainSin = new JButton("sin");
        nappainSin.addActionListener(new NappaimenKirjoittaja("sin(", syotekentta));
        nappaimisto.add(nappainSin);
        
        JButton nappainCos = new JButton("cos");
        nappainCos.addActionListener(new NappaimenKirjoittaja("cos(", syotekentta));
        nappaimisto.add(nappainCos);
        
        return nappaimisto;
    }
    
    

    public JFrame getFrame() {
        return frame;
    }
}
