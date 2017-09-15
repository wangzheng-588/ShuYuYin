package cn.shuyuyin.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cn.shuyuyin.R;
import cn.shuyuyin.bean.Goods;
import cn.shuyuyin.bean.OrderItemBean;

public class SendGoodsOrderListview extends LinearLayout {

	private Context context;
	private ListView listView;
	private TextView tv_order_num;
	private TextView tv_similar_products;
	private OrderItemBean bean;
	private MyAdapter adapter;
	private TextView tv_pay;
	private LayoutInflater mInflater;

	public SendGoodsOrderListview(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.context = context;
		init();
	}

	public SendGoodsOrderListview(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	public SendGoodsOrderListview(Context context) {
		super(context);
		this.context = context;
		init();
	}

	private void init() {

		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = mInflater.inflate(R.layout.orderlistview,null);
		listView= view.findViewById(R.id.ll_order_list);
		//头部
		tv_order_num =  view.findViewById(R.id.tv_order_num);

		//底部
		tv_similar_products =  view.findViewById(R.id.tv_similar_products);
		tv_pay =  view.findViewById(R.id.tv_pay);
		tv_pay.setText("提醒");
		tv_pay.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				System.out.println("提醒");
			}
		});
		this.addView(view, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		adapter = new MyAdapter();
	}
	public void setData(OrderItemBean bean){
		this.bean=bean;
		listView.setAdapter(adapter);
		tv_order_num.setText(bean.getTime());
		this.setListViewHeightBasedOnChildren(listView);
	}
	class MyAdapter extends BaseAdapter {

		public int getCount() {
			return bean.getList().size();
		}

		public Object getItem(int position) {
			return bean.getList().get(position);
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if(convertView==null){
				holder=new ViewHolder();
				convertView = mInflater.inflate(R.layout.item_orderdetail,null);
				holder.iv_icon = convertView.findViewById(R.id.iv_orderdetail_icon);
				holder.tv_order_name= convertView.findViewById(R.id.tv_order_name);
				holder.tv_price= convertView.findViewById(R.id.tv_price);
				holder.tv_order_buy_num= convertView.findViewById(R.id.tv_order_buy_num);
				holder.tv_freight= convertView.findViewById(R.id.tv_freight);
				convertView.setTag(holder);
			}else{
				holder=(ViewHolder) convertView.getTag();
			}
			ArrayList<Goods> goodslist = bean.getList();

			Goods goods = goodslist.get(position);

			holder.tv_order_name.setText(goods.getProductTitle());
			holder.tv_price.setText(goods.getProductPrice()+"");


			return convertView;
		}

	}

	class ViewHolder{
		ImageView iv_icon;
		TextView tv_order_name;
		TextView tv_price;
		TextView tv_order_buy_num;
		TextView tv_freight;
	}
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		// 获取ListView对应的Adapter
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}
		int totalHeight = 0;
		for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0); // 计算子项View 的宽高
			totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
		}
		LayoutParams params = (LayoutParams) listView.getLayoutParams();
		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		listView.setLayoutParams(params);
	}
}
