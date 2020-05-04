package modeles;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Modélise un rectangle
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnRectangle extends UnPolygone {

	/**
	 * Constructeur
	 * @param pointsConstruction
	 * @param couleur
	 * @param plein
	 */
	public UnRectangle(ArrayList<UnPoint> pointsConstruction, Color couleur, boolean plein) {
		super(pointsConstruction, couleur, plein);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Enregistre les points de saisie
	 */
	protected void iniPointsSaisie() {
		// modifier
		pointsSaisie = null;
	}
}
