package generics_lab.one_jar_of_T;

public class Main {
    public static void main(String[] args) {
        Jar<Pickle> jarOfPickle = new Jar<>();

        jarOfPickle.add(new Pickle());
        jarOfPickle.add(new Pickle());

        Pickle pickle = jarOfPickle.remove();
    }
}
