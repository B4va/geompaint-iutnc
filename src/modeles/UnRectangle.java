package modeles;

import java.util.ArrayList;

/**
 * Modélise un rectangle
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnRectangle extends UnPolygone {

	/**
	 * Constructeur
	 * @param pointsConstruction points permettant de construire la figure
	 */
	public UnRectangle(ArrayList<UnPoint> pointsConstruction) {
		super(pointsConstruction);
	}

	@Override
	/**
	 * Enregistre les points de mémoire
	 */
	protected void iniPointsMemoire() {
		pointsMemoire = new ArrayList<>();
		UnPoint a = pointsMemoire.get(0);
		UnPoint b = pointsMemoire.get(1);
		int xA = a.getX();
		int yA = a.getY();
		int xB = b.getX();
		int yB = b.getY();
		pointsMemoire.add(a);
		// ajout du point haut-droite
		pointsMemoire.add(new UnPoint((xA > xB) ? xA : xB, yA));
		pointsMemoire.add(b);
		// ajout du point bas-gauche
		pointsMemoire.add(new UnPoint(xA, (yA > yB) ? yA : yB));	
	}
}
