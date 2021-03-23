package com.amine.tennis.utils;

import java.util.ArrayList;
import java.util.List;

public class SetResultContainer {

	List<String > setNumber = new ArrayList<>();
	List<String > p1result = new ArrayList<>();
	List<String > p2result = new ArrayList<>();
	public SetResultContainer()  {
		
		setNumber.add("");
		p1result.add("Player 1");
		p2result.add("Player 2");
	}
	public void addSetResult(int number,String p1resultv,String P2resultv) {
		setNumber.add(number!=0?"Set "+number:"");
		p1result.add(p1resultv);
		p2result.add(P2resultv);
		
	}
	public List<String> getSetNumber() {
		return setNumber;
	}
	public void setSetNumber(List<String> setNumber) {
		this.setNumber = setNumber;
	}
	public List<String> getP1result() {
		return p1result;
	}
	public void setP1result(List<String> p1result) {
		this.p1result = p1result;
	}
	public List<String> getP2result() {
		return p2result;
	}
	public void setP2result(List<String> p2result) {
		this.p2result = p2result;
	}
	
}
