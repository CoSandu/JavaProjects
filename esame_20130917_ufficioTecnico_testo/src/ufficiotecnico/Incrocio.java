package ufficiotecnico;

import java.util.*;

public class Incrocio {
	private ElementoTopografico strada1;
	private ElementoTopografico strada2;
	private boolean semaforo;
	
	public Incrocio(ElementoTopografico strada1, ElementoTopografico strada2, boolean semaforo) {
		this.strada1 = strada1;
		this.strada2 = strada2;
		this.semaforo = semaforo;
	}
	
	public ElementoTopografico getStrada1() {
		return strada1;
	}

	public void setStrada1(ElementoTopografico strada1) {
		this.strada1 = strada1;
	}

	public ElementoTopografico getStrada2() {
		return strada2;
	}

	public void setStrada2(ElementoTopografico strada2) {
		this.strada2 = strada2;
	}

	public boolean isSemaforo() {
		return semaforo;
	}

	public void setSemaforo(boolean semaforo) {
		this.semaforo = semaforo;
	}

	

}
