package generics;

import java.time.LocalDateTime;

public class StringStorage {

    private String value;
    private LocalDateTime storedTime;

    public StringStorage(String value) {
        this.value = value;
        this.storedTime = LocalDateTime.now();
    }

    public String getStoreInfo() {
        return "You Stored " + value + " at " + storedTime;
    }

}
