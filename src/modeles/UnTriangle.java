package modeles;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Modélise un triangle
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnTriangle extends UnPolygone {

	/**
	 * Constructeur
	 * @param pointsConstruction
	 * @param couleur
	 * @param plein
	 */
	public UnTriangle(ArrayList<UnPoint> pointsConstruction, Color couleur, boolean plein) {
		super(pointsConstruction, couleur, plein);
	}

}
