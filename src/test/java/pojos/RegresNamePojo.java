package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegresNamePojo {

    private String name;

    public RegresNamePojo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RegresNamePojo{" +
                "name='" + name + '\'' +
                '}';
    }

    public RegresNamePojo() {
    }
}
