import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(" >>>> ");

        String directory = args[0];

        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        Map<String, Map<String, Integer>> wordMap = new HashMap<>();

        for (File file : listOfFiles) {

            if (file.isFile()) {
                processFile(file, wordMap);
            }
        }

        printProcessFile(wordMap);

    }

    private static void processFile(File file, Map<String, Map<String, Integer>> wordMap) throws Exception {
        if (file.isFile() && file.getName().endsWith(".txt")) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String content = br.readLine();
                String prevWord = null;

                content = content.replaceAll("\\p{Punct}", "").toLowerCase();
                System.out.println(content); // can print all lines

                for (String word : content.split(" ")) {
                    // System.out.println(word+"\n");
                    if (!word.isEmpty()) {
                        if (prevWord != null) {
                            wordMap.putIfAbsent(prevWord, new HashMap<>());
                            wordMap.get(prevWord).merge(word, 1, Integer::sum);
                        }
                        prevWord = word;
                    }
                }

                br.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void printProcessFile(Map<String, Map<String, Integer>> wordMap) {

        for (Map.Entry<String, Map<String, Integer>> entry : wordMap.entrySet()) {
            // System.out.println("entry: "+entry);
            String word = entry.getKey();
            System.out.println(word);

            Map<String, Integer> nextWord = entry.getValue();

            //System.out.println("nextWord: " + nextWord);
            
            //retrieves a collection of views of the values (counts of next words)
            int totalNextWord = nextWord.values()
                                        // converts to stream to perform stream operations
                                        .stream()
                                        // parses Integer Object to int value
                                        .mapToInt(Integer::intValue)
                                        //sum all the int value
                                        .sum();
                                        
            //System.out.println(totalNextWord + "\n");

            for (Entry<String, Integer> nextWordEntry : nextWord.entrySet()) {
                String data = nextWordEntry.getKey();
                int count = nextWordEntry.getValue();
                double probability = count / (double) totalNextWord;
                System.out.println("\t"+data + " = " + probability);
            }
            
        }

    }

}
