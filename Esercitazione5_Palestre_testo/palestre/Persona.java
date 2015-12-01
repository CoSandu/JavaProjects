package palestre;

public interface Persona extends Comparable<Persona>{
  public abstract String getNome();
  public abstract String getCognome();
  public abstract String getCodiceFiscale();
  public abstract PersonalTrainer getPersonalTrainer();
}