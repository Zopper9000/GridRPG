package battle;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import character.Character;
import character.Monster;
import character.Player;

public class Battle extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Player
	private Player a;
	
	//Monster
	private Monster b;
	
	//Panel
	private JPanel panel;
	
	//Top panel
	private JPanel top;
	
	//Stats panels
	private JPanel statsA, statsB;
	
	//Battle between player and monster
	public Battle(Player a, Monster b)
	{
		this.a = a;
		this.b = b;
		
		//Make JFrame
		this.setTitle(a.getName() + " vs " + b.getName());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 200);
		
		//Start
		start();
		this.setVisible(true);
	}
	
	//Start function, makes everything
	public void start()
	{
		this.panel = new JPanel();
		this.panel.setLayout(new BorderLayout());
		
		//Initialize top
		top = new JPanel(new FlowLayout());
		
		//Add image of player
		top.add(new JLabel(new ImageIcon(a.img)));
		
		//Add label of player
		top.add(new JLabel(a.getName()));
		
		//Add vs
		top.add(new JLabel(" vs. "));
		
		//Add label of monster
		top.add(new JLabel(b.getName()));
		
		//Add image of monster
		top.add(new JLabel(new ImageIcon(b.img)));
		
		//Add top to panel
		panel.add(top, BorderLayout.PAGE_START);
		
		//Update statistics
		updateStats();
		
		panel.add(statsA, BorderLayout.WEST);
		panel.add(statsB, BorderLayout.EAST);
		
		this.getContentPane().add(panel);
		this.repaint();
	}
	
	//Update statistic displays
	public void updateStats()
	{
		a.calculate();
		statsA = new JPanel();
		statsA.setLayout(new BoxLayout(statsA, BoxLayout.Y_AXIS));
		
		statsA.add(new JLabel("HP: " + a.getHp() + "/" + a.getMaxHp()));
		statsA.add(new JLabel("MP: " + a.getMp() + "/" + a.getMaxMp()));
		statsA.add(new JLabel("Damage: " + a.getMinDamage() + "-" + a.getMaxDamage()));
		statsA.add(new JLabel("Critical Damage: " + a.getCriticalDamage()));
		statsA.add(new JLabel("Critical Change: " + a.getCriticalChance()));
		statsA.add(new JLabel("Accuracy: " + a.getAccuracy() * 100 + " %"));
		statsA.add(new JLabel("Resistance: " + a.getResistance() * 100 + "%"));
		
		
		statsB = new JPanel();
		statsB.setLayout(new BoxLayout(statsB, BoxLayout.Y_AXIS));
		
		statsB.add(new JLabel("HP: " + b.getHp() + "/" + b.getMaxHp()));
		statsB.add(new JLabel("MP: " + b.getMp() + "/" + b.getMaxMp()));
	}

	//Actionlistener
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
	//Kill
	public void exit()
	{
		setVisible(false);
	}
}
