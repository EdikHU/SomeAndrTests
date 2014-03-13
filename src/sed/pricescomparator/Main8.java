package sed.pricescomparator;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.content.Context;
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

public class Main8 extends Activity {

	private static final String LOG_TAG = "LOG_TAG";
	private static Button btnStart;
	private Button btnShow;
	protected Context context;
	private Button btnStop;
	private static ModAsyncTask aTask;

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
					aTask = new ModAsyncTask();
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

		aTask = (savedState == null ? null : (ModAsyncTask) savedState
				.get("aTask"));

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (aTask != null)
			outState.putSerializable("aTask", aTask);
	}

	@Override
	protected void onDestroy() {
		System.out.println("HERE onDestroy [" + isFinishing() + "]");
		super.onDestroy();
		if (isFinishing() && aTask != null) {
			aTask.cancel(true);
			aTask = null;
		}
	}

	private static class ModAsyncTask extends AsyncTask<Void, Void, Void>
			implements Serializable {

		private static final long serialVersionUID = 8318525478434598949L;

		int count;

		@Override
		protected Void doInBackground(Void... params) {
			try {
				while (true) {

					if (isCancelled())
						break;

					Log.d(LOG_TAG, "HERE doInBackground [" + count + "]");

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
			Main8.btnStart.setText("[" + (count++) + "]");
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
			Main8.btnStart.setText("Start [" + count + "]");
		}

	}

}
