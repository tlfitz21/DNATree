import java.text.DecimalFormat;
/**
 * This is a subclass of Node. It contains data for he DNA sequence, but no
 * pointers
 * 
 * @author Tanner FitzGerald / Collin Greene
 * @version Spring 2026
 */
public class Leaf implements Node {

    /**
     * The data for this leaf node
     */
    private String sequence;

    /**
     * Constructor for the leaf
     * 
     * @param inSeq
     *            the sequence that gets stored in it
     */
    public Leaf(String inSeq) {
        sequence = inSeq;
    }


    /**
     * Accessor method for the Node's sequence
     * 
     * @return
     *         the sequence itself
     */
    public String getSeq() {
        return sequence;
    }

    /**
     * Mutator method for the Node's sequence
     * 
     * @param inSeq
     *            the new sequence for the leaf
     */
// public void setSeq(String inSeq) {
// sequence = inSeq;
// }


    /**
     * 
     * Part of the recursive insert function. splits the leaf
     * and then calls insert again on the new internal node.
     * it will return that internal node back to what called this
     * 
     * @param inSeq
     *            the sequence to be inserted
     * @param depth
     *            the current depth of the node within the entire tree
     * @return
     *         returns the result of the recursive call, which will always
     *         be the resulting "new root" that is at the position this used
     *         to be in
     */
    public Node insert(String inSeq, int depth) {

        // If the sequence matches this leaf's sequence, it's a duplicate and we
        // need to flag it as an error
        if (inSeq.compareTo(getSeq()) == 0) {
            DNADB.isDuplicate = true;
            return this;
        }

        
        Internal temp = new Internal();
        temp.setPoint(getSeq().charAt(depth), this);
        return temp.insert(inSeq, depth);
    }
    
    /**
     * part of the recursive print function. this one of the base cases
     * here, it will print out the sequence and any additional info based
     * on the type that was passed
     * 
     * @param type
     *          the type of print function
     *          
     * @return the string for this leaf
     */
    public String print(char type) {
        String rString = "";
        switch (type) {
            case 'r':
                rString = sequence;
                break;
            case 'l':
                rString = sequence + " " + (sequence.length() - 1);
                break;
            case 's':
                DecimalFormat dec = new DecimalFormat("#0.00");
                int a = 0;
                int c = 0;
                int g = 0;
                int t = 0;
                for (int i = 0; i < sequence.length(); i++) {
                    switch (sequence.charAt(i)) {
                        case 'A':
                            a++;
                            break;
                        case 'C':
                            c++;
                            break;
                        case 'G':
                            g++;
                            break;
                        case 'T':
                            t++;
                            break;
                    }
                }    
                double aPer = 100 * a / (sequence.length() - 1);
                double cPer = 100 * c / (sequence.length() - 1);
                double gPer = 100 * g / (sequence.length() - 1);
                double tPer = 100 * t / (sequence.length() - 1);
               
                rString = sequence + " A:" + dec.format(aPer) + " "
                                + "C:" + dec.format(cPer) + " "
                                + "G:" + dec.format(gPer) + " "
                                + "T:" + dec.format(tPer) + " ";
                break;           
        }
        return rString;
        
    }
    
    public Node search(String sequence, int currDepth, DNADB obj) {
        obj.visited = obj.visited + 1;
        return this;
    }
    
    public String searchHard(String sequence) {
        return "found";
    }

}
