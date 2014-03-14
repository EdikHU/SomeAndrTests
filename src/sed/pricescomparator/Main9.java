package sed.pricescomparator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class Main9 extends Activity{

	private Button btnStart;
	private Button btnStop;
	private Main9 content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		content = this;
		
		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
		setContentView(la);
		
		btnStart = new Button(this);
		la.addView(btnStart);
		btnStart.setText("BtnStart");
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startService( new Intent(content,Main9Service.class) );
			}
		});
		
		btnStop = new Button(this);
		la.addView(btnStop);
		btnStop.setText("BtnStop");
		btnStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stopService( new Intent(content,Main9Service.class) );
			}
		});

		
		ProgressBar btn = new ProgressBar(this);
		la.addView(btn);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("here");
			}
		});

		
	}
}
