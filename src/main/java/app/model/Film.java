package app.model;

public class Film extends Model
{

    private String name;
    private int duration;
    private Type type;

    private Film(){}

    public Film(String name, int duration, String type)
    {
        this.name = name;
        this.duration = duration;
        this.type = Type.valueOf(type);
    }

    public Film(int duration, String type)
    {
        this.duration = duration;
        this.type = Type.valueOf(type);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)return true;
        if(o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if(duration != film.duration)return false;
        if(name != null ? !name.equals(film.name) : film.name != null) return false;
        return type != null ? type.equals(film.type) : film.type == null;
    }

    @Override
    public int hashCode()
    {
        int mult = 31;
        int result = name!=null ? name.hashCode() : 0;
        result = mult * result + (type != null ? type.hashCode() : 0);
        result = mult * result + duration;

        return result;
    }
}
