package org.example.classes.components;

public class TextComponent extends Component{
    private String text;
    private String lineUp;
    private String color;


    public TextComponent(String idComponent, String page, String classComponent, String text, String lineUp, String color, int flag) {
        super(idComponent, page, classComponent, flag);
        this.text = text;
        this.lineUp = lineUp;
        this.color = color;
    }

    public TextComponent(String text, String lineUp, String color, int flag){
        super(flag);
        this.text = text;
        this.lineUp = lineUp;
        this.color = color;
    }

    public TextComponent(String text, int flag){
        super(flag);
        this.text = text;
    }

    public  TextComponent(String text, String lineUp, int flag){
        super(flag);
        this.text = text;
        this.lineUp = lineUp;
    }

    public  TextComponent(String text, int flag, String color){
        super(flag);
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLineUp() {
        return lineUp;
    }

    public void setLineUp(String lineUp) {
        this.lineUp = lineUp;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
