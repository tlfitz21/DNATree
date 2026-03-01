// -------------------------------------------------------------------------

/**
 * The database implementation for this project.
 * This manages the commands for the DNA tree.
 *
 * @author CS3114/5040 Staff
 * @version Spring 2026
 *
 */
public class DNADB implements DNA {

    // ----------------------------------------------------------
    /**
     * The singleton flyweight for this program
     */
    public static Flyweight fw;

    /**
     * A flag for insert to mark when an input sequence matches an existing one
     */
    public static boolean isDuplicate;
    
    /**
     * The root of the entire tree
     */
    private Node root;
    
    public static int visited;

    /**
     * Create a new DNADB object.
     */
    public DNADB() {
        fw = new Flyweight();
        isDuplicate = false;
        root = fw;
        visited = 0;
    }


    // ----------------------------------------------------------
    /**
     * Insert a DNA string into the database
     * 
     * @param sequence
     *            The sequence to insert
     * @return The outcomes message string
     */
    public String insert(String sequence) {

        // sanity checks, to make sure null, empty, and wrong letter input
        // sequences are caught
        if (sequence == null) {
            return "Bad input: Sequence may not be null";
        }

        if (sequence.compareTo("") == 0) {
            return "Bad input: Sequence may not be empty";
        }

        if (!checkLetters(sequence)) {
            return "Bad Input Sequence " + sequence;
        }
        sequence += "$";

        // call the recursive insert function of the root node
        root = root.insert(sequence, 0);
        
        //if it was a duplicate, revert isDuplicate and then return error message
        //otherwise return success message
        if (isDuplicate) {
            isDuplicate = false;
            return "Sequence " + sequence + " already exists";
        }
        
        return "Sequence " + sequence + " inserted";
    }


    // ----------------------------------------------------------
    /**
     * Remove a DNA string into the database
     * 
     * @param sequence
     *            The sequence to remove
     * @return The outcomes message string
     */
    public String remove(String sequence) {
        
        if (sequence == null) {
            return "Bad input: Sequence may not be null";
        }

        if (sequence.compareTo("") == 0) {
            return "Bad input: Sequence may not be empty";
        }

        if (!checkLetters(sequence)) {
            return "Bad Input Sequence " + sequence;
        }
        
        return "Sequence " + sequence + " does not exist";
    }


    // ----------------------------------------------------------
    /**
     * Print the tree
     * 
     * @return the print string
     */
    public String print() {
        
        return "tree dump:\n" + root.print('r');

    }


    // ----------------------------------------------------------
    /**
     * Print the lengths
     * 
     * @return the print string
     */
    public String printLengths() {
        return "tree dump with lengths:\n" +  root.print('l');
    }


    // ----------------------------------------------------------
    /**
     * Print the stats
     * 
     * @return the print string
     */
    public String printStats() {
        return "tree dump with stats:\n" +  root.print('s');
    }


    // ----------------------------------------------------------
    /**
     * Search for a given string
     * 
     * @param sequence
     *            The sequence to search for
     * @return the print string
     */
    public String search(String sequence) {
        
        if (sequence == null) {
            return "Bad input: Sequence may not be null";
        }

        if (sequence.compareTo("") == 0) {
            return "No sequence found\n" + "# of nodes visited: 1";
        }
        
        if (!checkLetters(sequence)) return "Bad Input Sequence " + sequence;
        
        StringBuilder sb = new StringBuilder();
        // calls recursive search, returns a node always
        Node ret = root.search(sequence, 0);
        // if its a leaf node, it worked no problem
        if(ret instanceof Leaf) {
            if(((Leaf)ret).getSeq().equals(sequence)) {
                sb.append(sequence + "\r\n" + "# of nodes visited: " + visited);
                visited = 0;
                return sb.toString();
            } else {
                sb.append("No sequence found\r\n" + "# of nodes visited: " + visited);
                visited = 0;
                return sb.toString();
            }
        // if its a flyweight, it didnt work
        } else if(ret instanceof Flyweight) {
            sb.append("No sequence found\r\n" + "# of nodes visited: " + visited);
            visited = 0;
            return sb.toString();
        }
        // if its neither, then its an internal node, so we do to a harder search
        sb.append(ret.searchAll() + "# of nodes visited: " + visited);
        visited = 0;
        return sb.toString();
    }


    /**
     * Checks if the inpt string contains correct letters
     * 
     * @param inStr
     *            the string to be checked
     * @return
     *         true if it's a valid string, false if not
     */
    public boolean checkLetters(String inStr) {
        // if any character in the string is not valid, return false
        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) != 'A' && inStr.charAt(i) != 'C' && inStr
                .charAt(i) != 'G' && inStr.charAt(i) != 'T' && inStr.charAt(i) != '$')
                return false;
            else
                continue;
        }
        // otherwise, return true
        return true;
    }

}
