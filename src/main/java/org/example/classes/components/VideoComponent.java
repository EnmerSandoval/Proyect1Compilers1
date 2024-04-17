package org.example.classes.components;

public class VideoComponent extends Component{
    private String origin;
    private String height;
    private String wide;
    public VideoComponent(String idComponent, String page, String classComponent, String origin, String height, String wide) {
        super(idComponent, page, classComponent);
        this.origin = origin;
        this.height = height;
        this.wide = wide;
    }

    public VideoComponent(String origin, String height, String wide){
        super();
        this.origin = origin;
        this.height = height;
        this.wide = wide;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }
}
