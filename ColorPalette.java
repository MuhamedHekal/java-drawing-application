import java.awt.List;
public class ColorPalette {
    public List colors = new List();

    public void addColor(String color){
        colors.add(color);
    }

    public String getColor(int index){
        return colors.getItem(index);
    }
}
