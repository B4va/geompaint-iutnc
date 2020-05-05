package modeles;

import java.util.ArrayList;

/**
 * Modélise un cercle
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnCercle extends FigureGeom {

	/**
	 * Constructeur
	 * @param pointsConstruction points permettant de construire la figure
	 */
	public UnCercle(ArrayList<UnPoint> pointsConstruction) {
		super(pointsConstruction);
	}
	
	@Override
	/**
	 * Enregistre les points de mémoire
	 */
	protected void iniPointsMemoire() {
		// modifier
		pointsMemoire = new ArrayList<>();
		int xA = pointsMemoire.get(0).getX();
		int yA = pointsMemoire.get(0).getY();
		int xB = pointsMemoire.get(1).getX();
		int yB = pointsMemoire.get(1).getY();
	}
}
