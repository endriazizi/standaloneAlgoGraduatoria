public class Customer {

    // member variables
    String custName;
    String custCity;
    Integer custAge;
    String dataDiNascita;

    // 3-arg parameterized constructor

    // getters & setters

    // toString() method


    public Customer(String custName, String custCity, Integer custAge, String dataDiNascita) {
        this.custName = custName;
        this.custCity = custCity;
        this.custAge = custAge;
        this.dataDiNascita = dataDiNascita;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public Integer getCustAge() {
        return custAge;
    }

    public void setCustAge(Integer custAge) {
        this.custAge = custAge;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custName='" + custName + '\'' +
                ", custCity='" + custCity + '\'' +
                ", custAge=" + custAge +
                ", dataDiNascita='" + dataDiNascita + '\'' +
                '}';
    }
}