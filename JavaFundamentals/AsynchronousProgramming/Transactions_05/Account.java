package AsynchronousProgramming.Transactions_05;

public class Account {
    int balance = 0;

    //make method synchronized to prevent lost of data when more of one thread use the method
    synchronized public void increment( int sum){
    balance += sum;
    }
}
