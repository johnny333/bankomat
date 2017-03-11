/**
 * Created by jakub on 11.03.17.
 */
interface IBankResponseSetters extends IBankResponseGetters {
    void setError(String error);

    void setKwota(Float kwota);
}
