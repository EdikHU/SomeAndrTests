package sed.pricescomparator;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main3ItemHolder extends LinearLayout {

	private Context context;
	private static int id = 0;

	public Main3ItemHolder(Context context) {
		super(context);
		this.context = context;
		init();
	}

//	public Main3ItemHolder(Context context, AttributeSet attrs, int defStyleAttr) {
//		super(context, attrs, defStyleAttr);
//		// this.context = context;
//		// init();
//	}
//
//	public Main3ItemHolder(Context context, AttributeSet attrs) {
//		super(context, attrs);
//		// this.context = context;
//		// init();
//	}

	private void init() {
		View xmlView = (View) ((LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
				R.layout.m3_item, null);
		this.addView(xmlView);
		((CheckBox) this.findViewById(R.id.m3_item_checkBox)).setText("["
				+ (id++) + "]");
	}

	public void setData(ArrayList<Main3Item> al, int position) {
		Main3Item item = al.get(position);

		((CheckBox) this.findViewById(R.id.m3_item_checkBox))
				.setChecked(item.checked);
		((CheckBox) this.findViewById(R.id.m3_item_checkBox)).setTag(position);
		((TextView) this.findViewById(R.id.m3_item_textView))
				.setText(item.info);

	}

}
