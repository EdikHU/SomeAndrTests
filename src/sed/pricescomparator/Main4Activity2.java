package sed.pricescomparator;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main4Activity2 extends Activity{

	private Main4Activity2 instance;
	private boolean needClose = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("*   A2  onCreate");

		instance = this;
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		setContentView(layout);
		
		TextView tv2 = new TextView(this);
		tv2.setText(" ch M4A2 "+new Date());
		
		layout.addView(tv2);
		
		Button butt = new Button(this);
		butt.setText("toGo");
		layout.addView(butt);
		butt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity( new Intent( instance, Main4.class));
				
			}
		});
		
		new Thread(){
			@Override
			public void run() {
				super.run();
				System.out.println("here");
				try {
					Thread.sleep(4321);
					startActivity( new Intent( instance, Main4.class));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("here out");
			}
		}.start();
	}



	@Override
	protected void onStart() {
		super.onStart();
		System.out.println("**  A2  onStart");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("*** A2  onResume");
		if (needClose){
			System.out.println("NEED CLOSE HERE");
			instance.finish();
		}
	}

	

	@Override
	protected void onPause() {
		super.onPause();
		System.out.println("*** A2  onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		System.out.println("**  A2  onStop");
		needClose = true;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("*   A2  onDestroy");
	}









}
