package controleurs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import modeles.Caneva;
import vues.MenuVue;

/**
 *
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
 public class MenuControleur implements ActionListener, ItemListener {
	 	private MenuVue menu;
		private Caneva caneva;
		
		/**
		 * Constructeur qui permet d'initialiser:
		 * @param unMenu pour la vue traitée par cette classe,
		 * @param unCaneva pour lier les actions au Caneva de l'application
		 * */
		public MenuControleur(MenuVue unMenu,Caneva unCaneva){
			this.menu = unMenu;
			this.caneva = unCaneva;
			this.menu.setButtonLister(this);
		}
		
		/**
		 * Récupération et traitement des cliques des boutons de l'application.
		 * */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			/**
			 * Récupération du bouton sous forme de numéro, 
			 * pour faire le traitement par un switch.
			 * */
			JButton source = (JButton)arg0.getSource();
			int button = this.menu.whoIsButton(source);
			
			switch(button) {
				case 1://carre

					break;
				
				case 2://triangle
					
					break;
				
				case 3://cercle
					
					break;
			
				case 4://polygone
					
					break;
					
				case 5://translate
					
					break;
					
				case 6://modifier
					
					break;
			}
		}
		/**
		 * Récupération et traitement des changements de valeurs du combobox,
		 * par index de séléction.
		 * */
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			JComboBox combobox = (JComboBox)arg0.getSource();
			switch (combobox.getSelectedIndex()) {
			case 0 ://noir 
				
				break;
				
			case 1 ://jaune

				break;
				
			case 2 ://vert

				break;
					
			case 3 ://bleu

				break;
			
			case 4 ://rouge

				break;
				
			case 5 ://rose

				break;
				
			case 6 ://gris

				break;
				
			case 7 ://gris foncé

				break;
				
			default ://noir par défaut

			}
			
		}		
 }
