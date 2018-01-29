package conference;
import java.util.Date;

public class Member {
    private Human human;
    private Meeting meeting;
    private boolean speaker;
    private Date invition_date;
    private Date statement_date;
    private String report_theme;
    private boolean theses;

    public Member(Human human, Meeting meeting, boolean speaker, Date invition_date, Date statement_date, String report_theme, boolean theses)
    {
        this.human=human;
        this.meeting=meeting;
        this.speaker=speaker;
        this.invition_date=invition_date;
        this.statement_date=statement_date;
        this.report_theme=report_theme;
        this.theses=theses;
    }

    public Human getHuman() { return human; }
    public boolean isSpeaker() {return speaker;}
    public Date getInvitionDate() {return invition_date;}
    public Date getStatementDate() {return statement_date;}
}
