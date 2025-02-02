package main;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mode extends Panel {
    private JButton randomButton;
    private JButton chooseButton;
    private JButton backButton;
    private Image backgroundImage;

    Mode( Frame frame ){
        super();

        this.backgroundImage = new ImageIcon("res\\mode\\ModeBackground.png").getImage();
        setLayout(null);

        initRandomButton(frame);
        initChooseButton(frame);
        initBackButton(frame);  

    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    private void initRandomButton(Frame frame){
        ImageIcon randomIcon = new ImageIcon("res\\mode\\JButton_Random.png");
        randomButton= new JButton(randomIcon);
        randomButton.setBounds(450, 380, 200, 83);
        randomButton.setFocusPainted(false);
        randomButton.setBorder(BorderFactory.createEmptyBorder());
        randomButton.setOpaque(true);
        this.add(randomButton);

        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setMode("Random");
                frame.switchToChooseLevel();
            }
        });
    }

    private void initChooseButton(Frame frame){
        ImageIcon customizeIcon = new ImageIcon("res\\mode\\JButton_Customize.png");
        chooseButton= new JButton(customizeIcon);
        chooseButton.setBounds(640, 380, 190, 83);
        chooseButton.setFocusPainted(false);
        chooseButton.setBorder(BorderFactory.createEmptyBorder());
        chooseButton.setOpaque(true);
        this.add(chooseButton);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setMode("Choose");
                frame.switchToChooseLevel();
            }
        });
    }

    private void initBackButton(Frame frame){
        ImageIcon backIcon = new ImageIcon("res\\mode\\JButton_Back.png");
        backButton= new JButton(backIcon);
        backButton.setBounds(10, 416, 221, 216);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setOpaque(true);
        this.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.switchToGameInterface();
            }
        });
    }
    
}
