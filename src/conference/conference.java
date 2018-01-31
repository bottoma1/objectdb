package conference;

import java.time.LocalTime;
import java.util.ArrayList;
import java.io.File;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;


public class conference {
    public static ObjectContainer data;
    public static ArrayList<UniqueMeetings> meetingsList;
    public static ArrayList<Human> fastMembers;
    public static ArrayList<MultiSpeaker> multispeakers;
    public static void main(String[] args) {
        try {
			// создание БД в временном файле
            data = Db4o.openFile("DBOFILENAME");
            DataOperation operation = new DataOperation(data);
			
			// список для хранения встреч (встречи с неповторяющимся временем старта)
            meetingsList= new ArrayList<UniqueMeetings>();
			
			// список для хранения докладчиков, которые подали заявление не позднее, чем через 3 дня
            fastMembers=new ArrayList<Human>();
			
			// список докладчиков, которые выступают по нескольким направлениям
            multispeakers=new ArrayList<MultiSpeaker>();
			
			// добавление тестовых данных в БД
            operation.createData();

			// вывод количества записей Human
            int humanNumber = data.query(new Predicate<Human>() {
                @Override
                public boolean match(Human arg) {
                    return true;
                }
            }).size();
            System.out.println("Общее количество участников: " + humanNumber);
            System.out.println();

			// вывод количества людей, участвующих в направлениях как докладчики (флаг isSpeaker)
            int speakerNumber = data.query(new Predicate<Member>() {
                @Override
                public boolean match(Member arg) {
                    if(arg.isSpeaker())
                        return true;
                    return false;
                }
            }).size();

            System.out.println("Количество докладчиков: "+speakerNumber);
            System.out.println();

			// проверяется количество выступлений каждого докладчика функцией IsMemberMultispeaker
			// а так же в список fastMembers добавляются те докладчики,
			// дата подачи заявления которых не позже чем дата приглашения + 3 дня
            ObjectSet<Member> members =  data.query(new Predicate<Member>() {
                @Override
                public boolean match(Member arg) {
                    // 1 день = 86400000 миллисекунд
                    if(arg.getInvitionDate().getTime()+86400000*3 >= arg.getStatementDate().getTime() && arg.isSpeaker())
                        fastMembers.add(arg.getHuman());

                    if(arg.isSpeaker())
                        IsMemberMultispeaker(arg);
                    return true;
                }
            });
			
			// вывод докладчиков из списка fastMembers
            System.out.println("Докладчики, которые подали заявку в течение 3 дней после рассылки 1-го приглашения");
            for (Human item : fastMembers) {
                    System.out.println(item.getFio());
            }

			// вывод докладчиков из списка multispeakers
            System.out.println();
            System.out.println("Докладчики, которые подали заявку более чем на 1 направление");
            for (MultiSpeaker item : multispeakers) {
                if(item.number>1)
                    System.out.println(item.human.getFio()+", количество направлений: "+item.number);
            }

			// вывод времени начала каждого направления
			// а так же проверка уникальности времени старта каждого направления функцией MeetingTimeExists
            System.out.println();
            System.out.println("Время начала каждого направления");
            ObjectSet<Meeting> meetings =  data.query(new Predicate<Meeting>() {

                    @Override
                    public boolean match(Meeting arg) {
                        System.out.println(arg.getStartTime());
                        MeetingTimeExists(arg);
                        return true;
                    }
                });

			// вывод всех направлений из списка meetingsList
            System.out.println();
            System.out.println("Направления, которые не пересекаются");
            for (UniqueMeetings item : meetingsList) {
                if(item.number==1)
                    System.out.println("  -"+item.name+" "+ item.time);
            }

        } finally {
            if (data != null) {
                data.close();
            }
        }
        //удалим файл БД
        new File("DBOFILENAME").delete();
    }

	// функция, которая проверяет, есть ли уже направления с таким временем старта
	// если нет - добавляет в список новое (текущее)
    public static void MeetingTimeExists(Meeting arg)
    {
        for (UniqueMeetings item : meetingsList) {
            if(arg.getStartTime().getHour()==item.time.getHour() && arg.getStartTime().getMinute()==item.time.getMinute()) {
                item.number++;
                return;
            }
        }
        meetingsList.add(new UniqueMeetings(arg.getName(),arg.getStartTime(),1));
    }

	// функция, которая проверяет, заявлен ли уже этот докладчик на другое направление
    public static void IsMemberMultispeaker(Member arg)
    {
        for (MultiSpeaker item : multispeakers) {
            if(arg.getHuman().equals(item.human)) {
                item.number++;
                return;
            }
        }
        multispeakers.add(new MultiSpeaker(arg.getHuman(),1));
    }

}
