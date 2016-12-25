package Model;
import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Nathnael on 7/9/2016.
 */
public class YearlyRecord {
    private TreeMap<String, Integer> mappingCount = new TreeMap<String, Integer>();

    private TreeMap<String, Integer> mappingRank = new TreeMap<String, Integer>();


    private boolean update = true;

    public YearlyRecord() {
        mappingCount = new TreeMap<String, Integer>();
    }

    /** Creates a YearlyRecord using the given data. */
    public YearlyRecord(HashMap<String, Integer> mappingCount) {
        this.mappingCount = new TreeMap(mappingCount);
    }

    /** Returns the number of times WORD appeared in this year. */
    public int count(String word) {
        return mappingCount.get(word);
    }

    public int size() {
        return mappingCount.size();
    }

    /** Returns all words in ascending order of count. */
    public Collection<String> words() {
        String[] words = new String[size()];
        int count = 0;
        for (String word : mappingCount.keySet()) {
            words[count] = word;
            count += 1;
        }

        /* Sort words by order of number of Zs */
        Arrays.sort(words, new ReverseRankComparator());
        ArrayList result = new ArrayList(words.length);
        for (String w : words) {
            result.add(w);
        }
        return result;
    }

    /** Returns all counts in ascending order of count. */
    public Collection<Number> counts() {
        TreeSet<Number> set = new TreeSet();
        set.addAll(mappingCount.values());
        return set;

    }

    /** Records that WORD occurred COUNT times in this year. */
    public void put(String word, int count) {
        /* Will not pass muster for that 0.1 bonus points. */
        if (count > 0) {
            mappingCount.put(word, count);
            update = true;
        }

    }

    /** Returns the number of words with fewer Zs than x, where x is some
     * key in the map. If x is not part of the map, return -1. */
    public int rank(String x) {
        if (!mappingCount.containsKey(x)) {
            return -1;
        }

        if (update) {
            updateRank();
        }
        return mappingRank.get(x);
    }

    /** Comparator that compares strings based on zCount. */
    private class RankComparator implements Comparator<String> {
        public int compare(String x, String y) {
            return mappingCount.get(y) - mappingCount.get(x);
        }
    }
    private class ReverseRankComparator implements Comparator<String> {
        public int compare(String x, String y) {
            return mappingCount.get(x) - mappingCount.get(y);
        }
    }

    /** Update sthe fewerZsCount map using sorting. */
    private void updateRank() {
        mappingRank = new TreeMap<String, Integer>();
        String[] words = new String[mappingCount.size()];
        int count = 0;
        for (String word : mappingCount.keySet()) {
            words[count] = word;
            count += 1;
        }


        Arrays.sort(words, new RankComparator());

        for (int i = 0; i < words.length; i += 1) {
            mappingRank.put(words[i], i + 1);
        }
        update = false;

    }

}
