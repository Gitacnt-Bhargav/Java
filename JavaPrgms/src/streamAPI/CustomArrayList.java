package streamAPI;

import java.util.ArrayList;

public class CustomArrayList<Object> extends ArrayList<Object> {

    @Override
    public boolean add(Object e){
        if(this.contains(e))
            return false;
        return super.add(e);
    }
}
