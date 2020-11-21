package telran.movies.dto;

public class MovieDto {
    public String name;
    public String producer;
    public int year;

    public MovieDto() {
    }

    public MovieDto(String name, String producer, int year) {
        super();
        this.name = name;
        this.producer = producer;
        this.year = year;
    }

    @Override
    public String toString() {
        return "MovieDto [name=" + name + ", producer=" + producer + ", year=" + year + "]";
    }

}
