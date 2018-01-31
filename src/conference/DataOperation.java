package conference;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.time.*;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class DataOperation {
	
	private ObjectContainer data;
		
	public DataOperation(ObjectContainer data) {
		this.data = data;
	}

	public void createData() {
		Human human1 = new Human("Петров Петр Петрович", "кандидат наук", "доцент", "Россия", "Ижевск");
		data.store(human1);
		Human human2 = new Human("Иванов Иван Иванович", "кандидат наук", "профессор", "Россия", "Москва");
		data.store(human2);
		Human human3 = new Human("Князев Илья Алексеевич", "доктор наук", "профессор", "Россия", "Казань");
		data.store(human3);
		Human human4 = new Human("Никитин Никита Александрович", "кандидат наук", "доцент", "Белоруссия", "Минск");
		data.store(human4);
		Human human5 = new Human("Сидоров Олег Андреевич", "доктор наук", "доцент", "Украина", "Киев");
		data.store(human5);

		Meeting meeting1 = new Meeting("информационные технологии", 123, LocalTime.of(12, 15));
		data.store(meeting1);
		Meeting meeting2 = new Meeting("биотехнологии", 125, LocalTime.of(12, 45));
		data.store(meeting2);
		Meeting meeting3 = new Meeting("строительство", 111, LocalTime.of(13, 15));
		data.store(meeting3);
		Meeting meeting4 = new Meeting("производство", 133, LocalTime.of(13, 15));
		data.store(meeting4);
		Meeting meeting5 = new Meeting("новые материалы", 234, LocalTime.of(14, 15));
		data.store(meeting5);

		Member member1 = new Member(human1, meeting1, true, parseDate("01-12-2017"), parseDate("02-12-2017"), "технологии в действии", true);
		data.store((member1));
		Member member2 = new Member(human2, meeting1, false, parseDate("01-12-2017"), parseDate("05-12-2017"), "", false);
		data.store((member2));
		Member member3 = new Member(human1, meeting2, true, parseDate("02-12-2017"), parseDate("10-12-2017"), "искуственные части тела", true);
		data.store((member3));
		Member member4 = new Member(human3, meeting2, false, parseDate("02-12-2017"), parseDate("03-12-2017"), "", false);
		data.store((member4));
		Member member5 = new Member(human4, meeting3, true, parseDate("01-12-2017"), parseDate("03-12-2017"), "кирпичи из воздуха", false);
		data.store((member5));
	}

	// функция для преобразования строки с датой в тип Date
	public static Date parseDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern("dd-MM-yyyy");
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}


}
