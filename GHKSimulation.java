import java.util.Scanner;

public class GHKSimulation {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      
      // constant values
      double R = 8.314; // J/(mol·K)
      double T = 294.75; // K
      double F = 96485; // C/mol
      
      // potassium parameter values
      double pK = 1;
      double[] outsideK = {5,10,15,25,35,100,150,180,200};
      double insideK = 210;
      
      // sodium parameter values
      double pNa = 0.075;
      double outsideNa = 145;
      double insideNa = 13;
      
      // chlorine parameter values
      double pCl = 0.5;
      double outsideCl = 130;
      double insideCl = 13;
      
      // calculation
      double[] V = new double[outsideK.length];
      for(int i = 0; i < outsideK.length; i++) {
         double currentOutsideK = outsideK[i];
         double insideStuff = ((pK * currentOutsideK) + (pNa * outsideNa) + (pCl * insideCl)) /
                              ((pK * insideK) + (pNa * insideNa) + (pCl * outsideCl));
         V[i] = ((R * T) / F) * Math.log(insideStuff);
      }
      
      for(int i = 0; i < V.length; i++) {
         System.out.println(V[i]);
      }
      
      stdin.close();
   }
}