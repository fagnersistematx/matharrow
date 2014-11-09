package br.com.ufpb.prolicen.screen;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import br.com.ufpb.prolicen.arrowfraction.R;

public class Presentation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_presentation);
		
		new Thread(){
			@Override
			public void run(){
				try{
					sleep(3000);
				}catch (Exception e) {
					
				}finally{
					Intent intentSelect = new Intent(Presentation.this, Opction.class);
					startActivity(intentSelect);
					finish();
				}
			}
		}.start();		
	}

}
