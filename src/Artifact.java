import java.util.ArrayList;
import java.util.List;

public class Artifact {

    static List<Integer> coordArt = new ArrayList<>();
    public static void setArtifact(){

        for(int i = 0; i < 12; i++){
            coordArt.add(i, (int)((Math.random() * 17)+2));
        }
    }
}
