package a.childish_tales.recyclerview.multi;

import java.util.ArrayList;

public class MultiItem {
    public static final int TEXT_BOX = 92;
    public static final int IMAGE = 118;
    public static final int TITLE = 303;
    public static final int SLIDER_LAKCHERI = 135213;
    public static final int SLIDER_HORIZONTAL = 128;
    public static final int SLIDER_VERTICAL = 68;
    public static final int TWO_ICON = 110612222;

    int type;
    String story_title,story_desc,story_image,story_soundName,story_sound;
    String text,title,desc,image;
    boolean Boolean = false;
    String url;
    int on_click;
    ArrayList<MultiItem> arrayList;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStory_title() {
        return story_title;
    }

    public void setStory_title(String story_title) {
        this.story_title = story_title;
    }

    public String getStory_desc() {
        return story_desc;
    }

    public void setStory_desc(String story_desc) {
        this.story_desc = story_desc;
    }

    public String getStory_image() {
        return story_image;
    }

    public void setStory_image(String story_image) {
        this.story_image = story_image;
    }

    public String getStory_soundName() {
        return story_soundName;
    }

    public void setStory_soundName(String story_soundName) {
        this.story_soundName = story_soundName;
    }

    public String getStory_sound() {
        return story_sound;
    }

    public void setStory_sound(String story_sound) {
        this.story_sound = story_sound;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isBoolean() {
        return Boolean;
    }

    public void setBoolean(boolean aBoolean) {
        Boolean = aBoolean;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOn_click() {
        return on_click;
    }

    public void setOn_click(int on_click) {
        this.on_click = on_click;
    }

    public ArrayList<MultiItem> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<MultiItem> arrayList) {
        this.arrayList = arrayList;
    }
}
