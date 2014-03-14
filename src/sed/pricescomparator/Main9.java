package sed.pricescomparator;

import android.app.Activity;
import android.app.PendingIntent;
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
	protected PendingIntent pendingIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		content = this;
		
		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
		setContentView(la);

		final Intent intent = new Intent(content,Main9Service.class);
		pendingIntent  = createPendingResult(777, new Intent(), 0);
		intent.putExtra("777", pendingIntent);
	
		startService(intent);
		
		btnStart = new Button(this);
		la.addView(btnStart);
		btnStart.setText("BtnStart");
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("start", "start");
				startService( intent  );
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

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 777){
			btnStop.setText("["+data.getIntExtra("777", 0)+"]");
		}
	}
}
