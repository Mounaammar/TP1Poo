package tp1Poo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Secteur implements Comparable<Secteur>, Serializable {
private TypaAnimal typeAnimauxDansSecteur;
List<animal> animauxDansSecteur;

public Secteur(TypaAnimal type) {
	typeAnimauxDansSecteur =type;
	animauxDansSecteur=new ArrayList<animal>();
}

public void ajouterAnimal(animal l) throws AnimalDansMauvaisSecteurException{
	if (l.getTypeAnimal()!=typeAnimauxDansSecteur)
		throw new AnimalDansMauvaisSecteurException ("animal dans mauvais secteur");
	animauxDansSecteur.add(l);
}
public int getNombreAnimaux() {
	return animauxDansSecteur.size();
}
public TypaAnimal obtenirType() {
	return typeAnimauxDansSecteur;
}

@Override
public int compareTo(Secteur s) {
	
	return getNombreAnimaux()-s.getNombreAnimaux();
}


}

