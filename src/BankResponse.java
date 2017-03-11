/**
 * Created by jakub on 11.03.17.
 */
class BankResponse implements IBankResponseGetters, IBankResponseSetters {
    private String error = "";
    private Float kwota = 0f;

    @Override
    public String getError() {
        return this.error;
    }

    @Override
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public Float getKwota() {
        return this.kwota;
    }

    @Override
    public void setKwota(Float kwota) {
        this.kwota = kwota;
    }
}
