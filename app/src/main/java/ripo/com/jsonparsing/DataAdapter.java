package ripo.com.jsonparsing;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<JSONResponse> android;

    public DataAdapter(ArrayList<JSONResponse> android) {
        this.android = android;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_id.setText(android.get(i).getId());
        viewHolder.tv_name.setText(android.get(i).getName());
        viewHolder.tv_symbol.setText(android.get(i).getSymbol());
        viewHolder.tv_rank.setText(android.get(i).getRank());
        viewHolder.tv_price_usd.setText(android.get(i).getPriceUsd());
        viewHolder.tv_price_btc.setText(android.get(i).getPriceBtc());
        viewHolder.tv_volume.setText(android.get(i).get24hVolumeUsd());
        viewHolder.tv_market_cap.setText(android.get(i).getMarketCapUsd());
        viewHolder.tv_arible_supply.setText(android.get(i).getAvailableSupply());
        viewHolder.tv_max_supply.setText(android.get(i).getMaxSupply());
        viewHolder.tv_change_1h.setText(android.get(i).getPercentChange1h());
        viewHolder.tv_change_24h.setText(android.get(i).getPercentChange24h());
        viewHolder.tv_change_7d.setText(android.get(i).getPercentChange24h());
        viewHolder.tv_last_udated.setText(android.get(i).getPercentChange7d());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_id,tv_name,tv_symbol,tv_rank,tv_price_usd,tv_price_btc,
                tv_volume,tv_market_cap,tv_arible_supply,tv_max_supply,
                tv_change_1h,tv_change_24h,tv_change_7d,tv_last_udated;

        public ViewHolder(View view) {
            super(view);

            tv_id = (TextView)view.findViewById(R.id.tv_id);
            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_symbol = (TextView)view.findViewById(R.id.tv_symbol);
            tv_rank = (TextView)view.findViewById(R.id.tv_rank);
            tv_price_usd = (TextView)view.findViewById(R.id.tv_price_usd);
            tv_price_btc = (TextView)view.findViewById(R.id.tv_price_btc);
            tv_volume = (TextView)view.findViewById(R.id.tv_volume);
            tv_market_cap = (TextView)view.findViewById(R.id.tv_market_cap);
            tv_arible_supply = (TextView)view.findViewById(R.id.tv_arible_supply);
            tv_max_supply = (TextView)view.findViewById(R.id.tv_max_supply);
            tv_change_1h= (TextView)view.findViewById(R.id.tv_change_1h);
            tv_change_24h = (TextView)view.findViewById(R.id.tv_change_24h);
            tv_change_7d= (TextView)view.findViewById(R.id.tv_change_7d);
            tv_last_udated = (TextView)view.findViewById(R.id.tv_last_udated);
        }
    }

}
