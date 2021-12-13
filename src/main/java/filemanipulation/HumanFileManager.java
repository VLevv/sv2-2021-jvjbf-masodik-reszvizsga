package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans=new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path){
        try{
        List<String> lines = Files.readAllLines(path);
            for (String s :
                    lines) {
                humans.add(new Human(s.substring(0,s.indexOf(';')),s.substring(s.indexOf(';')+1)));
            }
    }catch (IOException ioe){
            throw new IllegalStateException("Can't read file!",ioe);
        }
    }

    public void writeMaleHumansToFile(Path path){
        try{
            List<String> males=new ArrayList<>();
        for (Human h :
                humans) {
            if (h.getIdentityNumber().startsWith("1")||h.getIdentityNumber().startsWith("3")){
                males.add(h.getName()+";"+h.getIdentityNumber());
            }
        }
        Files.write(path,males);
        }catch (IOException ioe){
            throw new IllegalStateException("Can't read file!",ioe);
        }
    }
}
