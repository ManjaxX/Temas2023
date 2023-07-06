package com.proyectos.juego;

/**
 *
 * @authors Manja/https://www.sanfoundry.com/java-program-gaussian-elimination-algorithm/
 */
public class Gauss {
    int[][]A={{1,1,0,1,0,0,0,0,0},
              {1,1,1,0,1,0,0,0,0},
              {0,1,1,0,0,1,0,0,0},
              {1,0,0,1,1,0,1,0,0},
              {0,1,0,1,1,1,0,1,0},
              {0,0,1,0,1,1,0,0,1},
              {0,0,0,1,0,0,1,1,0},
              {0,0,0,0,1,0,1,1,1},
              {0,0,0,0,0,1,0,1,1}};
    
    public void solve(int[] B)
    {
        int N = B.length;
        for (int k = 0; k < N; k++) 
        {
            int max = k;
            for (int i = k + 1; i < N; i++) 
                if (Math.abs(A[i][k])%2 > Math.abs(A[max][k])%2) 
                    max = i;
   
            int[] temp = A[k]; 
            A[k] = A[max]; 
            A[max] = temp;
 
            int t = B[k]; 
            B[k] = B[max]; 
            B[max] = t;
 
            for (int i = k + 1; i < N; i++) 
            {
                int factor = (A[i][k] / A[k][k])%2;
                B[i] -= (factor * B[k])%2;
                for (int j = k; j < N; j++) 
                    A[i][j] -= (factor * A[k][j])%2;
            }
        }
 
        /*printRowEchelonForm(A,B);*/
 
        int[] solution = new int[N];
        for (int i = N - 1; i >= 0; i--) 
        {
            int sum = 0;
            for (int j = i + 1; j < N; j++) 
                sum += (A[i][j] * solution[j])%2;
            solution[i] = ((B[i] - sum) / A[i][i])%2;
        }        
        printSolution(solution);
    }
    /*public void printRowEchelonForm(int[][] A, int[] B)
    {
        int N = B.length;
        System.out.println("\nRow Echelon form : ");
        for (int i = 0; i < N; i++)
           {
               for (int j = 0; j < N; j++)
                   System.out.printf("%d ", Math.abs(A[i][j]));
               System.out.printf("| %d\n", Math.abs(B[i]));
           }
           System.out.println();
    }*/
    public void printSolution(int[] sol)
    {
        int N = sol.length;
        System.out.println("\nSolucion : ");
        for (int i = 0; i < 3; i++) 
               System.out.printf("%d", Math.abs(sol[i]));
        System.out.print("\n");
        for (int i = 3; i < 6; i++) 
               System.out.printf("%d", Math.abs(sol[i]));
        System.out.print("\n");
        for (int i = 6; i < 9; i++) 
               System.out.printf("%d", Math.abs(sol[i]));
        System.out.print("\n");
        System.out.println();     
    }    
}