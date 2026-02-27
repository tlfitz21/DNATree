
public interface Node {

    /**
     * 
     * Recursive insert function. calls itself recursively to find/create the
     * correct
     * place to insert the sequence. It will return once the flyweight calls
     * this and
     * updates it's "position" with a new leaf node
     * 
     * @param sequence
     *            the sequence to be inserted
     * @param depth
     *            the current depth of the node within the entire tree
     * @return
     *         eventually returns the new or updated root node of the tree
     *         -the flyweight method returns the new leaf node
     *         -the leaf method returns the new internal node
     *         -the internal method returns itself
     */
    public Node insert(String sequence, int depth);
}
