package com.sujal.sas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.sujal.sas.candidate.Candidate;
import com.sujal.sas.candidate.Option;
import com.sujal.sas.institute.Branch;
import com.sujal.sas.institute.Institute;

public class Allotter {
	static ArrayList<Candidate> candidates;
	static ArrayList<Institute> institutes;

	public static void allot(ArrayList<Candidate> candidates, ArrayList<Institute> institutes) {
		Allotter.candidates = candidates;
		Allotter.institutes = institutes;

		// Sort candidates based on Rank
		Collections.sort(candidates);

		for (Candidate candidate : candidates) {
			assignInstitutes(candidate);
		}
		
		// Save Report
		File file = new File("candidates.log");
		FileWriter fw;
		try {
			fw = new FileWriter(file);
			String str = "";
			for (Candidate candidate : candidates) {
				str += candidate + "\n";
			}
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void assignInstitutes(Candidate candidate) {
		for (Option option : candidate.optionList) {
			Institute institute = Allotter.institutes.get(option.instituteId);
			Branch branch = option.instituteBranch;
			if (checkAvailablity(institute, branch)) {
				candidate.isAlloted = true;
				institute.seats.replace(branch, institute.seats.get(branch) - 1);
				candidate.assignedInstitute = institute.id;
				candidate.assignedBranch = branch;
				return;
			}

		}
	}

	private static boolean checkAvailablity(Institute institute, Branch branch) {
		if (institute.seats.get(branch) > 0)
			return true;
		else
			return false;
	}
}
