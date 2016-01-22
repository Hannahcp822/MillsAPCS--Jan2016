
/**
 * Write a description of class DrumKitTestDrive here.
 * 
 * @author Hannah Pang
 * @version January 21, 2016
 */

class DrumKitTestDrive
{
    public static void main(String[] args) 
    {
        DrumKit d = new DrumKit();
        d.playSnare();
        d.snare = false;
        d.playTopHat();
        
        if (d.snare == true) {
            d.playSnare();
        }
    }
}
    
