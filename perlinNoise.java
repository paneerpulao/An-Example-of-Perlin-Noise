import java.util.Arrays;
import java.util.Random;
public class perlinNoise {
    double[] ans;
    int octaves;
    int len;
    Random rand;
    perlinNoise(int o, int ll){
        octaves = o;
        len = ll;
        ans = new double[len];
        Arrays.fill(ans, 0.0d);
        rand = new Random();
    }
    public void main(String[] args) {
        this.solve();
    }
    void solve(){
        int l = len/2;
        int u = 0;
        
        ans[0] = rand.nextDouble();

        while(l<len){
            for(u = 0; u < len - l; u+=l){
                double a = 2.0*l*Math.random()/len, b = 2.0*l*Math.random()/len;
                // System.out.println(a + " " + b +" ");
                interpolate(a, b, u, u + l, ans);
            }
            for(int i = 0; i < len; i++){
                System.out.println(ans[i]);
            }
            System.out.println();
            l*=2;
        }
        // for(int i = 1; i < len; i++){
        //     ans[i-1] = ans[i] - ans[i-1];
        // }
        // for(int i = 0; i < 129; i++)
        //     System.out.print((int)ans[i]*100 + " ");
        
        // System.out.println();
    }
    // void solve(){
    //     solveHelpr(octaves, ans, 0, len-1);
    // }
    // void normalize(){

    //     double max = ans[0] - 0.0 != 0.00001? ans[0] : 0.00001;

    //     for(int i = 0; i < len; i++){
    //         if(ans[i] > max) max = ans[i];
    //     }
    //     if(max - 0.0 != 0.000001)
    //     for(int i = 0; i < len; i++){
    //         ans[i] = ans[i]/max;
    //     }
    // }
    // void solveHelpr(int octaves, double[] arr, int l, int r){
    //     if(octaves == 0) return;
    //     interpolate(2.0*(r-l)*rand.nextDouble()/len, 2.0*(r-l)*rand.nextDouble()/len, r - l, r, ans);
    //     solveHelpr(octaves - 1, arr, l, r/2);
    //     solveHelpr(octaves - 1, arr, r/2, r);
    // }
    void interpolate(double x, double y, int u, int v, double[] arr){
        // a lot of math
        // int l = v - u;
        // double cs = arr[v];
        int i = u;
        double mu2, mu;
        //int sign = Math.random() > 0.5 ? 1:-1;
        while(i<v){
            mu = (i-u)*1.0/(v-u);
            mu2 = (1-Math.cos(mu*Math.PI))/2;
            arr[i] += arr[u]*(1 - mu2) + arr[v]*mu2;
            //arr[i] += (cosX(i - u, v - u) - 1)*0.5*(arr[u] - arr[i]) + arr[u]; // cs = arr[u-l]
            //System.out.println(arr[v]);
            i++;
        }
    }
    double cosX(int x, int l){
        return Math.cos(Math.PI * x / l);
    }
}
