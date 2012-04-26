package de.mpa.client.model.dbsearch;

import java.util.ArrayList;
import java.util.List;

import de.mpa.client.model.SpectrumMatch;
import de.mpa.db.accessor.SearchHit;

public class PeptideSpectrumMatch extends SpectrumMatch {
	
	/**
	 * The ion charge.
	 */
	private int charge;
	
	/**
	 * The search engine hits.
	 */
	private List<SearchEngineHit> searchEngineHits;
	
	/**
	 * Default empty constructor.
	 */
	public PeptideSpectrumMatch() {
		
	}
	
	/**
	 * Constructor for the PeptideSpectrumMatch.
	 * @param spectrumid
	 * @param votes
	 * @param searchEngineHits
	 */
	public PeptideSpectrumMatch(long spectrumid, SearchHit searchHit, SearchEngineType type) {
		this.searchSpectrumID = spectrumid;
		this.charge = (int) searchHit.getCharge();
		this.searchEngineHits = new ArrayList<SearchEngineHit>();
		this.searchEngineHits.add(new SearchEngineHit(searchHit, type));
	}
	
	/**
	 * Returns the search engine hit.
	 * @return The search engine hit.
	 */
	public SearchEngineHit getFirstSearchEngineHit() {
		return searchEngineHits.get(0);
	}
	
	/**
	 * Returns the list of search engine hits.
	 * @return The list of search engine hits.
	 */
	public List<SearchEngineHit> getSearchEngineHits() {
		return searchEngineHits;
	}
	
	/**
	 * Adds a search engine hit to the PSM.
	 * @param hit Another search engine hit to be added.
	 */
	public void addSearchEngineHit(SearchEngineHit hit) {
		this.searchEngineHits.add(hit);
	}

	/**
	 * Returns the PSM charge.
	 * @return The PSM charge.
	 */
	public int getCharge() {
		return charge;
	}
	
	/**
	 * Returns the votes.
	 * @return The number of votes for the search engine hits.
	 */
	public int getVotes(){
		return searchEngineHits.size();
	}
}