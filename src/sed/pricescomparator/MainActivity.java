package sed.pricescomparator;

import android.os.Bundle;

import android.widget.Button;
import android.widget.LinearLayout;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.another);
		LinearLayout layout = (LinearLayout) findViewById(R.id.another);

		// View butt = getLayoutInflater().inflate(R.layout.my_button, layout,false);
		// View butt = findViewById(R.id.my_button);
		MyButtonHolder butt = MyButtonHolder.getInstance(this);

		layout.addView(butt.getRoot());

		Button btn = (Button) findViewById(R.id.mb_butt);
		btn.setText("Here");

	}

}
