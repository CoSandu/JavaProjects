package agenziaviaggi;

public class PrenotazioneAlbergo extends Prenotazione{

	private String hotel;
	private String dataIn;
	private int notti;

	public PrenotazioneAlbergo(String hotel, String dataCheckIn, int numNotti, double importo){
		super(importo);
		this.hotel = hotel;
		this.dataIn = dataCheckIn;
		this.notti = numNotti;
	
	}
	
	public String getHotel(){
		return hotel;
	}
	
	public String getDataCheckIn(){
		return dataIn;
	}
	
	public int getNumNotti(){
		return notti;
	}
}
