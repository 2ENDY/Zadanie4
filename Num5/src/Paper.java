import java.time.LocalDate;

public class Paper {
    String author;
    String title;
    int count;
    String category;
    static LocalDate date;

    Paper(String author, String title, int count, String category, LocalDate date){
        this.author = author;
        this.title = title;
        this.count = count;
        this.category = category;
        this.date = date;
    }
    //Get
    public String getAuthor(){
        return author;
    }

    public String getTitle(){
        return title;
    }

    public int getCount(){
        return  count;
    }

    public String getCategory(){
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    //Set
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date=date;
    }

    @Override
    public String toString() {
        return "Автор:" + this.author + ",  Название:" + this.title + ",  Рубрика:" + this.category + ",  Кол-во просмотров:" + this.count + ",  Дата:" + this.date;
    }
}
