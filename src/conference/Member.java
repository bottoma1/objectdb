package conference;
import java.util.Date;

// участник направления
public class Member {
    private Human human; // человек, который является участником
    private Meeting meeting; // направление, в котором он является участником
    private boolean speaker; // докладчик или нет
    private Date invition_date; // дата приглашения
    private Date statement_date; // дата подачи заявления
    private String report_theme; // тема доклада
    private boolean theses; // поданы ли тезисы

	// конструктор
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
