package conference;

public class Human {
    private String fio;
    private String science_degree;
    private String science_status;
    private String country;
    private String city;

    public Human(String fio, String science_degree, String science_status, String country, String city)
    {
        this.fio=fio;
        this.science_degree=science_degree;
        this.science_status=science_status;
        this.country=country;
        this.city=city;
    }

    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return "Human [fio=" + fio + ", science_degree=" + science_degree + ", science_status=" + science_status + ", country=" + country + ", city=" + city + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;

        if (fio == null) {
            if (other.fio != null)
                return false;
        } else if (!fio.equals(other.fio))
            return false;

        if (science_degree == null) {
            if (other.science_degree != null)
                return false;
        } else if (!science_degree.equals(other.science_degree))
            return false;

        if (science_status == null) {
            if (other.science_status != null)
                return false;
        } else if (!science_status.equals(other.science_status))
            return false;

        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;

        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        return true;
    }
}
