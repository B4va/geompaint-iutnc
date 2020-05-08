package controleurs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

import modeles.Caneva;
import modeles.Forme;
import vues.MenuVue;

/**
 * Gestionnaire des événements liés au menu
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
 public class MenuControleur implements ActionListener, ItemListener,FocusListener {
	 
	 	private MenuVue menu;
	 	
		
		/**
		 * Constructeur permettant d'initialiser la gestion d'événement
		 * @param unMenu pour la vue traitée par cette classe,
		 * @param unCaneva pour lier les actions au Caneva de l'application
		 * */
		public MenuControleur(MenuVue unMenu){
			this.menu = unMenu;
			this.menu.setButtonListener(this);
		}
		
		/**
		 * Récupère et traite les boutons de l'application
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			/**
			 * Récupération du bouton sous forme de numéro, 
			 * pour faire le traitement par un switch
			 * */
			JButton source = (JButton)arg0.getSource();
			Caneva can = Caneva.getCaneva();
			int button = this.menu.whoIsButton(source);
			switch(button) {
				case 1://carre
					can.setForme(Forme.RECTANGLE);
					can.setSelection(null);
					can.display();
					break;
				
				case 2://triangle
					can.setForme(Forme.TRIANGLE);
					can.setSelection(null);
					can.display();
					break;
				
				case 3://cercle
					can.setForme(Forme.CERCLE);
					can.setSelection(null);
					can.display();
					break;
			
				case 4://polygone
					can.setForme(Forme.POLYGONE);
					can.setSelection(null);
					can.display();
					break;
					
				case 5://plein
					can.setPlein(!can.isPlein());
					if(can.getSelection() != null) {
						can.getSelection().setPlein(can.isPlein());
						can.display();
					}
					if (can.isPlein()) {
						source.setBorder(new MatteBorder(3, 3, 3, 3, Color.DARK_GRAY));
					} else {
						source.setBorder(new MatteBorder(1, 1, 1, 1, Color.GRAY));
					}
					break;
					
				case 6://selection
					can.setForme(null);
					break;
					
				case 7://effacer
					if(can.getFigures().size() > 0) {
						int n = JOptionPane.showConfirmDialog(new JOptionPane(), "Tout effacer ?", null, JOptionPane.YES_NO_OPTION);
						//oui = 0; non = 1
						if (n == 0) {
							can.clearFigures();
							can.setForme(null);
							can.setSelection(null);
							can.display();
						}
					}
					break;
			}
			//menu.setEnabled(button);
		}
		
		/**
		 * Récupère et traite les changements de valeurs du combobox
		 * par index de séléction
		 */
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			JComboBox<?> combobox = null;
			if (arg0.getSource() instanceof JComboBox<?>) {				
				combobox = (JComboBox<?>)arg0.getSource();
			}
			Caneva can = Caneva.getCaneva();
			switch (combobox.getSelectedIndex()) {
			case 0 ://noir 
				if(can.getSelection() != null) {
					can.getSelection().setCouleur(Color.BLACK);
				}

				can.setCouleur(Color.BLACK);
				break;
				
			case 1 ://jaune
				if(can.getSelection() != null) {
					can.getSelection().setCouleur(Color.YELLOW);
				}

				can.setCouleur(Color.YELLOW);
				break;
				
			case 2 ://vert
				if(can.getSelection() != null) {
					can.getSelection().setCouleur(Color.GREEN);
				}
				can.setCouleur(Color.GREEN);
				break;
					
			case 3 ://bleu
				if(can.getSelection() != null) {
					can.getSelection().setCouleur(Color.BLUE);
				}
				can.setCouleur(Color.BLUE);
				break;
			
			case 4 ://rouge
				if(can.getSelection() != null) {
					can.getSelection().setCouleur(Color.RED);
				}
				can.setCouleur(Color.RED);
				break;
				
			case 5 ://rose
				if(can.getSelection() != null) {
					can.getSelection().setCouleur(Color.PINK);
				}
				can.setCouleur(Color.PINK);
				break;
				
			case 6 ://gris
				if(can.getSelection() != null) {
					can.getSelection().setCouleur(Color.GRAY);
				}
				can.setCouleur(Color.GRAY);
				break;
				
			case 7 ://gris foncé
				if(can.getSelection() != null) {
					can.getSelection().setCouleur(Color.DARK_GRAY);
				}
				can.setCouleur(Color.DARK_GRAY);
				break;
				
			default ://noir par défaut
				can.setCouleur(Color.BLACK);
			}
			if (can.getSelection() != null) {
				can.display();
			}
		}

		/**
		 * Formatte le bouton sélectionné
		 * @param arg0 événement
		 */
		@Override
		public void focusGained(FocusEvent arg0) {
			JButton button =(JButton)arg0.getSource();
			button.setBorder(new MatteBorder(3, 3, 3, 3, Color.DARK_GRAY));

		}

		/**
		 * Formatte le bouton désélectionné
		 * @param arg0 événement
		 */
		@Override
		public void focusLost(FocusEvent arg0) {
			JButton button =(JButton)arg0.getSource();
			button.setBorder(new MatteBorder(1, 1, 1, 1, Color.GRAY));
		}		
 }
