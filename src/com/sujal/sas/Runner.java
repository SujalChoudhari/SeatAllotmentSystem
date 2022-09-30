package com.sujal.sas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import com.sujal.sas.candidate.Candidate;
import com.sujal.sas.candidate.Category;
import com.sujal.sas.candidate.Option;
import com.sujal.sas.institute.Branch;
import com.sujal.sas.institute.Institute;

public class Runner {
	static ArrayList<Candidate> candidates;
	static ArrayList<Institute> institutes;


	public static void start() {
		System.out.println("Started...");
		candidates = new ArrayList<Candidate>(100_000);
		institutes = new ArrayList<Institute>(10);
		
		// Create Random Candidates
		for (int i = 0; i < 100_000; i++) {
			candidates.add(createRandomCandidate(i));
		}
		System.out.println("Candidates Created \nCreating Institutes...");
		
		// Create Random Institutes
		for (int i = 0; i < 100; i++) {
			institutes.add(createRandomInstitute(i));
		}
		
		System.out.println("Creating OptionList...");
		// Create OptionList of each Candidate
		createCadidateOptionList();
		
		System.out.println("Alloting Seats...");
		// Allot seats
		Allotter.allot(candidates,institutes);
		
		System.out.println("Done.");
	}

	private static Candidate createRandomCandidate(int id) {
		Random rd = new Random();
		Category category;
		
		if (rd.nextBoolean())
			category = Category.OPEN;
		else if (rd.nextBoolean())
			category = Category.OBC;
		else
			category = Category.values()[rd.nextInt(Category.values().length)];

		Candidate candidate = new Candidate(id, category);
		candidate.cetRank = rd.nextInt(1_000_000_000);
		return candidate;
	}
	
	private static Institute createRandomInstitute(int id) {
		Random rd = new Random();
		Branch branch;
		Institute institute = new Institute(id);
		
		int options = rd.nextInt(4,7);
		for(int i=0; i < options ;i++) {
			branch = Branch.values()[i];
			int seats = branch.seats;
			if(rd.nextBoolean()) seats += 60; 
			institute.seats.put(branch, seats);			
		}
		institute.totalSeats = (HashMap<Branch, Integer>) institute.seats.clone();
		return institute;
	}
	
	private static void createCadidateOptionList() {
		Random rd = new Random();
		for (Candidate candidate: candidates) {
			for(Institute institute: institutes) {
				if(rd.nextInt(10) == 1) continue;
				for(Branch branch: institute.seats.keySet()) {
					if(rd.nextInt(10) >= 6) continue;
					candidate.optionList.add(new Option(institute.id,branch));
				}
			}
			
		}
	}
}
