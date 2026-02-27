import student.TestCase;
import student.testingsupport.annotations.ScoringWeight;

/**
 * @author CS3114/5040 staff
 * @version Spring 2026
 */
public class DNAProjTest extends TestCase {
    private DNA it;


    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        it = new DNADB();
    }


//    /**
//     * Test output formatting
//     */
//    public void testSampleInput() {
//        assertFuzzyEquals(
//            "Sequence |ACGT| inserted",
//            it.insert("ACGT"));
//        assertFuzzyEquals(
//            "Sequence |ACGT| already exists",
//            it.insert("ACGT"));
//        assertFuzzyEquals(
//            "Sequence |ACGT| removed",
//            it.remove("ACGT"));
//        assertFuzzyEquals(
//            "Sequence |AAAA| inserted",
//            it.insert("AAAA"));
//        assertFuzzyEquals(
//            "Sequence |AA| inserted",
//            it.insert("AA"));
//        assertFuzzyEquals(
//            "Sequence |ACG| does not exist",
//            it.remove("ACG"));
//        assertFuzzyEquals(
//            "tree dump:\r\n"
//            + "I\r\n"
//            + "  I\r\n"
//            + "    I\r\n"
//            + "      AAAA\r\n"
//            + "      E\r\n"
//            + "      E\r\n"
//            + "      E\r\n"
//            + "      AA\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "  E\r\n"
//            + "  E\r\n"
//            + "  E\r\n"
//            + "  E",
//                it.print());
//        assertFuzzyEquals(
//            "tree dump with lengths:\r\n"
//            + "I\r\n"
//            + "  I\r\n"
//            + "    I\r\n"
//            + "      AAAA 4\r\n"
//            + "      E\r\n"
//            + "      E\r\n"
//            + "      E\r\n"
//            + "      AA 2\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "  E\r\n"
//            + "  E\r\n"
//            + "  E\r\n"
//            + "  E",
//                it.printLengths());
//        assertFuzzyEquals(
//            "tree dump with stats:\r\n"
//            + "I\r\n"
//            + "  I\r\n"
//            + "    I\r\n"
//            + "      AAAA A:100.00 C:0.00 G:0.00 T:0.00\r\n"
//            + "      E\r\n"
//            + "      E\r\n"
//            + "      E\r\n"
//            + "      AA A:100.00 C:0.00 G:0.00 T:0.00\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "    E\r\n"
//            + "  E\r\n"
//            + "  E\r\n"
//            + "  E\r\n"
//            + "  E",
//                it.printStats());
//        assertFuzzyEquals(
//            "AAAA\r\n"
//            + "# of nodes visited: 4",
//                it.search("AAAA$"));
//        assertFuzzyEquals(
//            "AAAA\r\n"
//            + "AA\r\n"
//            + "# of nodes visited: 8",
//                it.search("AA"));
//        assertFuzzyEquals(
//            "No sequence found\r\n"
//                + "# of nodes visited: 3",
//                it.search("ACGT$"));
//    }


    /**
     * Example tests for bad input error formatting
     */
    public void testBadInput() {
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be null\r\n",
            it.insert(null));
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be empty\r\n",
            it.insert(""));
        assertFuzzyEquals("testBadInput",
            "Bad Input Sequence |AXA|\r\n",
            it.insert("AXA"));
        assertFuzzyEquals("testBadInput",
            "Bad Input Sequence |A A|\r\n",
            it.insert("A A"));
        assertFuzzyEquals("testBadInput",
            "Bad Input Sequence |A |\r\n",
            it.insert("A "));
        assertFuzzyEquals("testBadInput",
            "Bad Input Sequence |A$|\r\n",
            it.insert("A$"));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |A$A|\r\n",
            it.search("A$A"));
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be null\r\n",
            it.search(null));
        assertFuzzyEquals("testBadInput",
            "No sequence found\r\n"
                + "# of nodes visited: 1",
            it.search(""));
        assertFuzzyEquals("testBadInput",
            "Bad input sequence |A$A|\r\n",
            it.remove("A$A"));
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be null\r\n",
            it.remove(null));
        assertFuzzyEquals("testBadInput",
            "Bad input: Sequence may not be empty",
            it.remove(""));
    }
    
    public void testBasicInput() {

        assertFuzzyEquals(
            "Sequence |A| inserted",
            it.insert("A"));

assertFuzzyEquals(
            "Sequence |C| inserted",
            it.insert("C"));

assertFuzzyEquals(
            "Sequence |G| inserted",
            it.insert("G"));

assertFuzzyEquals(
            "Sequence |T| inserted",
            it.insert("T"));

assertFuzzyEquals(
            "Sequence |AA| inserted",
            it.insert("AA"));

assertFuzzyEquals(
            "Sequence |AC| inserted",
            it.insert("AC"));

assertFuzzyEquals(
            "Sequence |AG| inserted",
            it.insert("AG"));

assertFuzzyEquals(
            "Sequence |AT| inserted",
            it.insert("AT"));

assertFuzzyEquals(
            "Sequence |CA| inserted",
            it.insert("CA"));

assertFuzzyEquals(
            "Sequence |CC| inserted",
            it.insert("CC"));

assertFuzzyEquals(
            "Sequence |CG| inserted",
            it.insert("CG"));

assertFuzzyEquals(
            "Sequence |CT| inserted",
            it.insert("CT"));

assertFuzzyEquals(
            "Sequence |GA| inserted",
            it.insert("GA"));

assertFuzzyEquals(
            "Sequence |GC| inserted",
            it.insert("GC"));

assertFuzzyEquals(
            "Sequence |GG| inserted",
            it.insert("GG"));

assertFuzzyEquals(
            "Sequence |GT| inserted",
            it.insert("GT"));

assertFuzzyEquals(
            "Sequence |TA| inserted",
            it.insert("TA"));

assertFuzzyEquals(
            "Sequence |TC| inserted",
            it.insert("TC"));

assertFuzzyEquals(
            "Sequence |TG| inserted",
            it.insert("TG"));

assertFuzzyEquals(
            "Sequence |TT| inserted",
            it.insert("TT"));

assertFuzzyEquals(
            "Sequence |AAA| inserted",
            it.insert("AAA"));

assertFuzzyEquals(
            "Sequence |AAC| inserted",
            it.insert("AAC"));

assertFuzzyEquals(
            "Sequence |AAG| inserted",
            it.insert("AAG"));

assertFuzzyEquals(
            "Sequence |AAT| inserted",
            it.insert("AAT"));

assertFuzzyEquals(
            "Sequence |ACA| inserted",
            it.insert("ACA"));

assertFuzzyEquals(
            "Sequence |ACC| inserted",
            it.insert("ACC"));

assertFuzzyEquals(
            "Sequence |ACG| inserted",
            it.insert("ACG"));

assertFuzzyEquals(
            "Sequence |ACT| inserted",
            it.insert("ACT"));

assertFuzzyEquals(
            "Sequence |AGA| inserted",
            it.insert("AGA"));

assertFuzzyEquals(
            "Sequence |AGC| inserted",
            it.insert("AGC"));

assertFuzzyEquals(
            "Sequence |AGG| inserted",
            it.insert("AGG"));

assertFuzzyEquals(
            "Sequence |AGT| inserted",
            it.insert("AGT"));

assertFuzzyEquals(
            "Sequence |ATA| inserted",
            it.insert("ATA"));

assertFuzzyEquals(
            "Sequence |ATC| inserted",
            it.insert("ATC"));

assertFuzzyEquals(
            "Sequence |ATG| inserted",
            it.insert("ATG"));

assertFuzzyEquals(
            "Sequence |ATT| inserted",
            it.insert("ATT"));

assertFuzzyEquals(
            "Sequence |CAA| inserted",
            it.insert("CAA"));

assertFuzzyEquals(
            "Sequence |CAC| inserted",
            it.insert("CAC"));

assertFuzzyEquals(
            "Sequence |CAG| inserted",
            it.insert("CAG"));

assertFuzzyEquals(
            "Sequence |CAT| inserted",
            it.insert("CAT"));

assertFuzzyEquals(
            "Sequence |CCA| inserted",
            it.insert("CCA"));

assertFuzzyEquals(
            "Sequence |CCC| inserted",
            it.insert("CCC"));

assertFuzzyEquals(
            "Sequence |CCG| inserted",
            it.insert("CCG"));

assertFuzzyEquals(
            "Sequence |CCT| inserted",
            it.insert("CCT"));

assertFuzzyEquals(
            "Sequence |CGA| inserted",
            it.insert("CGA"));

assertFuzzyEquals(
            "Sequence |CGC| inserted",
            it.insert("CGC"));

assertFuzzyEquals(
            "Sequence |CGG| inserted",
            it.insert("CGG"));

assertFuzzyEquals(
            "Sequence |CGT| inserted",
            it.insert("CGT"));

assertFuzzyEquals(
            "Sequence |CTA| inserted",
            it.insert("CTA"));

assertFuzzyEquals(
            "Sequence |CTC| inserted",
            it.insert("CTC"));

assertFuzzyEquals(
            "Sequence |CTG| inserted",
            it.insert("CTG"));

assertFuzzyEquals(
            "Sequence |CTT| inserted",
            it.insert("CTT"));

assertFuzzyEquals(
            "Sequence |GAA| inserted",
            it.insert("GAA"));

assertFuzzyEquals(
            "Sequence |GAC| inserted",
            it.insert("GAC"));

assertFuzzyEquals(
            "Sequence |GAG| inserted",
            it.insert("GAG"));

assertFuzzyEquals(
            "Sequence |GAT| inserted",
            it.insert("GAT"));

assertFuzzyEquals(
            "Sequence |GCA| inserted",
            it.insert("GCA"));

assertFuzzyEquals(
            "Sequence |GCC| inserted",
            it.insert("GCC"));

assertFuzzyEquals(
            "Sequence |GCG| inserted",
            it.insert("GCG"));

assertFuzzyEquals(
            "Sequence |GCT| inserted",
            it.insert("GCT"));

assertFuzzyEquals(
            "Sequence |GGA| inserted",
            it.insert("GGA"));

assertFuzzyEquals(
            "Sequence |GGC| inserted",
            it.insert("GGC"));

assertFuzzyEquals(
            "Sequence |GGG| inserted",
            it.insert("GGG"));

assertFuzzyEquals(
            "Sequence |GGT| inserted",
            it.insert("GGT"));

assertFuzzyEquals(
            "Sequence |GTA| inserted",
            it.insert("GTA"));

assertFuzzyEquals(
            "Sequence |GTC| inserted",
            it.insert("GTC"));

assertFuzzyEquals(
            "Sequence |GTG| inserted",
            it.insert("GTG"));

assertFuzzyEquals(
            "Sequence |GTT| inserted",
            it.insert("GTT"));

assertFuzzyEquals(
            "Sequence |TAA| inserted",
            it.insert("TAA"));

assertFuzzyEquals(
            "Sequence |TAC| inserted",
            it.insert("TAC"));

assertFuzzyEquals(
            "Sequence |TAG| inserted",
            it.insert("TAG"));

assertFuzzyEquals(
            "Sequence |TAT| inserted",
            it.insert("TAT"));

assertFuzzyEquals(
            "Sequence |TCA| inserted",
            it.insert("TCA"));

assertFuzzyEquals(
            "Sequence |TCC| inserted",
            it.insert("TCC"));

assertFuzzyEquals(
            "Sequence |TCG| inserted",
            it.insert("TCG"));

assertFuzzyEquals(
            "Sequence |TCT| inserted",
            it.insert("TCT"));

assertFuzzyEquals(
            "Sequence |TGA| inserted",
            it.insert("TGA"));

assertFuzzyEquals(
            "Sequence |TGC| inserted",
            it.insert("TGC"));

assertFuzzyEquals(
            "Sequence |TGG| inserted",
            it.insert("TGG"));

assertFuzzyEquals(
            "Sequence |TGT| inserted",
            it.insert("TGT"));

assertFuzzyEquals(
            "Sequence |TTA| inserted",
            it.insert("TTA"));

assertFuzzyEquals(
            "Sequence |TTC| inserted",
            it.insert("TTC"));

assertFuzzyEquals(
            "Sequence |TTG| inserted",
            it.insert("TTG"));

assertFuzzyEquals(
            "Sequence |TTT| inserted",
            it.insert("TTT"));
    
    assertFuzzyEquals(
      "Sequence |TTT| already exists",
      it.insert("TTT"));
    assertFuzzyEquals(
        "Sequence |AGT| already exists",
        it.insert("AGT"));
    assertFuzzyEquals(
        "Sequence |A| already exists",
        it.insert("A"));
    assertFuzzyEquals(
        "Sequence |TA| already exists",
        it.insert("TA"));
    }
    
//    assertFuzzyEquals(
//        "Sequence |AC| inserted",
//        it.insert("AC"));
//    assertFuzzyEquals(
//        "Sequence |AG| inserted",
//        it.insert("AG"));
//    assertFuzzyEquals(
//        "Sequence |TA| inserted",
//        it.insert("TA"));
//    assertFuzzyEquals(
//        "Sequence |A| inserted",
//        it.insert("A"));
//    assertFuzzyEquals(
//        "Sequence |CCA| inserted",
//        it.insert("CCA"));
//    assertFuzzyEquals(
//        "Sequence |GAA| inserted",
//        it.insert("GAA"));
//    assertFuzzyEquals(
//        "Sequence |ACGTGCA| inserted",
//        it.insert("ACGTGCA"));
}
