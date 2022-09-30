package com.sujal.sas.candidate;

import java.util.ArrayList;

import com.sujal.sas.institute.Branch;

public class Candidate implements Comparable<Candidate> {
	public int id;
	public Category category;
	public int cetRank;	
	public ArrayList<Option> optionList;
	public boolean isAlloted;
	public int assignedInstitute;
	public Branch assignedBranch;
	
	public Candidate(int id,Category category) {
		this.id = id;
		this.category = category;
		this.optionList = new ArrayList<Option>(100);
		this.isAlloted = false;
		this.assignedInstitute = 0;
	}

	@Override
	public int compareTo(Candidate o) {
		int rank = o.cetRank;
		return this.cetRank - rank;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += id +"\t" + category + "\t"+ cetRank;
		if(isAlloted) {
			str += " " + assignedInstitute + " " +assignedBranch;
		}
		return str;
	}
}
