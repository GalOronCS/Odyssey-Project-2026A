package edu.starter;

public class Combatant {
    private String name ;
    private int curr_hp ;
    private final int max_hp ;
    private int resources ;
    private int pending_defence ;
    private String err = "None" ;

    public Combatant(String name, int curr_hp, int max_hp, int resources, int pending_defence) {
        this.name = name ;
        this.curr_hp = curr_hp ;
        this.max_hp = max_hp ;
        this.resources = resources ;
        this.pending_defence = pending_defence ;
    }

    public String get_name() {return this.name ;}
    public int get_hp() {return this.curr_hp ;}
    public int get_resources() {return this.resources ;}
    public int get_defence() {return this.pending_defence ;}
    public String get_err() {return this.err ;}

    public void set_name(String name) {this.name = name ;}
    public void set_hp(int hp) {
        if ((hp >=0) && (hp <= max_hp)) {this.curr_hp = hp ;}
        else {err = "You can't add that much HP!" ;}
    }
    public void set_resources(int resources) {this.resources = resources ;}
    public void set_defence(int defences) {this.pending_defence = defences ;} 
    public void set_err(String err) {this.err = err ;}

    public void attack(Combatant player2) {
        int used_defence = Math.clamp(player2.get_defence(), 0, 10) ;
        int p2_new_hp = Math.clamp(player2.get_hp() - 10 + used_defence, 0, 100) ;
        player2.set_defence(player2.get_defence() - used_defence) ;
        player2.set_hp(p2_new_hp) ;
    }
    public void defend() {set_defence(get_defence() + 5) ;}
    public void recover() {
        if ((resources >= 0) && (resources <= 9)) {set_resources(Math.clamp(resources + 3, 0, 10)) ;}
        else {err="You can't add that many resources!" ;}
    }
    public void special(Combatant player2) {
        if (resources < 3) {err = "Too few resources to use special!" ;}
        else {
            set_resources(Math.clamp(get_resources() - 3, curr_hp, curr_hp)) ;
            int p2_new_hp = Math.clamp(player2.get_hp() - 10, 0, 100) ;
            player2.set_hp(p2_new_hp) ;
        }
    }
}
