package tp1Poo;

import java.util.Comparator;

public class secteurComparateur implements Comparator<Secteur> {

	
	public int compare(Secteur s0, Secteur s1) {
		// TODO Auto-generated method stub
		return Integer.compare(s0.getNombreAnimaux(),s1.getNombreAnimaux());
	}

}
