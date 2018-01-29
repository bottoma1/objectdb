package conference;

import java.time.*;
public class Meeting {
    private String name;
    private int classroom;
    private LocalTime start_time;

    public LocalTime getStartTime() {
        return start_time;
    }

    public String getName() {return name;}

    public Meeting(String name, int classroom, LocalTime start_time)
    {
        this.name=name;
        this.classroom=classroom;
        this.start_time=start_time;
    }

    @Override
    public String toString() {
        return "Meeting [name=" + name + ", classroom=" + classroom + ", start time=" + start_time + "]";
    }
}
