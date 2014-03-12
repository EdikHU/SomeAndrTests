package sed.pricescomparator;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Main7 extends Activity{

	protected static final String LOG_TAG = "The_LOG_TAG";
	private static Handler h;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
		setContentView(la);
		
		
		Button btnTest = new Button(this);
		btnTest.setText("Test");
		btnTest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(LOG_TAG, "test");
			}
		});
		la.addView(btnTest);
		
		
		ProgressBar pb = (ProgressBar)((LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)   ).inflate(R.layout.m7_pb, null);
				//new ProgressBar(this);
		la.addView(pb);
		
		final TextView tv = new TextView(this);
		la.addView(tv);
		
		final Button btnStart = new Button(this);
		btnStart.setText("Start");
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				btnStart.setEnabled(false);
				new Thread(){
					@Override
					public void run() {
						for (int i = 1 ; i <=10 ; i++){
							Log.d(LOG_TAG, "START  download ["+i+"] ");
							//tv.setText("["+i+"]");
							download();
							h.sendEmptyMessage(i);
							Log.d(LOG_TAG, "FINISH download ["+i+"] ");
						}
					}
				}.start();
			}
		});
		la.addView(btnStart);

		
		h = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				tv.setText("--> "+msg.what);
				if (msg.what == 10){
					btnStart.setEnabled(true);
				}
			}
		};
		
	}

	protected void download() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
