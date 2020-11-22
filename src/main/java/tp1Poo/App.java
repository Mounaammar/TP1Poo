package tp1Poo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class) ;

	public static void main(String[] args) throws LimiteVisiteurException, AnimalDansMauvaisSecteurException {
		// TODO Auto-generated method stub
		Zoo zoo= new Zoo();
		logger.info("what info ! ");
		logger.trace("what trace !");
		logger.warn("what warnin !");
		logger.error("what error ! ");
		logger.debug("what debug ! ");
		zoo.ajouterSecteur(TypaAnimal.chat);
		zoo.ajouterSecteur(TypaAnimal.chat);
		zoo.ajouterSecteur(TypaAnimal.chat);
		zoo.ajouterSecteur(TypaAnimal.chien);
		zoo.ajouterSecteur(TypaAnimal.chien);
		zoo.nouveauVisiteur();
		zoo.nouvelAnimal(new Chat("michou"));
		zoo.nouvelAnimal(new Chien("fox"));
		System.out.println(zoo.nombreAnimaux());
		logger.error("erreur");
		Secteur s = new Secteur(TypaAnimal.chat);
		Chat l1 = new Chat("jilber");
		Chat l2 = new Chat("jilber2");
		Chien l3 = new Chien("jilber3");
		s.ajouterAnimal(l1);
		s.ajouterAnimal(l2);
		Secteur s2 = new Secteur(TypaAnimal.chien);
		s2.ajouterAnimal(l3);
		
	}

}
