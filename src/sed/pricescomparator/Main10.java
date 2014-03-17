package sed.pricescomparator;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main10 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout la = new LinearLayout(this);
		setContentView(la);
		

		TextView tv = new TextView(this);
		tv.setText("main");
		la.addView(tv);

		LinearLayout laFrag = new LinearLayout(this);
		laFrag.setId(62546523);
		la.addView(laFrag);
		
		FragmentTransaction trFragments = getFragmentManager().beginTransaction();
		Main10Frag1 frag = new Main10Frag1();
		
		trFragments.add(laFrag.getId(), frag);
		trFragments.commit();
		
		
	}

	
	
}
