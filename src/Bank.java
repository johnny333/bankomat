import java.util.HashSet;
import java.util.Set;

/**
 * Created by jakub on 11.03.17.
 */
public class Bank implements IBankomat {

    private Set<IKonto> konta = new HashSet<>();

    Bank(Set<IKonto> konta) {
        this.konta = konta;
    }

    @Override
    public Float wyplac(String numerKonta, String pin, Float kwota) throws Exception {
        if (!this.konta.stream().filter(iKonto -> iKonto.getNumer().equals(numerKonta)).findFirst().isPresent()) {
            throw new Exception("Konto nie istnieje");
        }
        if (!this.konta.stream().filter(iKonto -> iKonto.getNumer().equals(numerKonta)).findFirst().get().getPin().equals(pin)) {
            throw new Exception("Nie poprawny kod pin");
        }
        if (this.konta.stream().filter(iKonto -> iKonto.getNumer().equals(numerKonta)).findFirst().get().getSaldo() - kwota < 0) {
            throw new Exception("Brak wystarczającej ilości środków");
        }
        this.konta.stream().filter(iKonto -> iKonto.getNumer().equals(numerKonta)).findFirst().get().setSaldo(this.konta.stream().filter(iKonto -> iKonto.getNumer().equals(numerKonta)).findFirst().get().getSaldo() - kwota);
        return kwota;
    }

    @Override
    public Float saldo(String numerKonta, String pin) throws Exception {
        if (!this.konta.stream().filter(iKonto -> iKonto.getNumer().equals(numerKonta)).findFirst().isPresent()) {
            throw new Exception("Konto nie istnieje");
        }
        if (!this.konta.stream().filter(iKonto -> iKonto.getNumer().equals(numerKonta)).findFirst().get().getPin().equals(pin)) {
            throw new Exception("Nie poprawny kod pin");
        }
        return this.konta.stream().filter(iKonto -> iKonto.getNumer().equals(numerKonta)).findFirst().get().getSaldo();
    }
}
