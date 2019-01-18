import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movie {

    private List<String> movies;

    public Movie(String pathname) {
        movies = new ArrayList<>();
        File file = new File(pathname);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                movies.add(scanner.nextLine ());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getMovie() {
        int index =(int) (Math.random() * movies.size());
        return movies.get(index);
    }

}