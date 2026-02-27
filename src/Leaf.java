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

}
