package conference;

import java.time.*;
public class Meeting {
    private String name; // название направления
    private int classroom; // аудитория
    private LocalTime start_time; // время старта направления

	// получить время старта
    public LocalTime getStartTime() {
        return start_time;
    }

	// получить название направления
    public String getName() {return name;}

	// конструктор
    public Meeting(String name, int classroom, LocalTime start_time)
    {
        this.name=name;
        this.classroom=classroom;
        this.start_time=start_time;
    }

	// привести информацию о направлении к строке
    @Override
    public String toString() {
        return "Meeting [name=" + name + ", classroom=" + classroom + ", start time=" + start_time + "]";
    }
}
