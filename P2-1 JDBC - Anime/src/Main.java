import java.sql.Connection;

public class Main {
    public static void main(String[] args) {




        AnimeService as = new AnimeService();
//        Anime anime = new Anime(
//                "shin-chan",
//                "Cuiño cuiño",
//                as.stringToDate("1997-10-11"),
//                99
//        );
//
//       as.insertAnime(anime);

        System.out.println(as.leer());

    }

}