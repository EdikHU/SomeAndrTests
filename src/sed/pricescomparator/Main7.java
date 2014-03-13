package sed.pricescomparator;

import java.util.concurrent.TimeUnit;

import android.app.Activity;
//import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
//import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
//import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main7 extends Activity{

	protected static final String LOG_TAG = "The_LOG_TAG";
	private static Handler h;
	private static TextView tv;
	private static Button btnStart;
	private static Main7PB pb;
	private Main7 context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context  = this;
		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
		setContentView(la);
		
		
		Button btnTest = new Button(this);
		btnTest.setText("Test");
		btnTest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d(LOG_TAG, "test");
				Toast.makeText(context, (""+pb.getProgress()), Toast.LENGTH_SHORT).show();
			}
		});
		la.addView(btnTest);
		
		
		pb = new Main7PB(this);
		//pb = (ProgressBar)( (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)   ).inflate(R.layout.m7_pb, null);
		//pb = new ProgressBar(this);
		pb.setMax(10);
		la.addView(pb);
		
		tv = new TextView(this);
		la.addView(tv);
		
		btnStart = new Button(this);
		btnStart.setText("Start");
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				btnStart.setVisibility(Button.INVISIBLE);//setEnabled(false);
				pb.setProgress(0);
				new Thread(){
					int iShow;
					@Override
					public void run() {
						for (int i = 1 ; i <=10 ; i++){
							Log.d(LOG_TAG, "START  download ["+i+"] ");
							download();
							iShow = i;
							//h.sendEmptyMessage(iShow);
							//runOnUiThread(new Runnable() {
							h.post(new Runnable() {
								@Override
								public void run() {
									tv.setText("--> "+iShow);
									Log.d(LOG_TAG, " SHOW  download ["+iShow+"] ");
									pb.incrementProgressBy(1);
									if (iShow == 10){
										btnStart.setVisibility(Button.VISIBLE);//setEnabled(true);
									}
								}
							});
							Log.d(LOG_TAG, "FINISH download ["+i+"] ");
						}
					}
				}.start();
			}
		});
		la.addView(btnStart);

		
		h = new ModHandler();
		
	}

	protected void download() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static class ModHandler extends Handler{
			@Override
			public void handleMessage(Message msg) {
				tv.setText("--> "+msg.what);
				pb.incrementProgressBy(1);
				if (msg.what == 10){
					btnStart.setEnabled(true);
				}
			}
	}

	
	
	
}
