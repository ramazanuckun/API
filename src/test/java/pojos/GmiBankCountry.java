package pojos;

public class GmiBankCountry {

    private int id;
    private String name;
    private  String status;

    public GmiBankCountry() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GmiBankCountry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public GmiBankCountry(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
