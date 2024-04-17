package org.example.classes.components;

public class TextComponent extends Component{
    private String text;
    private String lineUp;
    private String color;
    public TextComponent(String idComponent, String page, String classComponent, String text, String lineUp, String color) {
        super(idComponent, page, classComponent);
        this.text = text;
        this.lineUp = lineUp;
        this.color = color;
    }

    public TextComponent(String text, String lineUp, String color){
        super();
        this.text = text;
        this.lineUp = lineUp;
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
