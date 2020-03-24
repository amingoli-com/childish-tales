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
    String text_TEXTBOX;
    String image_1_TWOICON, text_1_TWOICON, image_2_TWOICON, text_2_TWOICON;
    String title_LAKCHERI, desc_LAKCHERI, image_LAKCHERI, sound_name_LAKCHERI, sound_LAKCHERI;
    ArrayList<MultiItem> itemSliderLakcheri;

    String image_IMAGE_and_SHORIZONTAL,title_IMAGE_and_SHORIZONTAL;
    String image_SVERTICAL,title_SVERTICAL,desc_SVERTICAL;
    String text_TITLE;
    boolean show_flash_TITLE = false;

    public MultiItem(int type, String text) {
        this.type = TEXT_BOX;
        this.text_TEXTBOX = text;
    }

    public MultiItem(int type, String image_1, String text_1, String image_2, String text_2) {
        this.type = TWO_ICON;
        this.image_1_TWOICON = image_1;
        this.text_1_TWOICON = text_1;
        this.image_2_TWOICON = image_2;
        this.text_2_TWOICON = text_2;
    }

    public MultiItem(int type,String title_story, String desc_story, String image_story, String sound_name_story, String sound_story) {
        this.type = SLIDER_LAKCHERI;
        this.title_LAKCHERI = title_story;
        this.desc_LAKCHERI = desc_story;
        this.image_LAKCHERI = image_story;
        this.sound_name_LAKCHERI = sound_name_story;
        this.sound_LAKCHERI = sound_story;
    }

    public MultiItem(ArrayList<MultiItem> itemSliderLakcheri) {
        this.itemSliderLakcheri = itemSliderLakcheri;
    }

    public MultiItem(int type, String image, String title) {
        this.type = IMAGE;
        if (type==SLIDER_HORIZONTAL)
            this.type = SLIDER_HORIZONTAL ;
        this.image_IMAGE_and_SHORIZONTAL = image;
        this.title_IMAGE_and_SHORIZONTAL = title;
    }

    public MultiItem(int type, String image_v, String title_v, String desc_v) {
        this.type = SLIDER_VERTICAL;
        this.image_SVERTICAL = image_v;
        this.title_SVERTICAL = title_v;
        this.desc_SVERTICAL = desc_v;
    }

    public MultiItem(int type, String text_itemTitle, boolean show_flash) {
        this.type = TITLE;
        this.text_TITLE = text_itemTitle;
        this.show_flash_TITLE = show_flash;
    }

    public static int getTextBox() {
        return TEXT_BOX;
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

    public String getText_TEXTBOX() {
        return text_TEXTBOX;
    }

    public void setText_TEXTBOX(String text_TEXTBOX) {
        this.text_TEXTBOX = text_TEXTBOX;
    }

    public String getImage_1_TWOICON() {
        return image_1_TWOICON;
    }

    public void setImage_1_TWOICON(String image_1_TWOICON) {
        this.image_1_TWOICON = image_1_TWOICON;
    }

    public String getText_1_TWOICON() {
        return text_1_TWOICON;
    }

    public void setText_1_TWOICON(String text_1_TWOICON) {
        this.text_1_TWOICON = text_1_TWOICON;
    }

    public String getImage_2_TWOICON() {
        return image_2_TWOICON;
    }

    public void setImage_2_TWOICON(String image_2_TWOICON) {
        this.image_2_TWOICON = image_2_TWOICON;
    }

    public String getText_2_TWOICON() {
        return text_2_TWOICON;
    }

    public void setText_2_TWOICON(String text_2_TWOICON) {
        this.text_2_TWOICON = text_2_TWOICON;
    }

    public String getTitle_LAKCHERI() {
        return title_LAKCHERI;
    }

    public void setTitle_LAKCHERI(String title_LAKCHERI) {
        this.title_LAKCHERI = title_LAKCHERI;
    }

    public String getDesc_LAKCHERI() {
        return desc_LAKCHERI;
    }

    public void setDesc_LAKCHERI(String desc_LAKCHERI) {
        this.desc_LAKCHERI = desc_LAKCHERI;
    }

    public String getImage_LAKCHERI() {
        return image_LAKCHERI;
    }

    public void setImage_LAKCHERI(String image_LAKCHERI) {
        this.image_LAKCHERI = image_LAKCHERI;
    }

    public String getSound_name_LAKCHERI() {
        return sound_name_LAKCHERI;
    }

    public void setSound_name_LAKCHERI(String sound_name_LAKCHERI) {
        this.sound_name_LAKCHERI = sound_name_LAKCHERI;
    }

    public String getSound_LAKCHERI() {
        return sound_LAKCHERI;
    }

    public void setSound_LAKCHERI(String sound_LAKCHERI) {
        this.sound_LAKCHERI = sound_LAKCHERI;
    }

    public ArrayList<MultiItem> getItemSliderLakcheri() {
        return itemSliderLakcheri;
    }

    public void setItemSliderLakcheri(ArrayList<MultiItem> itemSliderLakcheri) {
        this.itemSliderLakcheri = itemSliderLakcheri;
    }

    public String getImage_IMAGE_and_SHORIZONTAL() {
        return image_IMAGE_and_SHORIZONTAL;
    }

    public void setImage_IMAGE_and_SHORIZONTAL(String image_IMAGE_and_SHORIZONTAL) {
        this.image_IMAGE_and_SHORIZONTAL = image_IMAGE_and_SHORIZONTAL;
    }

    public String getTitle_IMAGE_and_SHORIZONTAL() {
        return title_IMAGE_and_SHORIZONTAL;
    }

    public void setTitle_IMAGE_and_SHORIZONTAL(String title_IMAGE_and_SHORIZONTAL) {
        this.title_IMAGE_and_SHORIZONTAL = title_IMAGE_and_SHORIZONTAL;
    }

    public String getImage_SVERTICAL() {
        return image_SVERTICAL;
    }

    public void setImage_SVERTICAL(String image_SVERTICAL) {
        this.image_SVERTICAL = image_SVERTICAL;
    }

    public String getTitle_SVERTICAL() {
        return title_SVERTICAL;
    }

    public void setTitle_SVERTICAL(String title_SVERTICAL) {
        this.title_SVERTICAL = title_SVERTICAL;
    }

    public String getDesc_SVERTICAL() {
        return desc_SVERTICAL;
    }

    public void setDesc_SVERTICAL(String desc_SVERTICAL) {
        this.desc_SVERTICAL = desc_SVERTICAL;
    }

    public String getText_TITLE() {
        return text_TITLE;
    }

    public void setText_TITLE(String text_TITLE) {
        this.text_TITLE = text_TITLE;
    }

    public boolean isShow_flash_TITLE() {
        return show_flash_TITLE;
    }

    public void setShow_flash_TITLE(boolean show_flash_TITLE) {
        this.show_flash_TITLE = show_flash_TITLE;
    }
}
