package springEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by WORK_x64 on 13.03.2017.
 */
public class FooService {
    private String name;
    @Autowired
    @Qualifier("fooService2")
    FooService fooService;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String doStuff(){
        return name + ".doStuff()";
    }
}
