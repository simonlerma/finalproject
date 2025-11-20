import javax.swing.*;
import java.awt.*;

public class App 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JPanel imagePanel = new JPanel();

        /*The Scene[] acts as a timeline of the game. Remember, the Scene class only associates the specific image,
        * text, and button text together. Scene allows these elements to be accessed by Main and Controller. 
        * Below is an example
        */
        Scene[] scenes = 
        {
            new Scene("ass.jpeg", "You walk into work.", "take stairs", "take elevator"),
            new Scene("asdf.jpeg", "Your coworkers hate your stank-ass", "leave", "stay"),
            //etc. However many scenes you want...
        };

    }
}
