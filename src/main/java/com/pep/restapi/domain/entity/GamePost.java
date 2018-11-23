package com.pep.restapi.domain.entity;

import java.util.List;

public class GamePost {

    private Game game;

    private Player player;

    private Board board;

    private List<Enemy> players;

    private List<Invader> invaders;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Enemy> getPlayers() {
        return players;
    }

    public void setPlayers(List<Enemy> players) {
        this.players = players;
    }

    public List<Invader> getInvaders() {
        return invaders;
    }

    public void setInvaders(List<Invader> invaders) {
        this.invaders = invaders;
    }

    public GamePost(){};



}
