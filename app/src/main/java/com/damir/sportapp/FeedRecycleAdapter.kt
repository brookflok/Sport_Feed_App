package com.damir.sportapp

import com.damir.sportapp.data.models.FeedView
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FeedRecycleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items : List<FeedView> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  FeedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_feed_video_item, parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when(holder){
           is FeedViewHolder ->{
               holder.bind(items.get(position))
           }
       }
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    fun submitList(feedList: List<FeedView>?){
        items = feedList!!
    }

    class FeedViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){


        private val feedImage : ImageView = itemView.findViewById(R.id.feed_image)
        private val feedTitle : TextView = itemView.findViewById(R.id.feed_title)
        private val feedAuthor : TextView = itemView.findViewById(R.id.feed_author)
        private val feedDescription : TextView = itemView.findViewById(R.id.feed_description)
        private val feedRelease : TextView = itemView.findViewById(R.id.feed_release)
        private val feedCard: LinearLayout = itemView.findViewById(R.id.feed_card)


        fun bind(feedView: FeedView){

            feedTitle.text = feedView.athlete.name
            feedAuthor.text ="Published by: " +feedView.author.name
            feedDescription.text = feedView.description
            feedRelease.text = "Published on " + feedView.createdAt
            if(feedView.athlete.avatar.contains("drive")){
              val replacedUrl =  feedView.athlete.avatar.replace("open?","uc?")

            Glide.with(itemView.context)
                .load(replacedUrl)
                .into(feedImage)
            }else{
                Glide.with(itemView.context)
                    .load(feedView.athlete.avatar)
                    .into(feedImage)
            }

            feedCard.setOnClickListener {
                val intent = Intent(itemView.context, VideoActivity::class.java)
                intent.putExtra("FeedView", feedView)
                itemView.context.startActivity(intent);

            }

        }

    }


}
