package gene;

public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna){

        String result = "";
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1) // no ATG
        {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex + 3);

        if(stopIndex == -1){ // no TTA
            return "";
        }
        result = dna.substring(startIndex, stopIndex + 3);
        return result;
    }

    public void testFindGeneSimple(){
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "TTATTA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

        dna = "CGATGGTTTG";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);

    }

    public static void main(String[] args) {
        FindGeneSimpleAndTest findGeneSimpleAndTest = new FindGeneSimpleAndTest();
        findGeneSimpleAndTest.testFindGeneSimple();
    }

}
