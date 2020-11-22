package tp1Poo;

import java.io.Serializable;

public abstract class animal implements Serializable {

	protected String nomAnimal;
	protected TypaAnimal typeAnimal; 

	public String getNomAnimal() {
		return nomAnimal;
	}

	public TypaAnimal getTypeAnimal() {
		return typeAnimal;
	}
}