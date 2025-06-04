package generics;

import java.time.LocalDateTime;

public class genericsFunctionality <T> {

    T value;
    LocalDateTime localDateTime;

    public genericsFunctionality(T value){
        this.value = value;
        this.localDateTime = LocalDateTime.now();
    }

    public String getStoreInfo() {
        return "Your store value is " + value + " at " + localDateTime;
    }
}

class storeUsage{

    public void printInfo(){
        genericsFunctionality<String> genericsFunctionality = new genericsFunctionality<>("s");
        System.out.println(genericsFunctionality.getStoreInfo());

        genericsFunctionality<Integer> genericsFunctionalityInteger = new genericsFunctionality<>(100);
        System.out.println(genericsFunctionalityInteger.getStoreInfo());
    }

    public static void main(String[] args) {
        storeUsage storeUsage = new storeUsage();
        storeUsage.printInfo();
    }

}



