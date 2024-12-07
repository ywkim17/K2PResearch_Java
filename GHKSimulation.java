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
      double outsideK = 0;
      double insideK = 140;
      
      // sodium parameter values
      double pNa = 0.00000001;
      double outsideNa = 130;
      double insideNa = 10;
      
      // chlorine parameter values
      double pCl = 1;
      double outsideCl = 130;
      double insideCl = 10;
      
      // calculation
      double insideStuff = ((pK * outsideK) + (pNa * outsideNa) + (pCl * insideCl)) /
                              ((pK * insideK) + (pNa * insideNa) + (pCl * outsideCl));
      double mV = ((R * T) / F) * Math.log(insideStuff);
      System.out.println(mV);
      
      stdin.close();
   }
}