package sed.pricescomparator;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.app.Activity;

public class MainActivity extends Activity {

	private ListView lv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.another_for_list);
		LinearLayout layout = (LinearLayout) findViewById(R.id.another_for_list);

		lv1 = (ListView) layout.findViewById(R.id.lv1);
		lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

		// String[]
		// namesArr={"uno","dos","tres","quatro","sinco","siete","seiz"};
		final ArrayList<String> names = new ArrayList<String>();// (ArrayList<String>)
															// Arrays.asList(namesArr);
		names.add("uno");
		names.add("dos");
		names.add("tres");
		names.add("quatro");
		names.add("sinco");
		names.add("siete");
		names.add("tres");
		names.add("quatro");
		names.add("sinco");
		names.add("siete");
		names.add("tres");
		names.add("quatro");
		names.add("sinco");
		names.add("siete");
		names.add("tres");
		names.add("quatro");
		names.add("sinco");
		names.add("siete");

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				layout.getContext(),
				android.R.layout.simple_list_item_single_choice, names);

		lv1.setAdapter(adapter);

//		((ViewGroup)lv1).addView(new Button(this),100,100);
		
		final Button butt1 = (Button) findViewById(R.id.button1);
		butt1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				butt1.setText("-> "+names.get(lv1.getCheckedItemPosition()));
			}
		});

	}

}
