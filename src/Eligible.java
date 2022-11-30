public interface Eligible {
    public void accept();
    public void reject();
    public void withdraw();
    public boolean isEligible(Station station);
}
