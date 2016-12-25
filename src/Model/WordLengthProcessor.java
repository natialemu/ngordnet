package Model;

/**
 * Created by Nathnael on 7/9/2016.
 */
public class WordLengthProcessor implements YearlyRecordProcessor {
    @Override
    public double process(YearlyRecord yr){
        long wordlSum = 0;
        long numWords = 0;
        for (String s : yr.words()){
            wordlSum += s.length() * yr.count(s);
            numWords += yr.count(s);
        }
        if (yr.size() == 0) {
            return 0;
        }
        return wordlSum / ((double) numWords);
    }
}
