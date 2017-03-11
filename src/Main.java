import java.util.HashSet;
import java.util.Set;

/**
 * Created by jakub on 11.03.17.
 */
public class Main {
    public static void main(String[] args) {
        IKonto konto1 = new Konto("1", "1", 10000f);
        IKonto konto2 = new Konto("2", "2", 10000f);
        IKonto konto3 = new Konto("3", "3", 10000f);
        IKonto konto4 = new Konto("4", "4", 10000f);
        IKonto konto5 = new Konto("5", "5", 10000f);
        IKonto konto6 = new Konto("6", "6", 10000f);
        Set<IKonto> konta = new HashSet<>();
        konta.add(konto1);
        konta.add(konto2);
        konta.add(konto3);
        konta.add(konto4);
        konta.add(konto5);
        konta.add(konto6);
        IBankomat bank = new Bank(konta);
        IBankomatInterface bankomatInterface = new Bankomat(bank);
        bankomatInterface.pokazInterface();
    }

}
