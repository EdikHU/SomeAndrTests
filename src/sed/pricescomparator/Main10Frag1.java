package sed.pricescomparator;

import java.util.Date;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Main10Frag1 extends Fragment {



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.main10_frag1, null);
		
		final TextView tv = (TextView)v.findViewById(R.id.main10_fr_textView);
		
		Button btn = (Button)v.findViewById(R.id.main_10_fr_button);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				tv.setText("["+(""+new Date()).split("\\s")[3]+"]");
			}
		});
		return v;

	}


}
