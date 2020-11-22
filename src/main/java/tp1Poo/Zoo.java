package tp1Poo;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager ;
import org.apache.logging.log4j.Logger ;


public class Zoo {
private int visiteurs;
private List<Secteur> secteursAnimaux;
private final int NB_MAX_VISITEURS=15;

public Zoo() {
	visiteurs=0;
	secteursAnimaux=new ArrayList<Secteur>();
}

public void ajouterSecteur(TypaAnimal typeAnimal) {
	secteursAnimaux.add(new Secteur(typeAnimal));
}
public void nouveauVisiteur() throws LimiteVisiteurException  {
	if(visiteurs==getLimiteVisiteur())
		throw new LimiteVisiteurException("le nombre maximal de visiteurs est atteint ");
	
		visiteurs++;
}
public int getLimiteVisiteur() {
	return NB_MAX_VISITEURS*secteursAnimaux.size();
}
public void nouvelAnimal(animal a) throws AnimalDansMauvaisSecteurException {
	getSecteurFromType(a.getTypeAnimal()).ajouterAnimal(a);
}

public int nombreAnimaux() {
	return secteursAnimaux.stream().mapToInt(x->x.getNombreAnimaux()).sum();
}

private Secteur getSecteurFromType(TypaAnimal type) {
	return secteursAnimaux.stream().filter(s -> s.obtenirType() == type).findFirst().orElse(null);
}

}

