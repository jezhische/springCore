package clients;

/**
 * Created by WORK_x64 on 02.03.2017.
 */
public class Client {
    private String id, fullName, greetings;
    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGreetings (String gr) {
        greetings = gr;
    }

}
