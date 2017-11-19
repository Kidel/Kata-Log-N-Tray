package com.logntray.bonofiglio;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginFrame extends JFrame {
	private static final long serialVersionUID = -8228227468907354176L;
	
	JButton blogin = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField txuser = new JTextField();
	JPasswordField pass = new JPasswordField();
	
	Util u = new Util();
	
	LoginFrame(String title, ActionListener actionListener){
		new LoginFrame(title);
		setActionLogin(actionListener);
	}

	LoginFrame(String title){
		super(title);
		
		setSize(320,250);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);

		panel.setLayout (null); 
		
		try {
			BufferedImage logoPicture = ImageIO.read(new File(u.getClassFilePath(), "images/logo.png"));
			JLabel picLabel = new JLabel(new ImageIcon(logoPicture));
			picLabel.setBounds(5,5,295,75);
	        panel.add(picLabel);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
		    setIconImage(ImageIO.read(new File(u.getClassFilePath(), "images/icon.png")));
		}
		catch (IOException exc) {
		    exc.printStackTrace();
		}

		txuser.setBounds(70,90,165,20);
		pass.setBounds(70,125,165,20);
		blogin.setBounds(105,160,90,20);

		panel.add(blogin);
	    panel.add(txuser);
		panel.add(pass);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setActionLogin(ActionListener actionListener){
		blogin.addActionListener(actionListener);
	}
	
	public String getLoginText() {
		return txuser.getText();
	}
	
	public String getPasswordText() {
		return new String(pass.getPassword());
	}
	
	public void setLoginText(String text) {
		txuser.setText(text);
	}
	
	public void setPasswordText(String text) {
		pass.setText(text);
	}
}
