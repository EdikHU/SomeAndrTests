package sed.pricescomparator;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Main9Service extends Service{

	private static AtomicInteger liveIncrimentor = new AtomicInteger(777); 
	
	String servId = (""+new Date()).split("\\s")[3];

	private int startId ;

	protected boolean needRunService = true;

	private PendingIntent pendinIntent;
	
	private static final String LOG_TAG = "LOG_TAG";


	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(LOG_TAG, "onCreate ["+startId+"]["+servId+"]");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		this.startId = startId;
		Log.d(LOG_TAG, "onStartCommand ["+startId+"]["+servId+"] BEGIN");
		pendinIntent = intent.getParcelableExtra("777");
		
		try {
			pendinIntent.send(this, 777, new Intent().putExtra("777", 111111)  );
		} catch (CanceledException e) {
			e.printStackTrace();
		}
		
		if ("start".equals(intent.getStringExtra("start"))){
			someHere();
		}

		//return super.onStartCommand(intent, flags, startId);
		return START_REDELIVER_INTENT;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		needRunService = false;
		Log.d(LOG_TAG, "onDestroy ["+startId+"]["+servId+"]");
	}


	@Override
	public IBinder onBind(Intent intent) {
		Log.d(LOG_TAG, "onBind");
		return null;
	}

	
	
	private void someHere() {
		new Thread(){
			String id = (""+new Date()).split("\\s")[3];
			private int locStartId =startId;
			@Override
			public void run() {
				int i = 0;
				while ( needRunService  ){
					i++;
					Log.d(LOG_TAG, "  someHere ["+locStartId+"]["+servId+"]["+id+"] run ["+i+"] ["+(liveIncrimentor.addAndGet(1))+"]");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					try {
						pendinIntent.send(Main9Service.this, 777, new Intent().putExtra("777", (int)liveIncrimentor.get())  );
					} catch (CanceledException e) {
						e.printStackTrace();
					}
					
					//Log.d(LOG_TAG, "  someHere ["+servId+"]["+id+"] END ["+i+"]");
				}
				//stopSelf();
				Log.d(LOG_TAG, "  someHere ["+locStartId+"]["+servId+"]["+id+"] stopSelf ["+stopSelfResult(locStartId)+"]");
			}
			
		}.start();
	}

	
}
