public class Scene {
    private String imagePath;
    private String sceneText;
    private String buttonOneText;
    private String buttonTwoText;
    private int nextSceneOne;
    private int nextSceneTwo;

    public Scene(String imagePath, String sceneText, String buttonOneText, String buttonTwoText,
                int nextSceneOne, int nextSceneTwo) {
        this.imagePath = imagePath;
        this.sceneText = sceneText;
        this.buttonOneText = buttonOneText;
        this.buttonTwoText = buttonTwoText;
        this.nextSceneOne = nextSceneOne;
        this.nextSceneTwo = nextSceneTwo;
    }

    public String getImagePath() { return imagePath; }
    public String getSceneText() { return sceneText; }
    public String getButtonOneText() { return buttonOneText; }
    public String getButtonTwoText() { return buttonTwoText; }
    public int getNextSceneOne() { return nextSceneOne; }
    public int getNextSceneTwo() { return nextSceneTwo; }
}
