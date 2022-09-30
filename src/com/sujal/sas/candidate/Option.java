package com.sujal.sas.candidate;

import com.sujal.sas.institute.Branch;

public class Option{
	public int instituteId;
	public Branch instituteBranch;
	
	public Option(int id,Branch branch) {
		instituteId = id;
		instituteBranch = branch;
	}
	
	public String toString() {
		return instituteId + ": " +instituteBranch;
	}
	
}
