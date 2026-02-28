
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
    
    /**
     * 
     * Recursive print function. calls itself recursively to print the contents
     * or type of each node. There are three print methods, and DNADB.print will
     * pass a different character to this type parameter to tell it which one
     * to do
     * 
     * @param type
     *          the type of print method we want to use.
     *          -r: regular print
     *          -l: lengths print
     *          -s: stats print
     * @return
     *          the string to be print
     */
    public String print(char type);
}
