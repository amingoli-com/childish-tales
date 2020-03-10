package a.childish_tales.recyclerview.slider;

public class ItemSlider {
    String id,title,desc,text,imageـurl,time,recorder,sound_name,sound_url;

    public ItemSlider(String id, String title, String desc, String text, String imageـurl,String time, String recorder, String sound_name, String sound_url) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.text = text;
        this.imageـurl = imageـurl;
        this.time = time;
        this.recorder = recorder;
        this.sound_name = sound_name;
        this.sound_url = sound_url;
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

    public String getImageـurl() {
        return imageـurl;
    }

    public void setImageـurl(String imageـurl) {
        this.imageـurl = imageـurl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getSound_name() {
        return sound_name;
    }

    public void setSound_name(String sound_name) {
        this.sound_name = sound_name;
    }

    public String getSound_url() {
        return sound_url;
    }

    public void setSound_url(String sound_url) {
        this.sound_url = sound_url;
    }
}
