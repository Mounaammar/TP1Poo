package tp1Poo;

import com.thoughtworks.xstream.XStream;

import java.beans.XMLEncoder;
import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger logger = LogManager.getLogger(App.class) ;

	public static void main(String[] args) throws LimiteVisiteurException, AnimalDansMauvaisSecteurException, IOException {
		// TODO Auto-generated method stub
		interfaceUtilisateur();
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
	private static void interfaceUtilisateur() throws IOException{
	boolean flag=true;
	Zoo zoo =new Zoo();
	zoo.setName("Super zoo");
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(flag) {
			  System.out.println("" + zoo.getName() + " : Que souhaitez vous faire ?");
			  System.out.println("1 : Creer un nouveau zoo");
			  System.out.println("2 : Ajouter un nouvel secteur");
			  System.out.println("3 : Ajouter un nouvel animal");
			  System.out.println("4 : Ajouter un visiteur");
			  System.out.println("5 : Sauvegarder mon zoo");
			  System.out.println("6 : Charger un zoo");
			  System.out.println("0 : Pour quitter");
			  System.out.println("Votre choix");
			  String s =br.readLine();
			  switch (s) {
			  case "1":
		          System.out.println("Quel est le nom du nouveau zoo ?");
		          String name = br.readLine();
		          zoo = new Zoo();
		          zoo.setName(name);
		          System.out.println("Zoo " + name + " cr�� !");
			    break;
		  		case "2": 
		  			 System.out.println("Quel type d'animal ?");
		  			  String typeS = br.readLine();
		  			  try {
			  			  TypaAnimal type = TypaAnimal.valueOf(typeS);
			  			  zoo.ajouterSecteur(type);
		  			  }
		  			  catch (Exception e) {
			 	  			 System.out.println(typeS + "n'est pas un type reconnu.");
		  			  }
		  		  break;
		  		case "3": 
		  			 System.out.println("Quel type d'animal ?");
		  			 String typeA = br.readLine();
		  			 try {
			  			  TypaAnimal type = TypaAnimal.valueOf(typeA);
			  			  
			  			  System.out.println("Quel est le nom de l'animal ?");
				          String nameA = br.readLine();
			  			  animal a;
			  			  if(type == TypaAnimal.chat) {
			  				  a = new Chat(nameA);
			  			  }else if(type == TypaAnimal.chien) {
				  				  a = new Chien(nameA);
				  			 }
		  			  }
		  			  catch (Exception e) {
			 	  			 System.out.println(typeA + "n'est pas un type reconnu.");
		  			  }
		  			 break;
		  		case "4": 
					try {
						zoo.nouveauVisiteur();
			  			System.out.println("Ajout d'un visiteur.");
					} catch (LimiteVisiteurException e) {
			  			System.out.println("Impossible : zoo plein !");
					}
		  			 break;
		  		case "5": 
		  			serializeZoo(zoo);
		  			 System.out.println("Zoo sauvergard� !");
		  			 break;
		  		case "6": 
		  			deSerializeZoo(zoo);
		  			 System.out.println("Zoo charg� !");
		  			 break;
		  		case "0":
		  			 System.out.println("Au revoir.");
		  			 flag = false;
		  			 break;
		  			
			  }
		}
	}
	public static void serializeZoo(Zoo zoo) {
		XMLEncoder encoder = null;
		
		try {
			XStream xstream = new XStream();
			xstream.toXML(zoo, new FileOutputStream(new File("zoo.xml")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			  if(encoder != null)
				  encoder.close();
		  }
	}
	public static void deSerializeZoo(Zoo zoo) throws IOException {
		FileInputStream file;
	
		try {
			XStream xstream = new XStream();
			file= new FileInputStream("zoo.xml");
			zoo=(Zoo)xstream.fromXML(file);
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
