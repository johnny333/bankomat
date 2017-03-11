import java.util.Scanner;

/**
 * Created by jakub on 11.03.17.
 */
class Bankomat implements IBankomatInterface {
    private IBankomat iBank;
    private Scanner scanner = new Scanner(System.in);

    Bankomat(IBankomat iBank) {
        this.iBank = iBank;
    }

    private IBankResponseSetters wyplac(String numerKonta, String pin, Float aKwota) {
        IBankResponseSetters kwota = new BankResponse();
        try {
            kwota.setKwota(iBank.wyplac(numerKonta, pin, aKwota));
        } catch (Exception e) {
            kwota.setError(e.getMessage());
        }
        return kwota;

    }

    private IBankResponseSetters saldo(String numerKonta, String pin) {
        IBankResponseSetters kwota = new BankResponse();

        try {
            kwota.setKwota(this.iBank.saldo(numerKonta, pin));
        } catch (Exception e) {
            kwota.setError(e.getMessage());
        }
        return kwota;
    }

    @Override
    public String wprowadzNumerKonta() {
        System.out.println("Wprowadź numer konta:");
        System.out.print("numer>>");
        return scanner.nextLine();
    }

    @Override
    public String wprowadzPin() {
        System.out.println("Wprowadź numer pin:");
        System.out.print("pin>>");
        return scanner.nextLine();
    }

    @Override
    public Float wprowadzKwote() {
        System.out.println("Wprowadź kwotę:");
        System.out.print("kwota>>");
        return Float.valueOf(scanner.nextLine());
    }

    @Override
    public void pokazInterface() {
        Boolean koniec = false;
        do {
            System.out.println();
            System.out.println("==========================>");
            System.out.println("Aby wypłacić kwotę wybierz 1:");
            System.out.println("Aby sprawdzić saldo wybierz 2:");
            System.out.print("wybór>>");
            switch (Integer.valueOf(scanner.nextLine())) {
                case 1:
                    IBankResponseGetters wyplata = this.wyplac(this.wprowadzNumerKonta(), this.wprowadzPin(), this.wprowadzKwote());
                    System.out.println(wyplata.getError().isEmpty() ? "Wypłacono kwotę:" + wyplata.getKwota() : wyplata.getError());
                    break;
                case 2:
                    IBankResponseGetters saldo = this.saldo(this.wprowadzNumerKonta(), this.wprowadzPin());
                    System.out.println(saldo.getError().isEmpty() ? "Saldo konta:" + saldo.getKwota() : saldo.getError());
                    break;
                default:
                    koniec = true;

            }
        } while (koniec.equals(false));
    }
}
