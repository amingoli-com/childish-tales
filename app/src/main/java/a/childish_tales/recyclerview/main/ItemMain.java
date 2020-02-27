package a.childish_tales.recyclerview.main;

import java.util.ArrayList;

import a.childish_tales.recyclerview.slider.ItemSlider;

public class ItemMain {
    String title;
    ArrayList<ItemSlider> itemTwos;

    public ItemMain(String title, ArrayList<ItemSlider> itemTwos) {
        this.title = title;
        this.itemTwos = itemTwos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ItemSlider> getItemTwos() {
        return itemTwos;
    }

    public void setItemTwos(ArrayList<ItemSlider> itemTwos) {
        this.itemTwos = itemTwos;
    }
}
