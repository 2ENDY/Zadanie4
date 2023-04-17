import java.util.Comparator;
public class Compare implements Comparator<Paper> {
    String sortBy;

    public  Compare(String sortBy) {
        this.sortBy = sortBy;
    }
    @Override
    public int compare(Paper paper1, Paper paper2) {
        switch (sortBy) {
            case ("Автор"):
                return paper1.author.compareTo(paper2.author);
            case ("Название"):
                return paper1.title.compareTo(paper2.title);
            case ("Кол-во просмотров"):
                return paper2.count - paper1.count;
            case ("Рубрика"):
                return paper1.category.compareTo(paper2.category);
            default:
                return 0;
        }
    }
}

