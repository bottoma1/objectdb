package conference;

// дополнительный класс, использущийся для хранения записей о докладчиках, которые подали заявление на несколько направлений
public class MultiSpeaker {
    public Human human; // человек, который подал заявление
    public int number; // количество направлений, на которые он подал заявление

	// конструктор
    public MultiSpeaker(Human human, int number)
    {
        this.human=human;
        this.number=number;
    }
}
