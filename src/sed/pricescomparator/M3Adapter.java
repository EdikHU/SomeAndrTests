package sed.pricescomparator;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;


public class M3Adapter extends BaseAdapter{

	private Context context;
	private ArrayList<Main3Item> al;
	private M3Adapter inst;

	public M3Adapter(Context context, ArrayList<Main3Item> al) {
		inst = this;
		this.context = context;
		this.al = al;
	}

	@Override
	public int getCount() {
		return al.size();
	}

	@Override
	public Object getItem(int position) {
		return al.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View changingView, ViewGroup parent) {
		Main3ItemHolder view = (Main3ItemHolder)changingView;
		if (view == null){
			view = new Main3ItemHolder(context);
			view.setOnLongClickListener(new OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
					int ss = (Integer)(((CheckBox)v.findViewById(R.id.m3_item_checkBox)).getTag());
					al.remove(ss);
					inst.notifyDataSetChanged();
					System.out.println("rem longClick --> "+ ss);
					return false;
				}
			});
		} 
		
		((CheckBox)view.findViewById(R.id.m3_item_checkBox)).setOnCheckedChangeListener(null);

		
		view.setData(al,position);
		
		((CheckBox)view.findViewById(R.id.m3_item_checkBox)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				System.out.println("here ["+(Integer)buttonView.getTag()+"]["+al.get((Integer)buttonView.getTag()).checked+"]--> " +isChecked);
				al.get((Integer)buttonView.getTag()).checked = isChecked;
			}
		});
		
		return view;
	}

}
