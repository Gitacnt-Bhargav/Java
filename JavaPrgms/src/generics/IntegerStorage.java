package generics;

import java.time.LocalDateTime;

public class IntegerStorage {

    private Integer value;
    private LocalDateTime localDateTime;

    public IntegerStorage(Integer value){
        this.value = value;
        this.localDateTime = LocalDateTime.now();
    }

    public String getStoreInfo(){
        return "Your store " + value + " at " + localDateTime;
    }
}
