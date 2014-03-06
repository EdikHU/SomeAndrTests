package sed.pricescomparator;

public class Main3Item {
	String info;
	boolean checked;

	public Main3Item(String info, boolean checked) {
		this.info = info;
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "[" + info + "][" + checked + "]";
	}
	
}
