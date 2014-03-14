package sed.pricescomparator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main9 extends Activity{

	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
		
		btn = new Button(this);
		la.addView(btn);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("here");
			}
		});
		
	}

	
	
}
