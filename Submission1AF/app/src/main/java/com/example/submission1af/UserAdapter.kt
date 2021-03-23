package com.example.submission1af

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(private val context: Context, private val listUser : ArrayList<User>) : BaseAdapter() {

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if(itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.item_user, null, true)
        }
        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    override fun getItem(Position: Int): Any {
        return listUser[Position]
    }

    override fun getItemId(Position: Int): Long {
        return Position.toLong()
    }

    override fun getCount(): Int {
        return listUser.size
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val imgAvatar: CircleImageView = view.findViewById(R.id.img_item_photo)
        private val txtName: TextView = view.findViewById(R.id.tv_item_username)
        private val txtLocation: TextView = view.findViewById(R.id.tv_item_location)

        internal fun bind(user: User) {
            user.avatar?.let { imgAvatar.setImageResource(it) }
            txtName.text = user.name
            txtLocation.text = user.location

        }
    }

}