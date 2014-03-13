package sed.pricescomparator;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

//
//	<!--android:configChanges="orientation|screenSize"--> removed from manifest
//

public class Main8 extends Activity implements Serializable{

	private static final long serialVersionUID = 9050983383887655662L;
	private static final String LOG_TAG = "LOG_TAG";
	protected Button btnStart;
	private Button btnShow;
	private Button btnStop;
	private Main8 context;
	private String id;
	private static ModAsyncTask aTask;

	
	
	public Main8() {
		super();
		id = (""+new Date()).split("\\s")[3];
		System.out.println("HERE Main8 constr superclass ["+id+"]");
	}

	
	
	public Main8(Button btnStart, Button btnShow, Button btnStop, Main8 context) {
		super();
		this.btnStart = btnStart;
		this.btnShow = btnShow;
		this.btnStop = btnStop;
		this.context = context;
		System.out.println("HERE Main8 constr fields");
	}



	@Override
	protected void onCreate(Bundle savedState) {

		Log.d(LOG_TAG, "HERE onCreate [" + savedState + "]");
		super.onCreate(savedState);
		context = this;

		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
		setContentView(la);

		btnStart = new Button(this);
		la.addView(btnStart);
		btnStart.setText("Start [" + (aTask != null ? aTask.count : "") + "]");
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (aTask == null
						|| aTask.getStatus() != AsyncTask.Status.RUNNING) {
					System.out.println("HERE START init!!!!!");
					aTask = new ModAsyncTask(context);
				}
				if (aTask.getStatus() != AsyncTask.Status.RUNNING) {
					System.out.println("HERE START execute!!!!!");
					aTask.execute();
				}
			}
		});

		btnStop = new Button(this);
		la.addView(btnStop);
		btnStop.setText("Stop");
		btnStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (aTask != null)
					aTask.cancel(false);
			}
		});

		btnShow = new Button(this);
		la.addView(btnShow);
		btnShow.setText("Show");
		btnShow.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context,
						"* [" + (aTask != null ? aTask.count : "---") + "]",
						Toast.LENGTH_SHORT).show();
			}
		});


//		if (savedState != null){
//			ModAsyncTask ssAtask = (ModAsyncTask) savedState.get("aTask");
//			if (ssAtask != null){
//				aTask = ssAtask;
//				aTask.activity = this;
//			}
//		}
		
		
		if (savedState != null){
		@SuppressWarnings("deprecation")
		ModAsyncTask ssAtask = (ModAsyncTask) getLastNonConfigurationInstance();
		if (ssAtask != null){
			aTask = ssAtask;
			aTask.activity = this;
		}
	}
		
	}

//	@Override
//	protected void onSaveInstanceState(Bundle outState) {
//		super.onSaveInstanceState(outState);
//		System.out.println("HERE onSaveInstanceState [" + isFinishing() + "]");
//		if (aTask != null)
//			outState.putSerializable("aTask", aTask);
//	}

	@Override
	@Deprecated
	public Object onRetainNonConfigurationInstance() {
		return aTask;
	}
	
	
	@Override
	protected void onDestroy() {
		System.out.println("HERE onDestroy [" + isFinishing() + "]");
		super.onDestroy();
		if (aTask!=null){
			aTask.activity=null;
		}
		if (isFinishing() && aTask != null) {
			aTask.cancel(true);
			aTask = null;
		}
	}


	private static class ModAsyncTask extends AsyncTask<Void, Void, Void>
			implements Serializable {

		private static final long serialVersionUID = 8318525478434598949L;

		int count;

		private Main8 activity;

		public ModAsyncTask(Main8 main8) {
			activity = main8;
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				while (true) {

					if (isCancelled())
						break;
					if (activity!=null)
					Log.d(LOG_TAG, "HERE doInBackground [" + count + "] ["+activity.hashCode()+"]["+activity.id+"]");

					publishProgress();
					TimeUnit.SECONDS.sleep(1);

				}
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
			if (activity!=null)
			activity.btnStart.setText("[" + (count++) + "]");
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
			if (activity!=null)
			activity.btnStart.setText("Start [" + count + "]");
		}

	}

}
