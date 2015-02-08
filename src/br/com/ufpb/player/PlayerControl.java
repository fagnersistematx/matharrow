package br.com.ufpb.player;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import br.com.ufpb.util.DatabaseConnection;

public class PlayerControl {
	
	private SQLiteStatement statement;	
	private static final String INSERT = "INSERT INTO PLAYER (NAME, SCORE) values (?, ?)";
	private static final String DELETE = "DELETE FROM PLAYER";
	
	public PlayerControl(Context context) {
		DatabaseConnection.getInstance(context);	
	}

	public void addPlyer(Player player) {
		this.statement = DatabaseConnection.getDb().compileStatement(INSERT);	
		this.statement.bindString(1, player.getName());
		this.statement.bindDouble(2, player.getScore());
		this.statement.executeInsert();
	}
	
	public void deletePleyers() {
		this.statement = DatabaseConnection.getDb().compileStatement(DELETE);
		this.statement.executeInsert();
	}
	
	public List<Player> getPlayers() {
		Player player;
		List<Player> players = new ArrayList<Player>();
		Cursor cursor = DatabaseConnection.getDb().query("PLAYER", new String[] { "ID", "NAME", "SCORE" },
				null, null, null, null, "SCORE DESC");

		if (cursor.moveToFirst()) {
			do {				
				player = new Player();
				player.setId(cursor.getInt(cursor.getColumnIndex("ID")));
				player.setName(cursor.getString(cursor.getColumnIndex("NAME")));
				player.setScore(cursor.getDouble(cursor.getColumnIndex("SCORE")));
				players.add(player);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return players;
	}
	
	
}
