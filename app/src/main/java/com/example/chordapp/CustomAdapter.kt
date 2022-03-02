package com.example.chordapp


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListenerTest
    private lateinit var mTouch: onItemTouchListener


    interface onItemTouchListener{
        fun itemTouchTest(position: Int)
    }

    fun setOnItemTouchListener(listener: onItemTouchListener){
        mTouch = listener
    }


    interface onItemClickListenerTest {
        fun itemClickTest(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListenerTest){
        mListener = listener
    }



    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.key_view_design, parent, false)

        //return ViewHolder(view, mListener)
        return ViewHolder(view, mTouch)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }


    // Holds the views for adding it to image and text
    @SuppressLint("ClickableViewAccessibility")
    //class ViewHolder(ItemView: View, listener: onItemClickListenerTest) : RecyclerView.ViewHolder(ItemView) {
    class ViewHolder(ItemView: View, listener: onItemTouchListener) : RecyclerView.ViewHolder(ItemView) {
        //val titleImage: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        init {
            itemView.setOnTouchListener(View.OnTouchListener{view, motionEvent ->
                listener.itemTouchTest(adapterPosition)
                return@OnTouchListener false
                })
        }
    }
}

