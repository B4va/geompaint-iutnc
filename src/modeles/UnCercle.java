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
		pointsMemoire = new ArrayList<>();
		UnPoint a = pointsSaisie.get(0);
		UnPoint b = pointsSaisie.get(1);
		int xA = a.getX();
		int yA = a.getY();
		int xB = b.getX();
		int yB = b.getY();
		int dist = (int)Math.sqrt((xB-xA)*(xB-xA) + (yB-yA)*(yB-yA));
		pointsMemoire.add(a);
		pointsMemoire.add(new UnPoint(xA+dist, yA));
	}
}
