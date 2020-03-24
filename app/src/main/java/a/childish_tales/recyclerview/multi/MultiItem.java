package a.childish_tales.recyclerview.multi;

import java.util.ArrayList;

public class MultiItem {
    public static final int TEXT_BOX = 92;
    public static final int TWO_ICON = 110612222;
    public static final int SLIDER_LAKCHERI = 135213;
    public static final int IMAGE = 118;
    public static final int SLIDER_HORIZONTAL = 128;
    public static final int SLIDER_VERTICAL = 68;
    public static final int TITLE = 303;

    int type;
    String textBox;
    String image_1,text_1,image_2,text_2;
    String title_story,desc_story,image_story,sound_name_story,sound_story;
    ArrayList<MultiItem> itemSliderLakcheri;

    String image,title;
    String image_v,title_v,desc_v;
    String text_itemTitle;
    boolean show_flash = false;

    public MultiItem(int type, String textBox) {
        this.type = TEXT_BOX;
        this.textBox = textBox;
    }

    public MultiItem(int type, String image_1, String text_1, String image_2, String text_2) {
        this.type = TWO_ICON;
        this.image_1 = image_1;
        this.text_1 = text_1;
        this.image_2 = image_2;
        this.text_2 = text_2;
    }

    public MultiItem(int type,String title_story, String desc_story, String image_story, String sound_name_story, String sound_story) {
        this.type = SLIDER_LAKCHERI;
        this.title_story = title_story;
        this.desc_story = desc_story;
        this.image_story = image_story;
        this.sound_name_story = sound_name_story;
        this.sound_story = sound_story;
    }

    public MultiItem(ArrayList<MultiItem> itemSliderLakcheri) {
        this.itemSliderLakcheri = itemSliderLakcheri;
    }

    public MultiItem(int type, String image, String title) {
        this.type = IMAGE;
        if (type==SLIDER_HORIZONTAL)
            this.type = SLIDER_HORIZONTAL ;
        this.image = image;
        this.title = title;
    }

    public MultiItem(int type, String image_v, String title_v, String desc_v) {
        this.type = SLIDER_VERTICAL;
        this.image_v = image_v;
        this.title_v = title_v;
        this.desc_v = desc_v;
    }

    public MultiItem(int type, String text_itemTitle, boolean show_flash) {
        this.type = TITLE;
        this.text_itemTitle = text_itemTitle;
        this.show_flash = show_flash;
    }

    public static int getTextBox() {
        return TEXT_BOX;
    }

    public void setTextBox(String textBox) {
        this.textBox = textBox;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    public String getText_1() {
        return text_1;
    }

    public void setText_1(String text_1) {
        this.text_1 = text_1;
    }

    public String getImage_2() {
        return image_2;
    }

    public void setImage_2(String image_2) {
        this.image_2 = image_2;
    }

    public String getText_2() {
        return text_2;
    }

    public void setText_2(String text_2) {
        this.text_2 = text_2;
    }

    public String getTitle_story() {
        return title_story;
    }

    public void setTitle_story(String title_story) {
        this.title_story = title_story;
    }

    public String getDesc_story() {
        return desc_story;
    }

    public void setDesc_story(String desc_story) {
        this.desc_story = desc_story;
    }

    public String getImage_story() {
        return image_story;
    }

    public void setImage_story(String image_story) {
        this.image_story = image_story;
    }

    public String getSound_name_story() {
        return sound_name_story;
    }

    public void setSound_name_story(String sound_name_story) {
        this.sound_name_story = sound_name_story;
    }

    public String getSound_story() {
        return sound_story;
    }

    public void setSound_story(String sound_story) {
        this.sound_story = sound_story;
    }

    public ArrayList<MultiItem> getItemSliderLakcheri() {
        return itemSliderLakcheri;
    }

    public void setItemSliderLakcheri(ArrayList<MultiItem> itemSliderLakcheri) {
        this.itemSliderLakcheri = itemSliderLakcheri;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_v() {
        return image_v;
    }

    public void setImage_v(String image_v) {
        this.image_v = image_v;
    }

    public String getTitle_v() {
        return title_v;
    }

    public void setTitle_v(String title_v) {
        this.title_v = title_v;
    }

    public String getDesc_v() {
        return desc_v;
    }

    public void setDesc_v(String desc_v) {
        this.desc_v = desc_v;
    }

    public String getText_itemTitle() {
        return text_itemTitle;
    }

    public void setText_itemTitle(String text_itemTitle) {
        this.text_itemTitle = text_itemTitle;
    }

    public boolean isShow_flash() {
        return show_flash;
    }

    public void setShow_flash(boolean show_flash) {
        this.show_flash = show_flash;
    }

    public static int getTwoIcon() {
        return TWO_ICON;
    }

    public static int getSliderLakcheri() {
        return SLIDER_LAKCHERI;
    }

    public static int getIMAGE() {
        return IMAGE;
    }

    public static int getSliderHorizontal() {
        return SLIDER_HORIZONTAL;
    }

    public static int getSliderVertical() {
        return SLIDER_VERTICAL;
    }

    public static int getTITLE() {
        return TITLE;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
