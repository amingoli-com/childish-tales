package a.childish_tales.MAIN;

import java.util.ArrayList;
import java.util.List;

import a.childish_tales.TWO.ItemTwo;

public class ItemMain {
    String title;
    ArrayList<ItemTwo> itemTwos;

    public ItemMain(String title, ArrayList<ItemTwo> itemTwos) {
        this.title = title;
        this.itemTwos = itemTwos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ItemTwo> getItemTwos() {
        return itemTwos;
    }

    public void setItemTwos(ArrayList<ItemTwo> itemTwos) {
        this.itemTwos = itemTwos;
    }
}
