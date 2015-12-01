package palestre;

import java.util.Collection;

public interface PersonalTrainer extends Persona {
  public String getMatricola();
  public Collection<Persona> getClienti();
  public Collection<Persona> getClientiOrdinatiPerEtaDecrescente();
}