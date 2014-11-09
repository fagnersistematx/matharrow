package br.com.ufpb.util;

import java.util.ArrayList;
import java.util.List;

import br.com.ufpb.prolicen.arrowfraction.Player;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class ConexaoBanco {

	private static final String DATABASE_NAME = "banco_arrow.db";
	private static final int DATABASE_VERSION = 1;
	private Context context;
	private SQLiteDatabase db;
	private SQLiteStatement insertStmt;
	private SQLiteStatement updateStmt;

	private static final String INSERTP = "insert into JOGADOR (nome, pontuacao) values (?, ?)";
	private static final String UPDATEP = "update JOGADOR set nome = ? where id = ?";

	public ConexaoBanco(Context context) {
		this.context = context;
		OpenHelper openHelper = new OpenHelper(this.context);
		this.db = openHelper.getWritableDatabase();
		this.insertStmt = this.db.compileStatement(INSERTP);
		this.updateStmt = this.db.compileStatement(UPDATEP);
	}

	public long insertJogador(String nome, float pontuacao) {
		this.insertStmt.bindString(1, nome);
		this.insertStmt.bindDouble(2, pontuacao);
		return this.insertStmt.executeInsert();
	}

	public long updateJgador(String nome, int id) {
		this.insertStmt.bindString(1, nome);
		this.updateStmt.bindLong(2, id);
		return this.updateStmt.executeInsert();
	}

	// public paciente buscarPacienteId(int _id) {
	// cliente cliente = new cliente();
	// Cursor cursor = this.db.query("cliente", new String[]{"id", "nome"},
	// null, null, null, null, "nome asc");
	//
	// if (cursor.moveToFirst()) {
	// do {
	// if (_id == cursor.getInt(cursor.getColumnIndex("id"))) {
	// cliente = new cliente();
	// cliente.setId(cursor.getInt(cursor.getColumnIndex("id")));
	// cliente.setNome(cursor.getString(cursor.getColumnIndex("nome")));
	// }
	// } while (cursor.moveToNext());
	// }
	// if (cursor != null && !cursor.isClosed()) {
	// cursor.close();
	// }
	// return client;
	// }
	public List<Player> getPlayers() {
		Player player;
		List<Player> players = new ArrayList<Player>();
		Cursor cursor = this.db.query("jogador", new String[] { "id", "nome", "pontuacao" },
				null, null, null, null, "pontuacao asc");

		if (cursor.moveToFirst()) {
			do {
				Log.w("Example",
						"ADICIONA "
								+ cursor.getString(cursor
										.getColumnIndex("pontuacao")));
				player = new Player();
				player.setId(cursor.getInt(cursor.getColumnIndex("id")));
				player.setName(cursor.getString(cursor.getColumnIndex("nome")));
				player.setScore(cursor.getDouble(cursor.getColumnIndex("pontuacao")));
				Log.w("To string = ",player.toString());
				players.add(player);
			} while (cursor.moveToNext());
		}
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}
		return players;
	}

	private static class OpenHelper extends SQLiteOpenHelper {
		OpenHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE jogador(" + "id INTEGER PRIMARY KEY, "
					+ "nome TEXT, pontuacao DOUBLE )");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w("Example",
					"Upgrading database, this will drop tables and recreate.");
			// db.execSQL("DROP TABLE IF EXISTS " + PACIENTE);
			// onCreate(db);
		}
	}
}