package sed.pricescomparator;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2 extends ListActivity {

	private ArrayList<String> gl_names=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("here");

		ArrayList<String> names = new ArrayList<String>();
		names.add("uno");
		names.add("dos");
		names.add("tres");
		names.add("quatro");
		names.add("uno");
		names.add("tres");
		names.add("quatro");
		names.add("uno");
		names.add("tres");
		names.add("quatro");
		names.add("uno");
		names.add("tres");
		names.add("quatro");
		names.add("uno");
		gl_names = names;
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.my_list_item,R.id.label, names );


		//getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		this.setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		System.out.println("pos["+position+"] id["+id+"]");
		//gl_names.set(position, "+++");
	//	 ((TextView)v.findViewById(R.id.label)).setText("***");
		gl_names.remove(position);
		
//		l.removeView(v);
	}

	

}
