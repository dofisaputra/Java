// author : dofisaputra

package program.atm;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int saldo = 1550000;
        int[] tarikTunai = {100000, 250000, 500000};
        char yesOrNo = 'y';

        while (yesOrNo == 'y' || yesOrNo == 'Y') {
            Fungsi.printMenuAwal();

            System.out.print("Masukan Pilihan : ");
            int pilihanMenuAwal = input.nextInt();

            switch (pilihanMenuAwal) {
                case 1:
                    Fungsi.printSaldo(saldo);

                    System.out.print("Transaksi Lain? : ");
                    yesOrNo = input.next().charAt(0);

                    if (yesOrNo == 'n' || yesOrNo == 'N') {
                        System.out.println("Keluar...");
                        break;
                    }

                    else {
                        while (yesOrNo != 'y' && yesOrNo != 'n') {
                            System.out.println("Masukan y/n!");
                            System.out.print("Transaksi Lain? : ");
                            yesOrNo = input.next().charAt(0);
                        }                        
                    }

                    break;
                    
                case 2:
                    Fungsi.printMenuTarik();

                    System.out.print("Masukan Pilihan : ");
                    int pilihanMenuTarik = input.nextInt();

                    switch (pilihanMenuTarik) {
                        case 1:
                            System.out.println();
                            System.out.println("---------------------------------------------");
                            System.out.println("Penarikan Berhasil, Sisa Saldo Rp." + Fungsi.tarikTunai(saldo, tarikTunai[0]));
                            System.out.println("---------------------------------------------");
                            System.out.println();
                            saldo -= tarikTunai[0];

                            System.out.print("Transaksi Lain? : ");
                            yesOrNo = input.next().charAt(0);

                            if (yesOrNo == 'n' || yesOrNo == 'N') {
                                System.out.println("Keluar...");
                                break;
                            }

                            else {
                                while (yesOrNo != 'y' && yesOrNo != 'n') {
                                    System.out.println("Masukan y/n!");
                                    System.out.print("Transaksi Lain? : ");
                                    yesOrNo = input.next().charAt(0);
                                }                        
                            }

                            break;

                        case 2:
                            System.out.println();
                            System.out.println("---------------------------------------------");
                            System.out.println("Penarikan Berhasil, Sisa Saldo Rp." + Fungsi.tarikTunai(saldo, tarikTunai[1]));
                            System.out.println("---------------------------------------------");
                            System.out.println();
                            saldo -= tarikTunai[1];

                            System.out.print("Transaksi Lain? : ");
                            yesOrNo = input.next().charAt(0);

                            if (yesOrNo == 'n' || yesOrNo == 'N') {
                                System.out.println("Keluar...");
                                break;
                            }

                            else {
                                while (yesOrNo != 'y' && yesOrNo != 'n') {
                                    System.out.println("Masukan y/n!");
                                    System.out.print("Transaksi Lain? : ");
                                    yesOrNo = input.next().charAt(0);
                                }                        
                            }

                            break;

                        case 3:
                            System.out.println();
                            System.out.println("---------------------------------------------");
                            System.out.println("Penarikan Berhasil, Sisa Saldo Rp." + Fungsi.tarikTunai(saldo, tarikTunai[2]));
                            System.out.println("---------------------------------------------");
                            System.out.println();
                            saldo -= tarikTunai[2];

                            System.out.print("Transaksi Lain? : ");
                            yesOrNo = input.next().charAt(0);

                            if (yesOrNo == 'n' || yesOrNo == 'N') {
                                System.out.println("Keluar...");
                                break;
                            }

                            else {
                                while (yesOrNo != 'y' && yesOrNo != 'n') {
                                    System.out.println("Masukan y/n!");
                                    System.out.print("Transaksi Lain? : ");
                                    yesOrNo = input.next().charAt(0);
                                }                        
                            }

                            break;

                        default:
                            while (pilihanMenuTarik != 1) {
                                System.out.print("Masukan Pilihan : ");
                                pilihanMenuTarik = input.nextInt(); 
                            }
                    }

                    break;

                case 3:
                    int trueOrFalse = 0;
                    int nominalTransfer = 0;
            
                    while (trueOrFalse != 1) {
                        System.out.println();
                        System.out.println("------------------------------------------");
                        System.out.print("Masukan No Rekening Tujuan : ");
                        int noRek = input.nextInt();
                        System.out.println();
            
                        System.out.print("Masukan Nama Bank          : ");
                        String namaBank = input.next();
                        System.out.println();
            
                        System.out.print("Masukan Nominal Transfer   : ");
                        nominalTransfer = input.nextInt();
                        System.out.println("------------------------------------------");
            
                        System.out.println();
            
                        System.out.println("Berikut Data Transfer");
                        System.out.println();
                        System.out.println("------------------------------------------");
                        System.out.println("No Rekening Tujuan : " + noRek);
                        System.out.println("Nama Bank          : " + namaBank);
                        System.out.println("Nominal Transfer   : Rp." + nominalTransfer);
                        System.out.println("------------------------------------------");
                        System.out.println();
                
                        System.out.println("[1] Benar");
                        System.out.println("[2] Salah");
                        System.out.println();
                
                        System.out.print("Masukan Pilihan [1] atau [2] : ");
                        trueOrFalse = input.nextInt();
                        
                    }
                    
                    saldo -= nominalTransfer;
                    System.out.println();
                    System.out.println("---------------------------------------------");
                    System.out.println("Transfer Berhasil, Sisa Saldo Rp." + saldo);
                    System.out.println("---------------------------------------------");
                    System.out.println();

                    System.out.print("Transaksi Lain? : ");
                    yesOrNo = input.next().charAt(0);

                    if (yesOrNo == 'n' || yesOrNo == 'N') {
                        System.out.println("Keluar...");
                        break;
                    }

                    else {
                        while (yesOrNo != 'y' && yesOrNo != 'n') {
                            System.out.println("Masukan y/n!");
                            System.out.print("Transaksi Lain? : ");
                            yesOrNo = input.next().charAt(0);
                        }                        
                    }

                    break;  

                default:
                    while (pilihanMenuAwal < 1 || pilihanMenuAwal > 3) {
                        System.out.println();
                        System.out.println("Masukan angka 1-4!");
                        System.out.print("Ulang? (y/n) : ");
                        yesOrNo = input.next().charAt(0);

                        if (yesOrNo == 'n' || yesOrNo == 'N') {
                            System.out.println("Keluar...");
                            break;
                        }

                        else {
                            while (yesOrNo != 'y' && yesOrNo != 'n') {
                                System.out.println("Masukan y/n!");
                                System.out.print("Transaksi Lain? : ");
                                yesOrNo = input.next().charAt(0);
                            }                        
                        }

                        break;
                    }
            }   
        }
    }
}