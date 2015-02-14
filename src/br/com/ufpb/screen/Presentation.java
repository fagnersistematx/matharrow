package br.com.ufpb.screen;
import br.com.ufpb.matharrow.R;
import br.com.ufpb.util.StandartLesson;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Presentation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_presentation);			
		
		//Thread myGame = new Thread(new StandartLesson(this));
		//myGame.start();
		
		new Thread(){
			@Override
			public void run(){
				try{
					sleep(3000);
				}catch (Exception e) {
					
				}finally{
					Intent intentSelect = new Intent(Presentation.this, Start.class);
					startActivity(intentSelect);
					finish();
				}
			}
		}.start();		
	}

}
