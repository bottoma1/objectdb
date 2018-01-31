package conference;
import java.time.LocalTime;

// дополнительный класс, использующийся для хранения направлений с уникальным временем старта
public class UniqueMeetings {
    public String name; // название направления
    public LocalTime time; // время старта
    public int number; // общее количество направлений с таким же временем старта

	// конструктор
    public UniqueMeetings(String name, LocalTime time, int number)
    {
        this.name=name;
        this.time=time;
        this.number=number;
    }
}
