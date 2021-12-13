package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words=new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word){
        validateWord(word);
        words.add(word);

    }

    public boolean isThereAWordTwice(){
        for(int i =0;i<words.size();++i){
            for(int j=i+1;j<words.size();++j){
                if(words.get(i).equals(words.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    private void validateWord(String word){
        if(word.contains(" ")){
            throw new IllegalArgumentException("It should be one word!");
        }
        for(int i =0;i<word.length();++i){
            if(Character.isUpperCase(word.charAt(i))){
                throw new IllegalArgumentException("Word should be lower case!");
            }
        }
    }
}
