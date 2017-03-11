/**
 * Created by jakub on 11.03.17.
 */
interface IBankomat {
    Float wyplac(String numerKonta, String pin, Float kwota) throws Exception;

    Float saldo(String numerKonta, String pin) throws Exception;
}
