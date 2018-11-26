package com.pep.restapi.domain.valueobjects;

import com.pep.restapi.domain.entity.Enemy;
import com.pep.restapi.domain.entity.Game;
import com.pep.restapi.domain.entity.Invader;
import com.pep.restapi.domain.entity.Player;
import com.pep.restapi.domain.valueobjects.Board;

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

    @Override
    public String toString() {
        return "GamePost{" +
                "game=" + game +
                ", player=" + player +
                ", board=" + board +
                ", players=" + players +
                ", invaders=" + invaders +
                '}';
    }

    public GamePost(){};



}
