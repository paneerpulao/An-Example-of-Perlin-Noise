import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class perlinNoiseGUI {
    perlinNoiseGUI(){
        perlinNoise x[][] = new perlinNoise[3][2];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                x[j][i] = new perlinNoise(5, 129);
                x[j][i].solve();
                // x[j][i].normalize();
            }
        }
        // for(int i = 0; i < 129; i++){
        //     System.out.println(x[0][0].ans[i]);
        // }

        JFrame f=new JFrame("Perlin Noise Example - by Suryansh");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel[][] pix = new JPanel[129][129];
        for(int i = 0; i < 129; i++){
            for(int j = 0; j < 129; j++){
                pix[i][j] = new JPanel();
                pix[i][j].setBounds(i*2, j*2, 2, 2 );
                int r = (int)(255*(x[0][1].ans[i] + x[0][0].ans[j])/2.0)
                , g = (int)(255*(x[1][1].ans[i] + x[1][0].ans[j])/2.0)
                , b = (int)(255*(x[2][1].ans[i] + x[2][0].ans[j])/2.0);
                pix[i][j].setBackground(new Color( r > 255 ? 255: r, g > 255 ? 255: g, b > 255 ? 255:b));
                f.add(pix[i][j]);
                //System.out.println((x[0][1].ans[i] + x[0][0].ans[j])/2.0);
            }
        }
        f.setSize(272,295);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        return;
    }
}
