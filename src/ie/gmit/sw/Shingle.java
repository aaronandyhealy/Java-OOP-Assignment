//Designed by Aaron Healy G00333148
package ie.gmit.sw;

public class Shingle {
	private int docID;
	private int hashCode;
		
	//Constructors
	public Shingle(int docID, int hashCode) {
		super();
		this.docID = docID;
		this.hashCode = hashCode;
	}
	
	//Getters and Setters
	public int getDocID() {
		return docID;
	}
	public void setDocID(int docID) {
		this.docID = docID;
	}
	
	public int getHashCode() {
		return hashCode;
	}
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
}//Shingle