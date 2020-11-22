package tp1Poo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class AppTest {

private void addVisiteur(Zoo zoo , int max ) throws LimiteVisiteurException{
	for(int i=0;i<max;i++) {
		zoo.nouveauVisiteur();
	}
	
}
@Test
public void testNbVisiteurOK() {
	Zoo zoo1 = new Zoo();
	zoo1.ajouterSecteur(TypaAnimal.chat);
	Throwable e = null;

	try {
		addVisiteur(zoo1, 18);
	} catch (Exception ex) {
		e = ex;
	}

	assertTrue(e instanceof LimiteVisiteurException);

}
@Test
public void testNbAnimaux() {
	Throwable e = null;
	Zoo zoo = new Zoo();

	zoo.ajouterSecteur(TypaAnimal.chien);
	try {
		zoo.nouvelAnimal(new Chien("Rex"));
	} catch (AnimalDansMauvaisSecteurException exc) {
		e = exc;
	}

	assertFalse(e instanceof AnimalDansMauvaisSecteurException);
	assertEquals(1,zoo.nombreAnimaux());

}
@Test
public void testNombreAnimauxDansSecteur() throws AnimalDansMauvaisSecteurException{
Secteur s1= new Secteur(TypaAnimal.chat);
Secteur s2= new Secteur(TypaAnimal.chat);
assertEquals(0,s1.compareTo(s2));
animal l1= new Chat("miou");
s1.ajouterAnimal(l1);
assertTrue(s1.compareTo(s2)>0);
assertTrue(s2.compareTo(s1)<0);
secteurComparateur sc= new secteurComparateur();
sc.compare(s1,s2);

}
}
