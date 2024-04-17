package org.example.classes.components;

public class ImageComponent extends Component{

    private String origin;
    private String lineUp;
    private String height;
    private String wide;
    public ImageComponent(String idComponent, String page, String classComponent, String origin, String lineUp, String height, String wide) {
        super(idComponent, page, classComponent);
        this.origin = origin;
        this.lineUp = lineUp;
        this.height = height;
        this.wide = wide;
    }

    public ImageComponent(String origin, String lineUp, String height, String wide){
        super();
        this.origin = origin;
        this.lineUp = lineUp;
        this.height = height;
        this.wide = wide;
    }
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLineUp() {
        return lineUp;
    }

    public void setLineUp(String lineUp) {
        this.lineUp = lineUp;
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
