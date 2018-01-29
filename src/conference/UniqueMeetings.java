package conference;
import java.time.LocalTime;
public class UniqueMeetings {
    public String name;
    public LocalTime time;
    public int number;

    public UniqueMeetings(String name, LocalTime time, int number)
    {
        this.name=name;
        this.time=time;
        this.number=number;
    }
}
