import java.io.Serializable;
// A JavaBean, or bean, is a Java class that
//    provides a zero-argument constructor
//    has getters and setters for all instance variables
//    implements the Serializable or Externalizable interface
// You can think of a bean as a Java class that just represents data, meaning the class doesn't perform any complex logic or control flow, rather, it just serves as a way to group properties.
// Models (M of MVC) are classes that represent our entities, which represent information from the database, will be written as beans.

public class Album implements Serializable {
    private int id;
    private String artist;
    private String name;
    private int releaseDate;
    private long sales;
    private String genre;

    // Zero-arg constructor
    public Album() {
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getSales() {
        return sales;
    }

    public void setSales(long sales) {
        this.sales = sales;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
/*
* ALBUMS MySQL Table:
    id — auto-incrementing unsigned integer primary key
    artist — string for storing the recording artist name
    name — string for storing a record name
    release_date — integer representing year record was released
    sales — floating point value for number of records sold (in millions)
    genre — string for storing the record's genre(s)
*/