package gene;

public class AllCodons {

    public int findStopCondon(String dnaStr, int startIndex, String stopCodon){

        int currIndex = dnaStr.indexOf(stopCodon, startIndex+3);
        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff % 3 == 0){
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }

        return dnaStr.length();
    }

    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        //System.out.println("hapens or not");
        if(startIndex == -1){
            return "";
        }
        //System.out.println("hapens or not 2");
        int taaIndex = findStopCondon(dna, startIndex, "TAA");
        int tagIndex = findStopCondon(dna, startIndex, "TAG");
        int tgaIndex = findStopCondon(dna, startIndex, "TGA");
        // System.out.println("hapens or not 3");
        int minIndex = 0;
        if( taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex) ){
            minIndex = tgaIndex;
        }else {
            minIndex = taaIndex;
        }
        if(minIndex == -1 || (tgaIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }
        if(minIndex == -1){
            return "";
        }
        //System.out.println("hapens or not 4");
        //System.out.println(minIndex);
        return dna.substring(startIndex, minIndex + 3);
    }

    public void printAllGenes(String dna){
        int startIndex = 0;
        String currentGene;
        while (true){
            currentGene = findGene(dna, startIndex);
            //System.out.println("happens");
            if(currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            //System.out.println("before sI= " + startIndex);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
            // System.out.println("after sI= " + startIndex);
        }

    }
    public void testFindStop(String dna){
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna);
    }

    public static void main(String[] args) {
        AllCodons allCodons = new AllCodons();
        allCodons.testFindStop("ATGATCTAATTTATGCTGCAACGGTGAAGA");
//        allCodons.testFindStop("");
//        allCodons.testFindStop("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }


}
