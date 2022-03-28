import java.util.ArrayList;
import java.util.List;

public class BeanTest {
    public static void main(String[] args) {
        Album album = new Album();
        Quote quote = new Quote();
        Quote quote2 = new Quote();
        Author author = new Author();

        album.setId(1);
        album.setArtist("Metallica");
        album.setName("Ride the Lightning");
        album.setGenre("metal");
        album.setSales(1000000);
        album.setReleaseDate(1984);

        quote.setAuthorId(1);
        quote.setId(1);
        quote.setContent("Do or do not, there is no try.");
        quote.setAuthor("Yoda");

        quote2.setAuthorId(2);
        quote2.setId(2);
        quote2.setContent("I ain't got time to bleed.");
        quote2.setAuthor("The Body");

        author.setId(1);
        author.setFirstName("Yo");
        author.setLastName("da");

        List<Quote> quotes = new ArrayList<>();
        quotes.add(quote);
        quotes.add(quote2);

        for (Quote q: quotes) {
            System.out.println(q.getAuthor());
            System.out.println(q.getContent());
        }
    }
}
