package edu.starter;

import java.util.Scanner;

public class Battle {
    private String turn ;
    private final Combatant player ;
    private final Combatant enemy ;
    private String victor = "None" ;
    private String err = "" ;
    private final Scanner scanner ;

    public Battle(String turn, Combatant player, Combatant enemy, Scanner new_scanner) {
        this.turn = turn ;
        this.player = player ;
        this.enemy = enemy ;
        this.scanner = new_scanner ;
    }
    
    public boolean start_battle() {
        Battle new_battle = new Battle(turn, player, enemy, scanner) ;
        while (new_battle.victor.equals("None")) {
            if (turn.equals("Player")) {
                System.out.println("Your HP: " + new_battle.player.get_hp() + "\nYour resources: " + new_battle.player.get_resources() + "\nYour pending defences: " + new_battle.player.get_defence() + "\nEnemy HP: " + new_battle.enemy.get_hp() + "") ;
                System.out.println("Attack, Defend, Special or Recover?") ;
                String choice = scanner.nextLine() ;
                
                switch (choice.toLowerCase()) {
                    case "attack" -> player.attack(enemy) ;
                    case "defend" -> player.defend() ;
                    case "recover" -> player.recover() ;
                    case "special" -> player.special(enemy) ;
                    default -> {
                        new_battle.err = "\nchoose something u dum dum\n";
                        System.out.println(new_battle.err) ;
                        continue;
                    }
                }
                
                if (!player.get_err().equals("None")) {
                    new_battle.err = player.get_err() ;
                    player.set_err("None") ;
                    System.out.println("\n" + new_battle.err) ;
                    continue ;
                }
                
                System.out.println("\n");
                
                if (enemy.get_hp() == 0) {new_battle.victor = new_battle.player.get_name() ; break ;}
                turn = "Enemy" ;
            } else {
                enemy.attack(player) ;
                
                System.out.println("Enemy attacked!\n") ;
                
                if (player.get_hp() == 0) {new_battle.victor = new_battle.enemy.get_name() ; break ;}
                turn = "Player" ;
            }
        }   
        System.out.println("%s won!".formatted(new_battle.victor));
        new_battle.player.set_defence(0) ;
        boolean didPlayerWin = (new_battle.victor.equals(new_battle.player.get_name())) ;
        return didPlayerWin ;
    }
}
