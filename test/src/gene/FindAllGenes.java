package gene;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;

import static jdk.nashorn.internal.objects.ArrayBufferView.length;

public class FindAllGenes {

    public int findStopCodon(String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex + 1);
            }
        }

        return dnaStr.length();
    }

    public String findGene(String dna, int position) {
        int startIndex = dna.indexOf("ATG", position);
        if (startIndex == -1) {
            return "";
        }

        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tgaIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);

    }

    public void printAllGenes(String dna) {
        int countGene = 0;
        int countGeneOver60 = 0;
        int countrateCG = 0;
        int startIndex = 0;
        float rateCGAll = 0;
        String currentGene;
        while (true) {
            currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()) {
                break;
            }
            countGene = countGene + 1;
            if (currentGene.length() > 60){
                countGeneOver60 = countGeneOver60 + 1;
            }

            int countCG = 0;


            for(int i=1;i<currentGene.length();i++){
                if(currentGene.charAt(i) == 'C' || currentGene.charAt(i) == 'G'){
                    countCG = countCG + 1;
                }

            }
            rateCGAll = (float)(countCG)/currentGene.length();
//            System.out.println(rateCGAll);
//            System.out.println((countC + countG)/currentGene.length());
            if (rateCGAll > 0.35){
                countrateCG = countrateCG+1;
            }
            System.out.println("第"+countGene+"个基因  " +"第"+countGeneOver60+"个超过60的基因   "+ "基因开始位置 " + startIndex + "   基因长度 " + currentGene.length()+ "   CG的个数 "+countCG +  "   CG的比例 "+rateCGAll +"   CG的比例超0.35个数 "+countrateCG +"    基因内容 " + currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();

        }
    }

    public void testFindStop(String dna) {
        System.out.println("Testing printAllGenes on" + dna);
        printAllGenes(dna);

    }

    public String realTesting(String filepath) throws Exception {
//        DirectoryResource dr = new DirectoryResource();
//        for (File f : dr.selectedFiles()) {
//            FileResource fr = new FileResource(f);
//            String s = fr.asString();
//            System.out.println("read " + s.length() + " characters");
//            String result = findProtein(s);
//            System.out.println("found " + result);
//        }

        File file = new File(filepath);
//        System.out.println("11111");
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }


    public static void main(String[] args) throws Exception {
        FindAllGenes findAllGenes = new FindAllGenes();
        String myDNA = findAllGenes.realTesting("D:\\Windows\\JavaProject\\test\\test\\src\\gene\\GRch38dnapart.fa");
        System.out.println(myDNA);
        findAllGenes.testFindStop(myDNA.toUpperCase());


    }
}