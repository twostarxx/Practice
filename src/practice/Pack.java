package practice;

import java.util.Arrays;

public class Pack {

    static int N = 5;  // 物品个数
    static int V = 10;  // 最大容量
    static int[] C = {1, 2, 3, 4, 5};   // 对应V，花费，体积等
    static int[] W = {5, 4, 3, 2, 1};   // 价值
    static int[] R = {1, 2, 3, 4, 5};   // 物品个数

    static int[] weath = new int[V+1];

    public static void main(String[] args) {
        // 01背包
        int zerooneres = ZeroOnePack();
        System.out.println(zerooneres);

        Arrays.fill(weath, 0);
        // 完全背包
        int completres = CompletePack();
        System.out.println(completres);
//
//        // 多重背包
//        int multipleres = MultiplePack();
//        System.out.println(multipleres);
    }

    //    01背包问题
    public static int ZeroOnePack(){
        for (int i=0; i<N; i++) {
            helpZeroOnePack(C[i], W[i]);
        }

        int maxW = Integer.MIN_VALUE;
        for (int j=0; j<=V; j++) {
            maxW = Math.max(maxW, weath[j]);
        }
        System.out.println("ZeroOnePack: " + Arrays.toString(weath));
        return maxW;
    }
    public static void helpZeroOnePack(int cost_i, int weath_i){
        for (int v=V; v>0; v--) {
            if (v-cost_i >= 0)
                weath[v] = Math.max(weath[v], weath[v-cost_i]+weath_i);
        }
    }

    //    完全背包问题
    public static int CompletePack(){
        for (int i=0; i<N; i++){
            helpCompletePack(C[i], W[i]);
        }

        int maxW = Integer.MIN_VALUE;
        for (int j=0; j<=V; j++) {
            maxW = Math.max(maxW, weath[j]);
        }
        System.out.println("CompletePack: " + Arrays.toString(weath));
        return maxW;
    }
    public static void helpCompletePack(int cost_i, int weath_i){
        for (int v=cost_i; v<=V; v++) {
            if (v-cost_i >= 0)
                weath[v] = Math.max(weath[v], weath[v-cost_i]+weath_i);
        }
    }

    //    多重背包问题
    public static int MultiplePack(){
        int maxW = Integer.MIN_VALUE;
//        helpMultiplePack();
        return maxW;
    }
    public static void helpMultiplePack(int cost_i, int weath_i, int num_i){
        int maxW = Integer.MIN_VALUE;
        if (cost_i*weath_i > V) {    // 无限取用，等同于CompletePack
            helpCompletePack(cost_i, weath_i);
        } else {                // 有限取用，用k进行放置，k=k*2

        }
    }

}
