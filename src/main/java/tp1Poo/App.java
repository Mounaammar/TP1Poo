package tp1Poo;

public class App {

	public static void main(String[] args) throws LimiteVisiteurException, AnimalDansMauvaisSecteurException {
		// TODO Auto-generated method stub

		Zoo zoo= new Zoo();
		
		zoo.ajouterSecteur(TypaAnimal.chat);
		zoo.ajouterSecteur(TypaAnimal.chat);
		zoo.ajouterSecteur(TypaAnimal.chat);
		zoo.ajouterSecteur(TypaAnimal.chien);
		zoo.ajouterSecteur(TypaAnimal.chien);
		zoo.nouveauVisiteur();
		zoo.nouvelAnimal(new Chat("michou"));
		zoo.nouvelAnimal(new Chien("fox"));
		System.out.println(zoo.nombreAnimaux());
	}

}
