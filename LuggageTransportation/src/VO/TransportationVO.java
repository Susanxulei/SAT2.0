package VO;

import java.util.Vector;

public class TransportationVO {
	
	String pno;
	String start;
	String destination;
	

	String cabin;
	String passengerType;
	
	double ticket;
	double cost;
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	
	public double getTicket() {
		return ticket;
	}
	public void setTicket(double ticket) {
		this.ticket = ticket;
	}
	Vector<LuggageVO> luggages;
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCabin() {
		return cabin;
	}
	public void setCabin(String cabin) {
		this.cabin = cabin;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public Vector<LuggageVO> getLuggages() {
		return luggages;
	}
	public void setLuggages(Vector<LuggageVO> luggages) {
		this.luggages = luggages;
	}
	public void setOneLuggage(LuggageVO luggage) {
		if (this.luggages == null)
			luggages = new Vector<LuggageVO>();
		this.luggages.add(luggage);
	}

}
