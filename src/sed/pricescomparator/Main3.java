package sed.pricescomparator;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Main3 extends Activity{

	private ArrayList<Main3Item> al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout layout = new LinearLayout(this);
		setContentView(layout);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		Button butt = new Button(this);
		layout.addView(butt);
		butt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println(al);
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
		
		M3Adapter adapter = new M3Adapter(layout.getContext(),al);
		listView.setAdapter(adapter);
		
		
	}

}
