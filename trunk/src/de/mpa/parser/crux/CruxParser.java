package de.mpa.parser.crux;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CruxParser {
	
	   /**
     * Default constructor for the CruxParser.
     */
    public CruxParser() {
    }
    
	 /**
	 * Reads the Crux (percolated) output file and returns a CruxFile object.
	 *
	 * @param file
	 * @return cruxfile CruxFile object
	 */
	public CruxFile read(String file) {
		
		// Init the CruxFile
		CruxFile cruxfile = new CruxFile(file);
		
		// Init the reader
		BufferedReader reader = null;
		
		// Init the MsgfHit list
		List<CruxHit> hitList = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String nextLine;
			hitList = new ArrayList<CruxHit>();
			// Iterate over all the lines of the file.
			while ((nextLine = reader.readLine()) != null) {

		     if (!nextLine.startsWith("scan")) {
					StringTokenizer tokenizer = new StringTokenizer(nextLine, "\t");
					List<String> tokenList = new ArrayList<String>();
					CruxHit hit = new CruxHit();

					// Iterate over all the tokens
					while (tokenizer.hasMoreTokens()) {
						tokenList.add(tokenizer.nextToken());
					}

                    // Check tokenList for null
					if (tokenList.size() > 0){
						hit.setScanNumber(Integer.valueOf(tokenList.get(0)));
						hit.setCharge(Integer.valueOf(tokenList.get(1)));
                        hit.setPrecursorMZ(Double.valueOf(tokenList.get(2)));
                        hit.setNeutralMass(Double.valueOf(tokenList.get(3)));
                        hit.setPeptideMass(Double.valueOf(tokenList.get(4)));
                        hit.setDeltaCN(Double.valueOf(tokenList.get(5)));
                        hit.setxCorrScore(Double.valueOf(tokenList.get(6)));
                        hit.setxCorrRank(Integer.valueOf(tokenList.get(7)));
                        hit.setPercolatorScore(Double.valueOf(tokenList.get(8)));
                        hit.setPercolatorRank(Integer.valueOf(tokenList.get(9)));
                        hit.setqValue(Double.valueOf(tokenList.get(10)));
                        hit.setMatchesSpectrum(Integer.valueOf(tokenList.get(11)));
                        hit.setPeptide(tokenList.get(12));
                        hit.setCleavageType(tokenList.get(13));
                        hit.setProteinid(tokenList.get(14));        
                        hit.setFlankingAA(tokenList.get(15));
                        hitList.add(hit);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}       
		cruxfile.setHits(hitList);
		return cruxfile;
	}
}
