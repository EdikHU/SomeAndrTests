package sed.pricescomparator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Main5Act2 extends Activity implements OnClickListener{

	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("Main5Act2 onCreate ["+getIntent().getScheme()+"]");
		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
		setContentView(la);

		et = new EditText(this);
		la.addView(et);
		
		Button btn = new Button(this);
		btn.setText("return");
		la.addView(btn);
		btn.setOnClickListener(this);
		
		
		
	}

	@Override
	public void onClick(View v) {
		Intent intent = getIntent();//new Intent();
		intent.putExtra("some", et.getText().toString());
		setResult(RESULT_OK, intent);
		finish();
	}

}
