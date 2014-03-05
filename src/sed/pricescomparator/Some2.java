package sed.pricescomparator;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class Some2 {

	
	
	private static TextView tv;

	public static View getInstance(MainActivity context) {
		View mView = (View)((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.some, null);
		tv = new TextView(context);
		tv.setText("[]");
		 ((ViewGroup)mView).addView(tv);

		 mView.setTag(Some2.class);
		 
		return mView;
	}

	public static void setTV(String s) {
		tv.setText("["+s+"]");
		
	}

}
