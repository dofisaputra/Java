// author : dofisaputra

package program.atm;

public class Fungsi {

    public static void printMenuAwal() {
        System.out.println();
        System.out.println("Program ATM");
        System.out.println("-----------------------");

        System.out.println("1. Cek Saldo");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Transfer");
        System.out.println("-----------------------");
        System.out.println();
    }
    
    public static void printSaldo(int saldo) {
        System.out.println();
        System.out.println("Saldo Anda Rp." + saldo);
        System.out.println();
    }

    public static int tarikTunai(int saldo, int tarikTunai) {
        return saldo - tarikTunai;
    }

    public static void printMenuTarik() {
        int[] tarikTunai = {100000, 250000, 500000};
        int index = 1;

        System.out.println();
        System.out.println("----------------------------");
        for (int tarik: tarikTunai) {
            System.out.println(index + ". Tarik Tunai Rp." + tarik);
            index ++;
        }
        System.out.println("----------------------------");
        System.out.println();
    }    
}