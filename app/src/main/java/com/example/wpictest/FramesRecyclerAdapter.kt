package com.example.wpictest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.coroutines.currentCoroutineContext


class FramesRecyclerAdapter(
    val loadedFrames: MutableList<FrameItem>
) : RecyclerView.Adapter<FramesRecyclerAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val frameImage: ImageView = view.findViewById(R.id.item_frame__img__frame_image)
        val premiumBtn: ImageButton = view.findViewById(R.id.item_frame__img__unlock)
        val root: View = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_frame, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = loadedFrames.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentFrame = loadedFrames[position]

        holder.frameImage.setImageDrawable(currentFrame.frame)

        if (currentFrame.isPremium &&! currentFrame.isAdWatched){
            holder.premiumBtn.visibility = View.VISIBLE
            holder.frameImage.setOnClickListener { unlockPremiumFrame(holder.root.context, position) }
        } else {
            holder.premiumBtn.visibility = View.GONE
            holder.frameImage.setOnClickListener(null)
        }

        if (currentFrame.is2ColumnWide) {
            val layoutParams = holder.itemView.layoutParams as StaggeredGridLayoutManager.LayoutParams
            layoutParams.isFullSpan = true
        }
    }

    private fun unlockPremiumFrame(context: Context, framePosition: Int) {

        val alertDialog = AlertDialog.Builder(context)

        alertDialog.setTitle("Here should be an add, I think..")
        alertDialog.setMessage("The frame should be available for now.")

        alertDialog.setPositiveButton("ok") { dialog, _ ->
            dialog.dismiss()
        }

        alertDialog.setOnDismissListener {
            loadedFrames[framePosition].isAdWatched = true
            notifyItemChanged(framePosition)
        }

        alertDialog.show()
    }

}