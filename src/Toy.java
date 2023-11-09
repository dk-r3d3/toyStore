public class Toy implements Comparable<Toy> {
    protected int id;
    protected String name;
    protected int count;
    protected int frequency;

    public Toy(int id, String name, int count, int frequency) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return id +
                ". Игрушка '" + name + '\'' +
                ", количество - " + count +
                ", частота выпадения - " + frequency;
    }

    public int compareTo(Toy other) {
        return this.frequency - other.frequency;
    }
}