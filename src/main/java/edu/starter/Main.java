package edu.starter;

import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in) ;
    // private int playerHp = 100 ;
    // private int enemyHp = 100 ;
    // private int playerResources = 5 ;
    // private int pendingDefenses = 0 ;
    // private String victor = "None" ;
    // private String err = "" ;

    // public boolean p_atk() {
    //     enemyHp = Math.clamp(enemyHp - 10, 0, 100) ; 
    //     if (enemyHp == 0) {victor = "Player" ;}
    //     return true ;}
    // public boolean p_def() {pendingDefenses += 10 ; return true ;}
    // public boolean p_rec() {
    //     if (playerResources == 10) {err = "\nMax resources! Try again.\n" ; return false ;}
    //     playerResources = Math.clamp(playerResources + 3, 0, 10) ; 
    //     return true ;
    // }
    // public boolean p_spc() {
    //     if (playerResources < 3) {
    //         err = "\nCan't use special. Earn more resources!\n" ;
    //         return false ;
    //     } else {
    //         enemyHp = Math.clamp(enemyHp - 15, 0, 100) ; 
    //         playerResources -= 3 ; 
    //         if (enemyHp == 0) {victor = "Player" ;}
    //         return true ;
    //     }
    // }

    // public boolean e_atk() {
    //     int margin = 110 - playerHp ;
    //     playerHp = Math.clamp(playerHp - 10 + pendingDefenses, 0, 100) ; 
    //     pendingDefenses = Math.clamp(pendingDefenses - margin, 0, 100) ;
    //     if (playerHp == 0) {victor = "Enemy" ;}
    //     return true ;
    // }

    // Main game = new Main() ;
    // Scanner scanner = new Scanner(System.in) ; 

    // while (game.victor.equals("None")) {
    //     System.out.println("Your HP: " + game.playerHp + "\nYour resources: " + game.playerResources + "\nYour pending defences: " + game.pendingDefenses + "\nEnemy HP: " + game.enemyHp + "") ;
    //     System.out.println("Attack, Defend, Special or Recover?") ;
    //     String choice = scanner.nextLine() ;
    //     boolean res = true ;

    //     if (choice.equals("attack") || choice.equals("Attack")) {res = game.p_atk() ;}
    //     else if (choice.equals("defend") || choice.equals("Defend")) {res = game.p_def() ;}
    //     else if (choice.equals("recover") || choice.equals("Recover")) {res = game.p_rec() ; }
    //     else if (choice.equals("special") || choice.equals("Special")) {res = game.p_spc() ; } 
    //     else {res = false ; game.err = "\nchoose something u dum dum\n" ;}

    //     if (!res) {System.out.println(game.err) ; continue ;}

    //     System.out.println("\n");
        
    //     if (!game.victor.equals("None")) {break ;}
    //     game.e_atk() ;
    // }

    // scanner.close() ;
    // System.out.println("%s won!".formatted(game.victor));

    public static void main(String[] args) {
        Main new_game = new Main() ;
        Combatant player ;
        System.out.println("Please enter your name: ") ;
        String player_name = new_game.scanner.nextLine() ;
        player = new Combatant(player_name, 100, 100, 0, 0) ;

        Combatant enemyA = new Combatant("Sari Kaelen", 30, 30, 0, 0) ;
        Battle battleA = new Battle("Player", player, enemyA, new_game.scanner) ;
        boolean victorA = battleA.start_battle() ;

        if (!victorA) {
            System.out.println("oops u tried hehe") ;
            return ;
        }

        Combatant enemyB = new Combatant("Jaran Vane", 45, 45, 0, 0) ;
        Battle battleB = new Battle("Player", player, enemyB, new_game.scanner) ;
        battleB.start_battle() ;
    }
}