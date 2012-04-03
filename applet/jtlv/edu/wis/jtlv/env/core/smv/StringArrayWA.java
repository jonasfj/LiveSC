package edu.wis.jtlv.env.core.smv;

// this is a workaround since antlr cannot return an array... 
// it swallows the braces. 
public class StringArrayWA {
	public String[] arr;
	public int length;

	public StringArrayWA(int size) {
		this.length = size;
		this.arr = new String[this.length];
	}

	public StringArrayWA(Initiator context, String default_str,
			StmtValueArrayWA vals) {
		this(context, default_str, "", vals, "");
	}

	public StringArrayWA(Initiator context, String default_str,
			String pre_text, StmtValueArrayWA vals, String post_text) {
		int[] int_vals = null;
		boolean in_var_decl = context.isVarDeclPhase();
		this.length = in_var_decl ? 1 : context.get_module_pool_size();
		this.arr = new String[this.length];
		int_vals = in_var_decl ? null : context.quickEvalIntValue(vals);

		for (int i = 0; i < this.arr.length; i++)
			this.arr[i] = (int_vals == null) ? default_str : pre_text
					+ int_vals[i] + post_text;
	}

	public StringArrayWA concat(StringArrayWA other) {
		StringArrayWA res = new StringArrayWA(this.length);
		for (int i = 0; i < res.length; i++) {
			res.arr[i] = this.arr[i] + other.arr[i];
		}
		return res;
	}

}
