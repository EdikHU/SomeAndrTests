package sed.pricescomparator;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Main3 extends Activity{

	private ArrayList<Main3Item> al;
	private M3Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		setContentView(layout);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		Button btnPrn = new Button(this);
		layout.addView(btnPrn);
		btnPrn.setText("long process");
		btnPrn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println(al);
				System.out.println("long process");
				longProcessing(14000);
				System.out.println("waiter finish");
			}
		});
		
		Button butt = new Button(this);
		butt.setText("add");
		layout.addView(butt);
		butt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				al.add(new Main3Item("mychacha",true));
				adapter.notifyDataSetChanged();
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

	protected void longProcessing(final int i) {
		new Thread(){
			@Override
			public void run() {
				try {
					System.out.println("longProcessing start ["+i+"]");
					Thread.sleep(1234);
					Iterator<Main3Item> iter = al.iterator();
					while (iter.hasNext()){
						Main3Item elm = iter.next();
						elm.checked = (elm.checked ? false:true);
					}
					//
					System.out.println("longProcessing finish ["+i+"]");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		adapter.notifyDataSetChanged();
	}

}

