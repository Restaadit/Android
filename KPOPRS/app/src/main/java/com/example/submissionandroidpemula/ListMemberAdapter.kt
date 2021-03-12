package com.example.submissionandroidpemula

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMemberAdapter(val listMember: ArrayList<Member>): RecyclerView.Adapter<ListMemberAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_member, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val member = listMember[position]

        Glide.with(holder.itemView.context)
                .load(member.photo)
                .apply(RequestOptions().override(55, 55))
                .into(holder.imgPhoto)
        holder.tvName.text = member.name
        holder.tvGroup.text = member.group

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, MemberDetail::class.java)
            moveDetail.putExtra(MemberDetail.EXTRA_NAME, member.name)
            moveDetail.putExtra(MemberDetail.EXTRA_GROUP, member.group)
            moveDetail.putExtra(MemberDetail.EXTRA_PHOTO, member.photo)
            moveDetail.putExtra(MemberDetail.EXTRA_BIODATA, member.biodata)
            moveDetail.putExtra(MemberDetail.EXTRA_FACT, member.fact)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listMember.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvGroup: TextView = itemView.findViewById(R.id.tv_item_group)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
