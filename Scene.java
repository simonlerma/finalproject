import javax.swing.*;
import java.awt.*;

public class Scene 
{
    private String imagePath;
    private String sceneText;
    private String buttonOneText;
    private String buttonTwoText;

    public Scene(String img, String sTxt, String b1Txt, String b2Txt)
    {
        this.imagePath = img;
        this.sceneText = sTxt;
        this.buttonOneText = b1Txt;
        this.buttonTwoText = b2Txt;                                                
    }

    public String getImageFilePath()
    {
        return imagePath;
    }

    public String getScneneText()
    {
        return sceneText;
    }

    public String getButtonOneText()
    {
        return buttonOneText;
    }

    public String getButtonTwoText()
    {
        return buttonTwoText;
    }
}
