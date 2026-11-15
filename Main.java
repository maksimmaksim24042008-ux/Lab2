import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        int N = in.nextInt();
        int M = in.nextInt();

        char[][] a = new char[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String elementsOfArray = in.next();
                a[i][j] = elementsOfArray.charAt(0);
            }
        }


        out.println("САМ МАССИВ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.print(a[i][j] + " ");
            }
            out.println();
        }



        for (int k = 1; k < N;k++) {
            for (int i = 0; i < N - k; i++) {

                int uppercase1 = 0;
                int countLowerSymbols1 = 0;
                for (int j = 0; j < M; j++) {
                    char symbol = a[i][j];
                    if (a[i][j] >= 'A' && a[i][j] <= 'Z')
                        uppercase1++;

                    char lowerCaseSymbol = Character.toLowerCase(symbol);
                    if (lowerCaseSymbol>='a' && lowerCaseSymbol<='z' && "aeiou".indexOf(lowerCaseSymbol) == -1)
                        countLowerSymbols1++;
                }

                int uppercase2 = 0; int countLowerSymbols2 = 0;
                for (int j = 0; j < M; j++) {
                    char symbol = a[i+1][j];
                    if (a[i+1][j] >= 'A' && a[i+1][j] <= 'Z')
                        uppercase2++;

                    char lowerCaseSymbol = Character.toLowerCase(symbol);
                    if (lowerCaseSymbol>='a' && lowerCaseSymbol<='z' && "aeiou".indexOf(lowerCaseSymbol) == -1)
                        countLowerSymbols2++;
                }

                boolean needToSwap = false;
                if (uppercase1 < uppercase2)
                    needToSwap = true;

                else if (uppercase1 == uppercase2) {
                    if(countLowerSymbols1 > countLowerSymbols2)
                        needToSwap = true;

                    else  if (countLowerSymbols1 == countLowerSymbols2){
                        int j = 0;
                        while (j < M || !needToSwap) {
                            if (a[i][j] != a[i + 1][j]) {
                                if (a[i][j] > a[i + 1][j])
                                    needToSwap = true;
                                j++;
                            }
                        }


                    }
                }

                if(needToSwap == true) {
                    char[] t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                }

            }
        }



        out.println("ОТСОРТИРОВАННЫЙ МАССИВ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.print(a[i][j] + " ");
            }
            out.println();
        }


        char minSymbol = a[0][0];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] < minSymbol)
                    minSymbol = a[i][j];
            }
        }
        out.println("минимальный ASCII-код = "+(int)minSymbol+", "+minSymbol);



        out.println("Вывод элементов отсортированного массива в виде зигзага");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ( j==i || j==i+1)
                    out.print(a[i][j] + " ");
                else
                    out.print("  ");
            }
            out.println();
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char symbol = a[i][j];
                char lowerCaseSymbol = Character.toLowerCase(symbol);

                if ("aeiou".indexOf(lowerCaseSymbol) > 0)
                    a[i][j] = '*';
                else
                    a[i][j] = '#';
            }
        }

        out.println("Конечный Массив");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                out.print(a[i][j] + " ");
            }
            out.println();
        }

    }
}