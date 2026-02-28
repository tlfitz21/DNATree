
public class Internal implements Node {

    
    /**
     * 5 Node pointers
     */
    private Node pointA;
    private Node pointC;
    private Node pointG;
    private Node pointT;
    private Node pointD;
    
    //Constructors
    
//    /**
//     * Constructor if nodes are specified
//     * 
//     * @param inA
//     *          pointer for a
//     * @param inC
//     *          pointer for c
//     * @param inG
//     *          pointer for g
//     * @param inT
//     *          pointer for t
//     * @param inD
//     *          pointer for $
//     */
//    public Internal(Node inA, Node inC, Node inG, Node inT, Node inD) {
//        pointA = inA;
//        pointC = inC;
//        pointG = inG;
//        pointT = inT;
//        pointD = inD;
//    }
    
    /**
     * Constructor if nothing is specified
     * All pointers are set to flyweight
     */
    public Internal()
    {
        pointA = DNADB.fw;
        pointC = DNADB.fw;
        pointG = DNADB.fw;
        pointT = DNADB.fw;
        pointD = DNADB.fw;
    }
    
    /**
     * Accessor method for all 5 pointers
     * 
     * @param point
     *              the character corresponding to 
     *              the pointer you want returned
     * @return
     *              the pointer
     */
    public Node getPoint(char point) {
        
        Node rPoint;
        
        switch (point) {
            case 'A':
                rPoint = pointA;
                break;
            case 'C':
                rPoint = pointC;
                break;
            case 'G':
                rPoint = pointG;
                break;
            case 'T':
                rPoint = pointT;
                break;
            default:
                rPoint = pointD;
                break;
        }
        
        return rPoint;
    }
    
    /**
     * Mutator method for all 5 pointers
     * 
     * @param point
     *              the character corresponding to
     *              the pointer you want updated
     * @param newNode
     *              the node you want to change it to
     */
    public void setPoint(char point, Node newNode) {
        switch (point) {
            case 'A':
                pointA = newNode;
                break;
            case 'C':
                pointC = newNode;
                break;
            case 'G':
                pointG = newNode;
                break;
            case 'T':
                pointT = newNode;
                break;
            default:
                pointD = newNode;
                break;
        }
    }
    
    /**
     * 
     * Part of the recursive insert function. identifies the pointer
     * the sequence would go through and recursively calls insert at
     * that node. returns itself.
     * 
     * @param sequence
     *            the sequence to be inserted
     * @param depth
     *            the current depth of the node within the entire tree
     * @return
     *         returns itself as the updated root of what was called before 
     */
    public Node insert(String sequence, int depth) {
        //the letter that we follow to sort the sequence
        char letter = sequence.charAt(depth);
        //recursively call insert at the node the respective pointer
        //is pointing to, and set the pointer to it in case it changes
        setPoint(letter, getPoint(letter).insert(sequence, depth + 1));

        return this;       
    }
    
    public String print(char type) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("I\n  ");
        sb.append(pointA.print(type) + "\n  ");
        sb.append(pointC.print(type) + "\n  ");
        sb.append(pointG.print(type) + "\n  ");
        sb.append(pointT.print(type) + "\n  ");
        sb.append(pointD.print(type));
        
        return sb.toString();
    }

}





















