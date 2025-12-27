package AsynchronousProgramming.Deadlock_06;

public class MyClass {

        String id;

    public MyClass(String id) {
        this.id = id;
    }

    synchronized void a (MyClass other){
        System.out.printf("%s called method A on %s%n", this.id, other.id);
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        other.b(this);
    }

    synchronized void b(MyClass other){
        System.out.printf("%s called method B on %s%n", other.id, this.id);

        other.c();
    }

    synchronized private void c(){
        System.out.println(this.id  + " done");
    }
}

