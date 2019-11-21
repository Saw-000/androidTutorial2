package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.database.SleepNight

/**
 * adapter概要:
 * 1[viewHolder] : one_item内で使用する空のviewsが入った箱。viewsの中身と配置(layout)の2つを設定すると、layoutが完成して、recycleViewに渡せる状態になる。
 * 2[onBindViewHolder] : [viewHolder]を渡すと、view達の中身(値/修飾など)をsetしてくれる。
 * 3[onCreateViewHolder] :
 * (明示されてはいないがおそらく。。[onBindViewHolder]で中身が設定されたview達を持った状態の)
 * [viewHolder]を渡すと、view達を当てはめるlayoutをあてがって、完成されたone_itemのlayoutの情報を持ったViewHolderがRecyclerViewに渡される。
 */
class SleepNightAdapter: RecyclerView.Adapter<SleepNightAdapter.ViewHolder>() {
    /** Observing "database.Nights(Livedata)" **/
    var data =  listOf<SleepNight>()
        set(value) {  //set()にnotifyDataSetChanged()を追加
            field = value
            notifyDataSetChanged() /** <= RecyclerView redraws the whole data of the list!!**/
        }

    /** Decide recycleView's size **/
    override fun getItemCount() = data.size

    /** about one item **/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    /** called by RecyclerView to display the data for one list item at the specified position **/
    /** adapter_classの<>の型を返さないといけない。 **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    /** ViewHolder! (主役)**/
    class ViewHolder private constructor(itemView: View): RecyclerView.ViewHolder(itemView) {
        val sleepLength: TextView = itemView.findViewById(R.id.sleep_length)
        val quality: TextView = itemView.findViewById(R.id.quality_string)
        val qualityImage: ImageView = itemView.findViewById(R.id.quality_image)

        /** Viewの中身データの設定 **/
        fun bind(item: SleepNight) {
            val res = itemView.context.resources //リソースはこのパスを通して使わんといかんみたい。ViewHolder使うときは。
            sleepLength.text = convertDurationToFormatted(item.startTimeMilli, item.endTimeMilli, res)
            quality.text = convertNumericQualityToString(item.sleepQuality, res)
            qualityImage.setImageResource(when (item.sleepQuality) {
                0 -> R.drawable.ic_sleep_0
                1 -> R.drawable.ic_sleep_1
                2 -> R.drawable.ic_sleep_2
                3 -> R.drawable.ic_sleep_3
                4 -> R.drawable.ic_sleep_4
                5 -> R.drawable.ic_sleep_5
                else -> R.drawable.ic_sleep_active
            })
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                // @params "parent" is always the Recycler View, which has a context having information to inflate
                val view = layoutInflater
                        .inflate(R.layout.list_item_sleep_night, parent, false)

                return ViewHolder(view)
            }
        }
    }

}