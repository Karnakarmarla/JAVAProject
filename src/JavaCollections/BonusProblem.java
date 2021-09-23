package JavaCollections;
import java.io.*;
import java.util.*;

public class BonusProblem {
    public static void mostUsedWord(String s) {

        String words[]=s.replaceAll("\\.+"," ").split("\\s+");
        HashMap<String, Integer> hm = new HashMap<>();
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            if(words[i].length()>=3) {
                if(hm.containsKey(words[i]))
                    hm.put(words[i],hm.get(words[i])+1);
                else
                    hm.put(words[i],1);
            }
        }

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            list.add(entry.getValue());
        }

        Collections.sort(list);
        for (int num : list) {
            for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                if (entry.getValue().equals(num)) {
                    sortedMap.put(entry.getKey(), num);
                }
            }
        }
        List<String> keys=new ArrayList<String>(sortedMap.keySet());
        int len=keys.size();
        System.out.println(keys.get(len-1));

    }
    public static void main(String[] args) throws IOException {
        String line = "";
        String paragraph = "";

        System.out.println("Enter the text: ");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        do
        {
            line = bufferedReader.readLine();
            paragraph = paragraph + line + " ";
        }while(!line.equals("exit"));
        isr.close();
        bufferedReader.close();
        mostUsedWord(paragraph);
    }
}
