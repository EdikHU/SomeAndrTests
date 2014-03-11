package sed.pricescomparator;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main5Act3FakeTel extends Activity{

	
	
	private EditText et;
	private SharedPreferences pref;

	public Main5Act3FakeTel() {
		super();
		System.out.println("HERE");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		pref = getPreferences(MODE_PRIVATE);
		
		LinearLayout la = new LinearLayout(this);
		la.setOrientation(LinearLayout.VERTICAL);
		setContentView(la);
		
		TextView tv = new TextView(this);
		tv.setText("["+getIntent().getAction()+"]["+getIntent().getData().getScheme()+"]["+getIntent().getData().getSchemeSpecificPart()+"]["+getIntent().getDataString()+"]");
		la.addView(tv);
		
		et = new EditText(this);
		load();
		la.addView(et);
		
		Button btnLoad = new Button(this);
		btnLoad.setText("Load");
		btnLoad.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				load();
			}
		});
		la.addView(btnLoad);
		
		Button btnSave = new Button(this);
		btnSave.setText("Save");
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				save();
			}
		});
		la.addView(btnSave);

		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		save();
	}

	protected void load() {
		et.setText(pref.getString("some", ""));
	}

	protected void save() {
		Editor prf = pref.edit();
		prf.putString("some", et.getText().toString());
		prf.commit();
	}


}
