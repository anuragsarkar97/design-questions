package io.swiggy.battleship.players;

public class PlayerTracker {

  private Player attacker;
  private Player defender;



  public PlayerTracker() {
  }

  public void swap() {
    Player current = this.attacker.clone();
    this.attacker = this.defender.clone();
    this.defender = current;
  }

  public PlayerTracker(Player attacker, Player defender) {
    this.attacker = attacker;
    this.defender = defender;
  }

  public Player getAttacker() {
    return this.attacker;
  }

  public void setAttacker(Player attacker) {
    this.attacker = attacker;
  }

  public Player getDefender() {
    return this.defender;
  }

  public void setDefender(Player defender) {
    this.defender = defender;
  }

  public PlayerTracker attacker(Player attacker) {
    this.attacker = attacker;
    return this;
  }

  public PlayerTracker defender(Player defender) {
    this.defender = defender;
    return this;
  }



  @Override
  public String toString() {
    return "{" +
      " attacker='" + getAttacker() + "'" +
      ", defender='" + getDefender() + "'" +
      "}";
  }

}