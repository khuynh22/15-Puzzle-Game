import javafx.scene.control.Button;

public class MyButton extends Button {
    public int row;
    public int col;
    public int val;
    public int posX;
    public int posY;

    // 3 args constructor for Button
    MyButton(int r, int c, int v) {
        row = r;
        col = c;
        val = v;
        posX = 300 * (c + 1);
        posY = 100 * (r + 1);

        setPrefSize(100, 100);
        setDisable(true);
        if (v != 0) {
            setText(String.valueOf(v));
            setStyle("-fx-background-color: coral");
        } else {
            setText(String.valueOf(v));
            setStyle("-fx-background-color: papayawhip");
        }
    }

    public void changeValue(int v) {
        val = v;
        setText(String.valueOf(v));
        if (v != 0) {
            setStyle("-fx-background-color: coral");
            setDisable((false));
        } else {
            setStyle("-fx-background-color: papayawhip");
            setDisable(true);
        }
    }
}
