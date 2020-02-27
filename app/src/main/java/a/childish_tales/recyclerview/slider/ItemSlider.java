package a.childish_tales.recyclerview.slider;

public class ItemSlider {
    String id,title,desc,text,sound_file,sound_url,image,time,writer,narrator,my_sound,memory;
    int star, image_drawable;
    boolean displayed,favorite;

    public ItemSlider(String id, String title, String desc, String text, String sound_file, String sound_url, String image, String time, String writer, String narrator, String my_sound, String memory, int star, boolean displayed, boolean favorite) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.text = text;
        this.sound_file = sound_file;
        this.sound_url = sound_url;
        this.image = image;
        this.time = time;
        this.writer = writer;
        this.narrator = narrator;
        this.my_sound = my_sound;
        this.memory = memory;
        this.star = star;
        this.displayed = displayed;
        this.favorite = favorite;
    }
    public ItemSlider(String id, String title, String desc, String text, String sound_file, String sound_url, int image_drawable, String time, String writer, String narrator, String my_sound, String memory, int star, boolean displayed, boolean favorite) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.text = text;
        this.sound_file = sound_file;
        this.sound_url = sound_url;
        this.image_drawable = image_drawable;
        this.time = time;
        this.writer = writer;
        this.narrator = narrator;
        this.my_sound = my_sound;
        this.memory = memory;
        this.star = star;
        this.displayed = displayed;
        this.favorite = favorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSound_file() {
        return sound_file;
    }

    public void setSound_file(String sound_file) {
        this.sound_file = sound_file;
    }

    public String getSound_url() {
        return sound_url;
    }

    public void setSound_url(String sound_url) {
        this.sound_url = sound_url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public String getMy_sound() {
        return my_sound;
    }

    public void setMy_sound(String my_sound) {
        this.my_sound = my_sound;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }

    public boolean isDisplayed() {
        return displayed;
    }

    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
