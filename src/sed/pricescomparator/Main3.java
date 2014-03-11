package sed.pricescomparator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Main3 extends Activity{

	private ArrayList<Main3Item> al;
	private M3Adapter adapter;
	private Main3 inst;
	private Button butt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inst = this;
		
		LinearLayout layout = new LinearLayout(this);
		setContentView(layout);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		Button btnPrn = new Button(this);
		layout.addView(btnPrn);
		btnPrn.setText("long process");
		btnPrn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				longProcessing(14000);
			}
		});
		
		Button buttAdd = new Button(this);
		buttAdd.setText("add");
		layout.addView(buttAdd);
		buttAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				al.add(new Main3Item("mychacha",true));
				adapter.notifyDataSetChanged();
			}
		});

		butt = new Button(this);
		butt.setText("Modify");
		layout.addView(butt);
		butt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callAsyncTask();
			}
		});

		
		ListView listView = new ListView(this);
		layout.addView(listView);
		
		al = new ArrayList<Main3Item>();
		al.add(new Main3Item("uno",false));
		al.add(new Main3Item("dos",true));
		al.add(new Main3Item("tres",false));
		al.add(new Main3Item("quatro",false));
		al.add(new Main3Item("sinko",true));
		al.add(new Main3Item("siete",false));
		al.add(new Main3Item("seiz",false));
		al.add(new Main3Item("dos",true));
		al.add(new Main3Item("tres",false));
		al.add(new Main3Item("uno",false));
		al.add(new Main3Item("dos",true));
		al.add(new Main3Item("tres",false));
		al.add(new Main3Item("direcho",false));
		
		adapter = new M3Adapter(layout.getContext(),al);
		listView.setAdapter(adapter);
		
		
	}

	protected void callAsyncTask() {
		
		
		new AsyncTask<Object, Object, Object>() {


			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				System.out.println("*** onPreExecute");
				inst.butt.setText("*** ");
			}

			@Override
			protected Object doInBackground(Object... params) {
				String ss = "--> " + (""+new Date()).split("\\s")[3];
				System.out.println("*** doInBackground ["+ss+"]");
				return ss;
			}
			
			@Override
			protected void onPostExecute(Object ss) {
				super.onPostExecute(ss);
				System.out.println("*** onPostExecute "+ ss);
			}

			@Override
			protected void onProgressUpdate(Object... values) {
				System.out.println("!!!! HERE !!!!!!!");
				super.onProgressUpdate(values);
			}
			
			
			
		}.execute(this);
	}

	protected void longProcessing(final int i) {
		new Thread(){
			@Override
			public void run() {
					System.out.println("longProcessing start ["+i+"]");
					Iterator<Main3Item> iter = al.iterator();
					while (iter.hasNext()){
						Main3Item elm = iter.next();
						elm.checked = (elm.checked ? false:true);
					}
					//adapter.notifyDataSetInvalidated();
					inst.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							adapter.notifyDataSetChanged();
						}
					});
					System.out.println("longProcessing finish ["+i+"]");
			}
		}.start();
	}

}

