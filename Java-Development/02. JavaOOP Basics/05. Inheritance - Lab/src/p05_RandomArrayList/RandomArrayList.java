package p05_RandomArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random random;

    public RandomArrayList(){
        this.random = new Random();
    }


    public Object getRandomElement(){
        int index = this.random.nextInt(this.size());
        Object object = this.get(index);
        this.remove(index);
        return object;
    }
}
