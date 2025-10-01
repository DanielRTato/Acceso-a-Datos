import java.sql.Connection;

public class Main {
    public static void main(String[] args) {




        AnimeService as = new AnimeService();

        Anime anime = new Anime(
                "shin-chan",
                "Cuiño cuiño",
                as.stringToDate("1997-10-11"),
                99
        );

        as.insertAnime(anime);

        System.out.println(as.leer());

        Anime animeactulizar = new Anime("shin-chan", "testtest" , as.stringToDate("1111-11-11") , 50);
        as.actualizar(animeactulizar);

        System.out.println(as.leer());

        as.eliminar("shin-chan");

        System.out.println(as.leerFiltrado(91));




    }

}