/**
 * Created by jakub on 11.03.17.
 */
class Konto implements IKonto {
    private String numer;
    private String pin;
    private Float saldo;

    Konto(String numer, String pin, Float saldo) {
        this.numer = numer;
        this.pin = pin;
        this.saldo = saldo;
    }

    @Override
    public String getNumer() {
        return numer;
    }

    @Override
    public String getPin() {
        return pin;
    }

    @Override
    public Float getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Konto konto = (Konto) o;

        return numer.equals(konto.numer);

    }

    @Override
    public int hashCode() {
        return numer.hashCode();
    }
}
