package de.mpa.job;


public interface Executable {
	/**
	 * Return a description for the job.
	 * @return description The description represented as String
	 */
	public String getDescription();
	
	/**
	 * Returns the job status. 
	 * @return status The JobStatus
	 */
	public JobStatus getStatus();
	
	/**
	 * Returns the error (if any error has occurred)
	 * @return error The error represented as String.
	 */
	public String getError();
	

}
