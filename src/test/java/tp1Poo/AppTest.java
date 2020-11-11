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
}
